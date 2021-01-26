package com.aloogn.project.config;

import com.aloogn.project.exception.BaseException;
import com.aloogn.project.response.ErrorResult;
import com.aloogn.project.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


/**
 * Created by zouXiaoLong on 2020/12/28 20:41
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //自定义异常
    @ExceptionHandler(BaseException.class)
    public ErrorResult baseExceptionHandler(BaseException ex) {
        return ErrorResult.fail(ex.getCode(),ex.getMessage());
    }

//    //运行时异常
//    @ExceptionHandler(RuntimeException.class)
//    public ErrorResult runtimeExceptionHandler(RuntimeException ex) {
//        return errorResult(ex);
//    }
//
//    //空指针异常
//    @ExceptionHandler(NullPointerException.class)
//    public ErrorResult nullPointerExceptionHandler(NullPointerException ex) {
//        return errorResult(ex);
//    }
//
//    //类型转换异常
//    @ExceptionHandler(ClassCastException.class)
//    public ErrorResult classCastExceptionHandler(ClassCastException ex) {
//        return errorResult(ex);
//    }
//
//    //IO异常
//    @ExceptionHandler(IOException.class)
//    public ErrorResult iOExceptionHandler(IOException ex) {
//       return errorResult(ex);
//    }
//
//    //未知方法异常
//    @ExceptionHandler(NoSuchMethodException.class)
//    public ErrorResult noSuchMethodExceptionHandler(NoSuchMethodException ex) {
//        return errorResult(ex);
//    }
//
//    //数组越界异常
//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    public ErrorResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
//        return errorResult(ex);
//    }
//
//    //400错误
//    @ExceptionHandler({HttpMessageNotReadableException.class})
//    public ErrorResult requestNotReadable(HttpMessageNotReadableException ex) {
//        return errorResult(ex);
//    }
//
//    //400错误
//    @ExceptionHandler({TypeMismatchException.class})
//    public ErrorResult requestTypeMismatch(TypeMismatchException ex) {
//        return errorResult(ex);
//    }
//
//    //400错误
//    @ExceptionHandler({MissingServletRequestParameterException.class})
//    public ErrorResult requestMissingServletRequest(MissingServletRequestParameterException ex) {
//        return errorResult(ex);
//    }
//
//    //405错误
//    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
//    public ErrorResult request405(HttpRequestMethodNotSupportedException ex) {
//        return errorResult(ex);
//    }
//
//    //406错误
//    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
//    public ErrorResult request406(HttpMediaTypeNotAcceptableException ex) {
//        return errorResult(ex);
//    }
//
//    //500错误
//    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
//    public ErrorResult server500(RuntimeException ex) {
//        return errorResult(ex);
//    }
//
//    //栈溢出
//    @ExceptionHandler({StackOverflowError.class})
//    public ErrorResult requestStackOverflow(StackOverflowError ex) {
//        return errorResult(ex);
//    }
//
//    //除数不能为0
//    @ExceptionHandler({ArithmeticException.class})
//    public ErrorResult arithmeticException(ArithmeticException ex) {
//        return errorResult(ex);
//    }
//
//    //其他错误
//    @ExceptionHandler({Exception.class})
//    public ErrorResult exception(Exception ex) {
//        return errorResult(ex);
//    }
//
//    public ErrorResult errorResult(Throwable ex){
//        ex.printStackTrace();
//        return ErrorResult.fail(ResultCode.SYSTEM_ERROR,ex);
//    }
}
