package com.atguigu.mvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 讲解requestMapping 注释
 * */
@Controller //把该类放入到IOC容器中，总共有四个标识符，都是注册用的

@RequestMapping("/hallo")//在类上面的是初始路径
public class RequestMappingController {

    @RequestMapping("/success") //在方法上的是具体路径，那么访问路径就是 初始路径+具体路径
    public String success(){
        return "success";
    }


    @RequestMapping(value = {
            "/test1","/test2"
    }) //value属性是一个String类型的数组,只要请求地址对应其中任意一个都会进入该方法
    public String success1(){
        return "success";
    }

    @RequestMapping(value = {
            "/test3"
    },method = {RequestMethod.POST}) //method的属性，要是没有设置，则任何请求方式都能进来，只要请求地址对了就行。要是设置了，不仅要地址对，还要对应的method的属性才行
   //常用的method属性:GET POST PUT DELETE
    public String success2(){
        return "success";
    }
    /*
    * 关于method属性，有四个派生注解
    * @GETMapping
    * @POSTMapping
    * @PUTMapping
    * @DELETEMapping
    * 用这些注解，就已经给定了method属性，只要在括号里面写请求地址就好了
    * 浏览器目前仅支持get和Post请求，如果设置的是Put或者DELETE请求，默认转化为GET请求。具体怎么用PUT和DELETE后面会讲到。注意听
    * */


    //params属性,如果设置了则请求中必须包含该属性，但不是唯一,在key前面加！或是value前面加！表示必须不包含，只要包含就报错
    //还有headers属性这里不演示了，知道就好
    @RequestMapping(value = "/testParams"
            ,params = {"username=admin"} )
    public String testParams(){
        return "success";
    }


    //ant风格-->类似于模糊查询
    /*
    * “?”:代表任意单个字符
    * ”*“:表示0个或任意一个字符
    * ”**“：表示任意一层目录或多层目录
    * */
    @RequestMapping(value = "/**/testant")
    public String ant(){
        return "success";
    }

    //restful风格，通过占位符"{}"的形式
    @RequestMapping("/testFul/{id}")
    public String restful(@PathVariable("id") Integer id){//用@PathVariable获取占位符内容，然后再后面加一个形参去接收或者说转换值
        System.out.println("id:  "+id);
        return "success";
    }




}
