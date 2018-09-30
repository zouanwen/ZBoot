package com.zou.exception;

import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.apache.shiro.authz.UnauthenticatedException;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;

//import com.tvac.shiro.util.ResultMap;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA
 *
 * @Author zou
 * @Description 异常处理
 * @Date 2018-04-09
 * @Time 17:09
 */
@RestControllerAdvice
public class ExceptionController {
	
    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public Msg handle401(HttpServletRequest request) {
        return ResultUtil.error(401, "没有权限访问!");
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public Msg globalException(HttpServletRequest request, Throwable ex) {
        return ResultUtil.error(getStatus(request).value(), "访问出错，无法访问: " + ex.getMessage());
    }
    
    @ExceptionHandler(UnauthenticatedException.class)
    public Msg UnauthenticatedException(UnauthenticatedException e, Throwable ex) {
    	return ResultUtil
        		.error(401, "tonken无效");
    }
    
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
    
}
