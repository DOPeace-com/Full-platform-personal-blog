package com.peace.service;

import com.peace.mapper.UserMapper;
import com.peace.pojo.User;
import com.peace.util.SqlServiceFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlServiceFactoryUtil.getSqlSessionFactory();

    /**
     * 登录方法
     * @param userid
     * @param password
     * @return
     */
    public User login(String userid,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.login(userid, password);
        sqlSession.close();
        return user;
    }
}
