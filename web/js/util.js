FormItem = function (name) {
    this.name = name;
}
//登入和注册判断账户或者密码是否为空
LOGIN = function () {
    this.isNotEmpty = function (formItemArray) {
        for (var i = 0;i < formItemArray.length;i++){
            var formItem = formItemArray[i];
            var name = formItem.name;
            var obj = document.getElementById(name);
            if (obj.value == ""){
                obj.focus();
                return false;
            }
        }
        return true;
    }
}
var util = new LOGIN();