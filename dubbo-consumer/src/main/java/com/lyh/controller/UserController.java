package com.lyh.controller;

import com.lyh.dubbo.demo.IUserService;
import com.lyh.entity.User;
import net.sf.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("userController")
public class UserController {
    @RequestMapping("/validateUser")
    public String validateUser(String username, String password){
        JSONObject jb=new JSONObject();
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.err.println("消费者启动");
        IUserService userService=context.getBean(IUserService.class);
        boolean flag=userService.validateUser(username,password);
        if(flag) return "success";
        else return "failure";
    }
}
