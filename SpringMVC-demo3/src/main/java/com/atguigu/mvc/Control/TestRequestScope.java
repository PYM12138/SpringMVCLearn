package com.atguigu.mvc.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TestRequestScope {
    /*
    * 通过request域对象共享数据
    * 1.原生的servletAPI的方式，在控制器的形参添加HttpServletRequest然后调用setAttribute的方式(不演示)。
    * 2.通过ModelAndView(对象，返回值)的方式，里面包含了Model和View两个功能。
    * 3.用Model(形参)的方式。
    * 4.用map集合(形参)的方式。
    * 5.用ModelMap(形参)的方式。
    * */

    @RequestMapping("/testModelAndView")
    public ModelAndView testMAV(){
        ModelAndView modelAndView = new ModelAndView();
        //设置request键值对
        modelAndView.addObject("testRequestScope","hallo,MAV");
        //设置视图名称,Themyleaf帮你自动解析
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","model,hallo");
        return "success";
    }
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","map,hallo");
        return "success";
    }
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","modelMap,hallo");
        return "success";
    }


}
