package com.gmu.system.controller;

import com.gmu.system.dao.UserDao;
import com.gmu.system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username,password,lvl;
        username = request.getParameter("username");
        password = request.getParameter("password");
        lvl = request.getParameter("lvl");
        User user = new User(username,password,lvl);
        int result = UserDao.add(user);
        if (result == 1) request.getRequestDispatcher("addUser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
