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
<!-- main css -->
<link href="css/main.css" rel="stylesheet">
<title>設定密碼</title>
<style type="text/css">
.header-bot-home{
	float:right;
}
.header-bot-contactus{
	float:right;
	padding:0 25px 0 0;
}
.content-group{
	padding:0 80px 0 160px;
}
.content-text2{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	/*color:#585657;*/
	color:#000000;
	padding:15px 0 0px 0;
}
.section-btn{
	
}
</style>
<%
String status = (String)request.getAttribute("status");
%>
<script type="text/javascript">
function formsubmit(){
	var mappingForm = document.getElementById("mappingForm");
	if(mappingForm.inputPassword.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入密碼!");
		mappingForm.inputPassword.focus();
		return false;
	}else if(mappingForm.inputPassword2.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請再一次輸入密碼!");
		mappingForm.inputPassword2.focus();
		return false;
	}else if(mappingForm.inputPassword.value != mappingForm.inputPassword2.value){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("您輸入的密碼不一致，請重新輸入!");
		mappingForm.inputPassword2.focus();
		return false;
	}else{
		mappingForm.submit();
	}
}
</script>
</head>
<body>
<!-- <img src="img/bg2.jpg" class="bg"> -->
	<div class="header">
		<div class="header-top">
			<div class="header-top-group">
				<div class="header-top-phone">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-top-text">
						<%=session.getAttribute("userphone") %>
					</div>
				</div>
				<div class="header-top-logout">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="mapping.do?action=logout" >登出</a>
					</div>
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
				</div>
			</div>
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
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
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="mapping.do?action=getMappingList" >配對清單</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="section_text">
			<div class="content-title">
				設定密碼
			</div>
			<form id="mappingForm" class="bs-docs-example form-horizontal" method="post" action="mapping.do" >
			<div class="content-group">
				<div class="content-text2">
					歡迎使用離線通，第一次登入請先設定密碼。
				</div>
				<div class="content-text2">
					請輸入密碼
				</div>
            	<div class="input-group-lg login-name">
            		<input type="password" class="form-control input-lg" id="inputPassword" name="inputPassword" placeholder="請輸入密碼">
            	</div>
            	<div class="content-text2">
					請再一次輸入密碼
				</div>
            	<div class="input-group-lg login-name">
            		<input type="password" class="form-control input-lg" id="inputPassword2" name="inputPassword2" placeholder="請再一次輸入密碼">
            	</div>
            	<div class="section-btn">
					<a href="#" onclick="formsubmit()"><img src="img/save_btn.png" height="70px" width="70px"></a>
				</div>
            </div>
            <input type="hidden" name="verify" id="verify" value="<%=request.getAttribute("verify") %>">
            <input type="hidden" name="action" id="action" value="setPwd">
			</form>
		</div>
	</div>
</body>
</html>