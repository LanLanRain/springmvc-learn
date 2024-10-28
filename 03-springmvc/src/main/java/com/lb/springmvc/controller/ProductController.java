package com.lb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    /* @RequestMapping("/detail")
    public String toDetail(){
        return "detail";
    } */

    @RequestMapping("/product/detail")
    public String toDetail(){
        return "/product/detail";
    }
}

/*
@Controller
@RequestMapping("/product")
public class ProductController {
    @RequestMapping("/detail")
    public String toDetail(){
        return "/product/detail";
    }
}
*/
