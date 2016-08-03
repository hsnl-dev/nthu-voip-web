<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/util-functions.js"></script>
<script type="text/javascript" src="js/clear-default-text.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<title>新增附屬帳號</title>
<style type="text/css"> 
body {
	margin: 0;
	padding-top:70px;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	line-height: 1.7em;
	font-size: 11px;
	background-color:#E0C860;
	background-image:url(img/bg5.png);
	background-size: 100%;
}
.header{
		padding:0px 15% 0px 15%;
		/*background-color:#e2b9f4;*/
	}
#searchform{
	float:right;
}
#navheader{
	float:left;
	width:40%;
}
#content{
	float:right;
	padding:60px 30px 0 0;
}
#content a{
	color:blue;
}
.navbar-minestyle{
		height:110px;
		background-image:url(img/banner.png);
		background-color:#E7EDC6;
		-moz-background-size:100%;
		-webkit-background-size:100%;
		-o-background-size:100%;
		background-size:100%;
		padding-top:0px;
		margin-left:100px;
		margin-right:100px;
		font-size:18px;
		/*background-color:#e2b9f4;*/
		color: #FFF;
		z-index:2;
		moz-box-shadow: 1px 1px 5px #555; /* Firefox */
		-webkit-box-shadow: 1px 1px 5px #555; /* Safari 和 Chrome */
		box-shadow: 1px 1px 5px #555; /* Opera 10.5 + */
		/*filter:alpha(opacity=80);*/
		-moz-opacity:0.8;
		-khtml-opacity:0.8; 
		opacity:0.8;
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
.section1{
		margin:30px 120px;
		height:600px;
		background-color:white;
		border: 1px solid #CCC;
		moz-box-shadow: 1px 1px 2px 2px #DDD; /* Firefox */
		-webkit-box-shadow: 1px 1px 2px 2px #DDD; /* Safari 和 Chrome */
		box-shadow: 1px 1px 2px 2px #DDD; /* Opera 10.5 + */
	}
	.sec1_alert{
		height:50px;
		width:480px;
		margin:0px auto;
		padding:0 40px 0 40px;
	}
	.sec1_text{
		width:100%;
		height:600px;
		margin:0px auto;
		padding:10px 20% 0 20%;
	}
	.sec1_text p {
		font: 16px "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
		padding:10px 0 0 10px;
	}
	.sec1_text div{
		padding:10px 0 0 0;
	}
</style>
<script type="text/javascript">
function check(subUserForm){
	if(subUserForm.phone1.value == ""){
		alert("請輸入附屬帳號分機號碼");
		subUserForm.phone1.focus();
		return false;
	}
	if(subUserForm.useremail1.value == ""){
		alert("請輸入附屬帳號電子郵件信箱");
		subUserForm.useremail1.focus();
		return false;
	}
}
function editDefault(){
	document.getElementById("action").value = "editDefault";
	document.getElementById("contactForm").action = "default.do";
	document.getElementById("contactForm").submit();
}
function editMode(){
	document.getElementById("action").value = "editMode";
	document.getElementById("contactForm").action = "contact.do";
	document.getElementById("contactForm").submit();
}
</script>
</head>
<body>
<div id="fb-root"></div>
<div id="maincontainer">
    <div class="header">
        	<!-- <div id="searchform">
        		<input id="searchText" type="text" class="input-small search-query" placeholder="查詢連絡人">
  				<button type="button" class="btn btn-small" onclick="searchfunction()">Search</button>
        	</div>  -->
        	<nav class="navbar navbar-minestyle navbar-fixed-top" role="navigation">
  			<!-- Brand and toggle get grouped for better mobile display -->
  				<div id="navheader" class="navbar-header">
    				<a class="navbar-brand" href="Home.jsp"><img src="img/6talk_logo.png"></a>
    			</div>
    			<div id="content">
        			<ul class="nav nav-pills">
  						<li class="dropdown">
    						<a class="dropdown-toggle" data-toggle="dropdown" href="">
      							聯絡人清單 <span class="caret"></span>
    						</a>
    						<ul class="dropdown-menu">
    							<li><a href="contact.do">聯絡人清單</a></li>
      							<li><a href="NewContact.jsp" >新增聯絡人</a></li>
      							<li><a href="#" onclick="editMode()">編輯聯絡人</a></li>
      							
    						</ul>
  						</li>
  						<% 
				    	String level = (String)session.getAttribute("level");
				    	if("0".equals(level)){
				    	%>
  						<li class="dropdown">
    						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
      							預設聯絡人管理 <span class="caret"></span>
    						</a>
    						<ul class="dropdown-menu">
      							<li><a href="newDefaultContact.jsp">新增預設聯絡人</a></li>
      							<li><a href="#" onclick="editDefault()">預設聯絡人管理</a></li>
    						</ul>
  						</li>
  						<% 
				    	}
				    	if("0".equals(level) | "1".equals(level)){
				    	%>
				    	<li class="dropdown">
    						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
      							附屬帳號管理 <span class="caret"></span>
    						</a>
    						<ul class="dropdown-menu">
      							<li><a href="#">新增附屬帳號</a></li>
      							<li><a href="accountManage.jsp">附屬帳號管理</a></li>
    						</ul>
  						</li>
				    	<% } %>
  						<li class="dropdown">
    						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
      							其他功能 <span class="caret"></span>
    						</a>
    						<ul class="dropdown-menu">
    							<li><a href="phone.jsp">分機設定</a></li>
    							<li><a href="chgPassword.jsp">密碼設定</a></li>
      							<li><a href="contactUs.html">聯絡我們</a></li>
      							<li><a href="login.do?action=logout">登出</a></li>
    						</ul>
  						</li>
					</ul>
    			</div>
			</nav>
    
    </div>
    <div class="line"></div>
  
<div style=" margin: 10px; height: 25px; text-align: center;">  
 
</div>
 
<div id="content_area">
 
<div id="left_column">
	
</div>
 
<div id="content_column">
	<div class="content">
		<div class="leftsection">
			
		</div>
		<div class="rightsection">
			
		</div>
		<div class="section1">
		<%
		String depart = (String)session.getAttribute("depart");
		%>
			<div class="sec1_alert">
				<div class="alert alert-success" width="200px">
					<b><h4>
					您一次可以新增兩筆<%=depart %>的附屬帳號
					</h4></b>
				</div>
			</div>
			<div class="sec1_text">
				<span class="label label-success"><h4>新增附屬帳號</h4></span>
				<form id="subUserForm" class="bs-docs-example form-horizontal" method="post" onsubmit="return check(this)" action="webSubUser.do">
            		<div class="input-group input-group-lg">
              			附屬帳號1分機號碼:&nbsp;
                		<input class="span2" type="text" name="phone1" id="phone1" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="8" placeholder="請輸入930+分機號碼" required>
            		</div>
            		<div class="input-group input-group-lg">
              			附屬帳號1電子郵件信箱:&nbsp;
                		<input type="text" class="form-control input-lg" id="useremail1" name="useremail1" maxLength="40" placeholder="請輸入附屬帳號之電子郵件信箱" required>
            		</div>
            		<hr style="border-top:1px dotted red;HEIGHT:0;width:400px;" >
            		<div class="input-group input-group-lg">
              			附屬帳號2分機號碼:&nbsp;
                		<input class="span2" type="text" name="phone2" id="phone2" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="8" placeholder="請輸入930+分機號碼">
            		</div>
            		<div class="input-group input-group-lg">
              			附屬帳號2電子郵件信箱:&nbsp;
                		<input type="text" class="form-control input-lg" id="useremail2" name="useremail2" maxLength="40" placeholder="請輸入附屬帳號之電子郵件信箱">
            		</div>
            		<hr style="border-top:1px dotted red;HEIGHT:0;width:400px;">
            		<div class="control-group">
                		<button class="btn btn-primary" type="submit" >確定</button>&nbsp&nbsp&nbsp&nbsp<a href="#" onclick="editDefault()" class="btn btn-default" type="button">取消</a>
           			</div>
           			<input type="hidden" name="action" id="action" value="newSubUser"/>
          		</form>
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