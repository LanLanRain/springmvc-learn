package com.lb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    /* @RequestMapping("/detail")
    public String toDetail(){
        return "detail";
    } */

    @RequestMapping("/user/detail")
    public String toDetail(){
        return "/user/detail";
    }
}

/* @Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/detail")
    public String toDetail(){
        return "/user/detail";
    }
} */
