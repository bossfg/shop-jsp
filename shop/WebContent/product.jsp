<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品列表</title>
<link rel="stylesheet" type="text/css" href="style/reset.css" />
<link rel="stylesheet" type="text/css" href="style/main.css" />
<script src="js/setHomeSetFav.js" type="text/javascript"
	charset="gb2312"></script>
<script src="js/myfocus-2.0.1.min.js" type="text/javascript"></script>
<script src="js/mf-pattern/mF_YSlider.js" type="text/javascript"></script>
<link href="js/mf-pattern/mF_YSlider.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	//获取page，修改输入框
	function getQueryString(name) {
		var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
		var r = window.location.search.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		}
		return 1;
	}
	// 这样调用：
	window.onload = function() {
		document.getElementById("currentPage").value = getQueryString("page");
	}
	myFocus.set({
		id : 'picBox'
	})
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!--Banner部分-->
	<div class="comWidth clearfix products">
		<div class="leftArea">
			<div class="leftNav">
				<h3 class="nav_title">手机、相机、数码</h3>
				<div class="nav_cont">
					<h3>手机通讯</h3>
					<ul class="navCont_list clearfix">
						<li><a href="filter.jsp">全部手机</a></li>
						<li><a href="filter.jsp">1080p高清</a></li>
						<li><a href="filter.jsp">双卡手机</a></li>
						<li><a href="filter.jsp">拍照手机</a></li>
						<li><a href="filter.jsp">老年手机</a></li>
						<li><a href="filter.jsp">对讲机</a></li>
						<li><a href="filter.jsp">联通专区</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>数码相机</h3>
					<ul class="navCont_list clearfix">
						<li><a href="filter.jsp">全部手机</a></li>
						<li><a href="filter.jsp">1080p高清</a></li>
						<li><a href="filter.jsp">双卡手机</a></li>
						<li><a href="filter.jsp">拍照手机</a></li>
						<li><a href="filter.jsp">老年手机</a></li>
						<li><a href="filter.jsp">对讲机</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>单反</h3>
					<ul class="navCont_list clearfix">
						<li><a href="filter.jsp">全部手机</a></li>
						<li><a href="filter.jsp">1080p高清</a></li>
						<li><a href="filter.jsp">双卡手机</a></li>
						<li><a href="filter.jsp">拍照手机</a></li>
						<li><a href="filter.jsp">老年手机</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>镜头</h3>
					<ul class="navCont_list clearfix">
						<li><a href="filter.jsp">全部手机</a></li>
						<li><a href="filter.jsp">1080p高清</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>摄像机</h3>
					<ul class="navCont_list clearfix">
						<li><a href="filter.jsp">全部手机</a></li>
						<li><a href="filter.jsp">1080p高清</a></li>
						<li><a href="filter.jsp">双卡手机</a></li>
						<li><a href="filter.jsp">拍照手机</a></li>
						<li><a href="filter.jsp">老年手机</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>摄像配件</h3>
					<ul class="navCont_list clearfix">
						<li><a href="filter.jsp">全部手机</a></li>
						<li><a href="filter.jsp">1080p高清</a></li>
						<li><a href="filter.jsp">双卡手机</a></li>
						<li><a href="filter.jsp">拍照手机</a></li>
						<li><a href="filter.jsp">老年手机</a></li>
						<li><a href="filter.jsp">对讲机</a></li>
						<li><a href="filter.jsp">联通专区</a></li>
						<li><a href="filter.jsp">拍照手机</a></li>
						<li><a href="filter.jsp">老年手机</a></li>
						<li><a href="filter.jsp">对讲机</a></li>
						<li><a href="filter.jsp">联通专区</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>数码储存</h3>
					<ul class="navCont_list clearfix">
						<li><a href="filter.jsp">全部手机</a></li>
						<li><a href="filter.jsp">1080p高清</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>电子教育</h3>
					<ul class="navCont_list clearfix">
						<li><a href="filter.jsp">全部手机</a></li>
						<li><a href="filter.jsp">1080p高清</a></li>
						<li><a href="filter.jsp">双卡手机</a></li>
						<li><a href="filter.jsp">拍照手机</a></li>
						<li><a href="filter.jsp">老年手机</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="rightArea">
			<div class="banner_bar banner_big">
				<ul class="imgBox">
					<li><a href="#"><img src="img/banner_01.png" alt="banner"></a></li>
				</ul>
			</div>
			<div class="hr_7"></div>
			<div class="products_title">
				<div style="display: inline;">
					<h3 style="display: inline;">${products[0].category.cname }</h3>
					<span style="float: right; display: inline;" class="page"> <c:if
							test="${beginIndex<8 }">
							<a href="javascript:void(0);" style="cursor: not-allowed;">上一页</a>
						</c:if> <c:if test="${beginIndex>=8 }">
							<a href="product?cid=${cid }&page=${page-1}">上一页</a>
						</c:if> <c:if test="${page>=totalPage }">
							<a href="javascript:void(0);" style="cursor: not-allowed;">下一页</a>
						</c:if> <c:if test="${page<totalPage }">
							<a href="product?cid=${cid }&page=${page+1}">下一页</a>
						</c:if> <c:forEach begin="1" end="${totalPage }" step="1"
							varStatus="stat">
							<c:if test="${page==stat.index }">
								<a href="javascript:void(0);"
									class="active" style="cursor: not-allowed;">${stat.index }</a>
							</c:if>
							<c:if test="${page!=stat.index }">
								<a href="product?cid=${cid }&page=${ stat.index}">${stat.index }</a>
							</c:if>
						</c:forEach>

						<form method="get"
							action="${pageContext.request.contextPath }/product?cid=${cid }&page=${page}"
							id="jump" name="jump" style="display: inline; float: right;">
							<input type="hidden" name="cid" value="${cid }"> 第&nbsp;<input
								type="text" id="currentPage" value="" name="page"
								style="width: 45px; outline-style: groove; text-align: center;">&nbsp;/&nbsp;<span
								style="color: red;">${totalPage }&nbsp;</span>页 &nbsp;&nbsp;<input
								type="submit" value="跳转" title="跳转 "
								style="width: 30px; color: blue; background: transparent; cursor: pointer;" />
						</form>
					</span>
				</div>
			</div>

			<div class="products_list clearfix"
				style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
				<c:forEach varStatus="stat" begin="${beginIndex }"
					end="${beginIndex +7}">
					<c:if test="${not empty products[stat.index].pid }">
						<div class="item">
							<div class="img_item1">
								<a
									href="proIntroduce?cid=${products[stat.index].category.cid }&pid=${products[stat.index].pid }"><img
									src="${products[stat.index].pimage }" alt="商品图片"
									style="width: 150px;"></a>
							</div>
							<p>
								<a href="#">${products[stat.index].pname}</a>
							</p>
							<p class="money">￥${products[stat.index].shop_price}</p>
							<p>
								<span>评论：</span> <span class="stars"></span> <span class="stars"></span>
								<span class="stars"></span> <span class="nostars"></span> <span
									class="nostars"></span> <a href="#">(78条)</a>
							</p>
						</div>
					</c:if>
					<c:if test="${stat.index == 3 }">
						<br />
					</c:if>
				</c:forEach>
				<div class="hr_7"></div>
				<div class="products_title"></div>
			</div>
			<h3>浏览记录</h3>
		</div>
		<div class="products_list clearfix"
			style="text-overflow: ellipsis; white-space: nowrap;">
			<c:forEach begin="0" end="2" varStatus="stat">
				<c:if test="${not empty historyList[stat.index] }">
					<div class="item">
						<div class="img_item2">
							<a href="proIntroduce?pid=${historyList[stat.index].pid }"><img
								src='${pageContext.request.contextPath }/${historyList[stat.index].pimage}'
								alt="商品图片"></a>
						</div>
						<p>
							<a href="proIntroduce?pid=${historyList[stat.index].pid }">${historyList[stat.index].pname}</a>
						</p>
						<p class="money">￥${historyList[stat.index].shop_price}</p>
						<p>
							<span>评论：</span> <span class="stars"></span> <span class="stars"></span>
							<span class="stars"></span> <span class="stars"></span> <span
								class="nostars"></span> <a href="#">(78条)</a>
						</p>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
	</div>
	<!--空白区-->
	<div class="hr_25"></div>
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
	</div>
</body>
</html>