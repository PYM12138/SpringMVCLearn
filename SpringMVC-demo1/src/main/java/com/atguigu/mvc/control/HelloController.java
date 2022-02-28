package com.atguigu.mvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {//当有两个控制器，里面的方法对应同一个路径，直接编译报错。
    //写一个方法，访问 “/” 路径 ，随后跳转到index.html
    @RequestMapping("/")
    public String index(){
        //返回值会被themyleaf视图解析器处理，在那里面已经写好了路径，只要一个视图名称就可以访问对应的页面了
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }

}
