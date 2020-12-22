function checkInput(){
    //验证用户输入
    //获取对象
    var userName=document.getElementById("username");
    var password=document.getElementById("password");
    var password2=document.getElementById("password2");
    //验证
    if (userName.value==""){
        alert("用户名未填写")
        return false;
    }if (userName.value.length<2){
        alert("密码长度至少为2")
        return false;
    }
    //可以使用正则表达式
    if (password.value==""){
        alert("密码不能为空");
        return false;
    }
    if (password.value.length<6){
        alert("密码长度至少为6");
        return false;
    }
    if (password.value!=password2.value){
        alert("两次密码不一致");
        return false;
    }
        return true;

}

    // var register=document.getElementById("register");
    // register.onsubmit=checkInput();
    // register.onsubmit();