<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN" "http://www.w3.org/TR/jsp4/loose.dtd">
<jsp>
<head>
<title>重置密码</title>
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
		$('#forgetForm').validate({
			rules : {
				"email" : {
					"required" : true,
					"email" : true,
					"checkEmail" : true
				}
			},
			messages : {
				"email" : {
					"required" : "邮箱不能为空",
					"email" : "邮箱格式不正确",
					"checkEmail" : "该邮箱未注册"
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

		$('#pwdForm').validate({
			rules : {
				"password" : {
					"required" : true,
					"rangelength" : [ 1, 10 ]
				},
				"confirmpwd" : {
					"required" : true,
					"rangelength" : [ 1, 10 ],
					"equalTo" : "#password"
				}
			},
			messages : {
				"password" : {
					"required" : "密码不能为空",
					"rangelength" : "密码长度在1-10位"
				},
				"confirmpwd" : {
					"required" : "确认密码不能为空",
					"rangelength" : "确认密码长度在1-10位",
					"equalTo" : "两次密码不一致"
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
	$.validator.addMethod("checkEmail",//自定义校验规则的名称
	function(value, element, params) {//自定义校验规则的实现
		//value)表单元素值
		//element)校验的元素对象
		//params)校验规则输入的参数
		var flag = true;
		//发送一个Ajax，到服务器进行验证用户存在
		$.ajax({
			"async" : false,//同步操作
			"url" : "${pageContext.request.contextPath}/checkEmail",
			"type" : "POST",
			"data" : {
				"email" : value
			},
			"dataType" : "json",
			"success" : function(data) {
				flag = data.isExist;//true--存在  false--不存在
			}
		});
		//需要返回值 false----该校验器校验失败    true---校验通过
		return !flag;
	});
</script>
<script type="text/javascript">
	function setValue() {
		document.getElementById("identify2").value = document
				.getElementById("identify").value;
		//alert(document.getElementById("identify2").value);
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
						<span class="font-1">忘记密码</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="hr_50"></div>
	<div class="logonBox">
		<ul class="logon-list">
			<form action="${pageContext.request.contextPath}/resetPwd"
				method="post" id="forgetForm">
				<li><span><b class="redtip">*</b>邮箱：</span> <input type="text"
					name="email" class="person person1" value="${email }"></li>
				<li><span><b class="redtip">*</b>验证码：</span> <input type="text"
					name="identify" id="identify" class="person3"> <c:if
						test="${empty sendCodeSucess}">
						<input type="submit" class="btn" id="btn" name="getCode"
							value="获取验证码"
							style="color: blue; text-decoration: underline; background-color: transparent; cursor: pointer;"
							onclick="time();">
					</c:if> <c:if test="${not empty sendCodeSucess  }">
						<input type="submit" class="btn" id="btn" name="getCode"
							value="验证码已发送 " disabled="disabled"
							style="color: gray; text-decoration: underline; background-color: transparent; cursor: pointer;"
							onclick="time();">
					</c:if></li>
			</form>
			<form action="${pageContext.request.contextPath}/resetPwd"
				method="post" id="pwdForm">
				<li><span><b class="redtip">*</b>输入新密码：</span> <input
					type="password" name="password" id="password"
					class="person person1"></li>
				<li><span><b class="redtip">*</b>确认密码：</span> <input
					type="password" name="confirmpwd" id="confirmpwd"
					class="person person1"></li> <input type="hidden"
					name="identify" id="identify2" class="person3" value="">
				<div class="readyAgree" style="display: inline;">

					<input type="submit" class="agreeC" value="确认修改" name="submit"
						style="display: inline; width: 100px;" onclick="setValue()">
					<input type="reset" class="agreeC" value="重置" name="submit"
						style="display: inline; width: 100px;">
				</div>
				<span style="font-size: 15px"><a href="login.jsp">去登陆&gt;&gt;</a></span>
			</form>
		</ul>
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
</jsp>