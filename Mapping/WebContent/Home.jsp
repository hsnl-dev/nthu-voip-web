<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- for IE 8 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<!-- alertify plugin -->
<script src="js/alertify.min.js"></script>
<link href="css/alertify.core.css" rel="stylesheet">
<link href="css/alertify.default.css" rel="stylesheet">

<!-- main css -->
<link href="css/main.css" rel="stylesheet">
<title>離線通</title>
<%
	String status = (String)request.getAttribute("status");
%>
<script type="text/javascript">
function check(){
	if("<%=status%>" == "failed"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("帳號或密碼有誤，請重新輸入!");
	}else if("<%=status%>" == "nouser"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("無此帳號，請重新輸入!");
	}else if("<%=status%>" == "incorrect"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("密碼錯誤，請重新輸入!");
	}
}
function formsubmit(){
	var thisForm = document.getElementById("mappingForm");
	if(thisForm.userphone.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入手機號碼!");
		thisForm.userphone.focus();
		return false;
	}else if(thisForm.inputPassword.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入密碼!");
		thisForm.inputPassword.focus();
		return false;
	}else{
		thisForm.submit();
	}
}
</script>
</head>
<body onload="check()">
<!-- <img src="img/bg2.jpg" class="bg"> -->
	<div class="header">
		<div class="header-top">
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="http://nthu.kits.tw/service/home.html" >首頁</a>
					</div>
				</div>
				<div class="header-bot-qa">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="http://nthu.kits.tw/service/qamapping.html" >常見問題</a>
					</div>
				</div>
				<div class="header-bot-contactus">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="contactUs.jsp" >聯絡我們</a>
					</div>
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div >
			<p class="content_top">
				<img src="img/mapping.jpg" width="475px" height="150px">
			</p>
			<p class="content_top">
				離線通
			</p>
			<p class="content_top_text">
				您是無網一族嗎? 想用雲端網路電話服務卻沒網路!? 離線通，讓你無網嘛ㄟ通!
			</p>
			<p class="content_top_text">
				第一次使用離線通嗎? 請先<font color="red">取得驗證碼</font>才能使用服務喔!
			</p>
			<p class="content_top_text">
				<a href="apply.jsp"><img src="img/login1.PNG" height="30px" width="140px"></a>
			</p>
		</div>
		<div style="padding-top:30px;">
		<div class="section_text">
			<div class="content-subtitle">
				系統特色
			</div>
			<div class="content-text">
			<ol type="1">
				<li>專為使用一般型手機、<font color="red">智慧型手機</font>沒有申請上網服務，或無安裝 KITs APP 的教職員生設計</li>
				<li>離線通讓您在無網路或無安裝 KITs APP 仍能享受清大雲端網路電話所提供的撥話服務，撥打<font color="red">清大校內分機 ( TANet門號 )</font>以及<font color="red">清大 MVPN 社群內行動電話</font>免費。</li>
				<li>此創新服務僅提供清大 MVPN 社群會員使用，欲享有離線通完整免費服務，歡迎您趕快加入清大 MVPN 社群會員行列。請至<a href="http://mvpn.hsnl.cs.nthu.edu.tw/portal.html">清華大學 MVPN 申請網頁</a>申請加入。</li>
				<li>離線通僅限台灣境內使用，不支援行動國際漫遊服務。</li>
			</ol>
			</div>
		</div>
		<div class="section_login">
			<form id="mappingForm" class="bs-docs-example form-horizontal" method="post" action="mapping.do" >
            	<div class="login-top">
            		<div class="login-subtitle">
            			帳號登入
            		</div>
            	</div>
            	<div class="content-text1">
					手機號碼
				</div>
            	<div class="input-group-lg login-name">
               		<input type="text" class="form-control input-lg" id="userphone" name="userphone" placeholder="請輸入手機號碼">
            	</div>
            	<div class="content-text1">
					密碼
				</div>
            	<div class="input-group-lg login-pwd"> 
               		<input type="password" class="form-control input-lg" id="inputPassword" name="inputPassword" placeholder="請輸入密碼">
            	</div>
            	<div class="login-btn">
            		<div class="forgotpassword">
            			<a href="forgot.jsp">忘記密碼 ?</a>
            		</div>
            		<div class="login-btn-btn">
            			<a href="#" onclick="formsubmit()"><img src="img/login_btn.png" height="70px" width="70px"></a>            			
            		</div>
            	</div>
           		<input type="hidden" id="action" name="action" value="login">
          	</form>
		</div>
		</div>
	</div>

</body>
</html>