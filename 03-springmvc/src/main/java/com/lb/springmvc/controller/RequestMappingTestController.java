package com.lb.springmvc.controller;

import org.springframework.web.bind.annotation.*;

public class RequestMappingTestController {
    @RequestMapping("/x?z/testValueAnt")
    public String testValueAnt(){
        return "testValueAnt";
    }

    @RequestMapping(value="/testRESTful/{id}/{username}/{age}")
    public String testRESTful(
            @PathVariable("id")
            int id,
            @PathVariable("username")
            String username,
            @PathVariable("age")
            int age){
        System.out.println(id + "," + username + "," + age);
        return "testRESTful";
    }

    /* @RequestMapping(value="/login", method = RequestMethod.POST)
    public String testMethod(){
        return "testMethod";
    } */

    //@RequestMapping(value="/login", method = RequestMethod.POST)
    @PostMapping("/login")
    public String testMethod(){
        return "testMethod";
    }
/*   GetMapping：要求前端必须发送get请求
  PutMapping：要求前端必须发送put请求
  DeleteMapping：要求前端必须发送delete请求
  PatchMapping：要求前端必须发送patch请求 */

    @RequestMapping(value="/testParams", params = {"username", "password"})
    public String testParams(){
        return "testParams";
    }

    @RequestMapping(value="/testHeaders", headers = {"Referer=http://localhost:8080/springmvc/"})
    public String testHeaders(){
        return "testHeaders";
    }
}
