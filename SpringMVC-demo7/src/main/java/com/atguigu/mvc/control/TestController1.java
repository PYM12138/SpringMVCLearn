package com.atguigu.mvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TestController1 {
    @RequestMapping(value = "/getResponseBody")
    @ResponseBody
    public String getResponseBody()  {
        //可以把当前控制器方法的返回值直接当作响应数据发送到浏览器
        //需要配置 <mvc:message-converters>
        return "这个地方不知道为什么不能写中文(需要配置 <mvc:message-converters>)";
    }
}
