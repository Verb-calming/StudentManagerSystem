package com.gmu.system.controller;

import com.gmu.system.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username,password;
        username = request.getParameter("username");
        password = request.getParameter("password");
        int result = LoginDao.register(username,password);
        if (result == 1) request.getRequestDispatcher("/login.html").forward(request,response);
        else response.sendRedirect("register.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
