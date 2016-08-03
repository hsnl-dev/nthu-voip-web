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
<link href="css/style1.css" rel="stylesheet">
<title>網頁多點通</title>
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
		alertify.alert("無此帳號或帳號審核中!");
	}else if("<%=status%>" == "incorrectPassword"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("密碼有誤，請重新輸入!");
	}else if("<%=status%>" == "insufficient"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("輸入資料不完整，請重新輸入!");
	}else if("<%=status%>" == "error"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("登入失敗!");
	}else if("<%=status%>" == "verifysuccess"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("帳號驗證通過，歡迎使用網頁點點通!");
	}else if("<%=status%>" == "verifyfail"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("帳號驗證失敗，請重新驗證!");
	}else if("<%=status%>" == "fotgotsuccess"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("帳號密碼已重新設定，已寄出新密碼之電子郵件!");
	}else if("<%=status%>" == "applysuccess"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("帳號申請已送出，請至EMAIL信箱收取驗證EMAIL!");
	}else if("<%=status%>" == "timeout"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("登入期限已過期，請重新登入!");
	}
}

function formsubmit(){
	var thisForm = document.getElementById("webForm");
	if(thisForm.email.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入電子郵件信箱!");
		thisForm.email.focus();
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
<!-- <img src="img/web/14.JPG" class="bg"> -->	
	<div class="header">
		<div class="header-top">
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/web/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="login.jsp" >首頁</a>
					</div>
				</div>
				<div class="header-bot-qa">
					<div class="header-bot-img">
						<img src="img/web/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="qaweb.jsp" >常見問題</a>
					</div>
				</div>
				<div class="header-bot-contactus">
					<div class="header-bot-img">
						<img src="img/web/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="contactUs1.jsp" >聯絡我們</a>
					</div>
					<div class="header-bot-img">
						<img src="img/web/sp.png" height="30px" width="30px">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="section_text">
			<div class="content-title">
				網頁點點通
			</div>
			<div class="content-subtitle">
				服務特色
			</div>
			<div class="content-text">
				<ol type="1">
					<li>
					提供使用者建立個人通訊錄，撥號時僅需點擊網頁上的聯絡人照片，就可以用設定的電話與對方通話。
					<ul>
						<li>更便利的撥號 (點擊照片，不須記電話號碼)</li>
						<li>更清晰的通話品質 (分機通話，清晰無雜音)</li>
						<li>更方便的多人通話 </li>
						<li>更便宜的費率 (打給清華大學MVPN通訊群組手機<font color="red">免費</font>，非群組也大量節費)</li>
					</ul>
					</li>
				</ol>	
			</div>
			<div class="content-text">
				網頁點點通 與你最通
			</div>
		</div>
		<div class="section_login">
			<form id="webForm" class="bs-docs-example form-horizontal" method="post" action="login.do" >
            	<div class="login-top">
            		<div class="login-subtitle">
            			帳號登入
            		</div>
            		<div class="login-apply">
            			<a href="apply.jsp"><img src="img/web/apply_account.png" height="28px" width="100px"></a>
            		</div>
            	</div>
            	<div class="content-text1">
					電子郵件信箱
				</div>
            	<div class="input-group-lg login-name">
               		<input type="text" class="form-control input-lg" id="email" name="email" placeholder="請輸入電子郵件信箱">
            	</div>
            	<div class="content-text1">
					密碼
				</div>
            	<div class="input-group-lg login-pwd"> 
               		<input type="password" class="form-control input-lg" id="inputPassword" name="inputPassword" placeholder="請輸入密碼">
            	</div>
            	<div class="login-btn">
            		<div class="forgotpassword">
            			<!-- <a href="forgot.jsp">忘記密碼 ?</a> -->
            		</div>
            		<div class="login-btn-btn">
            			<a href="#" onclick="formsubmit()"><img src="img/web/login_btn.png" height="70px" width="70px"></a>            			
            		</div>
            	</div>
           		<input type="hidden" id="action" name="action" value="login">
          	</form>
		</div>
	</div>
</body>
</html>