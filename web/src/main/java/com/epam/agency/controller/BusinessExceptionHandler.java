package com.epam.agency.controller;

import com.epam.agency.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public String handleError(HttpServletRequest request, BusinessException exception) {
        request.setAttribute("error", exception);
        return PageName.ERROR.getValue();
    }
}
