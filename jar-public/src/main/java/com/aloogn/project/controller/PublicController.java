package com.aloogn.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.aloogn.project.base.Auth;
import com.aloogn.project.base.AuthService;
import com.aloogn.project.base.BaseService;
import com.aloogn.project.utils.*;
import com.aloogn.project.exception.BaseException;
import com.aloogn.project.response.ResultCode;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@DefaultProperties(defaultFallback = "failbackMethod")
public class PublicController {
    private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
    private static final String SERVICE = "Service";
    private static final String REQUEST_PARAM = "Po";
    private static final String RESPONSE_PARAM = "Vo";



    @Value("#{${aloogn.whiteMap}}")
    private Map<String,Boolean> whiteMap;

    @Value("${aloogn.basePackage}")
    private String basePackage;

    @RequestMapping("/")
    public String index(){
        return "auth/login";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Auth auth(Map<String,Object> mapObj, HttpServletRequest request, HttpServletResponse response){
        String account = (String)mapObj.get("account");
        String password = (String)mapObj.get("password");
        String code = (String)mapObj.get("code");

        //帐号判空
        if(StringUtils.isEmpty(account))  throw new BaseException(ResultCode.UNAUTHORIZED,"用户名不能为空");
        //密码判空
        if(StringUtils.isEmpty(password))  throw new BaseException(ResultCode.UNAUTHORIZED,"密码不能为空");

        try{

            AuthService authService = (AuthService)Class.forName(basePackage+".doservice.auth.AuthServiceImpl").newInstance();
            Auth auth = authService.auth(account,password);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", auth.getUserId()); // 用户id
            map.put("uid", request.getHeader("uid")); // app uid
            map.put("version", request.getHeader("version")); // app version
            map.put("sta", new Date().getTime());// 生成时间
            map.put("exp", new Date().getTime() + 30*24*60*1000); // 过期时间

            //生成token
            String token = TokenUtil.creatToken(map);
            auth.setToken(token);
            return auth;
        }catch (Exception e){
            e.printStackTrace();
            throw new BaseException(ResultCode.UNAUTHORIZED,e.getMessage());
        }
    }

    @RequestMapping(value = "/service", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Object service(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String transCode = (String) params.get("transCode");
        logger.info("--------本次 交易码为：[{}]",transCode);

        //判断交易码是否为空
        if(StringUtils.isEmpty(transCode)){
            throw new BaseException(ResultCode.PARAM_TRANSCODE_NOT_NULL);
        }

//        ThreadLocalUtil.set("params", params);
//        Thread.currentThread().setName("service-" + DateUtil.getNowTime("yyyyMMddHHmmssSSS"));

        //不在白名单范围内，验证token
        if(!whiteMap.get(transCode)) {
            logger.info("--------本次 交易码为：[{}],需要登录验证----",transCode);
            //进行token验证
            String token = request.getHeader("token");
            String userId = authToken(token);

            params.put("userId",userId);
            logger.info("--------本次 交易码为：[{}],登录验证成功----",transCode);
        }

        String basePackageFun = basePackage+".doservice."+transCode+".";

        //入参：赋值 bean
        Class<?> inClazz = getClassByName(basePackageFun + REQUEST_PARAM);
        Object inBean = ClassRefUtil.setValue(inClazz.newInstance().getClass(), params);

        //出参：赋值 bean
        Class<?> outClazz = getClassByName(basePackageFun + RESPONSE_PARAM);
        Object outBean = ClassRefUtil.setValue(outClazz.newInstance().getClass(), new HashMap<>());

        Map<String, Object> mapDataModel = new HashMap<>(2);
        mapDataModel.put(StringUtils.fristCharToLowerCase(REQUEST_PARAM),inBean);
        mapDataModel.put(StringUtils.fristCharToLowerCase(RESPONSE_PARAM), outBean);


        BaseService baseService = (BaseService)Class.forName(basePackageFun + SERVICE).newInstance();
        baseService.process(inBean,outBean);

        return outBean;
    }

    /**
     *     token验证
     *     成功返回userid
     */
    public String authToken(String token){
        //未登录
        if (StringUtils.isNullOrBlock(token)){
            throw new BaseException(ResultCode.UNAUTHORIZED);
        }
//        Map<String, Object> params = (Map)ThreadLocalUtil.get("params");

        try {
            //解析token
            Map<String, Object> validMap = TokenUtil.valid(token);
            Integer i = (Integer) validMap.get("Result");

            if (i == 1) {//验证错误
                logger.error("--------token验证错误------");
                throw new BaseException(ResultCode.UNAUTHORIZED);
            }

            if (i == 2) {//token已经过期
                logger.error("--------token已经过期------");
                throw new BaseException(ResultCode.SESSION_OVERTIME);
            }

            JSONObject jsonObject = (JSONObject) validMap.get("data");
            logger.debug("jsonObject----->"+jsonObject.toJSONString());

            //解析携带的token载体中的id
            String userId = (String) jsonObject.get("userId");
            //获取存入缓存中的token,每次登录就添加，登出就删除，更改密码或其它就替换
//            String rToken = (String)redisService.hashGet(Constant.REDIS_TOKEN_KEY, userId);
//            if(!token.equals(rToken)) {
////                loginError(response,"帐户己在其它地方登录，你己被迫下线");
//                throw new BaseException(ResultCode.UNAUTHORIZED);
//            }
            return userId;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(ResultCode.UNAUTHORIZED);
        }
    }

    public Class<?> getClassByName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }



}
