<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN" "http://www.w3.org/TR/jsp4/loose.dtd">
<jsp>
<head>
<title>商品筛选</title>
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
	<%@ include file="header.jsp" %>
	<!--Banner部分-->
	<div class="comWidth clearfix products">
		<div class="leftArea">
			<div class="leftNav vertical">
				<h3 class="nav_title">产品分类</h3>
				<div class="nav_cont">
					<h3>手机通讯</h3>
					<ul class="navCont_list clearfix">
						<li><a href="#">手机</a></li>
						<li><a href="#">对讲机</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>运营商</h3>
					<ul class="navCont_list clearfix">
						<li><a href="#">购机送费</a></li>
						<li><a href="#">“0”元购机</a></li>
						<li><a href="#">选号入网</a></li>
					</ul>
				</div>
				<div class="nav_cont">
					<h3>手机配件</h3>
					<ul class="navCont_list clearfix">
						<li><a href="#">手机电池</a></li>
						<li><a href="#">充电器/数据线</a></li>
						<li><a href="#">手机耳机</a></li>
						<li><a href="#">手机贴膜</a></li>
						<li><a href="#">手机存储卡</a></li>
						<li><a href="#">手机保护套</a></li>
						<li><a href="#">车载配件</a></li>
						<li><a href="#">iPhone 配件</a></li>
					</ul>
				</div>
				<div class="nav_cont white clearfix">
					<div class="nav_img">
						<a href="#"><img src="img/shopItem_smImg_03.png" alt="商品图片"
							class="picture2"></a>
					</div>
					<div class="nav_text">
						<p>
							<a href="#">全网低价 Apple苹果ipad mini1</a>
						</p>
						<p>$149.00</p>
					</div>
				</div>
				<div class="nav_cont white clearfix">
					<div class="nav_img">
						<a href="#"><img src="img/shopItem_smImg_03.png" alt="商品图片"
							class="picture2"></a>
					</div>
					<div class="nav_text">
						<p>
							<a href="#">全网低价 Apple苹果ipad mini1</a>
						</p>
						<p>$149.00</p>
					</div>
				</div>
				<div class="nav_cont white clearfix">
					<div class="nav_img">
						<a href="#"><img src="img/shopItem_smImg_03.png" alt="商品图片"
							class="picture2"></a>
					</div>
					<div class="nav_text">
						<p>
							<a href="#">全网低价 Apple苹果ipad mini1</a>
						</p>
						<p>$149.00</p>
					</div>
				</div>
				<div class="nav_cont white clearfix">
					<div class="nav_img">
						<a href="#"><img src="img/shopItem_smImg_03.png" alt="商品图片"
							class="picture2"></a>
					</div>
					<div class="nav_text">
						<p>
							<a href="#">全网低价 Apple苹果ipad mini1</a>
						</p>
						<p>$149.00</p>
					</div>
				</div>
				<div class="nav_cont white clearfix">
					<div class="nav_img">
						<a href="#"><img src="img/shopItem_smImg_03.png" alt="商品图片"
							class="picture2"></a>
					</div>
					<div class="nav_text">
						<p>
							<a href="#">全网低价 Apple苹果ipad mini1</a>
						</p>
						<p>$149.00</p>
					</div>
				</div>
			</div>
		</div>
		<div class="rightArea">
			<div class="screening_box">
				<dl class="screening clearfix">
					<dt>手机</dt>
					<dd class="screening_list">
						<ul class="clearfix">
							<li><a href="#">裸机(773)</a></li>
							<li><a href="#">合约机(192)</a></li>
						</ul>
					</dd>
				</dl>
				<dl class="screening clearfix">
					<dt>品牌</dt>
					<dd class="limit">
						<a href="#">不限</a>
					</dd>
					<dd class="screening_list">
						<ul class="clearfix">
							<li><a href="#">Samsung/三星</a></li>
							<li><a href="#">Apple/苹果</a></li>
							<li><a href="#">Huawei/华为</a></li>
							<li><a href="#">Miui/小米</a></li>
							<li><a href="#">Lenovo/联想</a></li>
							<li><a href="#">Apple/苹果</a></li>
							<li><a href="#">Samsung/三星</a></li>
							<li><a href="#">Apple/苹果</a></li>
							<li><a href="#">Lenovo/联想</a></li>
							<li><a href="#">Apple/苹果</a></li>
							<li><a href="#">Samsung/三星</a></li>
							<li><a href="#">Apple/苹果</a></li>
						</ul>
					</dd>
				</dl>
				<dl class="screening clearfix">
					<dt>屏幕尺寸</dt>
					<dd class="limit">
						<a href="#">不限</a>
					</dd>
					<dd class="screening_list">
						<ul class="clearfix">
							<li><a href="#">超大屏幕</a></li>
							<li><a href="#">大屏幕</a></li>
							<li><a href="#">主流屏幕尺寸</a></li>
						</ul>
					</dd>
				</dl>
				<dl class="screening clearfix">
					<dt>操作系统</dt>
					<dd class="limit">
						<a href="#">不限</a>
					</dd>
					<dd class="screening_list">
						<ul class="clearfix">
							<li><a href="#">Android</a></li>
							<li><a href="#">苹果iOS</a></li>
							<li><a href="#">Windows phone</a></li>
							<li><a href="#">Symbian</a></li>
							<li><a href="#">非智能机</a></li>
						</ul>
					</dd>
				</dl>
				<dl class="screening clearfix">
					<dt>适用网络制式</dt>
					<dd class="limit">
						<a href="#">不限</a>
					</dd>
					<dd class="screening_list">
						<ul class="clearfix">
							<li><a href="#">4G</a></li>
							<li><a href="#">移动3.5G</a></li>
							<li><a href="#">移动3G</a></li>
						</ul>
					</dd>
				</dl>
				<dl class="screening clearfix">
					<dt>更多选项</dt>
					<dd class="screening_list">
						<div class="screen_more">
							<select>
								<option value="CPU">CPU核心数</option>
								<option value="saab">Saab</option>
								<option value="opel">Opel</option>
								<option value="audi">Audi</option>
							</select>
						</div>
						<div class="screen_more">
							<select>
								<option value="CPU">主摄像头像素</option>
								<option value="saab">Saab</option>
								<option value="opel">Opel</option>
								<option value="audi">Audi</option>
							</select>
						</div>
					</dd>
				</dl>
			</div>
			<!--空白区-->
			<div class="hr_14"></div>
			<!--商品区-->
			<div class="addInfo clearfix">
				<div class="address">
					<span class="add_text">送至:</span>
					<div class="select">
						<select>
							<option value="CPU">海淀区五环内</option>
							<option value="saab">上帝</option>
							<option value="opel">五道口</option>
							<option value="audi">朝阳区</option>
						</select>
					</div>
				</div>
				<div class="fr screen_text">
					<span class="check"> <input type="checkbox" id="check">
						<label for="check">仅显示有货</label>
					</span> <span class="shop_number"> 共<em>${pageBean.totalCount }</em>件
					</span>
				</div>
			</div>
			<div class="products_list screening_list_more clearfix" style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap; }">
				<c:if test="${ pageBean.totalCount==0}">
				<br/><br/><br/><br/><br/>
				<h1 align="center">该类别下没有商品！</h1>
				</c:if>
				<c:forEach items="${pageBean.list}" var="product">
					<div class="item"  style="vertical-align: middle; display: inline-block;">
						<div class="item_cont">
							<div class="img_item3">
								<a href="proIntroduce?pid=${product.pid }&cid=${ cid}&currentPage=${pageBean.currentPage}"><img
									src="${pageContext.request.contextPath}/${product.pimage}"
									width="130" height="130" alt="商品图片"></a>
							</div>
							<p>
								<a href="#">${product.pname}</a>
							</p>
							<p class="psecond">
								<span class="money">${product.shop_price}&ensp;</span> <span
									class="pcomment">4886</span> <a href="#">评论</a>
							</p>
							<p>
								<a href="addCar?pid=${product.pid }&buyNum=1" class="addCar">加入购物车</a>
							</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!--页码区-->
	<div class="page">
		<c:if test="${ pageBean.currentPage==1}">
			<a href="javascript:void(0);" style="cursor: not-allowed;">上一页</a>
		</c:if>
		<c:if test="${ pageBean.currentPage>1}">
			<a href="filter?cid=${cid }&currentPage=${ pageBean.currentPage-1}">上一页</a>
		</c:if>
		<c:forEach begin="1" end="${ pageBean.totalPage}" step="1"
			varStatus="stat">
			<c:if test="${stat.index== pageBean.currentPage}">
				<a href="javascript:void(0);" class="active" style="cursor: not-allowed;">${ stat.index}</a>
			</c:if>
			<c:if test="${stat.index!= pageBean.currentPage}">
				<a href="filter?cid=${cid }&currentPage=${ stat.index}">${ stat.index}</a>
			</c:if>
		</c:forEach>
		<c:if test="${ pageBean.totalPage<=pageBean.currentPage}">
			<a href="javascript:void(0);" style="cursor: not-allowed;">下一页</a>
		</c:if>
		<c:if test="${ pageBean.totalPage>pageBean.currentPage}">
			<a href="filter?cid=${cid }&currentPage=${ pageBean.currentPage+1}">下一页</a>
		</c:if>
		<span class="morePage">共${ pageBean.totalPage}页，到第&nbsp;</span> <input
			type="text">&nbsp;页&nbsp; <input type="button" value="确定">
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
</jsp>