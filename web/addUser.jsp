<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2021/12/14
  Time: 23:53
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
                <td><input id="commit" type="button" value="添加"></td>
            </tr>
        </table>
    </div>
</body>
<script type="text/javascript" src="js/admin.js"></script>
<%--<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript">
    function validateForm(){
        var formItem1 = new FormItem("username");
        var formItem2 = new FormItem("password");
        var formItemArr = [formItem1,formItem2];
        var result = util.isNotEmpty(formItemArr);
        if (!result) document.getElementById("msg").innerHTML = "<img src='images/010.gif'>账号或密码不能为空";
        return result;
    }
</script>--%>
</html>
