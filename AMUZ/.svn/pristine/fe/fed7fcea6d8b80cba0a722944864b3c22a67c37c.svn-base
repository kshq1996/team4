<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.oracle.amuz.model.javabean.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
 	String path=request.getContextPath();
 	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="<%=basePath%>" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>个人资料</title>

<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="css/personal.css" rel="stylesheet" type="text/css">
<link href="css/infstyle.css" rel="stylesheet" type="text/css">
<script src="AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
<script src="AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>
<style type="text/css">
.span {
	float: left;
	padding: 5px 20px;
}
</style>
</head>
<body>
	<!--头 -->
	<header> <article>
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
	<%} %> <!--悬浮搜索框-->

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
	</article> </header>
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

				<div class="user-info">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small>
						</div>
					</div>
					<hr />

					<!--头像 -->
					<div class="user-infoPic">
						<div class="filePic">
							<input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*" enctype="multipart/form-data" onchange="upload()" id="imgButton"> <img class="am-circle am-img-thumbnail" src="images/getAvatar.do.jpg" alt="" id="headImg" />
							<s:hidden name="user.headImg" id="imgHidden" />
							<!-- 							<span style="white-space:pre">  </span>//利用AjaxUpload组件实现异步上传头像并回显   -->
						</div>
						<script type="text/javascript">
					        $(document).ready(function(){  
					            var button = $("#imgButton");  
					            new AjaxUpload(button,{  
					                action:"${basePath}nsfw/user_ajaxUpload.action",  
					                name:"headImg",//同Action中File文件名，""不能少  
					                onSubmit: function(file, ext) {    
					                    if (!(ext && /^(jpg|JPG|png|PNG|gif|GIF)$/.test(ext))) {    
					                        alert("您上传的图片格式不对，请重新选择！");    
					                        return false;    
					                    }    
					                },   
					                onComplete:function(file,response){//默认全成功，不再判断，直接设置img的src  
					                    var path = "${basePath}upload/";  
					                    var reg = /<pre.+?>(.+)<\/pre>/g;    
					                var result = response.match(reg);    
					                response = RegExp.$1;//以上三行是为了去除response返回的pre标签内容  
					                    $("#headImg").attr("src",path+response);  
					                    //由于已经异步设置了头像路径，注册时不再需要重新设置，因此直接隐藏域保存headImg属性  
					                    $("#imgHidden").val(response);  
					                }  
					            });  
					        });
							</script>

						<p class="am-form-help">头像</p>
						<div class="info-m">
							<div>
								<b>用户名：<i>${sessionScope.isLogined.username}</i></b>
							</div>
							<div class="u-level">
								<span class="rank r2"> <s class="vip1"></s><a class="classes" href="#">铜牌会员</a>
								</span>
							</div>
							<div class="u-safety">
								<a href="person/safety.jsp"> 账户安全 <span class="u-profile"><i class="bc_ee0000" style="width: 60px;" width="0">60分</i></span>
								</a>
							</div>
						</div>
					</div>

					<!--个人信息 -->
					<div class="info-main">
						<form class="am-form am-form-horizontal" action="UserServlet?method=update" method="post">
							<div class="am-form-group">
								<label for="user-name" class="am-form-label">姓名</label>
								<div class="am-form-content">
									<input type="text" id="user-name2" name="truename" value="${sessionScope.isLogined.truename}">
								</div>
							</div>
							<div class="am-form-group">
								<label class="am-form-label">性别</label>
								<div class="am-form-content sex">
									<c:choose>
										<c:when test="${sessionScope.isLogined.sex =='M'}">
											<label class="am-radio-inline"> <input type="radio" name="sex" data-am-ucheck value="0" checked="checked"> 男
											</label>
											<label class="am-radio-inline"> <input type="radio" name="sex" data-am-ucheck value="1"> 女
											</label>
										</c:when>
										<c:when test="${sessionScope.isLogined.sex =='F'}">
											<label class="am-radio-inline"> <input type="radio" name="sex" data-am-ucheck value="0"> 男
											</label>
											<label class="am-radio-inline"> <input type="radio" name="sex" data-am-ucheck value="1" checked="checked"> 女
											</label>
										</c:when>
									</c:choose>
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-birth" class="am-form-label">生日</label>
								<div class="am-form-content birth">
									<div class="birth-select">
										<select data-am-selected>
											<c:forEach varStatus="status" begin="1930" end="2017">
												<option value="a">${status.index}</option>
											</c:forEach>
										</select> <em>年</em>
									</div>
									<div class="birth-select2">
										<select data-am-selected>
											<c:forEach varStatus="status" begin="1" end="12">
												<option value="a">${status.index}</option>
											</c:forEach>
										</select> <em>月</em>
									</div>
									<div class="birth-select2">
										<select data-am-selected>
											<c:forEach varStatus="status" begin="1" end="31">
												<option value="a">${status.index}</option>
											</c:forEach>
										</select> <em>日</em>
									</div>
								</div>

							</div>
							<div class="am-form-group">
								<label for="user-email" class="am-form-label">电子邮件</label>
								<div class="am-form-content">
									<input id="user-email" name="email" placeholder="${sessionScope.isLogined.email}" type="email" value="${sessionScope.isLogined.email}">
								</div>
							</div>
							<div class="am-form-group safety">
								<label for="user-safety" class="am-form-label">账号安全</label>
								<div class="am-form-content safety">
									<a href="person/safety.html"> <span class="am-icon-angle-right"></span>
									</a>
								</div>
							</div>
							<div class="info-btn">
								<input type="submit" value="保存修改" class="am-btn am-btn-danger">
							</div>
						</form>
						<div>
							<c:choose>
								<c:when test="${request.updateSuccess !=null }">
									<span color="green" class="span">信息已更新！</span>
								</c:when>
								<c:when test="${request.updateFail !=null }">
									<span color="red" class="span">更新失败！</span>
								</c:when>
							</c:choose>
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
					<li class="active"><a href="#">个人信息</a></li>
					<li><a href="person/safety.jsp">安全设置</a></li>
					<li><a href="PayServlet?method=listAddress">收货地址</a></li>
				</ul></li>
			<li class="person"><a href="#">我的交易</a>
				<ul>
					<li><a href="person/order.html">订单管理</a></li>
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