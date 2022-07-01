package com.peace.web;

import com.alibaba.fastjson.JSON;
import com.peace.pojo.User;
import com.peace.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String userpassword = req.getParameter("userpassword");

        UserService userService = new UserService();
        User user = userService.login(userid, userpassword);
        System.out.println(user);
        System.out.println("Have a use");
        String s = JSON.toJSONString(user);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
