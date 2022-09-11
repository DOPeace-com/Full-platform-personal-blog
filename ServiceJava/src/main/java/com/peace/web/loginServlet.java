package com.peace.web;

import com.alibaba.fastjson.JSON;
import com.peace.pojo.User;
import com.peace.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin","*");
        String userid = req.getParameter("userid");
        String userpassword = req.getParameter("userpassword");

        UserService userService = new UserService();
        User user = userService.login(userid, userpassword);
        if (user != null){
            /*
            * 查询到了用户数据代表用户不为空，登录成功
            * */
            Date date = new Date();// 获取当前时间
            System.out.println(user.getUser_name()+"登录成功---登录时间:"+date);
            //将用户的登录数据转成json
            String s = JSON.toJSONString(user);
            //暂时用cookic直接发送会客户端做登录处理，之后在做加密处理
            Cookie cookie = new Cookie("longinCheck",s);
            cookie.setMaxAge(60*60*24);
            resp.addCookie(cookie);
            resp.getWriter().write("success");
        }else{
            System.out.println("非法用户");
            resp.getWriter().write("error");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
