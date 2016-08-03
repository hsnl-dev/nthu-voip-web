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
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
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
	font-size: 18px;
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
function deleteSubUser(){
	var node = $('#accountGrid').treegrid('getSelected');
	if(node != null){
		if(node.id == "1"){
			return false;
		}else{
			if(confirm("確定要刪除附屬帳號嗎?")){
				document.getElementById("subUser").value = node.account;
				document.getElementById("action").value = "deleteSubUser";
				document.getElementById("subUserForm").submit();
			}else{
				return false;
			}
		}
	}else{
		alert("請選擇一筆附屬帳號");
	}	
}
function changeLimitPoint(){
	var node = $('#accountGrid').treegrid('getSelected');
	if(node != null){
		if(node.id == "1"){
			return false;
		}else{
			document.getElementById("subUser").value = node.account;
			document.getElementById("limit").value = node.limitpoint;
			document.getElementById("subUserName").value = node.name;
			document.getElementById("action").value = "changeLimitPoint";
			document.getElementById("AccountManageForm").submit();
		}
	}else{
		alert("請選擇一筆附屬帳號");
	}
}
function editDefault(){
	document.getElementById("action").value = "editDefault";
	document.getElementById("subUserForm").action = "default.do";
	document.getElementById("subUserForm").submit();
}
function editMode(){
	document.getElementById("action").value = "editMode";
	document.getElementById("subUserForm").action = "contact.do";
	document.getElementById("subUserForm").submit();
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
    						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
      							聯絡人清單 <span class="caret"></span>
    						</a>
    						<ul class="dropdown-menu">
    							<li><a href="contact.do">聯絡人清單</a></li>
      							<li><a href="NewContact.jsp">新增聯絡人</a></li>
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
      							<li><a href="#" onclick="editDefault()">編輯預設聯絡人</a></li>
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
      							<li><a href="newSubUser.jsp">新增附屬帳號</a></li>
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
	<div id="tabs" style="margin-left:20px; width:90%; height:80%;">
		<ul class="nav nav-tabs" style="margin-bottom:0px;">
			<li class="active"><a href="#tabs-2"><h5>附屬帳號管理</h5></a></li>
		</ul>
		<div id="tabs-1" >
			<div class="alert fade in" style="width: 70%; margin: 0 auto; margin-bottom: 20px;">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<h4>在此可檢視附屬使用者帳號。</h4>
			</div>
			<div class="tableview">
			<table id="accountGrid" title="附屬帳號管理" class="easyui-treegrid" style="width:620px;height:300px;margin: 0px auto;"
			data-options="url:'webSubUser.do?action=getSubUserList', rownumbers:'false', idField:'id', treeField:'account'">
				<thead>
					<tr>
						<th field="account" width="160">分機號碼</th>
						<th field="name" width="160" >電子信箱</th>
						<th field="limitpoint" width="140" align="right">授權點數上限/每年</th>
						<th field="point" width="100" align="right">今年累積使用點數</th>
					</tr>
				</thead>
			</table>
			</div>
			<div class="tableview">
				<form method="post" action="webSubUser.do" id="subUserForm">
					<input type="hidden" name="subUser" id="subUser" value=""/>
					<input type="hidden" name="subUserName" id="subUserName" value=""/>
					<input type="hidden" name="limit" id="limit" value=""/>
					<input type="hidden" name="action" id="action" value=""/>
				</form>
				<!-- <button class="btn btn-primary" type="button" onclick="changeLimitPoint()">變更授權點數上限</button>  -->
				&nbsp;<button class="btn btn-primary" type="button" onclick="deleteSubUser()">刪除附屬帳號</button>
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