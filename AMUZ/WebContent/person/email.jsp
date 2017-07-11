<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.oracle.amuz.model.javabean.User"%>
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

<title>验证邮箱</title>

<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

<link href="css/personal.css" rel="stylesheet" type="text/css">
<link href="css/stepstyle.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
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
				<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利 <i class="am-icon-angle-right" style="padding-left: 10px;"></i>
			</div>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">

				<div class="am-cf am-padding">
					<div class="am-fl am-cf">
						<strong class="am-text-danger am-text-lg">绑定邮箱</strong> / <small>Email</small>
					</div>
				</div>
				<hr />
				<!--进度条-->
				<div class="m-progress">
					<div class="m-progress-list">
						<span class="step-1 step"> <em class="u-progress-stage-bg"></em> <i class="u-stage-icon-inner">1<em class="bg"></em></i>
							<p class="stage-name">验证邮箱</p>
						</span> <span class="step-2 step"> <em class="u-progress-stage-bg"></em> <i class="u-stage-icon-inner">2<em class="bg"></em></i>
							<p class="stage-name">完成</p>
						</span> <span class="u-progress-placeholder"></span>
					</div>
					<div class="u-progress-bar total-steps-2">
						<div class="u-progress-bar-inner"></div>
					</div>
				</div>
				<form class="am-form am-form-horizontal">
					<div class="am-form-group">
						<label for="user-email" class="am-form-label">验证邮箱</label>
						<div class="am-form-content">
							<input type="email" id="user-email" name="emailidentify" placeholder="请输入邮箱地址" value="${sessionScope.isLogined.email}"> <span id="error-email" style="color: red"></span>
						</div>
					</div>
					<div class="am-form-group code">
						<label for="user-code" class="am-form-label">验证码</label>
						<div class="am-form-content">
							<input type="tel" id="user-code" placeholder="验证码"> <span id="error-code" style="color: red"></span>
						</div>
						<a class="btn" onclick="sendMobileCode()" />
						<div class="am-btn am-btn-danger" id="sendMobileCodebtn">验证码</div>
						<input value="0" style="display: none" id="Btn-number-mark">
						<script type="text/javascript">
									var xhr;
									function sendMobileCode(t){
										var address=document.getElementById("user-email").value;
										var bl=isEmail(address);
										if(bl){
										var a=document.getElementById("Btn-number-mark").value;
										document.getElementById("Btn-number-mark").value=a+1;
											//使用ajax悄悄地到后台查询当前你输入的这个内容是否存在
											//1创建ajax 发送请求的对象(XMLHttpRequest)
											if(window.ActiveXObject){
												xhr = new ActiveXObject("Microsoft.XMLHTTP");
											}else if(window.XMLHttpRequest){
												xhr = new XMLHttpRequest();
											}else{
												alert("哥们，您可以换浏览器了!");
											}
											//2.用创建的ajax对象悄悄的发送请求到后台(静默)
											xhr.onreadystatechange=processResult_sendMobileCode;//提前设置好如果后台回发数据了，指定哪个函数处理
											xhr.open("get","EmailCodeServlet?method=sendEmail&emailAddress="+address);
											xhr.send(null);
										}else{
											document.getElementById("error-email").innerHTML="非法的邮箱格式"
										}
									}
										//ajax回掉函数，后台发回结果后执行业务的地方
									function processResult_sendMobileCode() {
											if (xhr.readyState == 4) {
												if (xhr.status == 200) {
													if (xhr.responseText == 'true') {
// 													document.getElementById("sendMobileCodebtn").innerHTML="验证码已发送";
														showtime(30);
													} else {
														alert("未知错误，发送失败！请稍后再行修改");
													}
												}
											}
										}
										
										function showtime(t){ 
											 document.getElementById("sendMobileCodebtn").disabled=true; 
											 for(i=1;i<=t;i++){
												 window.setTimeout("update_p(" + i + ","+t+")", i*1000); 
											 }
										}
										
										function update_p(num,t) {
											 if(num == t) {
												 document.getElementById("sendMobileCodebtn").innerHTML=" 重新发送 "; 
												 document.getElementById("sendMobileCodebtn").disabled=false; 
											 }
											 else { 
											 printnr = t-num; 
											 document.getElementById("sendMobileCodebtn").innerHTML = printnr+"秒后重新发送"; 
											 }
										}
										
										function isEmail(str){ 
											var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
											return reg.test(str); 
										}

								</script>
						</a>
					</div>
					<div class="info-btn">
						<div class="am-btn am-btn-danger" onclick="saveEmail()">保存修改</div>
						<span id="result-Code"></span>
						<script type="text/javascript">
						var xhr;
						function saveEmail(){
							var code=document.getElementById("user-code").value;
								//使用ajax悄悄地到后台查询当前你输入的这个内容是否存在
								//1创建ajax 发送请求的对象(XMLHttpRequest)
								if(window.ActiveXObject){
									xhr = new ActiveXObject("Microsoft.XMLHTTP");
								}else if(window.XMLHttpRequest){
									xhr = new XMLHttpRequest();
								}else{
									alert("哥们，您可以换浏览器了!");
								}
								//2.用创建的ajax对象悄悄的发送请求到后台(静默)
								xhr.onreadystatechange=processResult_saveEmail;//提前设置好如果后台回发数据了，指定哪个函数处理
								xhr.open("get","EmailCodeServlet?method=saveEmail&code="+code);
								xhr.send(null);
							}
							//ajax回掉函数，后台发回结果后执行业务的地方
						function processResult_saveEmail() {
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										if (xhr.responseText == 'success') { 
											document.getElementById("error-code").innerHTML =null;
											document.getElementById("result-Code").innerHTML = "<b  style='color:green'>验证成功</b>";
										} else {
											document.getElementById("error-code").innerHTML = "验证码输入错误";
										}
									}
								}
							}
						</script>
					</div>
				</form>

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
						<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
					</p>
				</div>
			</div>
		</div>

		<aside class="menu">
			<ul>
				<li class="person"><a href="index.html">个人中心</a></li>
				<li class="person"><a href="#">个人资料</a>
					<ul>
						<li><a href="person/information.jsp">个人信息</a></li>
						<li><a href="person/safety.jsp">安全设置</a></li>
						<li><a href="person/address.jsp">收货地址</a></li>
					</ul></li>
				<li class="person"><a href="#">我的交易</a>
					<ul>
						<li><a href="order.html">订单管理</a></li>
						<li><a href="change.html">退款售后</a></li>
					</ul></li>
				<li class="person"><a href="#">我的资产</a>
					<ul>
						<li><a href="coupon.html">优惠券 </a></li>
						<li><a href="bonus.html">红包</a></li>
						<li><a href="bill.html">账单明细</a></li>
					</ul></li>

				<li class="person"><a href="#">我的小窝</a>
					<ul>
						<li><a href="collection.html">收藏</a></li>
						<li><a href="foot.html">足迹</a></li>
						<li><a href="comment.html">评价</a></li>
						<li><a href="news.html">消息</a></li>
					</ul></li>

			</ul>

		</aside>
	</div>

</body>

</html>