package com.lyh.mapper;

import com.lyh.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IUserMapper {
    @Select("select * from t_user where userName = #{user.username} and password= #{user.password}")
    public User validateUser(@Param("user") User user);
}
