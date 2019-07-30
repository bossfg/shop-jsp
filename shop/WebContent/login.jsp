<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="style/reset.css" />
    <link rel="stylesheet" type="text/css" href="style/main.css" />
    <script src="js/setHomeSetFav.js" type="text/javascript" charset="gb2312"></script>
    <script src="js/myfocus-2.0.1.min.js" type="text/javascript"></script>
    <script src="js/mf-pattern/mF_YSlider.js" type="text/javascript"></script>
    <link href="js/mf-pattern/mF_YSlider.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
  //获取cookie值
    function getCookieValue(name){
      var name = escape(name);
      //读cookie属性，这将返回文档的所有cookie
      var allcookies = document.cookie;    
      //查找名为name的cookie的开始位置
       name += "=";
      var pos = allcookies.indexOf(name);  
      //如果找到了具有该名字的cookie，那么提取并使用它的值
      if (pos != -1){                       //如果pos值为-1则说明搜索"version="失败
        var start = pos + name.length;         //cookie值开始的位置
        var end = allcookies.indexOf(";",start);    //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置
        if (end == -1) end = allcookies.length;    //如果end值为-1说明cookie列表里只有一个cookie
        var value = allcookies.substring(start,end); //提取cookie的值
        return (value);              //对它解码   
         }  
      else return "";                //搜索失败，返回空字符串
    }
    window.onload = function() {
		document.getElementById("username").value = getCookieValue("cookie_username");
	}
    </script>
</head>
<body>
    <div class="box"> 
        <!--登陆头部-->
        <div class="headerBar">
            <!--logo头部-->
            <div class="logoBar">
                <div class="comWidth clearfix">
                    <div class="logo fl">
                        <a href="index.jsp"><img src="img/logo.png" alt="慕课网logo"></a>    
                    </div>
                    <div class="font fl">
                        <span class="font-1">欢迎登录</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="hr_50">
    </div>
    <div class="loginBox">
        <form action="login" method="post">
            <ul class="login-list">
                <li>用户名</li>
                <li><input type="text" name="username" id="username" class="login-method person" value="getCookie"></li>
                <li class="space15"></li>
                <li>密码</li>
                <li><input type="password" name="password" class="person1"></li>
                <li class="checklogin">
                    <input type="checkbox" name="autoLogin" id="autoLogin" value="1">
                    <label for="login">自动登陆</label>
                    <input type="checkbox" id="safelogin" checked="checked">
                    <label for="safelogin">记住用户名</label>
                    <a href="forget.jsp">忘记密码？</a>
                </li>
                <li>
                    <input type="submit" name="submit" class="login-btn" value="登 录">
                </li>
            </ul>
        </form>
    </div>
    <div class="free-reg clearfix">
        <button class="reg-btn">
            <a href="register.jsp">免费注册&gt;&gt;</a>
        </button>
      </div>
    <div class="hr_50">
    </div>
<!--底部版权区-->
    <div class="footer">
        <p>
            <a href="#">购物简介<i>|</i></a>
            <a href="#">购物公告<i>|</i></a>
            <a href="#">招纳贤士<i>|</i></a>
            <a href="#">联系我们<i>|</i></a>
            <span>客服热线：400-675-1234</span>
        </p>
        <p>Copyright © 2006 - 2018 购物版权所有&nbsp;&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;&nbsp;某市公安局龙潭分局备案编号：32432421231</p>
        <p class="web">
            <a href="#"><img src="img/webLogo.png" alt="logo"></a>
            <a href="#"><img src="img/webLogo.png" alt="logo"></a>
            <a href="#"><img src="img/webLogo.png" alt="logo"></a>
            <a href="#"><img src="img/webLogo.png" alt="logo"></a>
        </p>
    </div>
</body>
</html>