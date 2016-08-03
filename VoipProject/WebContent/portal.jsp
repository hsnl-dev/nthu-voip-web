<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<title>網頁點點通</title>
<style type="text/css">
html, body{
	/*min-width:1280px;*/
	height:100%;
}
#wrap{
	min-height:100%;
	position:relative;
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
	width:25%;
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
.content{
	padding-top:100px;
	padding-bottom:60px;
	overflow:auto;
}
.content_top{
	text-align:center;
	padding-top:0px;
	height:470px;
}
.content_bot{
	height:200px;
	padding-top:0px;
}
.content_bot_left{
	text-align:center;
	float:left;
	width:35%;
	padding-top:30px;
}
.content_bot_mid{
	float:left;
	width:28%;
	height:200px;
	text-align:center;
	border-left:#585657 solid 1px;
	border-right:#585657 solid 1px
}
.content_bot_right{
	text-align:center;
	float:right;
	width:35%;
	padding-top:30px;
}
.top_title{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:28px;
	font-weight:bold;
	color:#611987;/*字體色碼*/
}
.top_subtitle{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:24px;
	color:#611987;/*字體色碼*/
}
.top_text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:16px;
	/*color:#585657;字體色碼*/
	color:#000000;
}
.bot_text{
	padding:50px 40px 0 40px;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:16px;
	/*color:#585657;字體色碼*/
	color:#000000;
	letter-spacing:3px;
}
.footer{
	position:relative;
	bottom:0;
	background:url(img/bottom.jpg);
	background-repeat:no-repeat;
	background-size: 100%;
	-webkit-background-size: cover;
  	-moz-background-size: cover;
  	-o-background-size: cover;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='img/bottom.jpg',sizingMethod='scale');
	-ms-filter: "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='img/bottom.jpg',sizingMethod='scale')";
	height:60px;
	width:100%;
	color:white;
}
.foot_content{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:18px;
	text-align:right;
	padding:20px 20px 0 0;
}
</style>
</head>
<body>
<div id="wrap">
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
						<a href="http://nthu.kits.tw/service/home.html" >首頁</a>
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
		<div class="content_top">
			<p><img src="img/webuser.png" width="120px" height="120px"></p>
			<p class="top_title">網頁點點通</p>
			<p class="top_subtitle">最健康、便利、清晰、節費的撥號方式。</p>
			<p class="top_text">專門為本校行政單位、教學單位教職員量身打造的單位通訊錄</p>
			<p class="top_text">提供單位管理者建立單位預設通訊錄</p>
			<p class="top_text">使用者建立個人通訊錄撥號校內分機以及清華大學 MVPN 社群內行動電話<font color="red">免費</font></p>
			<p class="top_text">獨家「<font color="red">網頁撥號，校內分機通話</font>」技術，</p>
			<p class="top_text">無需額外安裝轉接設備，也無須準備耳機麥克風，操作便利哦!</p>
			<p class="top_text">採階層式帳號管理架構：</p>
			<p class="top_text">系辦秘書(單位管理者)-->教授(附屬帳號使用者，由【系辦秘書】建立帳號)-->助理(附屬帳號使用者，由【教授】建立帳號)</p>
		</div>
		<div class="content_bot">
			<div class="content_bot_left">
				<p><a href="adminpage.jsp"><img src="img/adminicon.png" width="120px" height="120px"></a></p>
			</div>
			<div class="content_bot_mid">
				<p class="bot_text">單位管理者由各單位指派一人申請單位管理者帳號，附屬帳號使用者請向各單位之單位管理者申請帳號。</p>
			</div>
			<div class="content_bot_right">
				<p><a href="userpage.jsp"><img src="img/subusericon.png" width="120px" height="120px"></a></p>
			</div>
		</div>
	</div>
	<div class="footer">
		<p class="foot_content">Copyright 2013 National Tsing Hua University ALL RIGHT RESERVED.</p>
	</div>
</div>
</body>
</html>