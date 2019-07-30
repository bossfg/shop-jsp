<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="style/reset.css" />
<link rel="stylesheet" type="text/css" href="style/main.css" />
<script src="js/setHomeSetFav.js" type="text/javascript"
	charset="gb2312"></script>
<script src="js/myfocus-2.0.1.min.js" type="text/javascript"></script>
<script src="js/mf-pattern/mF_YSlider.js" type="text/javascript"></script>
<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<link href="js/mf-pattern/mF_YSlider.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	$(function() {
		$('#registForm').validate({
			rules : {
				"username" : {
					"required" : true,
					"checkUsername":true
				},
				"password" : {
					"required" : true,
					"rangelength" : [ 6, 12 ]
				},
				"confirmpwd" : {
					"required" : true,
					"rangelength" : [ 6, 12 ],
					"equalTo" : "#password"
				},
				"email" : {
					"required" : true,
					"email" : true
				},
				"telephone" : {
					"required" : true
				},
				"name" : {
					"required" : true
				},
				"birthday" : {
					"required" : true,
					"date" : true
				},
				"sex" : {
					"required" : true
				}
			},
			messages : {
				"username" : {
					"required" : "用户名不能为空",
					"checkUsername":"用户名已存在"
				},
				"password" : {
					"required" : "密码不能为空",
					"rangelength" : "密码长度在6-12位"
				},
				"confirmpwd" : {
					"required" : "确认密码不能为空",
					"rangelength" : "确认密码长度在6-12位",
					"equalTo" : "两次密码不一致"
				},
				"email" : {
					"required" : "邮箱不能为空",
					"email" : "邮箱格式不正确"
				},
				"telephone" : {
					"required" : "电话不能为空"
				},
				"name" : {
					"required" : "真实姓名不能为空"
				},
				"birthday" : {
					"required" : "生日不能为空",
					"date" : "日期格式不正确"
				},
				"sex" : {
					"required" : "性别必须选择"
				}
			},
			errorPlacement : function(error, element) { //指定错误信息位置
				if (element.is(':radio') || element.is(':checkbox')) { //如果是radio或checkbox

					error.appendTo(element.parent().parent()); //将错误信息添加当前元素的父结点后面
				} else {
					error.insertAfter(element);
				}
			}
		});
	});
	$.validator.addMethod(
			"checkUsername",//自定义校验规则的名称
			function(value,element,params){//自定义校验规则的实现
				//value)表单元素值
				//element)校验的元素对象
				//params)校验规则输入的参数
				var flag = true;
				//发送一个Ajax，到服务器进行验证用户存在
				$.ajax({
					"async":false,//同步操作
					"url":"${pageContext.request.contextPath}/checkUsername",
					"type":"POST",
					"data":{"username":value},
					"dataType":"json",
					"success":function(data){
						flag = data.isExist;//true--存在  false--不存在
					}
				});
				//需要返回值 false----该校验器校验失败    true---校验通过
				return !flag;
			}
 );
</script>
<script type="text/javascript">
	function generate() {
		document.getElementById("codeimg").src = "checkImgServlet?"
				+ new Date().getTime();
	}
	<!--
	function check() {
		if (document.getElementById("agree").checked == false) {
			document.getElementById("submit").disabled = "disabled";
			//alert("fasle");
		} else {
			document.getElementById("submit").disabled == "";
			//alert("true");
		}
	}
	-->
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
						<span class="font-1">欢迎注册</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="hr_50"></div>
	<div class="logonBox">
		<form  id="registForm" method="post" action="regist">
			<ul class="logon-list">
				<li><span><b class="redtip">*</b>账户名：</span> <input type="text"
					name="username" id="username" placeholder="邮箱/用户名/手机号"
					class="person2 person"></li>
				<li><span><b class="redtip">*</b>密码：</span> <input
					type="password" name="password" id="password" class="person person1"></li>
				<li><span><b class="redtip">*</b>确认密码：</span> <input
					type="password" name="confirmpwd" id="confirmpwd"  class="person person1"></li>
				<li><span><b class="redtip">*</b>邮箱：</span> <input type="text"
					name="email"  id="email" class="person person1"></li>
				<li><span><b class="redtip">*</b>姓名：</span> <input type="text"
					name="name"  id="name" class="person"></li>
				<li><span><b class="redtip">*</b>验证码：</span> <input type="text"
					name="identify"  id="identify" class="person3">
					 <img src="checkImgServlet" alt="验证码" id="codeimg" onclick="generate()"/> <a href="#identify"
					onclick="generate()">看不清？换一张</a></li>
			</ul>
			<div class="readyAgree">
				<input type="checkbox" checked="checked" class="agreeA" id="agree">我已阅读并同意 <a href="#" class="userAgreement">《用户注册协议》</a>
				<input type="submit" class="agreeC" value="提 交" name="submit"
					id="submit">
			</div>
		</form>
	</div>
	<div class="hr_50"></div>
	<!--底部版权区-->
	<div class="footer">
		<p>
			<a href="#">购物简介<i>|</i></a> <a href="#">购物公告<i>|</i></a> <a href="#">招纳贤士<i>|</i></a>
			<a href="#">联系我们<i>|</i></a> <span>客服热线：400-675-1234</span>
		</p>
		<p>Copyright © 2006 - 2018
			购物版权所有&nbsp;&nbsp;&nbsp;&nbsp;京ICP备09037834号&nbsp;&nbsp;&nbsp;&nbsp;某市公安局龙潭分局备案编号：32432421231</p>
		<p class="web">
			<a href="#"><img src="img/webLogo.png" alt="logo"></a> <a
				href="#"><img src="img/webLogo.png" alt="logo"></a> <a
				href="#"><img src="img/webLogo.png" alt="logo"></a> <a
				href="#"><img src="img/webLogo.png" alt="logo"></a>
		</p>
	</div>
</body>
</html>