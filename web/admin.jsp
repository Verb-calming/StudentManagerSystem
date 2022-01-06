<%@ page import="com.gmu.system.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2021/12/13
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>学生信息管理系统</title>
        <link rel="stylesheet" type="text/css" href="css/admin.css">
    </head>
    <body>
    <%
        User user = (User) session.getAttribute("admin");
        if(user != null){
    %>
        <header>
            <div class="title">
                <span>管理员操作界面</span>
            </div>
            <nav>
                <div class="userInfo">
                    <ul>
                        <li><%=user.getUsername()%></li>
                        <li><%=user.getLevel() %></li>
                        <li><a href="/myWeb/exit">退出登入</a></li>
                        <li><a href="login.html">返回首页</a></li>
                    </ul>
                </div>
            </nav>
        </header>

        <main>
            <%
                }else{
                    response.sendRedirect("login.html");
                }
            %>
            <div class="container">
                <div class="select">
                    <h3>请选择操作</h3>
                    <ul id="accordion" class="accordion">
                        <li>
                            <div id="user-info" class="link">用户信息管理</div>
                            <ul class="submenu">
                                <li><a href="javascript:void(0)" id="queryUser">查看所有用户</a></li>
                                <li><a href="javascript:void(0)" id="addUser">新增用户信息</a></li>
                                <li><a href="javascript:void(0)" id="deleteUser">删除指定用户</a></li>
                                <li><a href="javascript:void(0)" id="updateUser">修改用户信息</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div id="result" class="result">
                    <p class="welcome">欢迎使用学生信息管理系统！</p>
                </div>
            </div>
        </main>

        <footer>
            <div class="copyright">
                &copy; Copyright. All rights reserved. Design by <a href="#">Verb</a>
            </div>
        </footer>
    </body>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/admin.js"></script>
</html>
