<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN" "http://www.w3.org/TR/jsp4/loose.dtd">
<jsp>
<head>
<title>电子商务首页</title>
<link rel="stylesheet" type="text/css" href="style/reset.css" />
<link rel="stylesheet" type="text/css" href="style/main.css" />
<script src="js/setHomeSetFav.js" type="text/javascript"
	charset="gb2312"></script>
<script src="js/myfocus-2.0.1.min.js" type="text/javascript"></script>
<script src="js/mf-pattern/mF_YSlider.js" type="text/javascript"></script>
<link href="js/mf-pattern/mF_YSlider.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	myFocus.set({
		id : 'picBox'
	})
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!--标题头部-->
	<div class="navBox">
		<div class="comWidth">
			<div class="shopClass fl">

				<div class="shopClass_show">
					<dl class="shopClass_item">
						<dt>
							<a href="product?cid=1" class="b">手机</a> <a href="product?cid=1"
								class="b">数码</a> <a href="product?cid=1" class="aLink">合约机</a>
						</dt>
						<dd>
							<a href="product?cid=1">荣耀3X</a> <a href="product?cid=1">单反</a> <a
								href="product?cid=1">智能</a>
						</dd>
					</dl>
					<dl class="shopClass_item">
						<dt>
							<a href="product?cid=2" class="b">电脑</a> <a href="product?cid=2"
								class="b">硬件外设</a> <a href="product?cid=2" class="aLink">装机宝</a>
						</dt>
						<dd>
							<a href="product?cid=2">笔记本</a> <a href="product?cid=2">台式机</a> <a
								href="product?cid=2">超级本</a> <a href="product?cid=2">平板</a>
						</dd>
					</dl>
					<dl class="shopClass_item">
						<dt>
							<a href="product?cid=3" class="b">大家电</a>
						</dt>
						<dd>
							<a href="product?cid=3">电视</a> <a href="product?cid=3">空调</a> <a
								href="product?cid=3">冰箱</a> <a href="product?cid=3">洗衣机</a>
						</dd>
					</dl>
					<dl class="shopClass_item">
						<dt>
							<a href="product?cid=4" class="b">厨房电器</a> <a
								href="product?cid=4" class="b">生活电器</a>
						</dt>
						<dd>
							<a href="product?cid=4">空气净化器</a> <a href="product?cid=4">微波炉</a>
							<a href="product?cid=4">取暖设备</a>
						</dd>
					</dl>
					<dl class="shopClass_item">
						<dt>
							<a href="product?cid=5" class="b">食品/饮料/生鲜</a> <a
								href="product?cid=5" class="aLink">粮油</a>
						</dt>
						<dd>
							<a href="product?cid=5">进口</a> <a href="product?cid=5">方便面</a> <a
								href="product?cid=5">零食</a> <a href="product?cid=5">保健</a>
						</dd>
					</dl>
				</div>
				<div class="shopClass_list hide" id="shop1">
					<div class="shopClass_cont">
						<dl class="shopList_item">
							<dt>电脑整机</dt>
							<dd>
								<a href="#">笔记本</a> <a href="#">超级本</a> <a href="#">上网本</a> <a
									href="#">平板电脑</a> <a href="#">台式机</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>装机配件</dt>
							<dd>
								<a href="#">CPU</a> <a href="#">硬盘</a> <a href="#">SSD固态硬盘</a> <a
									href="#">内存</a> <a href="#">显示</a> <a href="#">智能显示器</a> <a
									href="#">主板</a> <a href="#">显卡</a> <a href="#">机箱</a> <a
									href="#">电源</a> <a href="#">散热器</a> <a href="#">光驱</a> <a
									href="#">声卡</a> <a href="#">拓展卡</a> <a href="#">服务器配件</a> <a
									href="#">DIY小附件</a> <a href="#">配件安装</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>整机附件</dt>
							<dd>
								<a href="#">电脑包</a> <a href="#">电脑桌</a> <a href="#">电池</a> <a
									href="#">贴膜</a> <a href="#">清洁用品</a> <a href="#">电源</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>电脑外设</dt>
							<dd>
								<a href="#">鼠标</a> <a href="#">键盘</a> <a href="#">游戏外设</a> <a
									href="#">移动硬盘</a> <a href="#">摄像头</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>网络设备</dt>
							<dd>
								<a href="#">路由器</a> <a href="#">网卡</a> <a href="#">网络存储</a> <a
									href="#">交换机</a> <a href="#">3G无线上网</a> <a href="#">布线工具</a> <a
									href="#">网络配件</a> <a href="#">正版软件</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>音频设备</dt>
							<dd>
								<a href="#">音箱</a> <a href="#">网络存储</a> <a href="#">交换机</a> <a
									href="#">3G无线上网</a> <a href="#">平板电脑</a> <a href="#">台式机</a>
							</dd>
						</dl>
						<dl class="shopList_item">
							<dt>音频设备</dt>
							<dd>
								<a href="#">音箱</a> <a href="#">耳机</a> <a href="#">麦克风</a> <a
									href="#">声卡</a> <a href="#">音频附件</a> <a href="">录音笔</a>
							</dd>
						</dl>
						<div class="shopList_links">
							<a href="#">电脑整机频道<span></span></a> <a href="#">硬件/外设频道<span></span></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!--Banner部分-->
	<div class="banner comWidth clearfix">
		<div class="ad" id="picBox">
			<div class="loading">
				<img src="img/loading.gif" alt="图片加载中" />
			</div>
			<div class="pic">
				<ul>
					<li><a href="#"><img src="img/banner_01.png" /></a></li>
					<li><a href="#"><img src="img/banner_02.png" /></a></li>
					<li><a href="#"><img src="img/banner_03.png" /></a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--商品标题一-->
	<div class="shopTit comWidth">
		<span class="icon"></span>
		<h3>最热商品</h3>
		<a href="#" class="more">更多&gt;&gt;</a>
	</div>
	<!--商品内容一-->
	<div class="shopList comWidth clearfix">
		<div class="leftArea">
			<div class="banner_bar banner_sm">
				<a href="#"><img src="img/banner_sm_01.png" alt="banner"></a>
			</div>
		</div>
		<div class="rightArea">
			<div class="shopList_top clearfix">
				<c:forEach items="${requestScope.hot_productup}" var="product">
					<div class="shop_item">
						<div class="shop_img">
							<a
								href="${pageContext.request.contextPath}/proIntroduce?pid=${product.pid}"><img
								src="${pageContext.request.contextPath}/${product.pimage}"
								width="130" height="130" alt="shop"></a>
						</div>
						<h3>${product.pname}</h3>
						<p>${product.market_price}元</p>
					</div>
				</c:forEach>

			</div>
			<!--商品右侧底部-->
			<div class="shopList_sm">
				<c:forEach items="${requestScope.hot_productdown}" var="product">
					<div class="shopItem_sm">
						<div class="shopItem_smImg">
							<a
								href="${pageContext.request.contextPath}/proIntroduce?pid=${product.pid}"><img
								src="${pageContext.request.contextPath}/${product.pimage}"
								width="70" height="70" alt="商品图片" class="picture1"></a>
						</div>
						<div class="shopItem_text">
							<a
								href="${pageContext.request.contextPath}/proIntroduce?pid=${product.pid}">${product.pname}<br></a>
							<h3>${product.market_price}</h3>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!--商品标题二-->
	<div class="shopTit comWidth">
		<span class="icon"></span>
		<h3>最新商品</h3>
		<a href="#" class="more">更多&gt;&gt;</a>
	</div>
	<!--商品内容二-->
	<div class="shopList comWidth clearfix">
		<div class="leftArea">
			<div class="banner_bar banner_sm">
				<a href="#"><img src="img/banner_sm_02.png" alt="banner"></a>
			</div>
		</div>
		<div class="rightArea">
			<div class="shopList_top clearfix">
				<c:forEach items="${requestScope.new_productup}" var="product">
					<div class="shop_item">
						<div class="shop_img">
							<a
								href="${pageContext.request.contextPath}/proIntroduce?pid=${product.pid}"><img
								src="${pageContext.request.contextPath}/${product.pimage}"
								width="130" height="130" alt="shop"></a>
						</div>
						<h3>${product.pname}</h3>
						<p>${product.market_price}元</p>
					</div>
				</c:forEach>
			</div>
			<!--商品右侧底部-->
			<div class="shopList_sm">
				<c:forEach items="${requestScope.new_productdown}" var="product">
					<div class="shopItem_sm">
						<div class="shopItem_smImg">
							<a
								href="${pageContext.request.contextPath}/proIntroduce?pid=${product.pid}"><img
								src="${pageContext.request.contextPath}/${product.pimage}"
								width="70" height="70" alt="商品图片" class="picture1"></a>
						</div>
						<div class="shopItem_text">
							<a
								href="${pageContext.request.contextPath}/proIntroduce?pid=${product.pid}">${product.pname}<br></a>
							<h3>${product.market_price}</h3>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
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
	<script type="text/javascript">
		document.getElementById("shop1").onMouseOver = function() {
			document.getElementById("shop1").style.display = "block";
		}
		document.getElementById("shop1").onMouseout = function() {
			document.getElementById("shop1").style.display = "none";
		}
	</script>
</body>
</jsp>