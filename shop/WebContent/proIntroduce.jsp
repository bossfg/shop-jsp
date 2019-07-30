<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN" "http://www.w3.org/TR/jsp4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品详情页</title>
<link rel="stylesheet" type="text/css" href="style/reset.css" />
<link rel="stylesheet" type="text/css" href="style/main.css" />
<script src="js/setHomeSetFav.js" type="text/javascript"
	charset="gb2312"></script>
<script src="js/myfocus-2.0.1.min.js" type="text/javascript"></script>
<script src="js/mf-pattern/mF_YSlider.js" type="text/javascript"></script>
<link href="js/mf-pattern/mF_YSlider.css" rel="stylesheet"
	type="text/css" />
<script src="js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function addCar() {
		var buyNum = $("#buyNum").val();
		window.location = "${pageContext.request.contextPath}/addCar?pid=${product.pid}&buyNum="
				+ buyNum;
		document.getElementById("")
	}
</script>
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
		document.getElementById("backList").href = "product?cid="
				+ getQueryString("cid");
		document.getElementById("proList").href="product?cid="+getQueryString("cid")+"&currentPage="+getQueryString("currentPage");
		document.getElementById("proList2").href="product?cid="+getQueryString("cid")+"&currentPage="+getQueryString("currentPage");
		document.getElementById("proInfo").href="proIntroduce?cid="+getQueryString("cid")+"&currentPage="+getQueryString("currentPage")+"&pid="+getQueryString("pid");
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="userPosition comWidth">
		<strong><a href="index">首页</a></strong> <span>&nbsp;&gt;&nbsp;</span>
		<a href="#" id="proList">电脑</a>
		<span>&nbsp;&gt;&nbsp;</span> <a
			href="#" id="proList2">平板电脑</a>
		<span>&nbsp;&gt;&nbsp;</span> <a
			href="#"
			id="proInfo">${product.pname }</a> <span>&nbsp;&gt;&nbsp;</span> <em>详细介绍</em>
		<span style="font-weight: bolder;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href='product?cid=${cid }&currentPage=${currentPage}'
			id="backList">返回商品列表</a>
		</span>
	</div>
	<div class="description-info comWidth">
		<div class="description clearfix">
			<div class="leftArea">
				<div class="description-imgs">
					<div class="big">
						<img src="${product.pimage }" style="width: 280px; height: 330px"
							alt="MD531CH/A">
					</div>
					<ul class="small clearfix">
						<li><a href="#"><img src="img/jpg/sm-img.jpg"
								class="active" alt=""></a></li>
						<li><a href="#"><img src="img/jpg/sm-img.jpg" alt=""></a>
						</li>
						<li><a href="#"><img src="img/jpg/sm-img.jpg" alt=""></a>
						</li>
						<li><a href="#"><img src="img/jpg/sm-img.jpg" alt=""></a>
						</li>
						<li><a href="#"><img src="img/jpg/sm-img.jpg" alt=""></a>
						</li>
					</ul>
				</div>
			</div>
			<div class="rightArea">
				<div class="des-content">
					<h3>${product.pname }</h3>
					<div class="dl clearfix">
						<div class="dt">慕课价</div>
						<div class="dd">
							<span class="des-money"><em>￥</em>${product.shop_price } </span>
						</div>
					</div>
					<div class="dl clearfix">
						<div class="dt">描述</div>
						<div class="dd">
							<span class="hg"><i class="hg-icon">满换购</i>${ product.pdesc}</span>
						</div>
					</div>
					<div class="des-position">
						<div class="dl clearfix">
							<div class="dt">送到</div>
							<div class="dd">
								<select name="" id="getwhere">
									<option value="">北京市 海淀区 五环内</option>
									<option value="">上海市 黄埔区 三环内</option>
									<option value="">广州市 天河区 四环内</option>
								</select> <span class="theGoods">有货，可当日出库</span>
							</div>
						</div>
						<div class="dl clearfix des-item">
							<div class="dt">选择颜色</div>
							<div class="dd des-item-active">白色</div>
							<div class="dd">黑色</div>
							<div class="dd">灰色</div>
						</div>
						<div class="dl clearfix des-item des-sm">
							<div class="dt">选择规格</div>
							<div class="dd des-item-active">WIFI 16G</div>
							<div class="dd">WIFI 64G</div>
							<div class="dd">WIFI 32G</div>
							<div class="dd">WIFI Cellular 32G</div>
							<div class="dd">WIFI Cellular 64G</div>
							<div class="dd">WIFI Cellular 16G</div>
						</div>
						<div class="dl clearfix">
							<div class="dt dt-num">数量</div>
							<div class="dd clearfix des-number">
								<div class="reduction">-</div>
								<div class="des-input">
									<input type="text" value="1" name="buyNum" id="buyNum">
								</div>
								<div class="plus">+</div>
							</div>
							<span class="xg">限购<em>9</em>件
							</span>
						</div>
					</div>
					<div class="des-select">
						<i>已选择</i><span> “白色|WIFI 16G”</span>
					</div>
					<a class="shopping-btn" href="javascript:addCar();" onclick=""></a>
					<span class="line"></span> <a href="#" class="buy-btn"></a>
				</div>
				<div class="notes">
					<span>注意：此商品可提供普通发票，不提供增值税发票。</span>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="hr_25"></div>
	<div class="des-info comWidth clearfix">
		<div class="leftArea">
			<div class="recommend">
				<h3 class="tit">同价位</h3>
				<div class="rec-item">
					<div class="rec-img-item">
						<a href="#"><img src="img/jpg/item01.jpg" alt="相机"></a>
					</div>
					<p>
						<a href="#">Samsung 三星 GALAXY Tab 3 8.0 WLAN版本 T310平板电话</a>
					</p>
					<p class="money">￥3588.00</p>
				</div>
				<div class="rec-item">
					<div class="rec-img-item">
						<a href="#"><img src="img/jpg/item02.jpg" alt="相机"></a>
					</div>
					<p>
						<a href="#">Samsung 三星 GALAXY Tab 3 8.0 WLAN版本 T310平板电话</a>
					</p>
					<p class="money">￥3588.00</p>
				</div>
				<div class="rec-item">
					<div class="rec-img-item">
						<a href="#"><img src="img/jpg/item03.jpg" alt="相机"></a>
					</div>
					<p>
						<a href="#">Samsung 三星 GALAXY Tab 3 8.0 WLAN版本 T310平板电话</a>
					</p>
					<p class="money">￥3588.00</p>
				</div>
				<div class="rec-item">
					<div class="rec-img-item">
						<a href="#"><img src="img/jpg/item04.jpg" alt="相机"></a>
					</div>
					<p>
						<a href="#">Samsung 三星 GALAXY Tab 3 8.0 WLAN版本 T310平板电话</a>
					</p>
					<p class="money">￥3588.00</p>
				</div>
			</div>
			<div class="hr-7"></div>
			<div class="recommend">
				<h3 class="tit">看了最终买</h3>
				<div class="rec-item">
					<div class="rec-img-item">
						<a href="#"><img src="img/jpg/item05.jpg" alt="相机"></a>
					</div>
					<p>
						<a href="#">Apple 苹果 iPaad mini 配备 Retina 显示屏 ME280CH/A</a>
					</p>
					<p class="money">￥3588.00</p>
				</div>
				<div class="rec-item">
					<div class="rec-img-item">
						<a href="#"><img src="img/jpg/item06.jpg" alt="相机"></a>
					</div>
					<p>
						<a href="#">某某品牌 配备 Retina 显示屏 IPS</a>
					</p>
					<p class="money">￥3588.00</p>
				</div>
				<div class="rec-item">
					<div class="rec-img-item">
						<a href="#"><img src="img/jpg/item07.jpg" alt="相机"></a>
					</div>
					<p>
						<a href="#">某某品牌 配备 Retina 显示屏 IPS</a>
					</p>
					<p class="money">￥3588.00</p>
				</div>
			</div>
		</div>
		<div class="rightArea">
			<div class="des-infoContent">
				<ul class="des-tit">
					<li class="active"><span class="jieshao">产品介绍</span></li>
					<li><span class="pingjia">商品评价(123456)</span></li>
				</ul>
				<div class="ad">
					<a href="#"><img src="img/jpg/spring.jpg" alt="开春盛典"></a>
				</div>
				<div class="info-text">
					<div class="info-tit clearfix">
						<h3>强烈推荐</h3>
						<h4>货比三家，还选</h4>
					</div>
					<p>现在就是买mini的好时候！换代清仓直降，但苹果品质不变！A5双核，内置Lightning闪电接口，正反可插，方便人性。小身材，炫丽的7.9英寸显示屏，7.2mm的厚度，薄如铅笔。女生包包随身携带更时尚！facetime视频通话，与密友24小时畅聊不断线。微信倾力打造，你的智能助理。苹果的牌子就不用我说了，1111补仓，存货不多哦！</p>
					<div class="hr-50"></div>
					<div class="info-tit clearfix">
						<h3>强烈推荐</h3>
						<h4>货比三家，还选</h4>
					</div>
					<p>现在就是买mini的好时候！换代清仓直降，但苹果品质不变！A5双核，内置Lightning闪电接口，正反可插，方便人性。小身材，炫丽的7.9英寸显示屏，7.2mm的厚度，薄如铅笔。女生包包随身携带更时尚！facetime视频通话，与密友24小时畅聊不断线。微信倾力打造，你的智能助理。苹果的牌子就不用我说了，1111补仓，存货不多哦！</p>
					<div class="hr-50"></div>
					<img class="center" src="img/jpg/ipad.jpg" alt="ipad">
					<div class="hr-25"></div>
				</div>
			</div>
			<div class="hr-15"></div>
			<div class="des-infoContent">
				<h3 class="shopDes-tit">商品评价</h3>
				<div class="score-box clearfix">
					<div class="score">
						<span>4.7</span><em>分</em>
					</div>
					<div class="score-speed">
						<ul class="score-speed-text">
							<li class="speed-01">非常不满意</li>
							<li class="speed-02">不满意</li>
							<li class="speed-03">一般</li>
							<li class="speed-04">满意</li>
							<li class="speed-05">非常满意</li>
						</ul>
						<div class="score-num">
							4.7<i></i>
						</div>
						<p>共18939位慕课网友参与评分</p>
					</div>
				</div>
				<div class="review-tab clearfix">
					<ul class="review fl">
						<li><a href="#" class="active">全部</a></li>
						<li><a href="#">满意（17490）</a></li>
						<li><a href="#">一般（549）</a></li>
						<li><a href="#">不满意（743）</a></li>
					</ul>
					<div class="review-sort fr">
						<a href="#" class="review-time">时间排序</a> <a href="#"
							class="review-reco">推荐排序</a>
					</div>
				</div>
				<div class="evaluate">
					<div class="eva clearfix">
						<div class="eva-userhead fl">
							<div class="evaHead">
								<img src="img/jpg/userhead1.png" alt="">
							</div>
							<p>61***42</p>
							<p>金色会员</p>
						</div>
						<div class="eva-cont fl">
							<div class="count-box clearfix">
								<div class="starsBox fl">
									<span class="stars"></span> <span class="stars"></span> <span
										class="stars"></span> <span class="stars"></span> <span
										class="stars"></span>
								</div>
								<span class="eva-count">5分 满意</span>
							</div>
							<p>挺不错的，信赖慕课</p>
							<p>
								<a href="#" class="cai">踩（10）</a>&nbsp;&nbsp; <a href="#"
									class="ding">顶（23）</a>
							</p>
						</div>
						<div class="eva-time">
							<span>2018-03-07 17:41:44</span>
						</div>
					</div>
				</div>
				<div class="evaluate">
					<div class="eva clearfix">
						<div class="eva-userhead fl">
							<div class="evaHead">
								<img src="img/jpg/userhead2.png" alt="">
							</div>
							<p>88***22</p>
							<p>铜色会员</p>
						</div>
						<div class="eva-cont fl">
							<div class="count-box clearfix">
								<div class="starsBox fl">
									<span class="stars"></span> <span class="stars"></span> <span
										class="stars"></span> <span class="stars"></span> <span
										class="stars"></span>
								</div>
								<span class="eva-count">5分 满意</span>
							</div>
							<p>挺不错的，信赖慕课</p>
							<p>
								<a href="#" class="cai">踩（5）</a>&nbsp;&nbsp; <a href="#"
									class="ding">顶（45）</a>
							</p>
						</div>
						<div class="eva-time">
							<span>2018-03-07 17:41:44</span>
						</div>
					</div>
				</div>
				<div class="page pages">
					<a href="#">上一页</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a>
					<a href="#">4</a> <a href="#">5</a> <a href="#">6</a><span
						class="hl">...</span> <a href="#">200</a> <a href="#">下一页</a><span
						class="morepage">共200页，到第</span> <input type="text"> 页 <input
						type="button" value="确定">
				</div>
			</div>
		</div>
	</div>
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