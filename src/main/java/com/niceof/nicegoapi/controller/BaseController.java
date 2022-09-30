package com.niceof.nicegoapi.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    public Object User(String key) {
        Object info = request.getAttribute("userinfo");
        try {
            Map<?, ?> user = (Map<?, ?>) info;
            return user.get("uid");
        } catch (Exception e) {
            return null;
        }
    }
}
