package com.stmz.mgr.exception;

import com.stmz.mgr.support.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/11/30 11:50
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req){
        log.warn("可能是错误的警告");
        log.error("全局异常处理", e);
        Result result = new Result(400, "全局异常处理", 0, null);

        //使用HttpServletRequest中的header检测请求是否为ajax, 如果是ajax则返回json, 如果为非ajax则返回view(即ModelAndView)
        String contentTypeHeader = req.getHeader("Content-Type");
        String acceptHeader = req.getHeader("Accept");
        String xRequestedWith = req.getHeader("X-Requested-With");

        if ((contentTypeHeader != null && contentTypeHeader.contains("application/json"))
            || (acceptHeader != null && acceptHeader.contains("application/json"))
            || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith)) {
            return result;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg","全局异常处理");
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
}
