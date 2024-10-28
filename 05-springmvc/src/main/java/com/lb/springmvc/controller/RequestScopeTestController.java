package com.lb.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class RequestScopeTestController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        // 向request域中存储数据
        request.setAttribute("testRequestScope", "在SpringMVC中使用原生Servlet API实现request域数据共享");
        return "view";
    }

    // 无论是Model、Map还是ModelMap，底层实例化的对象都是：BindingAwareModelMap。
    // 所以，不管是Model还是Map，底层都是BindingAwareModelMap。
    // 通过继承结构可以看出：BindingAwareModelMap继承了ModelMap，而ModelMap又实现了Map接口。
    // 可以看出ModelMap又实现了Model接口。因此表面上是采用了不同方式，底层本质上是相同的。
    // SpringMVC之所以提供了这些方式，目的就是方便程序员的使用，提供了多样化的方式，可见它的重要性。
    // 所以，在SpringMVC中，使用Model、Map、ModelMap都可以实现request域数据共享。

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        // 向request域中存储数据
        model.addAttribute("testRequestScope", "在SpringMVC中使用Model接口实现request域数据共享");
        return "view";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        // 向request域中存储数据
        map.put("testRequestScope", "在SpringMVC中使用Map接口实现request域数据共享");
        return "view";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        // 向request域中存储数据
        modelMap.addAttribute("testRequestScope", "在SpringMVC中使用ModelMap实现request域数据共享");
        return "view";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建“模型与视图对象”
        ModelAndView modelAndView = new ModelAndView();
        // 绑定数据
        modelAndView.addObject("testRequestScope", "在SpringMVC中使用ModelAndView实现request域数据共享");
        // 绑定视图
        modelAndView.setViewName("view");
        // 返回
        return modelAndView;
    }
}