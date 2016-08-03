<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"></link> 
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script> 
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<title>修改密碼</title>
<style type="text/css">
body{
	/*background:url(img/web/03.jpg);*/
	padding-top:0px;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	background-image:url(img/web/14.JPG);
	background-size: 100%;
	background-repeat:no-repeat;
}
.header-top{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
}
.user-account{
	float:right;
	width:100px;
	padding:35px 20px 0 0px;
}
.logout{
	float:right;
	width:120px;
	padding:35px 30px 0 0px;
}
.navbar-minetype{
	height:50px;
	padding:65px 24px 0 0;
	background:rbga(0,0,0,0);
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	color:#611987;
}
#navheader{
	float:left;
	width:60%;
}
#content{
	float:right;
	padding:0 0 0 0;
}
.nav-mycolor{
	color:#611987;
}
.content-title{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:60px;
	color:#611987;
	padding:100px 0 0 160px;	
}
.section1{
	float:left;
	width:25%;
	height:300px;
	padding:50px 0 0 160px;
}
.section1-text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	color:#585657;
}
.section1-phone{
	padding:25px 0 25px 0;
}
.section1-pwd{
	padding:25px 0 25px 0;
}
.section1-pwd2{
	padding:25px 0 25px 0;
}
.section2{
	float:right;
	width:55%;
	height:400px;
}
.sub-btn{
	float:left;
	padding:270px 0 0 0px;
}
.sub-btn-btn{
	height:70px;
	width:70px;
	background-image:url(img/web/btn.png);
	background-size: cover;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	color:white;
}
.sub-text{
	padding:24px 14px 24px 14px;
}
.sub-text a,a:link,a:visited,a:hover{
	text-decoration:none;
}
</style>
<script type="text/javascript">
function accountManage(){
	document.getElementById("action").value = "getSubUserList";
	document.getElementById("subUserForm").action = "webSubUser.do";
	document.getElementById("subUserForm").submit();
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
function submit(){
	var subUserForm = document.getElementById("subUserForm");
	if(subUserForm.oldPassword.value == ""){
		alert("請輸入舊的密碼");
		subUserForm.oldPassword.focus();
		return false;
	}else if(subUserForm.inputPassword.value == ""){
		alert("請輸入新的密碼");
		subUserForm.inputPassword.focus();
		return false;
	}else if(subUserForm.inputPassword2.value == ""){
		alert("請再一次輸入新的密碼");
		subUserForm.inputPassword2.focus();
		return false;
	}else if(subUserForm.inputPassword.value != subUserForm.inputPassword2.value){
		alert("您輸入的密碼不一致，請重新輸入!");
		contactForm.inputPassword2.focus();
		return false;
	}else{
		subUserForm.submit();
	}
}
</script>
</head>
<body>
	<div class="header">
		<div class="header-top">
			<div class="logout">
				<img src="img/web/sp.JPG" height="30px" width="30px">
				<a href="login.do?action=logout"><span class="nav-mycolor">登出</span></a>
				<img src="img/web/sp.JPG" height="30px" width="30px">
			</div>
			<div class="user-account">
				<%=session.getAttribute("userphone") %>
			</div>
		</div>
		<nav class="navbar navbar-minetype" role="navigation">
  			<!-- Brand and toggle get grouped for better mobile display -->
  			<div id="navheader" class="navbar-header">
    			&nbsp;
    		</div>
    		<div id="content">
        		<ul class="nav nav-pills">
        			<li class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
      						<span class="nav-mycolor">聯絡人</span><span class="caret"></span>
    					</a>
    					<ul class="dropdown-menu">
    						<li><a href="contact.do"><span class="nav-mycolor">聯絡人清單</span></a></li>
      						<!-- <li><a href="NewContact1.jsp"><span class="nav-mycolor">新增聯絡人</span></a></li> -->
      						<li><a href="#" onclick="editMode()"><span class="nav-mycolor">編輯聯絡人</span></a></li>
    					</ul>
  					</li>
  					<li><img src="img/web/sp.JPG" height="30px" width="30px"></li>
					<% 
					String depart = (String)session.getAttribute("depart");
			    	String level = (String)session.getAttribute("level");
			    	if("0".equals(level)){
			    	%>
  					<li><a href="#" onclick="editDefault()"><span class="nav-mycolor">預設聯絡人</span></a></li>
  					<!-- 
  					<li class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    						<span class="nav-mycolor">預設聯絡人 </span><span class="caret"></span>
    					</a>
    					<ul class="dropdown-menu">
    						<li><a href="NewDefaultContact1.jsp"><span class="nav-mycolor">新增預設聯絡人</span></a></li>
    						<li><a href="#" onclick="editDefault()"><span class="nav-mycolor">預設聯絡人管理</span></a></li>
    					</ul>
  					</li>
  					 -->
  					<li><img src="img/web/sp.JPG" height="30px" width="30px"></li>
  					<% 
			    	}
			    	if("0".equals(level) | "1".equals(level)){
			    	%>
			    	<li><a href="#" onclick="accountManage()"><span class="nav-mycolor">附屬帳號</span></a></li>
			    	<!-- 
			    	<li class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    						<span class="nav-mycolor">附屬帳號 </span><span class="caret"></span>
    					</a>
    					<ul class="dropdown-menu">
    						<li><a href="newSubUser1.jsp"><span class="nav-mycolor">新增附屬帳號</span></a></li>
    						<li><a href="#" onclick="accountManage()"><span class="nav-mycolor">附屬帳號管理</span></a></li>
    					</ul>
  					</li>
  					 -->
  					<li><img src="img/web/sp.JPG" height="30px" width="30px"></li>
			    	<% } %>
			    	<li class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    						<span class="nav-mycolor">帳號設定 </span><span class="caret"></span>
    					</a>
    					<ul class="dropdown-menu">
    						<li><a href="phone1.jsp"><span class="nav-mycolor">分機設定</span></a></li>
    						<li><a href="chgPassword1.jsp"><span class="nav-mycolor">密碼設定</span></a></li>
    					</ul>
  					</li>
  					<li><img src="img/web/sp.JPG" height="30px" width="30px"></li>
  					<li><a href="contactUs1.jsp"><span class="nav-mycolor">聯絡我們</span></a></li>
  					<li><img src="img/web/sp.JPG" height="30px" width="30px"></li>
				</ul>
    		</div>
		</nav>
	</div>
	<div class="content">
		<div class="content-title">
			修改密碼
		</div>
		<div class="section1">
			<form id="subUserForm" class="bs-docs-example form-horizontal" method="post" onsubmit="return check(this)" action="web.html">
            	<div class="section1-text">
            		輸入舊密碼
            	</div>
            	<div class="input-group-lg section1-phone">
              		<input class="span2" type="password" style="border:1px solid #611987" name="oldPassword" id="oldPassword" value="" maxLength="10" placeholder="請輸入舊的密碼" required>
            	</div>
            	<div class="section1-text">
            		輸入新密碼
            	</div>
            	<div class="input-group-lg section1-pwd">
            		<input type="password" class="form-control input-lg" style="border:1px solid #611987" name="inputPassword" id="inputPassword" size="20" maxLength="10" value="" placeholder="請輸入新的密碼" required>
            	</div>
            	<div class="section1-text">
            		再一次輸入新號碼
            	</div>
            	<div class="input-group-lg section1-pwd2">
            		<input type="password" class="form-control input-lg" style="border:1px solid #611987" name="inputPassword2" id="inputPassword2" size="20" maxLength="10" value="" placeholder="請再一次輸入密碼" required>
            	</div>
            	<input type="hidden" id="action" name="action" value=changePassword>
          	</form>
		</div>
		<div class="section2">
			<div class="sub-btn">
            	<div class="sub-btn-btn">
            		<div class="sub-text">
            			<a href="#" onclick="submit()"><font color="white">儲存</font></a>
            		</div>            			
            	</div>
           	</div>
		</div>
	</div>
</body>
</html>