package com.niceof.nicegoapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController extends BaseController {
    @RequestMapping("")
    public Object Index() {
        int[] x = {1, 2, 3};
        System.out.println(this.User("uid"));
        return x;
    }
}
