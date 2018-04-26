package com.lyh.main;

import com.lyh.dubbo.demo.IDemoService;
import com.lyh.dubbo.demo.IHelloWorldService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.err.println("consumer启动");
        IHelloWorldService helloWorldService=context.getBean(IHelloWorldService.class);
        System.out.println(helloWorldService.sayHelloWorld());
       // IDemoService demoService=context.getBean(IDemoService.class);
        //System.err.println("consumer");
        //System.err.println(demoService.getPermissions(1L));
    }
}
