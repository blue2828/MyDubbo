package com.lyh.controller;

import com.lyh.dubbo.demo.IUserService;
import com.lyh.entity.User;
import net.sf.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller("userController")
public class UserController {
    @ResponseBody
    @RequestMapping("/validateUser")
    public JSONObject validateUser(String username,String password){
        JSONObject jb=new JSONObject();
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.err.println("消费者启动");
        IUserService userService=context.getBean(IUserService.class);
        boolean flag=userService.validateUser(username,password);
        if(flag) jb.put("success",true);
        else {
            jb.put("success",false);
            jb.put("errMsg","验证失败");
        }
        return jb;
    }
}
