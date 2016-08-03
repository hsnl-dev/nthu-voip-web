<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.account.service.xsd.WebContact, java.util.ArrayList "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聯絡人清單</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"></link> 
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script> 
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/sorttable.js"></script>
<script type="text/javascript" src="js/spin.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
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
	padding:20px 0 0 0;
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
	height:100%;
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
 

table.sortable {
	border: 1px solid #DFDFDF;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
}
table.sortable td,table.sortable th{
	border-top-color: white;
	border-bottom: 1px solid #00FFFF;
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
background:#CACACA;
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
margin-top:1px;
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

#progressbar{
 display:none;
 position:absolute;
 left:35%;
 top:50%;
 float:right;
 background:white;
 width:350px;
 height:130px;
 margin:2px 2px 2px 2px;
 padding:2px 2px 2px 2px;
 border:3px;
 border-style:solid;
 -webkit-border-radius: 10px;
 -moz-border-radius: 10px;
 border-radius: 10px;
 border-color:blue;
 opacity: 1;
 z-index:20;
}
#progressbar .div_1 {
 width:350px;
 height:35px; 
 float:left;
}
#progressbar .div_1 .p1 { 
 width:70px;
 height:35px; 
 float:left;
 padding:7px 0 0 0;
}
#progressbar .div_1 .p2 { 
 width:280px;
 height:35px;
 padding:10px 0 0 0; 
 font-size:16px;
 font-family:sans-serif;
 font-color:#000;
 font-weight:bold;
 float:right;
}
#progressbar .div_2 {
 width:350px;
 height:65px; 
 float:right;
}
#progressbar .div_2 .p3{
 width:90px;
 height:65px; 
 padding:0 0 0 0;
 float:left;
}
#progressbar .div_2 .p4{
 width:260px;
 height:65px; 
 padding:13px 0 0 0;
 font-size:14px;
 font-family:sans-serif;
 font-color:#000;
 font-weight:bold;
 float:right;
}
#progressbar .div_3 {
 width:350px;
 height:30px; 
 float:right;
}
#progressbar .div_3 .p5{
 width:150px;
 height:30px;
 padding:0 0 0 0; 
 float:left;
}
#progressbar .div_3 .p6{
 width:200px;
 height:30px;
 padding:0 0 0 0; 
 float:right;
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
.history{
	float:right;
}
</style>
<%
/*String nameString = "";
if(request.getAttribute("teacherList") != null){
	ArrayList tl = (ArrayList)request.getAttribute("teacherList");
	TeacherObj obj = null;
	for(int i = 0; i < tl.size(); i++){
		obj = (TeacherObj)tl.get(i);
		if(i != 0){
			nameString += ",";
		}
		nameString += obj.gettName();
	}
}*/
%>
<script type="text/javascript">

//$(function () {
//	$("#items").sortable({
//		start: function (event, ui) {
//			ui.item.toggleClass("highlight"); 
//		}, 
//		stop: function (event, ui) {
//			ui.item.toggleClass("highlight"); 
//		} 
//	}); 
//	$("#items").disableSelection(); 
//});
var spinner;
var opts = {
		  lines: 13, // The number of lines to draw
		  length: 7, // The length of each line
		  width: 4, // The line thickness
		  radius: 13, // The radius of the inner circle
		  corners: 1, // Corner roundness (0..1)
		  rotate: 0, // The rotation offset
		  color: '#000', // #rgb or #rrggbb
		  speed: 1, // Rounds per second
		  trail: 60, // Afterglow percentage
		  shadow: false, // Whether to render a shadow
		  hwaccel: false, // Whether to use hardware acceleration
		  className: 'spinner', // The CSS class to assign to the spinner
		  zIndex: 2e9, // The z-index (defaults to 2000000000)
		  top: '13px', // Top position relative to parent in px
		  left: '10px' // Left position relative to parent in px
		};

function hideProgressbar(){
	document.getElementById("progressbar").style.display = "none";
	$("#cover").fadeOut(100);
	spinner.stop();
}
function hideProgressbar2(){
	document.getElementById("p4").innerText = '取消撥號中...';
	document.getElementById("progressbar").style.display = "none";
	$("#cover").fadeOut(100);
	spinner.stop();
}
function hideAlert(){
	document.getElementById("saveOrderAlert").style.display = "none";
	$("#cover").fadeOut(100);
}
function changeText(userPhone){
	document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone + '\n撥號中...';
}
function changeTextForSaveOrder(){
	document.getElementById("saveOrderAlert").innerHTML = '<h4>更新連絡人排序</h4>' + '資料已成功儲存!';
}

function call(number,userPhone){
	var target = document.getElementById("p3");
	document.getElementById("p2").innerText = '雲端電話秘書撥號中 : '+number.toString();
	document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone;
	spinner = new Spinner(opts).spin(target);
	$("#cover").fadeIn(100);
	document.getElementById("progressbar").style.display = "block";
	setTimeout("changeText(" + userPhone + ")", 3000);
	$.ajax({
	    url:"contact.do",
	    type:"POST",
        data: "action=call&number="+number,
	    error:function(response){
	      alert("error");
	    },
	    success:function(response){
	      //alert("success");
	    	setTimeout("hideProgressbar()",13000);
	    },
	  });
	}
function callByName(name,userPhone){
	var target = document.getElementById("p3");
	document.getElementById("p2").innerText = '雲端電話秘書撥號中 : '+name.toString();
	document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone;
	spinner = new Spinner(opts).spin(target);
	$("#cover").fadeIn(100);
	document.getElementById("progressbar").style.display = "block";
	setTimeout("changeText(" + userPhone + ")", 3000);
	$.ajax({
	    url:"Teacher.html",
	    type:"POST",
        data: "action=callByName&callee="+name,
	    error:function(response){
	      alert("error");
	    },
	    success:function(response){
	      //alert("success");
	    	setTimeout("hideProgressbar()",13000);
	    },
	  });
}

function cancelCall(){
	var text1 = document.getElementById("p2").innerText;
	var callee = text1.substring(11);
	$.ajax({
	    url:"Teacher.html",
	    type:"POST",
        data: "action=cancelCall&callee="+callee,
	    error:function(response){
	      alert("error");
	    },
	    success:function(response){
	      //alert("success");
	    	setTimeout("hideProgressbar2()",3000);
	    },
	  });
}

function editMode(){
	document.getElementById("action").value = "editMode";
	document.getElementById("contactForm").action = "contact.do";
	document.getElementById("contactForm").submit();
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
	    url:"Teacher.html",
	    type:"POST",
        data: "action=saveNewOrder&order="+content+"&uuidAry="+uuidContent,
	    error:function(response){
	      alert("error");
	    },
	    success:function(response){
	      //alert("success");
	    	setTimeout("changeTextForSaveOrder()", 5000);
	    	setTimeout("hideAlert()",7000);
	    },
	  });
}
function newContact(){
	document.getElementById("action").value = "newContact";
	document.getElementById("TeacherForm").submit();
}
function importDefault(){
	document.getElementById("action").value = "importDefault";
	document.getElementById("TeacherForm").submit();
}
function editDefault(){
	document.getElementById("action").value = "editDefault";
	document.getElementById("contactForm").submit();
}
function searchfunction(){
	var searchTerm = document.getElementById("searchText").value;
	//var bodyText = document.body.innerHTML;
	//var i = -1;
	if(searchTerm != "" & searchTerm != null){
		window.find(searchTerm,true,true);
		
	}
}
var nameStr = '<%// =nameString%>';
//$(function() {
//	var nameAry = nameStr.split(",");
//    $( "#searchText" ).autocomplete({
//      source: nameAry
//    });
//  });
</script>
</head>
<body>
<body>
<div id="cover"> 
</div>
<div id="progressbar">
		<div class="div_1">
			<div id="p1" class="p1"><div style="float:right;"><img src="img/exclamation2.png" /></div></div>
			<div id="p2" class="p2"></div>
		</div>
		<div class="div_2">
			<div id="p3" class="p3"></div>
			<div id="p4" class="p4"></div>
		</div>
		<div class="div_3">
			<div id="p5" class="p5"></div>
			<div id="p6" class="p6"><a href="#" onclick="cancelCall()" class="btn btn-primary">取消通話</a></div>
		</div>
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
      							<li><a href="NewContact.jsp">新增聯絡人</a></li>
      							<li><a href="#" onclick="editMode()">編輯聯絡人</a></li>
      							
    						</ul>
  						</li>
  						<% 
  						String depart = (String)session.getAttribute("depart");
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
		<tr><td><h4><strong><%=depart %></strong></h4></td></tr>
		<tr><td>
		<ul id="items">
	<%
		String userPhone = (String)session.getAttribute("userphone");
		if(request.getAttribute("allContactList") != null){
			ArrayList allContactList = (ArrayList)request.getAttribute("allContactList");
			for(int i = 0; i < allContactList.size(); i++){
				WebContact con = (WebContact)allContactList.get(i);
	%>
					<li class="list">
                    <div class="radius">
                    	<div class="div_outer">
                    		<div class="div_img">
                    			<a href="#" rel="tooltip" onclick="call('<%=con.getMobilePhone() %>','<%=userPhone %>')" title="撥號"><img class="img_person"
                    			<% if("No".equals(con.getPic()) | "".equals(con.getPic()) | null == con.getPic()){ %> 
                    				src="img/nthu_cs/user.png" />
                    			<% }else{ %>
                    				src="img/<%=con.getPic() %>" />
                    			<% } %>
                    			</a>
                    		</div>
                    		<div class="div_phone">
                    			<div class="div_phone_inner">
                    			<% if("#".equals(con.getOfficePhone())) { %>
                    				<a href="#" class="btn btn-block">
                    			<% }else if(con.getOfficePhone().startsWith("9") && con.getOfficePhone().length()<10){ %>
                    				<a href="#" class="btn btn-custom btn-block" onclick="call('<%=con.getOfficePhone() %>','<%=userPhone %>')" data-toggle="tooltip" data-placement="bottom" title="撥打免費分機">
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block" onclick="call('<%=con.getOfficePhone() %>','<%=userPhone %>')" data-toggle="tooltip" data-placement="bottom" title="撥打付費分機">
                    			<% } %>
                    				<img src="img/contact.png" width="14px" height="14px"><br><%=con.getOfficePhone() %>
                    				</a>
                    			</div>
                    			<div class="div_phone_inner">
                    			<% if(con.getMVPN()){ %>
                    				<a href="#" class="btn btn-custom btn-block" onclick="call('<%=con.getMobilePhone() %>','<%=userPhone %>')" data-toggle="tooltip" data-placement="bottom" title="撥打免費手機">
                    			<% }else if("#".equals(con.getMobilePhone())){ %>
                    				<a href="#" class="btn btn-block">
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block" onclick="call('<%=con.getMobilePhone() %>','<%=userPhone %>')" data-toggle="tooltip" data-placement="bottom" title="撥打付費手機">
                    			<% } %>
                    				<img src="img/phone.png" width="14px" height="14px"><br><%=con.getMobilePhone() %>
                    				</a>
                    			</div>
                    		</div>
                    	</div>
                    	<div class="div_title">
                    		<strong><%=con.getName() %></strong>&nbsp;
							<input type="hidden" name="order" value="<%=con.getOrder() %>"/>
							<input type="hidden" name="uuidAry" value="<%=con.getUUID() %>"/>
							</div>
					</div>
					</li>
				<%
			}
		}
	%>
	</ul>
	<input type="hidden" name="action" id="action" value=""/>
	<input type="hidden" name="uuid" id="uuid" value=""/>
	<input type="hidden" name="number" id="number" value=""/>
	</td></tr>
	</table>
</form>
</td>
<td align="center" valign="top" width="20%">
<div class="history">
	<table border="0" cellpadding="1" cellspacing="1" bgcolor="#3381B7" width="100%">
		<tr height="50px">
			<td>
				<div class="phonediv">
					分機號碼 : <%=session.getAttribute("userphone") %>
				</div>
			</td>
		</tr>
		<tr>
			<td bgcolor="#FFFFFF" valign="top">
			<table border="0" cellpadding="0" cellspacing="0" width="100%"> 
				<tr bgcolor="#3381B7" style="height: 23px;" >                                                                                                                                                                                                                                                                                                                                                                                                                             
         			<td><img src="img/textbox_dot.gif" alt="dot" hspace=8 align="middle"><font color="white">最近聯絡人</font></td>                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
       			</tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        		<tr>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
          			<td style="padding: 20px 0px 0px 0px;">
          			<table border=0 cellpadding=4 cellspacing=0 align="center">
          				<tr align="center">
          					<th style="border-bottom: 1px solid #000000;">聯絡人</th>
          					<th style="border-bottom: 1px solid #000000;">電話號碼</th>
          				</tr>
          				<%
						if(request.getAttribute("historyList") != null){
							ArrayList historyList = (ArrayList)request.getAttribute("historyList");
							for(int i = 0; i < historyList.size(); i++){
								String[] record = (String[])historyList.get(i);
						%>
          				<tr align="center">
          					<td style="border-bottom: 1px solid #000000;"><a href="#" onclick="call('<%=record[1] %>','<%=userPhone %>')"><%=record[0] %></a></td>
          					<td style="border-bottom: 1px solid #000000;"><%=record[1] %></td>
          				</tr>
          				<% }
						}
						%>
          			</table>
          			</td>
          		</tr>
          	</table>
			</td>
		</tr>
	</table>
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