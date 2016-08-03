<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.util.ArrayList "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附屬帳號管理</title>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/util-functions.js"></script>
<script type="text/javascript" src="js/clear-default-text.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<style type="text/css"> 
body {
	margin: 0;
	padding: 0;
	line-height: 1.7em;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	background-color:#E0C860;
	background-image:url(img/bg5.png);
	background-size: 100%;
}
 
b {	font-size: 110%; }
em { color: red; }
 
#maincontainer {
	width: 980px;
	margin: 0 auto;
	background: #FFFFFF;
	background-image:url(img/bg4.png);
	background-size: 100%;
}
 
#mainmenu {
	background: #FFFFFF;
}
 
.header_left {
	float: left;
	width: 500px;
	padding-top: 0px;
	padding-left: 40px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
	font-weight: bold;
	color: #000;
}
 
.header_left span {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: normal;
	color: #99CCFF;
}
 
.header_right {
	float: right;
	width: 320px;
	margin: 20px 20px 0px 0px;
}
 
#top_section {
	background-image:url(img/banner.png);
	background-color:#E7EDC6;
	height: 110px;
}
#content_area {
	clear: both;
	min-height: 800px;
}
 
#content_column {
	float: left;
	width: 100%;
	height: 700px;
/*	width: 500px; */
}
 
#right_column {
	float: right;
	width: 165px;
	line-height: 1.8em;
}
#left_column {
	float: left;
	padding-left: 10px;
	width: 300px;
}
 
#footer {
	clear: both;
	width: 100%;
	background: black;
	color: #FFF;
	text-align: center;
	padding: 4px 0;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 10px;
}

#tabs-1 {
	height: 100%;
	margin: 0px auto;
	moz-box-shadow: 1px 1px 2px 2px #DDD;
	-webkit-box-shadow: 1px 1px 2px 2px #DDD;
	box-shadow: 1px 1px 2px 2px #DDD;
}
.tableview{
	display:table; 
	margin: 0px auto;
}
</style>
<script type="text/javascript">
function submit(){
	document.getElementById("AccountManageForm").submit();
}
</script>
</head>
<body>
<div id="fb-root"></div>
<div id="maincontainer">
    <div id="top_section">
    
    <div class="header_left" style="margin: 10px 0px 0px 0px;"><a href="login.html"><img src="img/6talk_logo.png" width="200" height="80"></a><br>歡迎使用"雲端電話秘書 APP (6Talk) 校園服務授權專案"  </div>
        
        <div class="header_right">
        
        	<div align="right" style="margin: 60px 10px 10px 0px;height:50px;">
        	<div class="btn-toolbar">
				<div class="btn-group">
				<a class="btn btn-small dropdown-toggle" data-toggle="dropdown" href="#">進階設定
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu pull-right">
					<li><a href="login.html">回首頁</a></li>
				    <li><a href="phone.jsp">分機設定</a></li>
					<li><a href="contactUs.html"  >聯絡我們</a></li>
					<li class="divider"></li>
					<li><a href="login.html?action=logout" >登出</a></li>
				</ul>
				</div>
			</div>
        	</div>
        </div>
    
    </div>
    <div class="line"></div>
  
<div style=" margin: 10px; height: 25px; text-align: center;">  

</div>
 
<div id="content_area">
 
<div id="left_column">
	
</div>
 
<div id="content_column">
	<div id="tabs" style="margin-left:20px; width:90%; height:80%;">
		<ul class="nav nav-tabs" style="margin-bottom:0px;">
			<li ><a href="newAccount.jsp"><h5>新增附屬帳號</h5></a></li>
			<li class="active"><a href="#tabs-2"><h5>附屬帳號管理</h5></a></li>
		</ul>
		<div id="tabs-1" >
			<div class="alert fade in" style="width: 70%; margin: 0 auto; margin-bottom: 20px;">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<h4>在此可變更附屬使用者授權點數上限。</h4>
			</div>
			<div class="tableview">
				<form method="post" action="AccountManage.html" id="AccountManageForm">
					<input type="hidden" name="action" id="action" value="changeLimit"/>
				<table border="0">
					<tr>
						<td>使用者帳號  :</td>
						<td><input type="text" name="subUser" id="subUser" value="<%=request.getAttribute("subUser") %>" readonly="true"/></td>
					</tr>
					<tr>
						<td>使用者名稱  :</td>
						<td><input type="text" name="subUserName" id="subUserName" value="<%=request.getAttribute("subUserName") %>" readonly="true"/></td>
					</tr>
					<tr>
						<td>授權點數上限  :</td>
						<td><input type="text" name="limit" id="limit" value="<%=request.getAttribute("limit") %>" required/> / 每年</td>
					</tr>
				</table>
				</form>
			</div>
			<div class="tableview">
				<button class="btn btn-primary" type="button" onclick="submit()">儲存</button>
				&nbsp;<button class="btn btn-primary" type="button" onclick="window.history.back()">取消</button>
			</div>
  		</div>
  		
  	</div>
</div>
 
</div>
 
<div id="footer">
<b>Copyright © 2012</b>
</div>
</div>
</body>
</html>