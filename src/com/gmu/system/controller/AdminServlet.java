package com.gmu.system.controller;

import com.gmu.system.dao.UserDao;
import com.gmu.system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action;
        action = request.getParameter("action");
        switch (action){
            case "queryUser":
                queryUser(request,response);break;
            case "addUser":
                addUser(request,response);break;
            case "deleteUser":
                deleteUser(request,response);break;
            case "updateUser":
                updateUser(request,response);break;
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("updateUser.jsp").forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username;
        username = request.getParameter("username");
        PrintWriter out = null;
        response.setContentType("text/html;charset=utf-8");
        int result = UserDao.delete(username);
        System.out.println(result);
        out = response.getWriter();
        if (result == 1) out.print("删除成功！");
        else out.print("删除失败！");
        out.flush();
        out.close();
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addUser.jsp").forward(request,response);
    }

    private void queryUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = null;
        users = UserDao.select();
        request.setAttribute("users",users);
        request.getRequestDispatcher("queryUser.jsp").forward(request,response);
    }
}
