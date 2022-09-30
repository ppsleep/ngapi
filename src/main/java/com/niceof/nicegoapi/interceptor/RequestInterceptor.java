package com.niceof.nicegoapi.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.niceof.nicegoapi.annotation.NoAuth;

public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
        HttpServletRequest request, 
        HttpServletResponse response, 
        Object handler
    ) throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        boolean needAuth = true;
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            needAuth = !method.hasMethodAnnotation(NoAuth.class);
        }
        Map<String, Object> userinfo = auth(request);
        if (userinfo == null && needAuth) {
            try {
                response.getWriter().write("{\"status\": -1}");
            } catch (IOException e) {
                return false;
            }
            return false;
        }
        request.setAttribute("userinfo", userinfo);
        return true;
    }

    @Override
    public void postHandle(
        HttpServletRequest request, 
        HttpServletResponse response,
        Object handler, 
        ModelAndView modelAndView
    ) throws Exception {
        
    }

    @Override
    public void afterCompletion(
        HttpServletRequest request, 
        HttpServletResponse response, 
        Object handler, 
        Exception ex
    ) throws Exception {
        if (ex != null){
            // ex.printStackTrace();
        }
    }

    public Map<String, Object> auth(HttpServletRequest request) {
        String authorization = request.getHeader("authorization");
        if (authorization == null || authorization == "") {
            return null;
        }
        Map<String, Object> userinfo = new HashMap<>();
        userinfo.put("uid", 1);
        return userinfo;
    }
}