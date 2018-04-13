package com.lyh.dubbo.demo.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException{
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        System.err.println(context.getDisplayName()+":here");
        context.start();
        System.err.println("服务已经启动");
        System.in.read();
    }
}
