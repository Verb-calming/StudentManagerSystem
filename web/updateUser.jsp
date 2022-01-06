<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2021/12/15
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <table>
        <tr><td>用户名：<input id="username" type="text" name="username"></td></tr>
        <tr><td>密&nbsp;码&nbsp;&nbsp;：<input id="password" type="password" name="password"></td></tr>
        <tr>
            <td>权&nbsp;限&nbsp;&nbsp;：<input id="lvl1" type="radio" name="level" value="用户" checked="checked"><span>用户</span>
                <input id="lvl2" type="radio" name="level" value="管理员"><span>管理员</span></td>
        </tr>
        <tr>
            <span id="msg" style="color: red;font-size: 8px"></span>
            <td><input id="update" type="button" value="更改"></td>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript" src="js/admin.js"></script>
</html>
