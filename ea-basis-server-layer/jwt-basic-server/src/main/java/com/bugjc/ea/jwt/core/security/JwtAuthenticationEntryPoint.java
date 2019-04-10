package com.bugjc.ea.jwt.core.security;

import com.alibaba.fastjson.JSON;
import com.bugjc.ea.jwt.core.dto.ResultCode;
import com.bugjc.ea.jwt.core.dto.ResultGenerator;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
        // Full authentication is required to access this resource
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        String result = JSON.toJSONString(ResultGenerator.genFailResult(ResultCode.UNAUTHORIZED.getCode(),"Unauthorized"));
        response.getOutputStream().write(result.getBytes());
    }
}