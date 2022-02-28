package com.atguigu.mvc.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class TestSessionAndServletContext {
    /*
    * 1.向session域对象共享数据，用原生的Servlet方式。SpringMVC的方式没讲
    * 2.向Application域对象共享数据，用原生的Servlet方式扩大session范围。
    * */

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","session,hallo");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","ServletContext,hallo");
        return "success";
    }

}
