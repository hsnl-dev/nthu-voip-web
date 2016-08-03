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
	/*height:548px;*/
	padding-top:100px;
	padding-bottom:60px;
	overflow:auto;
}
.content_left{
	float:left;
	width:70%;
	padding:0px 0 0 130px;
}
.content_right{
	float:right;
	width:180px;
	text-align:right;
	margin:0 100px 0 0;
	padding:200px 0px 0 0;
}
.content_title{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:32px;
	color:#611987;/*字體色碼*/
}
.content_subtitle{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	color:#611987;/*字體色碼*/
}
.content_text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:18px;
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
		<div class="content_left">
		<div >
			<p class="content_title">單位管理者</p>
			<ol class="content_text" type="1">
				<li>由<font color="red">各單位指派一人申請「單位管理者」帳號</font>。</li>
				<li>單位管理者完成申請後會收到清華大學雲端網路電話服務中心寄來的<font color="red"> e-mail 驗證信件</font>，</li>
				<li>通過驗證後即可登入單位管理者網頁享受服務囉!</li>
			</ol>
			<br>
			<p class="content_subtitle">功能說明</p>
			<ul class="content_text">
				<li>「<font color="#428bca">預設聯絡人</font>」功能 : <br>預設聯絡人為各單位共用之聯絡人名單，單位管理者可自行新增/修改名單。</li>
				<li>「<font color="#428bca">附屬帳號</font>」功能 : <br>單位管理者可指派/維護多位附屬帳號，並且分配/查看附屬帳號點數。</li>
				<li>「<font color="#428bca">聯絡人</font>」功能 : <br>聯絡人為個人聯絡人名單，單位管理者可新增/修改名單。</li>
			</ul>
		</div>
		</div>
		<div class="content_right">
			<p><a href="Home1.jsp"><img src="img/loginicon.png" height="33px" width="70px"></a></p>
			<p><a href="applyform.jsp"><img src="img/applyadmin.png" height="30px" width="175px"></a></p>
		</div>
	</div>
	<div class="footer">
		<p class="foot_content">Copyright 2013 National Tsing Hua University ALL RIGHT RESERVED.</p>
	</div>
</div>
</body>
</html>