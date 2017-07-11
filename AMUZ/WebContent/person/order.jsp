<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.oracle.amuz.model.javabean.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>订单管理</title>

<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

<link href="css/personal.css" rel="stylesheet" type="text/css">
<link href="css/orstyle.css" rel="stylesheet" type="text/css">

<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>
</head>
<body>
	<!--头 -->
	<header>
		<article>
			<div class="mt-logo">
				<!--顶部导航条 -->
				<div class="am-container header">
					<ul class="message-l">
						<div class="topMessage">
							<div class="menu-hd">
								<%if(session.getAttribute("isLogined")==null) {%>
								<a href="home/login.jsp" target="_top" class="h" style="color: red">亲，请登录</a> <a href="home/register.jsp" target="_top" style="color: orange">免费注册</a>
							</div>
						</div>
					</ul>
					<ul class="message-r">
						<div class="topMessage home">
							<div class="menu-hd">
								<a href="home/home.jsp" target="_top" class="h">商城首页</a>
							</div>
						</div>
					</ul>
				</div>
				<%}else{ %>
				<a target="_top" class="h" style="color: red" href="person/index.jsp"> 你好！尊敬的亚马逊会员：<%=((User)session.getAttribute("isLogined")).getTruename() %>
				</a> <a href="UserServlet?method=logout" style="color: green">退出登录</a>
			</div>
			</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="home/home.jsp" target="_top" class="h">商城首页</a>
					</div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng">
						<a href="person/index.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="home/shopcart.jsp" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a>
					</div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
					</div>
			</ul>
			</div>
			<%} %>
			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logoBig">
					<li><img src="images/logobig.png" /></li>
				</div>
				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off"> <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>
			<div class="clear"></div>
			</div>
			</div>
		</article>
	</header>
	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="#">首页</a></li>
				<li class="qc"><a href="#">闪购</a></li>
				<li class="qc"><a href="#">限时抢</a></li>
				<li class="qc"><a href="#">团购</a></li>
				<li class="qc last"><a href="#">大包装</a></li>
			</ul>
			<div class="nav-extra">
				<i class="am-icon-user-secret am-icon-md nav-user"></i> <b></b> 我的福利 <i class="am-icon-angle-right" style="padding-left: 10px;"></i>
			</div>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">
				<div class="user-order">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small>
						</div>
					</div>
					<hr />
					<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>
						<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active"><a href="#tab1">所有订单</a></li>
							<li><a href="#tab2">待付款</a></li>
							<li><a href="#tab3">待发货</a></li>
							<li><a href="#tab4">待收货</a></li>
							<li><a href="#tab5">待评价</a></li>
						</ul>

						<div class="am-tabs-bd">
							<div class="am-tab-panel am-fade am-in am-active" id="tab1">
								<div class="order-top">
									<div class="th th-item">
										<td class="td-inner">商品</td>
									</div>
									<div class="th th-price">
										<td class="td-inner">单价</td>
									</div>
									<div class="th th-number">
										<td class="td-inner">数量</td>
									</div>
									<div class="th th-operation">
										<td class="td-inner">商品操作</td>
									</div>
									<div class="th th-amount">
										<td class="td-inner">合计</td>
									</div>
									<div class="th th-status">
										<td class="td-inner">交易状态</td>
									</div>
									<div class="th th-change">
										<td class="td-inner">交易操作</td>
									</div>
								</div>

								<div class="order-main">
									<div class="order-list">

										<c:if test="${requestScope.listOrders==null}">
											<div class="order-status5">
												<div class="order-title">
													<div class="dd-num">
														<a href="javascript:;"></a>
													</div>
													<span style="color: red">没有查询到任何订单赶快购买吧！</span>
												</div>
											</div>
										</c:if>

										<c:if test="${requestScope.listOrders!=null}">
											<c:forEach var="orders" items="${requestScope.listOrders}" varStatus="status1">
												<div class="order-content">
													<div class="order-left">
														<c:set var="count" value="0"></c:set>

														<c:forEach var="hashmap" items="${requestScope.hashmapproducts}">
															<c:if test="${status1.current.order_id eq hashmap.key}">

																<div class="order-title">
																	<div class="dd-num">
																		订单编号： <a href="javascript:;">${orders.order_id}</a>
																	</div>
																	<span>成交时间：${orders.date}</span>
																</div>

																<c:forEach var="list" items="${hashmap.value}">
																	<ul class="item-list">
																		<li class="td td-item">
																			<div class="item-pic">
																				<a href="#" class="J_MakePoint"> <img src="${list.productImg1}" class="itempic J_ItemImg">
																				</a>
																			</div>
																			<div class="item-info">
																				<div class="item-basic-info">
																					<a href="#">
																						<p>${list.productName}</p>
																						<p class="info-little">
																							颜色：未知 <br /> 包装：未知
																						</p>
																					</a>
																				</div>
																			</div>
																		</li>
																		<li class="td td-price">
																			<div class="item-price">
																				折扣：
																				<fmt:formatNumber value="${list.discount}" pattern="0.00"></fmt:formatNumber>
																				<fmt:formatNumber value="${list.productCost*list.discount}" pattern="0.00"></fmt:formatNumber>
																			</div>
																		</li>
																		<li class="td td-number">
																			<div class="item-number">
																				<span>×</span>${list.num}
																			</div>
																		</li>
																		<li class="td td-operation">
																			<div class="item-operation">${list.productId}号</div>
																		</li>
																	</ul>
																	<c:set var="count" value="${count+list.productCost*list.num*list.discount}"></c:set>
																</c:forEach>
															</c:if>
														</c:forEach>

														<div class="order-right">
															<li class="td td-amount">
																<div class="item-amount">
																	合计：
																	<fmt:formatNumber pattern="0.00" value="${count}"></fmt:formatNumber>
																	<p>
																		含运费： <span>0.00</span>
																	</p>
																</div>
															</li>
															<div class="move-right">
																<li class="td td-status">
																	<div class="item-status">
																		<p class="Mystatus">交易成功</p>
																		<p class="order-info">
																			<a href="orderinfo.html">订单详情</a>
																		</p>
																		<p class="order-info">
																			<a href="logistics.html">查看物流</a>
																		</p>
																	</div>
																</li>
																<li class="td td-change">
																	<div class="am-btn am-btn-danger anniu">删除订单</div>
																</li>
															</div>
														</div>
													</div>
											</c:forEach>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="am-tab-panel am-fade" id="tab2">

				<div class="order-top">
					<div class="th th-item">
						<td class="td-inner">商品</td>
					</div>
					<div class="th th-price">
						<td class="td-inner">单价</td>
					</div>
					<div class="th th-number">
						<td class="td-inner">数量</td>
					</div>
					<div class="th th-operation">
						<td class="td-inner">商品操作</td>
					</div>
					<div class="th th-amount">
						<td class="td-inner">合计</td>
					</div>
					<div class="th th-status">
						<td class="td-inner">交易状态</td>
					</div>
					<div class="th th-change">
						<td class="td-inner">交易操作</td>
					</div>
				</div>
			</div>
			<div class="am-tab-panel am-fade" id="tab3">
				<div class="order-top">
					<div class="th th-item">
						<td class="td-inner">商品</td>
					</div>
					<div class="th th-price">
						<td class="td-inner">单价</td>
					</div>
					<div class="th th-number">
						<td class="td-inner">数量</td>
					</div>
					<div class="th th-operation">
						<td class="td-inner">商品操作</td>
					</div>
					<div class="th th-amount">
						<td class="td-inner">合计</td>
					</div>
					<div class="th th-status">
						<td class="td-inner">交易状态</td>
					</div>
					<div class="th th-change">
						<td class="td-inner">交易操作</td>
					</div>
				</div>
			</div>
			<div class="am-tab-panel am-fade" id="tab4">
				<div class="order-top">
					<div class="th th-item">
						<td class="td-inner">商品</td>
					</div>
					<div class="th th-price">
						<td class="td-inner">单价</td>
					</div>
					<div class="th th-number">
						<td class="td-inner">数量</td>
					</div>
					<div class="th th-operation">
						<td class="td-inner">商品操作</td>
					</div>
					<div class="th th-amount">
						<td class="td-inner">合计</td>
					</div>
					<div class="th th-status">
						<td class="td-inner">交易状态</td>
					</div>
					<div class="th th-change">
						<td class="td-inner">交易操作</td>
					</div>
				</div>
			</div>

			<div class="am-tab-panel am-fade" id="tab5">
				<div class="order-top">
					<div class="th th-item">
						<td class="td-inner">商品</td>
					</div>
					<div class="th th-price">
						<td class="td-inner">单价</td>
					</div>
					<div class="th th-number">
						<td class="td-inner">数量</td>
					</div>
					<div class="th th-operation">
						<td class="td-inner">商品操作</td>
					</div>
					<div class="th th-amount">
						<td class="td-inner">合计</td>
					</div>
					<div class="th th-status">
						<td class="td-inner">交易状态</td>
					</div>
					<div class="th th-change">
						<td class="td-inner">交易操作</td>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<!--底部-->
	<div class="footer">
		<div class="footer-hd">
			<p>
				<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
			</p>
		</div>
		<div class="footer-bd">
			<p>
				<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a href="#">网站地图</a> <em> © 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
				</em>
			</p>
		</div>

	</div>
	</div>

	<aside class="menu">
		<ul>
			<li class="person active"><a href="index.html">个人中心</a></li>
			<li class="person"><a href="#">个人资料</a>
				<ul>
					<li><a href="person/information.jsp">个人信息</a></li>
					<li><a href="person/safety.jsp">安全设置</a></li>
					<li><a href="PayServlet?method=listAddress">收货地址</a></li>
				</ul></li>
			<li class="person"><a href="#">我的交易</a>
				<ul>
					<li><a href="UserServlet?method=listAllOrders">订单管理</a></li>
					<li><a href="person/change.html">退款售后</a></li>
				</ul></li>
			<li class="person"><a href="#">我的资产</a>
				<ul>
					<li><a href="person/coupon.html">优惠券 </a></li>
					<li><a href="person/bonus.html">红包</a></li>
					<li><a href="person/bill.html">账单明细</a></li>
				</ul></li>

			<li class="person"><a href="#">我的小窝</a>
				<ul>
					<li><a href="person/collection.html">收藏</a></li>
					<li><a href="person/foot.html">足迹</a></li>
					<li><a href="person/comment.html">评价</a></li>
					<li><a href="person/news.html">消息</a></li>
				</ul></li>
		</ul>
	</aside>
	</div>
</body>

</html>