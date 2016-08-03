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
<title>聯絡我們</title>
</head>
<body>
<!-- <img src="img/bg2.jpg" class="bg"> -->
	<div class="header">
		<div class="header-top">
		<%
		if(session.getAttribute("sid") != null){
		%>
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
		<%
		}
		%>
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
				<%
				if(session.getAttribute("sid") != null){
				%>
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="mapping.do?action=getMappingList" >配對清單</a>
					</div>
				</div>
				<div class="header-bot-qa">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="chgPwd.jsp" >變更密碼</a>
					</div>
				</div>
				<%	
				}else{
				%>
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="Home.jsp" >首頁</a>
					</div>
				</div>
				<div class="header-bot-qa">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="qamapping.jsp" >常見問題</a>
					</div>
				</div>
				<%
				} 
				%>
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
				離線通
			</div>
			<div class="content-text">
				聯絡窗口 : 劉小姐
			</div>
			<div class="content-text">
				電子郵件信箱 : liuty@mx.nthu.edu.tw
			</div>
			<div class="content-text">
				電話 : 5731200
			</div>
		</div>
	</div>
</body>
</html>