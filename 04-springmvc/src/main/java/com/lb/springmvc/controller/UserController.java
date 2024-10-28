package com.lb.springmvc.controller;

import com.lb.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class UserController {
    @RequestMapping("/")
    public String toRegisterPage() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(HttpServletRequest request) {
        // 通过当前请求对象获取提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String[] hobbies = request.getParameterValues("hobby");
        String intro = request.getParameter("intro");
        System.out.println(username + "," + password + "," + sex + "," + Arrays.toString(hobbies) + "," + intro);
        return "success";
    }

    @PostMapping(value = "/register")
    public String register(
            @RequestParam(value = "username")
            String a,
            @RequestParam(value = "password")
            String b,
            @RequestParam(value = "sex")
            String c,
            @RequestParam(value = "hobby")
            String[] d,
            @RequestParam(name = "intro")
            String e) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(Arrays.toString(d));
        System.out.println(e);
        return "success";
    }

    @PostMapping("/register")
    public String register(User user) {
        System.out.println(user);
        return "success";
    }

    @PostMapping("/register")
    public String register(User user,
                           @RequestHeader(value = "Referer", required = false, defaultValue = "")
                           String referer) {
        System.out.println(user);
        System.out.println(referer);
        return "success";
    }

    @GetMapping("/register")
    public String register(User user,
                           @RequestHeader(value = "Referer", required = false, defaultValue = "")
                           String referer,
                           @CookieValue(value = "id", required = false, defaultValue = "2222222222")
                           String id) {
        System.out.println(user);
        System.out.println(referer);
        System.out.println(id);
        return "success";
    }

}