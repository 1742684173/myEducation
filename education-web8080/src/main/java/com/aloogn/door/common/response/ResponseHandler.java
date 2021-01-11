package com.aloogn.door.common.response;

/**
 * Created by zouXiaoLong on 2020/12/28 20:50
 */

import com.alibaba.fastjson.JSONObject;
import com.aloogn.door.common.response.ErrorResult;
import com.aloogn.door.common.response.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * ResponseBodyAdvice拦截Controller方法的返回值，统一处理返回值响应体
 * 1.对Controller全局数据统一数据处理
 * 2.对Controller全局异常统一数据处理
 *
 * basePackages：不加的话会对整个系统的Controller做了扩展功能，它会对某些功能产生冲突，如：不加的话swapper会空白
 */
//@RestControllerAdvice(basePackages = "com.aloogn.door")
@ControllerAdvice(basePackages = "com.aloogn.door")
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    /**
     * 是否支持advise功能 true支持 false不支持 默认false
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //获取当前处理请求的controller的方法
//        String methodName=methodParameter.getMethod().getName();
//        // 不拦截/不需要处理返回值 的方法
//        String method= "loginCheck"; //如登录
//        //不拦截
//        return !method.equals(methodName);

        return true;
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
