package com.atguigu.control;


import com.atguigu.bean.User1;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RequestAndResponseController {
    @RequestMapping(value = "/getRequestBody")
    public String getRequestBody(@RequestBody String body){
        System.out.println("requestBody:"+body);
        return "success";
    }
    @RequestMapping(value = "/getRequestEntity")
    public String getRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("Headers"+requestEntity.getHeaders());
        System.out.println("body"+requestEntity.getBody());
        return "success";
    }
    @RequestMapping(value = "/getResponse")
    public void getResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("idonot");
    }

    @RequestMapping(value = "/getResponseBody")
    @ResponseBody
    public String getResponseBody()  {
        //可以把当前控制器方法的返回值直接当作响应数据发送到浏览器
        //需要配置 <mvc:message-converters>
        return "这个地方不知道为什么不能写中文(需要配置 <mvc:message-converters>)";
    }

    @RequestMapping(value = "/getResponseUser")
    @ResponseBody
    public User1 getResponseUser(){
        //SpringMVC处理对象，先转换成JSON对象，然后浏览器显示数据
        return new User1(1001,"张三","16025",17,"男");
    }
    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username, String password){
        //处理ajax的响应，可以接收传过来的，也可以发送要响应的数据
        System.out.println("username:"+username+",password:"+password);
        return "hello,ajax";
    }



}
