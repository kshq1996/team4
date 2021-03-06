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
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
<title>地址管理</title>
<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="css/personal.css" rel="stylesheet" type="text/css">
<link href="css/addstyle.css" rel="stylesheet" type="text/css">
<script src="AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>
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

				<div class="user-address">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small>
						</div>
					</div>
					<hr />
					<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails" id="list-Address">
						<c:forEach var="addr" items="${requestScope.listAddress}" varStatus="status">
							<c:if test="${status.first==true}">
								<li class="user-addresslist defaultAddr" id="rm${status.index}"><span class="new-option-r"><i class="am-icon-check-circle"></i>默认地址</span>
									<p class="new-tit new-p-re">
										<span class="new-txt">${addr.name}</span> <span class="new-txt-rd2">${addr.phonenum}</span>
									</p>
									<div class="new-mu_l2a new-p-re">
										<p class="new-mu_l2cw">
											<span class="title">地址：</span> <span class="province">${addr.province}</span>省 <span class="city">${addr.state}</span>州/市 <span class="dist">${addr.city}</span>县/市 <span class="street">${addr.street}</span>
										</p>
									</div>
									<div class="new-addr-btn">
										<a href="#"><i class="am-icon-edit"></i>编辑</a> <span class="new-addr-bar">|</span> <a href="javascript:deleteAddress(${status.index})" onclick="delClick(this);" id="rm${status.index}"><i class="am-icon-trash"></i>删除</a>
									</div></li>
							</c:if>
							<c:if test="${status.first==false}">
								<li class="user-addresslist" id="rm${status.index}"><span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>
									<p class="new-tit new-p-re">
										<span class="new-txt">${addr.name}</span> <span class="new-txt-rd2">${addr.phonenum}</span>
									</p>
									<div class="new-mu_l2a new-p-re">
										<p class="new-mu_l2cw">
											<span class="title">地址：</span> <span class="province">${addr.province}</span>省 <span class="city">${addr.state}</span>州/市 <span class="dist">${addr.city}</span>县/市 <span class="street">${addr.street}</span>
										</p>
									</div>
									<div class="new-addr-btn">
										<a href="#"><i class="am-icon-edit"></i>编辑</a> <span class="new-addr-bar">|</span> <a href="javascript:deleteAddress(${status.index})" id="rm${status.index}"><i class="am-icon-trash"></i>删除</a>
									</div></li>
							</c:if>
							<input type="hidden" id="address-num" value="${status.index+2}">
						</c:forEach>
					</ul>
					<script type="text/javascript">
										    function deleteAddress(n){    
										        confirm_= confirm('真的要删除改地址吗？');
										        if(confirm_){
										            $.ajax({
										                type:"POST",
										                url:'PayServlet?method=deleteAddress&key='+n,
										                success:function(msg){
										                    alert("删除成功");
										                    $("#rm"+n).remove();
										                }
										            });
										        }
										    };
								</script>
					<div class="clear"></div>
					<a class="new-abtn-type" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加新地址</a>
					<!--例子-->
					<div class="am-modal am-modal-no-btn" id="doc-modal-1">
						<div class="add-dress">
							<!--标题 -->
							<div class="am-cf am-padding">
								<div class="am-fl am-cf">
									<strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small>
								</div>
							</div>
							<hr />
							<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
								<form class="am-form am-form-horizontal" id="insertAddress" action="javascript:insertAddress()">
									<div class="am-form-group">
										<label for="user-name" class="am-form-label">收货人</label>
										<div class="am-form-content">
											<input type="text" id="user-name" placeholder="收货人" name="name">
										</div>
									</div>
									<div class="am-form-group">
										<label for="user-phone" class="am-form-label">手机号码</label>
										<div class="am-form-content">
											<input id="user-phone" placeholder="手机号必填" type="text" name="phonenum">
										</div>
									</div>
									<div class="am-form-group">
										<label for="user-address" class="am-form-label">所在地</label>
										<div class="am-form-content address">
											<select data-am-selected name="province">
												<option value="浙江省">浙江省</option>
												<option value="湖北省" selected>湖北省</option>
											</select> <select data-am-selected name="state">
												<option value="温州市">温州市</option>
												<option value="武汉市" selected>武汉市</option>
											</select> <select data-am-selected name="city">
												<option value="瑞安区">瑞安区</option>
												<option value="洪山区" selected>洪山区</option>
											</select>
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-intro" class="am-form-label">详细地址</label>
										<div class="am-form-content">
											<textarea class="" rows="3" id="user-intro" placeholder="输入详细地址" name="street"></textarea>
											<small>100字以内写出你的详细地址...</small>
										</div>
									</div>
									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<input type="submit" class="am-btn am-btn-danger" value="保存"></a> <span id="insertResult"></span>
										</div>
									</div>
								</form>
								<input type="hidden" value="" id="hiddenname"> <input type="hidden" value="" id="hiddenphonenum"> <input type="hidden" value="" id="hiddenprovince"> <input type="hidden" value="" id="hiddenstate"> <input type="hidden" value="" id="hiddencity"> <input type="hidden" value="" id="hiddenstreet">
								<script type="text/javascript">
									function insertAddress(){
// 										$("#hiddenname").val()=$("#name").val();
// 										$("#hiddenphonenum").val()=$("#phonenum").val();
// 										$("#hiddenprovince").val()=$("#province").val();
// 										$("#hiddenstate").val()=$("#state").val();
// 										$("#hiddencity").val()=$("#city").val();
// 										$("#hiddenstreet").val()=$("#street").val();
										
										$.ajax({
							                cache: true,
							                type: "POST",
							                contentType: "application/x-www-form-urlencoded; charset=utf-8", 
							                dataType: "json",
							                url: "UserServlet?method=insertAddress",
							                data:$('#insertAddress').serialize(),// 你的formid
							                async: false,
							                error: function(request) {
							                	$("#insertResult").append("<b style='color:red' >保存失败</b>")
							                },
							                success: function(data) {
							                				$("#insertResult").append("<b style='color:green' >保存成功</b>")
											              	var url_="<li class='user-addresslist defaultAddr' id='rm"+$("#address-num").val()+"'>"
															+"<span class='new-option-r'><i class='am-icon-check-circle'></i>设为默认</span>"
															+"<p class='new-tit new-p-re'>"
															+"<span class='new-txt'>"+data.name+"</span>"
															+"<span class='new-txt-rd2'>"+data.phonenum+"</span></p>"
															+"<div class='new-mu_l2a new-p-re'>"
															+"<p class='new-mu_l2cw'>"
															+"<span class='title'>地址：</span>"
															+"<span class='province'>"+data.province+"</span>省"
															+"<span class='city'>"+data.state+"</span>州/市"
															+"<span class='dist'>"+data.city+"</span>县/市"
															+"<span class='street'>"+data.street+"</span></p></div>"
															+"<div class='new-addr-btn'>"
															+"<a href='#'><i class='am-icon-edit'></i>编辑</a>"
															+"<span class='new-addr-bar'>|</span>"
															+"<a href='javascript:deleteAddress("+$("#address-num").val()+")' id='rm"+$("#address-num").val()+"'><i class='am-icon-trash'></i>删除</a></div></li>"
											                $("#list-Address").append(url_);
															
															document.getElementById("name").value=null;
															document.getElementById("phonenum").value=null;
															document.getElementById("province").value=null;
															document.getElementById("state").value=null;
															document.getElementById("city").value=null;
															document.getElementById("street").value=null;
							                	
							                }
							            });
									}
									</script>
							</div>

						</div>

					</div>

				</div>

				<script type="text/javascript">
						$(document).ready(function() {							
							$(".new-option-r").click(function() {
								$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
							});
							var $ww = $(window).width();
							if($ww>640) {
								$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
							}
							
						})
					</script>

				<div class="clear"></div>

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
					<li class="active"><a href="PayServlet?method=listAddress">收货地址</a></li>
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