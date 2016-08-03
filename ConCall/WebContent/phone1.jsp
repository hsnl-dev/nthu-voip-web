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

<title>變更通話號碼</title>
<style type="text/css">
body{
	/*background:url(img/web/03.jpg);*/
	min-width:1024px;
	padding-top:0px;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	/*background-image:url(img/web/14.JPG);
	background-size: 100%;
	background-repeat:no-repeat;*/
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
	font-size:40px;
	color:#611987;
	padding:100px 0 0 160px;	
}
.section1{
	float:left;
	width:30%;
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
	width:50%;
	height:400px;
}
.sub-btn{
	float:left;
	height:80px;
	width:100%;
	padding:70px 0 0 0px;
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
.new-phone{
	float:left;
	height:80px;
	width:100%;
	padding:30px 0 0 0px;
}
</style>
<%
	String status = (String)request.getAttribute("status");
	String[] phoneList = (String[])session.getAttribute("phoneList");
	String userphone = (String)session.getAttribute("userphone");
%>
<script type="text/javascript">
function check(){
	if("<%=status%>" == "insufficient"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("輸入資料不完整，請重新輸入!");
	}else if("<%=status%>" == "incorrectSession"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("Session過期，請重新登入!");
	}else if("<%=status%>" == "noRecord"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("此電話號碼不在號碼清單中，請重新選擇!");
	}else if("<%=status%>" == "DRecord"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("此電話號碼已加入號碼清單中，請重新輸入!");
	}else if("<%=status%>" == "newSuccess"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("成功新增可接聽電話號碼至號碼清單中!");
	}else if("<%=status%>" == "error"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("變更電話號碼失敗，請聯絡系統管理者!");
	}
}
function formsubmit(){
	var subUserForm = document.getElementById("subUserForm");
	document.getElementById("action").value="setPhone";
	subUserForm.submit();
}
function newPhone(){
	var subUserForm = document.getElementById("subUserForm");
	if(subUserForm.phone.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入新增可接聽的電話號碼!");
		subUserForm.phone.focus();
		return false;
	}else{
		document.getElementById("action").value="newPhone";
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
				<%=userphone %>
			</div>
		</div>
		<nav class="navbar navbar-minetype" role="navigation">
  			<!-- Brand and toggle get grouped for better mobile display -->
  			<div id="navheader" class="navbar-header">
    			&nbsp;
    		</div>
    		<div id="content">
        		<ul id="bot_ul" class="nav nav-pills">
        			<!-- 
        			<li class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
      						<span class="nav-mycolor">聯絡人</span><span class="caret"></span>
    					</a>
    					<ul class="dropdown-menu">
    						<li><a href="contact.do"><span class="nav-mycolor">聯絡人清單</span></a></li>
      						<li><a href="NewContact1.jsp"><span class="nav-mycolor">新增聯絡人</span></a></li>
      						<li><a href="contact.do?action=editMode" ><span class="nav-mycolor">編輯聯絡人</span></a></li>
    					</ul>
  					</li>
  					 -->
  					<li><a href="contact.do"><span class="nav-mycolor">聯絡人</span></a></li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
					<li><a href="webSubUser.do?action=usedPoint"><span class="nav-mycolor">使用點數</span></a></li>
			    	<li><img src="img/web/sp.png" class="sbar"></li>
			    	<li><a href="history.do?action=getHistory"><span class="nav-mycolor">通話紀錄</span></a></li>
			    	<li><img src="img/web/sp.png" class="sbar"></li>
    				<!-- <li><a href="chgPassword1.jsp"><span class="nav-mycolor">變更密碼</span></a></li> -->
  					<li class="dropdown">
    					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
    						<span class="nav-mycolor">變更設定 </span><span class="caret"></span>
    					</a>
    					<ul class="dropdown-menu">
    						<li><a href="phone1.jsp"><span class="nav-mycolor">變更通話號碼</span></a></li>
    						<li><a href="chgPassword1.jsp"><span class="nav-mycolor">變更密碼</span></a></li>
    					</ul>
  					</li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
  					<li><a href="contactUs1.jsp"><span class="nav-mycolor">聯絡我們</span></a></li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
				</ul>
    		</div>
		</nav>
	</div>
	<div class="content">
		<div class="content-title">
			變更通話號碼
		</div>
		<div class="section1">
			<form id="subUserForm" class="bs-docs-example form-horizontal" method="post" onsubmit="return check(this)" action="web.html">
            	<div class="section1-text">
            		請從清單中選擇接聽的電話號碼 :
            	</div>
            	<div class="input-group-lg section1-phone">
            		<select name="selectPhone">
            			<%
            			for(int i = 0; i < phoneList.length; i++){
            				if(userphone.equals(phoneList[i])){
            			%>
            			<option value="<%=phoneList[i] %>" selected="selected"><%=phoneList[i] %></option>
            			<%
            				}else{
            			%>
            			<option value="<%=phoneList[i] %>"><%=phoneList[i] %></option>
            			<%
            				}
            			}
            			%>
            		</select>
            	</div>
            	<div class="section1-text">
            		新增可接聽的電話號碼至號碼清單 :
            	</div>
            	<div class="input-group-lg section1-phone">
            		<input type="text" name="phone" id="phone" size="20" style="border:1px solid #611987" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="10" value="" placeholder="請輸入電話號碼" required>
            	</div>
            	<input type="hidden" id="action" name="action" value="">
          	</form>
		</div>
		<div class="section2">
			<div class="sub-btn">
            	<div class="sub-btn-btn">
            		<a href="#" onclick="formsubmit()"><img src="img/web/save_btn.png" height="70px" width="70px"></a>
            	</div>
           	</div>
           	<div class="new-phone">
           		<div class="sub-btn-btn">
           			<a href="#" onclick="newPhone()"><img src="img/web/new_btn.png" height="70px" width="70px"></a>
           		</div>
           	</div>
		</div>
	</div>
</body>
</html>