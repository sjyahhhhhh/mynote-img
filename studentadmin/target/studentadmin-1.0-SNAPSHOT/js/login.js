function checkInput(){
    //验证用户输入
    //获取对象
    var userName=document.getElementById("username");
    var password=document.getElementById("userpassword");
    //验证
    if (userName.value==""){
        alert("用户名未填写")
        return false;
    }
    //可以使用正则表达式
    if (userpassword.value==""){
        alert("密码不能为空");
        return false;
    }
    return true;

}