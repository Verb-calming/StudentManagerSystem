package com.gmu.system.controller;

import com.gmu.system.dao.LoginDao;
import com.gmu.system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username,password,level;
        HttpSession session = null;
        username = request.getParameter("username");
        password = request.getParameter("password");
        level = request.getParameter("level");
        User user = LoginDao.login(username,password);
        if (user != null) {
            if (level.equals(user.getLevel()) && "管理员".equals(level)) {
                request.getSession().setAttribute("admin",user);
                request.getRequestDispatcher("admin.jsp").forward(request,response);
            }
            else if (level.equals(user.getLevel()) && "用户".equals(level)) {
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("users.jsp").forward(request,response);
            }
        }
        else {
            request.getRequestDispatcher("/login.html").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
