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

<title>忘記密碼</title>
<style type="text/css">
body{
	padding-top:0px;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
}
img.sbar{
	width: auto; 
	max-width: 25px; 
	height: auto; 
	max-height: 30px;
}
.header{
	background:url(img/webtop.jpg);
	background-repeat:no-repeat;
	background-size: 100%;
	-webkit-background-size: cover;
  	-moz-background-size: cover;
  	-o-background-size: cover;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='img/webtop.jpg',sizingMethod='scale');
	-ms-filter: "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='img/webtop.jpg',sizingMethod='scale')";
	height:100px;
	width:100%;
}
.header-top{
	height:58px;
	width:100%;
}
.header-bot{
	position:relative;
	z-index:1;
	height:35px;
	width:100%;
}
.header-bot a{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	color:#611987;/*字體色碼*/
}
.header-bot-group{
	float:right;
	width:30%;
}
.header-bot-img{
	float:left;
	width:30px;
	padding:0px 0px 0 0px;
}
.header-bot-text{
	float:left;
	padding:0px 0px 0 0px;
}
.content_block{
	width:500px;
	padding-left:100px;
}
.content-title{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:60px;
	color:#611987;
	padding:40px 0 0px 0px;	
}
.content-text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	/*color:#585657;*/
	color:#000000;
	padding:10px 0 10px 0px;
}
</style>
<%
	String status = (String)request.getAttribute("status");
%>
<script type="text/javascript">
function check(){
	if("<%=status%>" == "failed"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("帳號有誤，請重新再試一次!");
	}
}
function formsubmit(){
	var thisForm = document.getElementById("applyForm");
	if(thisForm.phone.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入註冊的分機號碼!");
		thisForm.phone.focus();
		return false;
	}else{
		thisForm.submit();
	}
}
</script>
</head>
<body onload="check()">
	<div class="header">
		<div class="header-top">
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/web/sp.png" class="sbar">
					</div>
					<div class="header-bot-text">
						<a href="http://nthu.kits.tw/service/home.html" >首頁</a>
					</div>
				</div>
				<div class="header-bot-qa">
					<div class="header-bot-img">
						<img src="img/web/sp.png" class="sbar">
					</div>
					<div class="header-bot-text">
						<a href="http://nthu.kits.tw/service/qaweb.html" >常見問題</a>
					</div>
				</div>
				<div class="header-bot-contactus">
					<div class="header-bot-img">
						<img src="img/web/sp.png" class="sbar">
					</div>
					<div class="header-bot-text">
						<a href="contactUs1.jsp" >聯絡我們</a>
					</div>
					<div class="header-bot-img">
						<img src="img/web/sp.png" class="sbar">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="content_block">
		<form id="applyForm" class="bs-docs-example form-horizontal" method="post" action="web.html">	
			<div class="content-title">
				忘記密碼
			</div>
			<div class="content-text">
				請輸入註冊的分機號碼 :
			</div>
			<div class="input-group-lg apply-depart">
            	<input type="text" class="form-control input-lg" maxlength="8" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" id="phone" name="phone" placeholder="請輸入930+分機號碼">
            </div>
            <div class="content-text">
				取得新的密碼
			</div>
            <div class="input-group-lg apply-depart">
            	<a href="#" onclick="formsubmit()" class="btn btn-primary">取得密碼</a>
            </div>
            <input type="hidden" name="action" value="forgotPwd">
        </form>
		</div>
	</div>
</body>
</html>