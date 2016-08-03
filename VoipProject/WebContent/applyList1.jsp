<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,util.User,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.account.service.xsd.WebAccount "%>
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

<!-- alertify plugin -->
<script src="js/alertify.min.js"></script>
<link href="css/alertify.core.css" rel="stylesheet">
<link href="css/alertify.default.css" rel="stylesheet">

<title>管理者帳號清單</title>
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
	width:40%;
}
.header-bot-manage{
	float:left;
	padding:0 25px 0 25px;
	
}
.header-bot-list{
	float:left;
	padding:0 14px 0 14px;
	
}
.header-bot-logout{
	float:left;
	padding:0 25px 0 25px;
}
.content-text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:60px;
	color:#611987;
	padding:40px 0 0 160px;	
}
.content-table{
	padding:0 0 0 160px;
}
#table1{
	border:1px solid #611987;
}
#table1 th{
	background-color:#611987;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	color:white;
}
#table1 td{
	border-right:1px solid #611987;
}
</style>
<script type="text/javascript">
function sendmail(phone){
	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	alertify.confirm("確定要重新寄出驗證信嗎?", function (e) {
	    if (e) {
	        // user clicked "ok"
	    	document.getElementById("phone").value = phone;
			document.getElementById("action").value = "sendmail";
			document.getElementById("webForm").submit();
	    } else {
	        // user clicked "cancel"
	    	return false;
	    }
	});
}
function deletewebuser(phone){
	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	alertify.confirm("確定要刪除單位管理者帳號(一併刪除單位之附屬帳號)?", function (e) {
	    if (e) {
	        // user clicked "ok"
	    	document.getElementById("phone").value = phone;
			document.getElementById("action").value = "deleteWebUser";
			document.getElementById("webForm").submit();
	    } else {
	        // user clicked "cancel"
	    	return false;
	    }
	});
}
</script>
</head>
<body>
	<div class="header">
		<div class="header-top">
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
				<div class="header-bot-manage">
					<a href="login.do?action=super" >單位管理者管理</a>
				</div>
				<div class="header-bot-list">
					<a href="web.html?action=applylist" >單位管理者清單</a>
				</div>
				<div class="header-bot-logout">
					<a href="login.do?action=logout" >登出</a>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="content-text">
			單位管理者帳號清單
		</div>
		<div class="content-table">
			<form id="webForm" method="post" action="web.html">
				<table id="table1">
					<tr>
						<th width="16%" >&nbsp;申請人單位名稱</th>
						<th width="16%" >&nbsp;申請人分機號碼</th>
						<th width="18%" >&nbsp;申請人電子郵件</th>
						<th width="14%" >&nbsp;申請人姓名</th>
						<th width="16%" >&nbsp;申請日期</th>
						<th width="20%" ></th>
					</tr>
					<% 
					List<User> webUserList = (List<User>)request.getAttribute("webUserList");
  			
  					if(webUserList != null){
  						int j = 0;
  						for(int i = 0; i < webUserList.size(); i++){
  							if(webUserList.get(i).isApproval() == true){
  								j++;
  					%>
  					<tr <%if(j%2 == 0){%>style="background-color:#e3e3e3;" <%} %>>
   						<td align="center"><%=webUserList.get(i).getUnitName() %></td>
   						<td align="center"><%=webUserList.get(i).getUsename() %></td>
  						<td align="center"><%=webUserList.get(i).getRegMail() %></td>
  						<td align="center"><%=webUserList.get(i).getName() %></td>
  						<td align="center"><%=webUserList.get(i).getDate() %></td>
  						<td align="center">
							<a href="javascript: return false;" onclick="sendmail('<%=webUserList.get(i).getUsename() %>')" class="btn btn-default">重寄認證信</a>
							<a href="javascript: return false;" onclick="deletewebuser('<%=webUserList.get(i).getUsename() %>')" class="btn btn-default">刪除管理者</a>
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