package com.lyh.main;

import com.lyh.dubbo.demo.IDemoService;
import com.lyh.dubbo.demo.IHelloWorldService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.Inet4Address;

public class Consumer extends Thread{
    private static int flag=1;
    private String arg[]=new String[2];
    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println(arg[0]+arg[1]);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    public void returnStr(IHelloWorldService helloWorldService)throws  Exception{
        this.arg[0]= helloWorldService.sayHelloWorld()[0];
        this.arg[1]= helloWorldService.sayHelloWorld()[1];
    }
    public static void main(String[] args)throws  Exception{
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        IHelloWorldService helloWorldService=context.getBean(IHelloWorldService.class);
        System.err.println("consumer启动");
        Consumer consumer=new Consumer();
        consumer.returnStr(helloWorldService);
        Thread t=new Thread(consumer,"t1");
        t.start();
    }
}
