package com.atguigu.mvc.control;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class GetParamController {
    /*
    * 获取请求参数的形式：
    * 1.使用restful风格，用占位符去获取对应值，在浏览器则用”/“的方式把值拼接起来
    * 2.用原生的ServletAPI,直接在控制器方法写Request形参就能调用了，不演示了。
    * 3.用SpringMVC的方式,请求参数名和你的控制器形参名保持一致，自动赋值。
    * */

    @RequestMapping("/testParams")
    public String params(String username,String[] hobby,String password){
        //多个同名参数用一个字符数组接收
        //经过测试，请求参数名和形参名一致即可，位置不需要一一对应。

        System.out.println("username:"+username+" hobby:"+ Arrays.toString(hobby)+" password:"+password);
        return "success";
    }
    @RequestMapping("/testParams1")
    public String params1(
            //遇到请求参数名和形参名不一致的，可以用@RequestParam 注解，去创建一个映射让它们相连。
            //但是要注意，如果使用该注解，那么这个请求参数就必须要有，没有则会报错。（此时你的形参名无效,主要依据变成了 @RequestParam的value）。
            //可以设置 required = false 把它关闭。当你关闭required，此时默认值是Null。
            //可以用defaultValue =  来设置默认值。不管你的required是什么，只要你设置了默认值，一样不会报错（空串也不会报错）。自动赋值默认值。
            //一般来说，required和defaultValue应该配合起来使用最佳。
            @RequestParam(value = "user_name",defaultValue = "hehe") String username,
            String[] hobby,
            String password){

        /*
        * 还有两个注释:@RequestHeader、 @CookieValue
        * 一个是请求头，一个是cookie(session依赖cookie)
        * 这两个注释的属性也是有三个，跟上面的一样。然后要是想要获取请求头就必须要用@RequestHeader。
        * */

        System.out.println("username:"+username+" hobby:"+ Arrays.toString(hobby)+" password:"+password);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        /*
        * GET请求乱码要去设置tomcat的配置文件
        * POST请求乱码要设置web.xml的filter过滤器
        * */

        System.out.println(user);
        return "success";
    }


}
