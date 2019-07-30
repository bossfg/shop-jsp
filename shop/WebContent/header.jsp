<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品列表</title>
<link rel="stylesheet" type="text/css" href="style/reset.css" />
<link rel="stylesheet" type="text/css" href="style/main.css" />
<script src="js/setHomeSetFav.js" type="text/javascript" charset="gb2312"></script>
<script src="js/myfocus-2.0.1.min.js" type="text/javascript"></script>
<script src="js/mf-pattern/mF_YSlider.js" type="text/javascript"></script>
<link href="js/mf-pattern/mF_YSlider.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
        myFocus.set({
            id:'picBox'
        })
</script>

</head>
<body>
    <!--头部-->
    <div class="box"> 
        <!--登陆头部-->
        <div class="headerBar">
            <div class="topBar">
                <div class="comWidth">
                    <div class="leftArea">
                        <a href="#" class="collection">收藏购物网</a>
                    </div>
                    <div class="rightArea">
                        <c:choose>
							<c:when test="${empty user }">
								<span>您好，请</span>
								<a href="login.jsp">[登录]</a>
								<a href="register.jsp">[免费注册]</a>
							</c:when>
							<c:otherwise>
								<span>欢迎您，${ user.username}！</span>
								<span style="color: blue;"><a href="logout">注销</a></span>
							</c:otherwise>
						</c:choose>
                    </div>
                </div>
            </div>
            <!--logo头部-->
            <div class="logoBar">
                <div class="comWidth">
                    <div class="logo fl">
                        <a href="index"><img src="img/logo.png" alt="慕课网logo"></a>
                        </div>
                    <div class="search_box fl">
                        <input type="text" class="search_text fl" value="搜索">
                        
                    </div>
                    <div class="shopCar fr">
                        <a href="car.jsp" class="shopText fl">购物车</a>
						<c:if test="${empty  sessionScope.totalNum }">
							<a href="car.jsp" class="shopNum fl">0</a>
						</c:if>
						<c:if test="${not empty  sessionScope.totalNum }">
							<a href="car.jsp" class="shopNum fl">${sessionScope.totalNum }</a>
						</c:if>
                    </div>
                </div>
            </div>
            <!--标题头部-->
            <div class="navBox">
                <div class="comWidth">
                    <div class="shopClass fl">
                        <h3>全部商品分类<span></span></h3>
                        </div>
                    </div>
                   <ul class="nav fl">
					<c:forEach items="${applicationScope.categoryList }" var="category">
						<li style="font-size: 15px; font-family: 微软雅黑;"><a href="filter?cid=${category.cid }">${category.cname}</a></li>
					</c:forEach>
				</ul>
                </div>
            </div>
        </div>
        <div class="hr_17">
        </div>
		
</body>
</html>