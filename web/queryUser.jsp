<%@ page import="java.util.List" %>
<%@ page import="com.gmu.system.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2021/12/14
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/query.css">
</head>
<body>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
    %>
    <div>
        <div id="top_text"><h2 align="center">用户信息展示</h2></div>
        <div align="center">
            <form name="updateForm" action="/myWeb/check" method="post">
                <table class="tables">
                    <tr>
                        <th>用户姓名</th>
                        <th>用户密码</th>
                        <th>权限级别</th>
                        <th>操作</th>
                    </tr>
                    <%
                        for (int i = 0;i < users.size();i++){
                    %>
                    <tr>
                        <%--<td><input type="text" name="id" value="<%=users.get(i).getUsername()%>"></td>
                        <td><input type="text" name="sname" value="<%=users.get(i).getPassword()%>"></td>
                        <td><input type="text" name="sex" value="<%=users.get(i).getLevel()%>"></td>--%>
                        <td><%=users.get(i).getUsername()%></td>
                        <td><%=users.get(i).getPassword()%></td>
                        <td><%=users.get(i).getLevel()%></td>
                        <td><a href="javascript:void(0)" id="deleteUser">删除</a></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </form>
            <%--<div class="bottom_div">
                <div class="bottom_right_div">
                    <div class="bottom_tool_div">
                        <div class="bottom_inner_left_div">
                            <table width="352px" height="35px" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="25%" height="29" nowrap="nowrap">
                                        <span>共${requestScope.totalSize}条纪录，当前第${requestScope.pageNo}/${requestScope.pageCount}页，每页${requestScope.pageSize}条纪录</span>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <%
                            boolean isNotFirstPage =  pageNo > 1;
                            boolean isNotLastPage = pageNo < pageCount;
                        %>
                        <div class="bottom_inner_right_div">
                            <table width="352px" height="35px" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td width="30" height="22" valign="middle"><div align="right"><img src="images/firstPage<%= isNotFirstPage ? "":"Disabled"%>.gif" <%=isNotFirstPage ? "style='cursor: pointer;' onclick='changePage(1)'":""%>></div></td>
                                    <td width="30" height="22" valign="middle"><div align="right"><img src="images/prevPage<%= isNotFirstPage ? "":"Disabled"%>.gif" <%=isNotFirstPage ? "style='cursor: pointer;' onclick='changePage("+ (pageNo-1) +")''":""%>></div></td>
                                    <td width="30" height="22" valign="middle"><div align="right"><img src="images/nextPage<%= isNotLastPage ? "":"Disabled"%>.gif" <%=isNotLastPage ? "style='cursor: pointer;' onclick='changePage("+ (pageNo+1) +")''":""%>></div></td>
                                    <td width="30" height="22" valign="middle"><div align="right"><img src="images/lastPage<%= isNotLastPage ? "":"Disabled"%>.gif" <%=isNotLastPage ? "style='cursor: pointer;' onclick='changePage("+ pageCount +")''":""%>></div></td>
                                    <td width="59" height="22" valign="middle"><div align="right">转到第</div></td>
                                    <td width="25" height="22" valign="middle">
                                    <span>
                                        <input id="myPageNo" type="text" style="height:14px; width:25px;text-align:right" size="5">
                                    </span>
                                    </td>
                                    <td width="23" height="22" valign="middle">页</td>
                                    <td width="30" height="22" valign="middle"><img onclick="getToPage()" style="cursor: pointer" src="images/go.gif" width="37" height="15"></td>
                                    <span id="error"></span>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>--%>
        </div>
    </div>
</body>
</html>
