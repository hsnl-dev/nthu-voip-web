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

<!-- alertify plugin -->
<script src="js/alertify.min.js"></script>
<link href="css/alertify.core.css" rel="stylesheet">
<link href="css/alertify.default.css" rel="stylesheet">

<title>變更通話分機</title>
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
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	position:relative;
	z-index:1;
	height:43px;
	width:100%;
}
.user-account{
	float:right;
	width:100px;
	padding:27px 20px 0 0px;
}
.logout{
	float:right;
	width:120px;
	padding:20px 30px 0 0px;
}
.navbar-minetype{
	height:50px;
	padding:0px 24px 0 0;
	background:rbga(0,0,0,0);
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	color:#611987;
}
#navheader{
	float:left;
	width:22%;
}
#content{
	float:right;
	width:78%;
	padding:0 0 0 0;
}
#bot_ul{
	float:right;
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
}
.sub-text{
	padding:24px 14px 24px 14px;
}
.sub-text a,a:link,a:visited,a:hover{
	text-decoration:none;
}
</style>
<%
	String status = (String)request.getAttribute("status");
%>
<script type="text/javascript">
function check(){
	if("<%=status%>" == "Duplicated"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("分機號碼已使用，請重新輸入!");
	}else if("<%=status%>" == "error"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("變更分機號碼失敗，請聯絡系統管理者!");
	}
}
function formsubmit(){
	var subUserForm = document.getElementById("subUserForm");
	if(subUserForm.phone.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入通話分機號碼!");
		subUserForm.phone.focus();
		return false;
	}else{
		subUserForm.submit();
	}
}
</script>
</head>
<body onload="check()">
	<div class="header">
		<div class="header-top">
			<div class="logout">
				<img src="img/web/sp.png" class="sbar">
				<a href="login.do?action=logout"><span class="nav-mycolor">登出</span></a>
				<img src="img/web/sp.png" class="sbar">
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
        		<ul id="bot_ul" class="nav nav-pills">
        			<li class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
      						<span class="nav-mycolor">聯絡人</span><span class="caret"></span>
    					</a>
    					<ul class="dropdown-menu">
    						<li><a href="contact.do"><span class="nav-mycolor">聯絡人清單</span></a></li>
      						<!-- <li><a href="NewContact1.jsp"><span class="nav-mycolor">新增聯絡人</span></a></li> -->
      						<li><a href="contact.do?action=editMode"><span class="nav-mycolor">編輯聯絡人</span></a></li>
    					</ul>
  					</li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
					<% 
					String depart = (String)session.getAttribute("depart");
			    	String level = (String)session.getAttribute("level");
			    	if("0".equals(level)){
			    	%>
  					<li><a href="default.do?action=editDefault"><span class="nav-mycolor">預設聯絡人</span></a></li>
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
  					<li><img src="img/web/sp.png" class="sbar"></li>
  					<% 
			    	}
			    	if("0".equals(level) | "1".equals(level)){
			    	%>
			    	<li><a href="webSubUser.do?action=getSubUserList"><span class="nav-mycolor">附屬帳號</span></a></li>
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
  					<li><img src="img/web/sp.png" class="sbar"></li>
			    	<% 
			    	}
			    	if("2".equals(level)){
			    	%>
			    	<li><a href="webSubUser.do?action=usedPoint"><span class="nav-mycolor">使用點數</span></a></li>
			    	<li><img src="img/web/sp.png" class="sbar"></li>
			    	<% } %>
			    	<li><a href="phone1.jsp"><span class="nav-mycolor">變更通話分機</span></a></li>
			    	<li><img src="img/web/sp.png" class="sbar"></li>
    				<li><a href="chgPassword1.jsp"><span class="nav-mycolor">變更密碼</span></a></li>
  					<!-- <li class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    						<span class="nav-mycolor">帳號設定 </span><span class="caret"></span>
    					</a>
    					<ul class="dropdown-menu">
    						<li><a href="phone1.jsp"><span class="nav-mycolor">變更通話分機</span></a></li>
    						<li><a href="chgPassword1.jsp"><span class="nav-mycolor">變更密碼</span></a></li>
    					</ul>
  					</li>
  					 -->
  					<li><img src="img/web/sp.png" class="sbar"></li>
  					<li><a href="contactUs1.jsp"><span class="nav-mycolor">聯絡我們</span></a></li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
				</ul>
    		</div>
		</nav>
	</div>
	<div class="content">
		<div class="content-title">
			變更通話分機
		</div>
		<div class="section1">
			<form id="subUserForm" class="bs-docs-example form-horizontal" method="post" onsubmit="return check(this)" action="web.html">
            	<div class="section1-text">
            		請輸入930 + 通話分機號碼(共8碼) :
            	</div>
            	<div class="input-group-lg section1-phone">
              		<input type="text" name="phone" id="phone" size="20" style="border:1px solid #611987" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="8" value="<%=session.getAttribute("userphone") %>" placeholder="請輸入930 + 通話分機號碼(共8碼)" required>
            	</div>
            	<input type="hidden" id="action" name="action" value=setPhone>
          	</form>
		</div>
		<div class="section2">
			<div class="sub-btn">
            	<div class="sub-btn-btn">
            		<a href="#" onclick="formsubmit()"><img src="img/web/save_btn.png" height="70px" width="70px"></a>
            	</div>
           	</div>
		</div>
	</div>
</body>
</html>