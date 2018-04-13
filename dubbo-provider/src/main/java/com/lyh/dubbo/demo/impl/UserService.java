package com.lyh.dubbo.demo.impl;

import com.lyh.dubbo.demo.IUserService;
import com.lyh.entity.User;
import com.lyh.mapper.IUserMapper;
import com.lyh.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService extends SessionUtil implements IUserService {
    @Override
    public boolean validateUser(String username, String pwd) {
        boolean flag=false;
        try{
            SqlSession sqlSession=getSession();
            IUserMapper mapper=sqlSession.getMapper(IUserMapper.class);
            User user=mapper.validateUser(new User(username,pwd));
            if(null!=user) flag=true;
            else flag=false;
        }catch (Exception e){
            e.printStackTrace();
            flag=false;
        }
        return flag;
    }
    public static void main(String[] args){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService userService=(IUserService) context.getBean("userService");
        boolean flag=userService.validateUser("ss","123");
        System.out.println(flag);
    }
}
