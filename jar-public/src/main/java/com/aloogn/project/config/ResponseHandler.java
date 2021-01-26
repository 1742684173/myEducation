package com.aloogn.project.config;

/**
 * Created by zouXiaoLong on 2020/12/28 20:50
 */

import com.alibaba.fastjson.JSONObject;
import com.aloogn.project.response.ErrorResult;
import com.aloogn.project.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;

/**
 * ResponseBodyAdvice拦截Controller方法的返回值，统一处理返回值响应体
 * 1.对Controller全局数据统一数据处理
 * 2.对Controller全局异常统一数据处理
 *
 * basePackages：不加的话会对整个系统的Controller做了扩展功能，它会对某些功能产生冲突，如：不加的话swapper会空白
 */
//@RestControllerAdvice(basePackages = "com.aloogn.door")
@ControllerAdvice(basePackages = "com.aloogn.project")
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    private static final Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    private boolean isResponseHandler;

    @Value("#{${aloogn.responseHandlerList}}")
    private Map<String,Boolean> responseHandlerList;
    /**
     * 是否支持advise功能 true支持 false不支持 默认false
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        获取当前处理请求的controller的方法
        String methodName=methodParameter.getMethod().getName();
        // 需要处理返回值 的方法
        Boolean flag =  responseHandlerList.get(methodName);
        logger.info("当前方法[{},是否统一返回值:{}]",methodName,flag);
        return flag==null?false:flag;
    }

    /**
     * 处理response的具体业务方法
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof ErrorResult){
            return o;
        }

        //处理返回值是String的情况
        if (o instanceof String) {
            return JSONObject.toJSON(Result.success(o)).toString();
        }

        return Result.success(o);
    }
}
