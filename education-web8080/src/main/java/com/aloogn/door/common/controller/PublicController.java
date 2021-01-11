package com.aloogn.door.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.aloogn.api.service.IBaseService;
import com.aloogn.api.utils.ClassRefUtil;
import com.aloogn.api.utils.DateUtil;
import com.aloogn.api.utils.StringUtils;
import com.aloogn.api.utils.ThreadLocalUtil;
import com.aloogn.door.common.exception.BaseException;
import com.aloogn.door.common.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class PublicController {
    private static final String SERVICE = "Service";
    private static final String REQUEST_PARAM = "Input";
    private static final String RESPONSE_PARAM = "Output";

    @Value("${aloogn.whiteList}")
    private String whiteList;

    @Value("${aloogn.basePackage}")
    private String basePackage;

    @RequestMapping("/")
    public String index(){
        return "auth/login";
    }

    @RequestMapping("/signIn")
    @ResponseBody
    public String signIn(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "main/index";
    }

    @RequestMapping(value = "/jsonRequest", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Object service(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String transCode = (String) params.get("transCode");
        log.info("--------本次 交易码为："+transCode);

        ThreadLocalUtil.set("request", request);
        ThreadLocalUtil.set("response", response);
        Thread.currentThread().setName("jsonRequest-" + DateUtil.getNowTime("yyyyMMddHHmmssSSS"));

        //判断交易码是否为空
        if(StringUtils.isEmpty(transCode)){
            throw new BaseException(ResultCode.PARAM_TRANSCODE_NOT_NULL);
        }

        //不在白名单范围内，验证token
        if(!whiteList.contains(transCode)) {
            //进行token验证
            String token = request.getHeader("token");
            authToken(token);
        }

        String basePackageFun = basePackage+"."+transCode+".";

        //入参：赋值 bean
        Class<?> inClazz = getClassByName(basePackageFun + REQUEST_PARAM);
        Object inBean = ClassRefUtil.setValue(inClazz.newInstance().getClass(), params);

        //出参：赋值 bean
        Class<?> outClazz = getClassByName(basePackageFun + RESPONSE_PARAM);
        Object outBean = ClassRefUtil.setValue(outClazz.newInstance().getClass(), params);


        Map<String, Object> mapDataModel = new HashMap<>(2);
        mapDataModel.put(StringUtils.fristCharToLowerCase(REQUEST_PARAM),inBean);
        mapDataModel.put(StringUtils.fristCharToLowerCase(RESPONSE_PARAM), outBean);


        IBaseService baseService = (IBaseService)Class.forName(basePackageFun + SERVICE).newInstance();
        baseService.process(mapDataModel);

        return mapDataModel.get(StringUtils.fristCharToLowerCase(RESPONSE_PARAM));
    }

    //token验证
    public void authToken(String token){
        //未登录
        if (StringUtils.isNullOrBlock(token)){
            throw new BaseException(ResultCode.UNAUTHORIZED);
        }

        HttpSession session = ((HttpServletRequest) ThreadLocalUtil.get("request")).getSession();
//            session.setAttribute("loginId", user.getUserID());
//            session.setAttribute("userName", user.getUserName());
//            session.setAttribute("branchName", user.getBranchName());
//            session.setAttribute("branchId", user.getOrgId());
//            session.setAttribute("userId", user.getUserKey());
    }

    public Class<?> getClassByName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

}
