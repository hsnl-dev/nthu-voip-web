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
<title>聯絡我們</title>
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
	height:58px;
	width:100%;
}
.user-account{
	float:right;
	width:100px;
	padding:25px 20px 0 0px;
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
.header-bot a,a:link,a:visited,a:hover{
	text-decoration:none;
}
.header-bot-group{
	float:right;
	width:35%;
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
.content-title{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:60px;
	color:#611987;
	padding:40px 0 20px 160px;	
}
.content-text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	color:#585657;
	padding:30px 0 0 160px;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
<!-- <img src="img/web/14.JPG" class="bg"> -->
	<div class="header">
		<%if(session.getAttribute("userphone") != null){ %>
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
      						<li><a href="contact.do?action=editMode" ><span class="nav-mycolor">編輯聯絡人</span></a></li>
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
		<%}else{ %>
		<div class="header-top">
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/web/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="portal.jsp" >網頁點點通</a>
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
		<%} %>
	</div>
	<div class="content">
		<div class="content-title">
			聯絡我們
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
	<form method="post" action="webSubUser.do" id="subUserForm">
		<input type="hidden" name="action" id="action" value=""/>
	</form>
</body>
</html>