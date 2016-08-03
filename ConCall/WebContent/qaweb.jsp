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
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<title>常見問題</title>
<style type="text/css">
html, body{
	height:100%;
}
img.sbar{
	width: auto; 
	max-width: 30px; 
	height: auto; 
	max-height: 37px;
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
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	height:58px;
	width:100%;
}
.header-bot{
	height:35px;
	width:100%;
}
.header-bot a{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	color:#611987;/*字體色碼*/
}
.header-bot a,a:link,a:visited,a:hover{
	text-decoration:none;
}
.header-bot-group{
	float:right;
	width:37%;
}
.header-bot-img{
	float:left;
	width:35px;
	padding:0px 0px 0 0px;
}
.header-bot-text{
	float:left;
	padding:8px 0px 0 0px;
}
.content{
	padding-top:100px;
	padding-bottom:60px;
}
.content-title{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:60px;
	color:#611987;
	padding:0px 0 20px 160px;	
}
.content-text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	color:#585657;
	padding:30px 0 0 160px;
}
.section2{
		float:left;
		height:400px;
		width:85%;
		padding:20px 0 0 240px;
		overflow:auto;
		/*border:#585657 ridge 1px;*/
}
h4{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
}
.footer{
	position:absolute;
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
		<div class="content-title">
			常見問題
		</div>
		<div class="section2">
			<div id="q1" class="panel panel-default">
    			<div class="panel-heading">
      			<h4 class="panel-title">
          			什麼是網頁點點通?
      			</h4>
    			</div>
      			<div class="panel-body">
        			網頁點點通是專為全校各行政與教學單位所設計之方便簡單的撥號系統，利用網頁儲存使用者的聯絡人清單，只要點擊聯絡人的頭像，便可輕鬆透過設定之分機撥出電話。
      			</div>
  			</div>
  			<div id="q2" class="panel panel-default">
    			<div class="panel-heading">
      			<h4 class="panel-title">
          			如何開始使用網頁撥號系統?
      			</h4>
    			</div>
      			<div class="panel-body">
        			一般使用者可直接申請帳號使用。
      			</div>
  			</div>
		</div>
	</div>
	<div class="footer">
		<p class="foot_content">Copyright 2013 National Tsing Hua University ALL RIGHTS RESERVED.</p>
	</div>
</div>
</body>
</html>