package com.atguigu.mvc.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/testThemyleaf")
    public String themyleafView(){
        return "success";
    }
}
