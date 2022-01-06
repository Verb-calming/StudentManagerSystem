$("#queryUser").click(function () {
    $.ajax({
        type:"GET",
        url:"admin?action=queryUser",
        success:function (data) {
            $("#result").html(data);
        }
    })
})
$("#addUser").click(function () {
    $.ajax({
        type:"GET",
        url:"admin?action=addUser",
        success:function (data) {
            $("#result").html(data);
        }
    })
})
$("#commit").click(function () {
    var username = $("#username").val();
    var password = $("#password").val();
    var lvl1 = document.getElementById("lvl1");
    var lvl2 = document.getElementById("lvl2");
    var lvl;
    if (lvl1.checked) lvl = lvl1.value;
    else if (lvl2.checked) lvl = lvl2.value;
    $.post("add",{username:username,password:password,lvl:lvl},function (data) {
        $("#result").html(data);
    })
})
$("#deleteUser").click(function () {
    var result = $("#result");
    var show = null;
    show = "<div align='center'>"
        + "<h3>请输入删除用户信息</h3>"
        + "<input id='username' type='text' autofocus='autofocus' name='username' value placeholder='用户名'  required>"
        + "<input id='getOn' type='button' onclick='delete_user()' name='submit' value='删除'>"
        + "<br>"
        + "<span id='msg' font-size='red'></span>"
        + "</div>";
    result.html(show);
})
function delete_user() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState === 4 && xmlHttp.status === 200){
            document.getElementById("msg").innerText = xmlHttp.responseText;
        }
    }
    var username = document.getElementById("username").value.toString();
    xmlHttp.open("GET","admin?action=deleteUser&username="+username,true);
    xmlHttp.send();
}
/*
$("#updateUser").click(function () {
    var result = $("#result");
    var show = null;
    show = "<div align='center'>"
        + "<h3>请输入需要更新的用户信息</h3>"
        + "<input id='username' type='password' autofocus='autofocus' name='username' value placeholder='用户名'  required>"
        + "<br>"
        + "<input id='password' type='password' autofocus='autofocus' name='username' value placeholder='密码'  required>"
        + "<br>"
        + "<input id='lvl1' type='radio' name='level' value= '用户' checked='checked'><span>用户</span>"
        + "<input id='lvl2' type='radio' name='level' value='管理员'><span>管理员</span>"
        + "<br>"
        + "<input id='update' type='button' onclick='update_user()' name='submit' value='更新'>"
        + "<br>"
        + "<span id='msg' font-size='red'></span>"
        + "</div>";
    result.html(show);
})
function update_user() {
    $.ajax({

    })
}*/
$("#updateUser").click(function () {
    $.ajax({
        type:"GET",
        url:"admin?action=updateUser",
        success:function (data) {
            $("#result").html(data);
        }
    })
})
$("#update").click(function () {
    var username = $("#username").val();
    var password = $("#password").val();
    var lvl1 = document.getElementById("lvl1");
    var lvl2 = document.getElementById("lvl2");
    var lvl;
    if (lvl1.checked) lvl = lvl1.value;
    else if (lvl2.checked) lvl = lvl2.value;
    $.post("update",{username:username,password:password,lvl:lvl},function (data) {
        $("#result").html(data);
    })
})
