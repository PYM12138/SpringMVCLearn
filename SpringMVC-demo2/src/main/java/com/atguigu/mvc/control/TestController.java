package com.atguigu.mvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/params")
    public String params(){
        return "test_param";
    }
}
