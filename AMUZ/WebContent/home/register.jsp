<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 	String path=request.getContextPath();
 	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<base href="<%=basePath %>" />
<meta charset="UTF-8">
<title>注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.min.css" />
<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

</head>

<body>

	<div class="login-boxtitle">
		<a href="home/demo.html"><img alt="" src="images/logobig.png" /></a>
	</div>

	<div class="res-banner">
		<div class="res-main">
			<div class="login-banner-bg">
				<span></span><img src="images/big.jpg" />
			</div>
			<div class="login-box">

				<div class="am-tabs" id="doc-my-tabs">
					<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
						<li class="am-active"><a href="">邮箱注册</a></li>
					</ul>
					<div class="am-tabs-bd">
						<form action="UserServlet?method=register" method="post">
							<div class="am-tab-panel am-active">
								<%if(request.getParameter("errorCode")!=null){%>
								<span color="red">${requestScope.errorCode}<span> <%} %>

										<div class="user-email">
											<label for="email"><i class="am-icon-envelope-o"></i></label> <input type="email" name="username" id="email" placeholder="请输入邮箱账号" value="" onblur="checkUsername(this.value)">
											<script type="text/javascript">
										var xhr;
										function checkUsername(v){
											if(window.ActiveXObject){
												xhr = new ActiveXObject("Microsoft.XMLHTTP");
											}else if(window.XMLHttpRequest){
												xhr = new XMLHttpRequest();
											}else{
												alert("请更新你的浏览器为主流浏览器");
											}
											//2.用创建的ajax对象悄悄的发送请求到后台(静默)
											xhr.onreadystatechange=processResult;
// 											alert("UserServlet?method=checkUsername&username="+v);
											xhr.open("get","UserServlet?method=checkUsername&username="+v);
											xhr.send(null);
										}
										
										function processResult(){
												//ajax回掉函数，后台发回结果后执行业务的地方
												if(xhr.readyState==4){
													if(xhr.status==200){
// 														alert(xhr.responseText);
														if(xhr.responseText=='false'){
															document.getElementById("CheckUsernameResult").innerHTML="<b  style='color:red'>当前输入的用户名已存在</b>";
														}else{
															document.getElementById("CheckUsernameResult").innerHTML="<b style='color:green'>当前输入的用户名可用</b>";
														}
													}
												}
											}//提前设置好如果后台回发数据了，指定哪个函数处理
										</script>
										</div> <span id="CheckUsernameResult"></span>
										<div class="user-pass">
											<label for="password"><i class="am-icon-lock"></i></label> <input type="password" name="password" id="password" placeholder="设置密码" value="">
										</div>
										<div class="user-pass">
											<label for="passwordRepeat"><i class="am-icon-lock"></i></label> <input type="password" name="passwordRepeat" id="passwordRepeat" placeholder="确认密码" value="" onblur="checkpw()">
										</div> <span id="pwCheckResult"></span> <script type="text/javascript">
                 	function checkpw(){
                 		var pw1=$("#password").val();
                 		var pw2=$("#passwordRepeat").val();
                 		if(pw1==pw2){
                 			document.getElementById("pwCheckResult").innerHTML="<b style='color:green'>密码相同</b>";
                 		}else{
                 			document.getElementById("pwCheckResult").innerHTML="<b style='color:red'>密码不同</b>";
                 		}
                 	}
                 	
                 	function ajaxCheckCode(v){
                 		var url="UserServlet?method=ajaxCheckCode&code="+v;
                 		$.ajax({
                 			url:url,
                 			type:'GET',
                 			async:true,
                 			success:function(data){
                         		if(data=='true'){
                         			document.getElementById("codeCheckResult").innerHTML="<b style='color:green'>验证码输入正确</b>";
                         		}else{
                         			document.getElementById("codeCheckResult").innerHTML="<b style='color:red'>验证码输入错误</b>";
                         		}
                 			}
                 		})
                 	}
                 </script>
										<div class="code">
											<!-- 								    <label for="passwordRepeat"><i class=""></i></label> -->
											<input type="text" name="code" placeholder="输入验证码" style="width: 150px; height: 40px" id="code" onkeyup="ajaxCheckCode(this.value)"> <img src="CodeServlet" onclick="this.src='CodeServlet?rnd=' + Math.random();" style="width: 100px; height: 40px" id="codeimg" />
										</div> <span id="codeCheckResult"></span>
										<div class="login-links"></div>
										<div class="am-cf">
											<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>
							</div>
						</form>

						<div class="am-tab-panel">
							<form method="post">
								<div class="user-phone">
									<label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label> <input type="tel" name="" id="phone" placeholder="请输入手机号">
								</div>
								<div class="verification">
									<label for="code"><i class="am-icon-code-fork"></i></label> <input type="tel" name="" id="code" placeholder="请输入验证码"> <a class="btn" href="javascript:void(0);" onclick="sendMobileCode();" id="sendMobileCode"> <span id="dyMobileButton">获取</span></a>
								</div>
								<div class="user-pass">
									<label for="password"><i class="am-icon-lock"></i></label> <input type="password" name="" id="password" placeholder="设置密码">
								</div>
								<div class="user-pass">
									<label for="passwordRepeat"><i class="am-icon-lock"></i></label> <input type="password" name="" id="passwordRepeat" placeholder="确认密码">
								</div>
								<div class="login-links"></div>
								<div class="am-cf">
									<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
								</div>
								<hr>
						</div>
						</form>
						<script>
									$(function() {
									    $('#doc-my-tabs').tabs();
									  })
								</script>

					</div>
				</div>

			</div>
		</div>

		<div class="footer ">
			<div class="footer-hd ">
				<p>
					<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
				</p>
			</div>
			<div class="footer-bd ">
				<p>
					<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a href="# ">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
				</p>
			</div>
		</div>
</body>

</html>