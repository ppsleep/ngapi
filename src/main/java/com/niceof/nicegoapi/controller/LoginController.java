package com.niceof.nicegoapi.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.niceof.nicegoapi.annotation.NoAuth;
import com.niceof.nicegoapi.model.service.UsersService;

@RestController
public class LoginController {
    @Resource
    UsersService usersService;

    @NoAuth
    @RequestMapping("/login")
    public Object Login() {
        Object kkx = usersService.findById(1);
        System.out.println(kkx);
        return 0;
    }

    @NoAuth
    @RequestMapping("/logout")
    public Object Logout() {
        return 0;
    }
}
