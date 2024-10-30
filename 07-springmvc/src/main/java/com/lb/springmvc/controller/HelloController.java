package com.lb.springmvc.controller;

import com.lb.springmvc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        // 由于你使用了 @ResponseBody 注解
        // 以下的return语句返回的字符串则不再是“逻辑视图名”了
        // 而是作为响应协议的响应体进行响应。
        return "hello";
    }

    // 以上程序中使用的消息转换器是：StringHttpMessageConverter，为什么会启用这个消息转换器呢？因为你添加@ResponseBody这个注解。


    /* @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "{\"username\":\"zhangsan\",\"password\":\"1234\"}";
    } */


    /* @RequestMapping(value = "/hello")
    @ResponseBody
    public User hello(){
        User user = new User("zhangsan", "22222");
        return user;
    } */

    // 为了方便，Spring MVC中提供了一个注解 @RestController。这一个注解代表了：@Controller + @ResponseBody。
    // @RestController 标注在类上即可。被它标注的Controller中所有的方法上都会自动标注 @ResponseBody

    // Spring MVC会自动使用 FormHttpMessageConverter消息转换器，将请求体转换成user对象。
    @RequestMapping("/save")
    public String save(User user) {
        // 执行保存的业务逻辑
        // userDao.save(user);
        // 保存成功跳转到成功页面
        return "success";
    }

    @RequestMapping("/save")
    public String save(@RequestBody String requestBodyStr) {
        System.out.println("请求体：" + requestBodyStr);
        return "success";
    }

    @RequestMapping("/send")
    @ResponseBody
    public String send(@RequestBody User user) {
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "success";
    }

    @RequestMapping("/send")
    @ResponseBody
    public String send(RequestEntity<User> requestEntity) {
        System.out.println("请求方式：" + requestEntity.getMethod());
        System.out.println("请求URL：" + requestEntity.getUrl());
        HttpHeaders headers = requestEntity.getHeaders();
        System.out.println("请求的内容类型：" + headers.getContentType());
        System.out.println("请求头：" + headers);

        User user = requestEntity.getBody();
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "success";
    }

    /* @Controller
    public class UserController {

        @GetMapping("/users/{id}")
        public ResponseEntity<User> getUserById(@PathVariable Long id) {
            User user = userService.getUserById(id);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            } else {
                return ResponseEntity.ok(user);
            }
        }
    } */


}