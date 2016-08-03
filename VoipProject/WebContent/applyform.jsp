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

<title>單位管理者帳號申請</title>
<style type="text/css">
body{
	/*background:url(img/web/03.jpg);*/
	min-width:1280px;
	padding-top:0px;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	/*background-image:url(img/web/14.JPG);
	background-size: 100%;
	background-repeat:no-repeat;*/
}
/*this is for ie 8*/
img.bg {
  /* Set rules to fill background */
  min-height: 100%;
  min-width: 1024px;
	
  /* Set up proportionate scaling */
  width: 100%;
  height: auto;
	
  /* Set up positioning */
  position: fixed;
  top: 0;
  left: 0;
  z-index:-1;
}

@media screen and (max-width: 1024px) { /* Specific to this particular image */
  img.bg {
    left: 50%;
    margin-left: -512px;   /* 50% */
  }
}
img.sbar{
	width: auto; 
	max-width: 30px; 
	height: auto; 
	max-height: 37px;
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
	width:35%;
}
.header-bot-img{
	float:left;
	width:35px;
	padding:0px 0px 0 0px;
}
.header-bot-text{
	float:left;
	padding:0px 0px 0 0px;
}
.section1{
	float:left;
	width:60%;
	height:600px;
	padding:0px 0 0 170px;
}
.apply-depart{
	width:350px;
	padding:0px 0 0px 0;
}
.apply-phone{
	width:350px;
	padding:0px 0 0px 0;
}
.apply-email{
	width:350px;
	padding:0px 0 0px 0;
}
.apply-name{
	width:350px;
	padding:0px 0 0px 0;
}
.section2{
	float:right;
	width:40%;
	height:600px;
}
.apply-btn{
	float:left;
	padding:470px 0 0 0px;
}
.apply-btn-btn{
	height:70px;
	width:70px;
}
.apply-text a,a:link,a:visited,a:hover{
	text-decoration:none;
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
		alertify.alert("發生未知錯誤，請連繫管理者!");
	}else if("<%=status%>" == "Duplicated"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("分機號碼已使用，請重新輸入!");
	}else if("<%=status%>" == "register"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("帳號申請已送出，請等候1-3天，帳號審核完成將以EMAIL通知您，謝謝!", function (e) {
	        if (e) {
	            window.location.href = "adminpage.jsp";
	        }
	        });
	}
}
function formsubmit(){
	var thisForm = document.getElementById("applyForm");
	var phoneStr = thisForm.phone.value;
	if(thisForm.depart.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入單位名稱!");
		thisForm.depart.focus();
		return false;
	}else if(thisForm.email.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入單位管理者電子郵件信箱!");
		thisForm.email.focus();
		return false;
	}else if(thisForm.name.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入單位管理者姓名!");
		thisForm.name.focus();
		return false;
	}else if(thisForm.phone.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入分機號碼!");
		thisForm.phone.focus();
		return false;
	}else if(phoneStr.length != 8 || phoneStr.substring(0,3) != "930"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入930 + 分機號碼!");
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
		<div class="section1">
			<form id="applyForm" class="bs-docs-example form-horizontal" method="post" onsubmit="return check(this)" action="web.html">
            	<div class="content-title">
					單位管理者帳號申請
				</div>
				<div class="content-text">
					單位名稱
				</div>
            	<div class="input-group-lg apply-depart">
            		<input type="text" class="form-control input-lg" id="depart" name="depart" placeholder="請輸入單位名稱">
            	</div>
            	<div class="content-text">
					分機號碼
				</div>
            	<div class="input-group-lg apply-phone">
            		<input type="text" class="form-control input-lg" maxlength="8" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" id="phone" name="phone" placeholder="請輸入930+分機號碼">
            	</div>
            	<div class="content-text">
					電子郵件
				</div>
            	<div class="input-group-lg apply-email">
            		<input type="text" class="form-control input-lg" id="email" name="email" placeholder="請輸入電子郵件信箱">
            	</div>
            	<div class="content-text">
					單位管理者姓名
				</div> 
            	<div class="input-group-lg apply-name">
            		<input type="text" class="form-control input-lg" id="name" name="name" placeholder="請輸入姓名">
            	</div>
            		<input type="hidden" name="action" value="register">
          	</form>
		</div>
		<div class="section2">
			<div class="apply-btn">
            	<div class="apply-btn-btn">
            		<a href="javascript: return false;" onclick="formsubmit()"><img src="img/web/submit_btn.png" width="70px" height="70px"></a>            			
            	</div>
           	</div>
		</div>
	</div>
</body>
</html>