<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.account.service.xsd.WebAccount "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者帳號清單</title>
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
<style type="text/css">
	#content{
		float:right;
		padding:60px 30px 0 0;
	}
	.section1{
		margin:50px 120px;
		height:500px;
		background-color:white;
		border: 1px solid #CCC;
		moz-box-shadow: 1px 1px 2px 2px #DDD; /* Firefox */
		-webkit-box-shadow: 1px 1px 2px 2px #DDD; /* Safari 和 Chrome */
		box-shadow: 1px 1px 2px 2px #DDD; /* Opera 10.5 + */
	}
	#table1{
		width:90%;
		border:0; 
  		border-collpase:collpase; 
		margin:30px 0 0 25px;
		font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	}
	#table1 tr{
		height:100px;
		border-bottom:1px solid #000;
	}
	#table1 th{
		color:blue;
		font-size:20px;
		padding:0 5px 0 5px;
	}
	#table1 td{
		font-size:20px;
		padding:0 5px 0 5px;
	}
	#table1 td a{
		margin:5px 0 5px 0;
	}
</style>
<script type="text/javascript">
	function del(phone){
		var r=confirm("確定要移除管理者帳號嗎?");
		if (r==true){
			alert("已移除管理者帳號!");
		}
	}
	function sendmail(phone){
		var r=confirm("確定要重新寄出驗證信嗎?");
		if (r==true){
			alert("已重新寄出驗證信!");
			document.getElementById("phone").value = phone;
			document.getElementById("action").value = "sendmail";
			document.getElementById("webForm").submit();
		}
	}
</script>
</head>
<body>
	<div class="header">
	<nav class="navbar navbar-minestyle navbar-fixed-top" role="navigation">
  		<!-- Brand and toggle get grouped for better mobile display -->
  		<div class="navbar-header">
    		<a class="navbar-brand" href="Home.jsp"><img src="img/6talk_logo.png"></a>
    	</div>
    	<div id="content">
    		<ul class="nav nav-pills">
    			<li><a href="login.do?action=super">管理者帳號申請管理</a></li>
        		<li><a href="web.html?action=applylist">管理者帳號清單</a></li>
      			<li class="dropdown">
    				<a class="dropdown-toggle" data-toggle="dropdown" href="#">
      					其他功能 <span class="caret"></span>
    				</a>
    				<ul class="dropdown-menu">
    					<li><a href="contactUs.html">聯絡我們</a></li>
      					<li><a href="login.do?action=logout">登出</a></li>
    				</ul>
  				</li>
  			</ul>
    	</div>
	</nav>
	</div>
	<div class="content">
		<div class="leftsection">
			
		</div>
		<div class="rightsection">
			
		</div>
		<div class="section1">
			<h2><span class="label label-success">管理者帳號清單</span></h2>
			<form id="webForm" method="post" action="web.html">
			<table id="table1">
				<tr>
					<th width="16%" >申請人單位名稱</th>
					<th width="16%" >申請人分機號碼</th>
					<th width="16%" >申請人電子郵件信箱</th>
					<th width="16%" >申請人姓名</th>
					<th width="16%" >申請通過日期</th>
					<th width="20%"></th>
				</tr>
				<% 
				WebAccount[] webUserList = (WebAccount[])request.getAttribute("webUserList");
  				String[] unitArray = (String[])request.getAttribute("unitArray");
  				if(webUserList != null && unitArray != null){
  					for(int i = 0; i < webUserList.length; i++){
  						if(webUserList[i].getApproval() == true){
  				%>
  					<tr>
  						<td align="center"><%=unitArray[i] %></td>
  						<td align="center"><%=webUserList[i].getUserName() %></td>
  						<td align="center"><%=webUserList[i].getRegMail() %></td>
  						<td align="center"><%=webUserList[i].getName() %></td>
  						<td align="center"><%=webUserList[i].getDate() %></td>
  						<td align="center">
							<a href="#" onclick="sendmail('<%=webUserList[i].getUserName() %>')" class="btn btn-default">重寄認證信</a>
						</td>
  					</tr>
  				<%
  						}
  					}
  				}
  				%>
			</table>
			<input type="hidden" id="phone" name="phone" value="">
				<input type="hidden" id="action" name="action" value="">
			</form>
		</div>
	</div>

</body>
</html>