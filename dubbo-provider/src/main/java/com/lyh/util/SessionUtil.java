package com.lyh.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SessionUtil{
    private SqlSessionFactory sqlSessionFactory;
    private  SqlSession sqlSession=null;
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public SqlSession getSession(){
        SqlSession session=null;
        try{
            if(null==this.sqlSession)
            session= this.getSqlSessionFactory().openSession();
            else session=this.sqlSession;
        }catch (Exception e){
            e.printStackTrace();
        }
        return session;
    }
}
