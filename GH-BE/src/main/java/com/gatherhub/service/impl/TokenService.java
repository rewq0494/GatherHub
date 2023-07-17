package com.gatherhub.service.impl;


import com.gatherhub.configuration.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenService {

    @Autowired
    private HttpServletRequest request;


    public String getAccount(){
        return JwtUtil.validateToken(getToken());
    }

    public String getToken(){
        return request.getHeader("Authorization");
    }

}
