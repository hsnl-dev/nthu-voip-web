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
<title>取得驗證碼</title>
<style type="text/css">
.content-group{
	padding:0 80px 0 160px;
}
.content-text3{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:14px;
	/*color:#585657;*/
	color:#000000;
}
.content-text2{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	/*color:#585657;*/
	color:#000000;
	padding:15px 0 0px 0;
}
.section_right{
	float:right;
	width:42%;
	padding:0 100px 0 0;
}
.section-btn{
	
}
</style>
<%
String status = (String)request.getAttribute("status");
%>
<script type="text/javascript">
function check(){
	if("<%=status%>" == "failed"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("驗證碼有誤，請重新輸入!");
	}
}
function sendMessage(){
	var userphone = document.getElementById("userphone").value;
	if(userphone.length < 10 | userphone.substring(0,2) != '09'){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入正確的手機號碼!");
		return false;
	}else{
		$.ajax({
		    url:"mapping.do",
		    type:"POST",
		    data: "action=sendMessage&userphone="+userphone,
		    error:function(response){
		      	//alert("error");
		    },
		    success:function(response){
		    	//alert("success");
		    	if(response == "noMVPN"){
		    		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		    		alertify.alert("此行動號碼非清華大學 MVPN 社群，請先加入 MVPN 社群!");
		    	}else if(response == "success"){
		    		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		    		alertify.alert("已寄出驗證碼簡訊。提醒您，如訊號不良或是系統繁忙遲未收到簡訊驗證碼，請等候 5-10 分鐘再重新取得驗證碼。");
		    	}else if(response == "duplicate"){
		    		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		    		alertify.alert("手機號碼已註冊，請輸入新的號碼。若您忘記密碼，請回上一頁點選「忘記密碼」，重新取得驗證碼。");
		    	}		    	
		    },
		  });
	}
}

function formsubmit(){
	var thisForm = document.getElementById("mappingForm");
	if(thisForm.userphone.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入手機號碼!");
		thisForm.userphone.focus();
		return false;
	}else if(thisForm.verify.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入驗證碼!");
		thisForm.verify.focus();
		return false;
	}else{
		thisForm.action.value="verify";
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
		<div class="section_text">
			<div class="content-title">
				取得驗證碼
			</div>
			<form id="mappingForm" class="bs-docs-example form-horizontal" method="post" action="mapping.do" >
			<div class="content-group">
				<div class="content-step">
					第一步 :
				</div>
				<div class="content-text1">
					請輸入手機號碼
				</div>
            	<div class="input-group-lg login-name">
            		<input type="text" class="form-control input-lg" id="userphone" name="userphone" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="10" placeholder="請輸入手機號碼">
            	</div>
            	<div class="content-step">
					第二步 :
				</div>
				<div class="content-text1">
					透過手機簡訊取得驗證碼<span style="padding:0 0px 0 40px;"><a href="#" onclick="sendMessage()" class="btn btn-primary" >取得驗證碼</a></span>
				</div>
				<div class="content-step">
					第三步 :
				</div>
            	<div class="content-text2">
					請輸入驗證碼 
				</div>
            	<div class="input-group-lg login-name">
            		<input type="password" class="form-control input-lg" id="verify" name="verify" placeholder="請輸入驗證碼">
            	</div>
            	<div class="section-btn">
					<a href="#" onclick="formsubmit()"><img src="img/submit_btn.png" height="70px" width="70px"></a>
				</div>
            </div>
            <input type="hidden" name="action" id="action" value="verify">
			</form>
		</div>
		<div class="section_right">
			<div style="padding-top:100px">
				<div class="content-text1">
					* 使用離線通服務需先加入清華大學 MVPN 社群，若未加入，請至<a href="http://mvpn.hsnl.cs.nthu.edu.tw/portal.html">清華大學 MVPN 申請網頁</a>申請加入。
				</div>
				<div class="content-text1">
					手機號碼需屬於清華大學 MVPN 社群，登入後請設定密碼作為再次登入使用。
				</div>
			</div>
		</div>
	</div>
</body>
</html>