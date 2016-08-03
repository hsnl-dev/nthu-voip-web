<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.account.service.xsd.WebContact "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>預設聯絡人清單</title>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
<![endif]-->

<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"></link> 
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script> 
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/sorttable.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" href="css/shake.css" />  -->
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
	width: 410px;
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
/*	width: 800px; */
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

.phonediv{
width:90%;
height:30px;
margin:2px 2px 2px 2px;
padding:2px 2px 2px 2px;
border-style:solid;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
border-radius: 5px;
border-color:#CACACA;
background:#CACACA;
font-weight:bold;
font-size:16px;
font-family:sans-serif;
}
.radius{
width:170px;
height:110px;
float:left;
margin:2px 2px 2px 2px;
padding:2px 2px 2px 2px;
border-style:solid;
-webkit-border-radius: 10px;
-moz-border-radius: 10px;
border-radius: 10px;
border-color:#CACACA;
background:#FDE37B;
}
.div_outer{
height:80%;
width:100%;
}
.div_img{
height:100%;
width:40%;
float:left;
}
.div_phone{
height:100%;
width:60%;
float:right;
align:left;
}
.div_phone_inner{
height:50%;
width:100%;
align:center;
valign:middle;
}
.div_title{
valign:top;
height:20%;
}
.img_person{
-moz-box-shadow:3px 3px 3px rgba(20%,20%,40%,0.5);
-webkit-box-shadow:3px 3px 3px rgba(20%,20%,40%,0.5);
box-shadow:3px 3px 3px rgba(20%,20%,40%,0.5);
width: 64px;
height:85px;
}
.img_contact{
  display: inline-block;
  width: 14px;
  height: 14px;
  margin-top: 1px;
  *margin-right: .3em;
  line-height: 14px;
  vertical-align: text-top;
  background-image: url("img/contact.png");
  background-position: 14px 14px;
  background-repeat: no-repeat;
}
.img_phone{
  display: inline-block;
  width: 14px;
  height: 14px;
  margin-top: 1px;
  *margin-right: .3em;
  line-height: 14px;
  vertical-align: text-top;
  background-image: url("img/glyphicons_169_phone.png");
  background-position: 14px 14px;
  background-repeat: no-repeat;
}
.list {
 font-size:13px; 
 text-align:left; 
 cursor:move; 
 font-family:Geneva,Arial,Helvetica,sans-serif; 
 border:1px solid white; 
} 
#items .ui-selected {
 background: red; 
 color: white; 
 font-weight:bold; 
} 
#items {
 list-style-type: none; 
 margin: 0; padding: 0; 
} 
#items li{ 
 float:left; 
 margin: 3px; 
 padding: 2px; 
 width:180px; 
 height:120px; 
} 
.highlight{ 
 border:3px solid red; 
 font-weight:bold; 
}
.btn-custom {
  background-color: #90ff90 !important;
  background-repeat: repeat-x;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#90ff90", endColorstr="#90ff90");
  background-image: -khtml-gradient(linear, left top, left bottom, from(#90ff90), to(#90ff90));
  background-image: -moz-linear-gradient(top, #90ff90, #90ff90);
  background-image: -ms-linear-gradient(top, #90ff90, #90ff90);
  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #90ff90), color-stop(100%, #90ff90));
  background-image: -webkit-linear-gradient(top, #90ff90, #90ff90);
  background-image: -o-linear-gradient(top, #90ff90, #90ff90);
  background-image: linear-gradient(#90ff90, #90ff90);
  border-color: #90ff90 #90ff90 #90ff90;
  color: #000 !important;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.03);
  
  -webkit-font-smoothing: antialiased;
}
#saveOrderAlert{
	display:none;
 	position:absolute;
 	left:35%;
 	top:50%;
 	float:right;
 	width:250px;
 	height:50px;
 	border:1px;
 	border-style:solid;
 	border-color:black;
 	opacity: 1;
 	z-index:20;
}
#cover {
   position: absolute;
   top: 0;
   left: 0;
   right: 0;
   bottom: 0;
   opacity: 0.80;
   background: #aaa;
   z-index: 10;
   display: none;
}
.text{
	padding-top:50px;
}
.text li{
	padding:10px 10px 0 0;
	list-style-type:none;
}
.text p{
	font-size:16px;
}
.style1{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	color:blue;
}
</style>
<script type="text/javascript">
$(function () {
	$("#items").sortable({
		start: function (event, ui) {
			ui.item.toggleClass("highlight"); 
		}, 
		stop: function (event, ui) {
			ui.item.toggleClass("highlight"); 
		} 
	}); 
	$("#items").disableSelection(); 
});
function editContact(uuid,cname,mobile,office,pic,contactOrder){
	//alert(uuid+cname+mobile+office);
	document.getElementById("action").value = "editContact";
	document.getElementById("uuid").value = uuid;
	document.getElementById("cname").value = cname;
	document.getElementById("mobile").value = mobile;
	document.getElementById("office").value = office;
	document.getElementById("pic").value = pic;
	document.getElementById("contactOrder").value = contactOrder;
	document.getElementById("contactForm").submit();
}
function normalMode(){
	document.getElementById("action").value = "normalMode";
	document.getElementById("contactForm").submit();
}
function editMode(){
	document.getElementById("action").value = "editMode";
	document.getElementById("contactForm").action = "contact.do";
	document.getElementById("contactForm").submit();
}
function hideAlert(){
	document.getElementById("saveOrderAlert").style.display = "none";
	$("#cover").fadeOut(100);
}
function changeTextForSaveOrder(){
	document.getElementById("saveOrderAlert").innerHTML = '<h4>更新連絡人排序</h4>' + '資料已成功儲存!';
}
function saveorder(){
	var orderAry = document.getElementsByName("order");
	var uuidAry = document.getElementsByName("uuidAry");
	var content = new Array;
	for(var key in orderAry){
		content.push(orderAry[key].value);
	}
	var uuidContent = new Array;
	for(var key in uuidAry){
		uuidContent.push(uuidAry[key].value);
	}
	document.getElementById("saveOrderAlert").innerHTML = '<h4>更新連絡人排序</h4>' + '資料儲存中，請稍候...';
	$("#cover").fadeIn(100);
	document.getElementById("saveOrderAlert").style.display = "block";
	$.ajax({
	    url:"default.do",
	    type:"POST",
        data: "action=saveDefaultContactOrder&order="+content+"&uuidAry="+uuidContent,
	    error:function(response){
	      alert("error");
	    },
	    success:function(response){
	      //alert("success");
	    	setTimeout("changeTextForSaveOrder()", 500);
	    	setTimeout("hideAlert()",700);
	    },
	  });
}
</script>
</head>
<body>
<div id="cover"> 
</div>
<div id="saveOrderAlert" class="alert alert-error alert-block">
</div>
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
      							<li><a href="#">預設聯絡人管理</a></li>
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
	<div>
	<table cellspacing="0" cellpadding="0" width="100%" border="0" summary="">
<tr>
<td width="1%" valign="top">

	<a class="item-image" href="http://web.cs.nthu.edu.tw/files/14-1015-4543,r1107-1.php" ></a>

</td>
<td valign="top" width="79%">
<form name="contactForm" id="contactForm" method="post" action="default.do">
	<table width="100%" >
		<tr><td>&nbsp;<td></tr>
		<% String depart = (String)session.getAttribute("depart"); %>
		<tr><td><div class="alert alert-info" style="width:80%; padding:5px 0 5px 0;"><h4>您可以在此編輯<span class="style1"><%=depart %></span>的預設聯絡人清單</h4></div></td></tr>
		<tr><td>
		<ul id="items">
	<%
		if(request.getAttribute("defaultList") != null){
			WebContact[] defaultList = (WebContact[])request.getAttribute("defaultList");
			int mod = 0;
			for(int i = 0; i < defaultList.length; i++){
				if(i != 0){ mod = i % 4;}
	%>
					<li class="list">
                    <div class="radius">
                    	<div class="div_outer">
                    		<div class="div_img">
                    			<a href="#" rel="tooltip" title="編輯聯絡人" onclick="editContact('<%=defaultList[i].getUUID() %>','<%=defaultList[i].getName() %>','<%=defaultList[i].getMobilePhone() %>','<%=defaultList[i].getOfficePhone() %>','<%=defaultList[i].getPic() %>','<%=defaultList[i].getOrder() %>')"><img class="img_person" 
                    			<% if("No".equals(defaultList[i].getPic()) | "".equals(defaultList[i].getPic()) | null == defaultList[i].getPic()){ %> 
                    				src="img/nthu_cs/user.png" />
                    			<% }else{ %>
                    				src="img/<%=defaultList[i].getPic() %>" />
                    			<% } %>
                    			</a>
                    		</div>
                    		<div class="div_phone">
                    			<div class="div_phone_inner">
                    			<% if("#".equals(defaultList[i].getOfficePhone())) { %>
                    				<a href="#" class="btn btn-block" >
                    			<% }else if(defaultList[i].getOfficePhone().startsWith("9") && defaultList[i].getOfficePhone().length()<10){ %>
                    				<a href="#" class="btn btn-custom btn-block" >
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block" >
                    			<% } %>
                    				<img src="img/contact.png" width="14px" height="14px"><br><%=defaultList[i].getOfficePhone() %>
                    				</a>
                    			</div>
                    			<div class="div_phone_inner">
                    			<% if(defaultList[i].getMVPN()){ %>
                    				<a href="#" class="btn btn-custom btn-block">
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block" >
                    			<% } %>
                    				<img src="img/phone.png" width="14px" height="14px"><br><%=defaultList[i].getMobilePhone() %>
                    				</a>
                    			</div>
                    		</div>
                    	</div>
                    	<div class="div_title">
                    		<strong><%=defaultList[i].getName() %></strong>&nbsp;
							<input type="hidden" name="order" value="<%=defaultList[i].getOrder() %>"/>
							<input type="hidden" name="uuidAry" value="<%=defaultList[i].getUUID() %>"/>
							</div>
					</div>
					</li>
				<%
			}
		}else{
	%>
			<h4><%=depart %>目前尚無預設聯絡人，請<a href="newDefaultContact.jsp">點此新增預設聯絡人</a>!</h4>
	<%
		}
	%>
	</ul>
	</td></tr>
	<input type="hidden" name="action" id="action" value=""/>
	<input type="hidden" name="cname" id="cname" value=""/>
	<input type="hidden" name="mobile" id="mobile" value=""/>
	<input type="hidden" name="office" id="office" value=""/>
	<input type="hidden" name="uuid" id="uuid" value=""/>
	<input type="hidden" name="contactOrder" id="contactOrder" value=""/>
	<input type="hidden" name="pic" id="pic" value=""/>
	</table>
</form>
</td>
<td align="center" valign="top" width="20%">
	<div class="text">
		<a href="#" onclick="saveorder()" class="btn btn-primary">儲存通訊錄版面</a>
		<ul>
			<li><p><img src="img/right-arrow.png">&nbsp;點擊聯絡人頭像可以開始進行編輯。</p></li>
			<li><p><img src="img/right-arrow.png">&nbsp;拖曳聯絡人外框可以調整聯絡人排序。</p></li>
			<li><p><img src="img/right-arrow.png">&nbsp;按儲存通訊錄版面來儲存更改後的排序。</p></li>
		</ul>
	</div>
</td>
</tr>
</table>
	</div>
</div>
 
</div>
 
<div id="footer">
<b>Copyright © 2012</b>
</div>
</div>
</body>
</html>