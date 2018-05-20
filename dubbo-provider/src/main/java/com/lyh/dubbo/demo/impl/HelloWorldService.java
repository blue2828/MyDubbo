package com.lyh.dubbo.demo.impl;

import com.lyh.dubbo.demo.IHelloWorldService;

import java.net.Inet4Address;

public class HelloWorldService implements IHelloWorldService {
    @Override
    public String[] sayHelloWorld() throws Exception{
        String[] str=new String[]{"hello world!", Inet4Address.getLocalHost().toString()};
        return str;
    }
}
