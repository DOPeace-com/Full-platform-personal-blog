package com.peace.mapper;

/*
* Mapper就是常说的Dao层
* 用处：
* 数据持久层，用来封装增删改查的数据库方式
* */

import com.peace.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User login(@Param("user_id") String user_id,@Param("user_password") String user_password);
}
