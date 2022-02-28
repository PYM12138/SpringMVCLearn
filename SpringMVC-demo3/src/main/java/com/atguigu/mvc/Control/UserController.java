package com.atguigu.mvc.Control;

import com.atguigu.mvc.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    /*
    * RestFul风格:
    * /user         GET     查询全部用户信息
    * /user/1       GET     根据ID查询用户信息
    * /user         POST    增加用户信息
    * */

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询全部用户");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("查询单个用户"+"id:"+id);
        return "success";
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public String addUser(User user){
        System.out.println("增加用户");
        System.out.println(user);
        return "success";
    }
    @RequestMapping(value = "/user" ,method = RequestMethod.PUT)
    public String updateUser(User user){
        System.out.println("修改用户");
        System.out.println(user);
        return "success";
    }






}
