<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Contact,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.account.service.xsd.WebContact, java.util.ArrayList "%>
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
body{
	/*background:url(img/web/03.jpg);*/
	min-width:1280px;
	padding-top:0px;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	/*background-image:url(img/web/13-13.jpg);
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
img.newContact{
	width: auto; 
	max-width: 120px; 
	height: auto; 
	max-height: 30px;
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
	padding:100px 0 0 150px;	
}
.contact-list{
	padding:0px 140px 0 150px;
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
.btn-ht{
	height:44px;
}
#progressbar{
 display:none;
 position:absolute;
 left:35%;
 top:50%;
 float:right;
 background:white;
 width:350px;
 height:100px;
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
 font-family:"微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
 font-color:#000;
 font-weight:bold;
 float:right;
}
#progressbar .div_1 .p2-1{
	width:240px;
	height:17px;
	padding:0 0 0 20px;
}
#progressbar .div_1 .p2-2{
	width:240px;
	height:17px;
	padding:0 0 0 30px;
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
 font-size:16px;
 font-family:"微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
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
#cover {
   position: absolute;
   min-width:1280px;
   top: 0;
   left: 0;
   right: 0;
   bottom: 0;
   opacity: 0.80;
   background: #aaa;
   z-index: 10;
   display: none;
}
</style>
<script type="text/javascript">
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
	document.getElementById("p4").innerHTML = '取消撥號中...';
	document.getElementById("progressbar").style.display = "none";
	$("#cover").fadeOut(100);
	spinner.stop();
}
function changeText(number,userPhone){
	//document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone + '\n撥號中...';
	//document.getElementById("p6").style.display = "none";
	$.ajax({
	    url:"contact.do",
	    type:"POST",
        data: "action=call&number="+number,
	    error:function(jqXHR, textStatus, errorThrown){
	      document.getElementById("progressbar").style.display = "none";
	  	  $("#cover").fadeOut(100);
	  	  spinner.stop();
	    },
	    success:function(response){
	      	if("SessionTimeout" == response){
	    		window.location.replace("Home1.jsp?status=timeout");
	    	}else{
	    		setTimeout("hideProgressbar()",5000);
	    	}
	    }
	  });
}
var timer;
function call(number,userPhone,calleename){
	var target = document.getElementById("p3");
	document.getElementById("p2-1").innerHTML = '雲端接線生立即幫您接通';
	document.getElementById("p2-2").innerHTML = calleename+'('+number.toString()+')';
	//document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone;
	document.getElementById("p4").innerHTML = '您的座機即將響鈴，請放心接聽';
	spinner = new Spinner(opts).spin(target);
	$("#cover").fadeIn(100);
	document.getElementById("progressbar").style.display = "block";
	//document.getElementById("p6").style.display = "block";
	timer = setTimeout("changeText('" + number + "','" + userPhone + "')", 300);
}
function callbyimg(mobile, office,userPhone,calleename){
	var number;
	if(mobile == "" | mobile == null){
		number = office;
	}else{
		number = mobile;
	}
	var target = document.getElementById("p3");
	document.getElementById("p2-1").innerHTML = '雲端接線生立即幫您接通';
	document.getElementById("p2-2").innerHTML = calleename+'('+number.toString()+')';
	//document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone;
	document.getElementById("p4").innerHTML = '您的座機即將響鈴，請放心接聽';
	spinner = new Spinner(opts).spin(target);
	$("#cover").fadeIn(100);
	document.getElementById("progressbar").style.display = "block";
	//document.getElementById("p6").style.display = "block";
	timer = setTimeout("changeText('" + number + "','" + userPhone + "')", 300);
}
function cancelCall(){
	var text1 = document.getElementById("p2").innerText;
	var callee = text1.substring(11);
	clearTimeout(timer);
	setTimeout("hideProgressbar2()",2000);
}
</script>
</head>
<body>
	<div id="cover"> 
	</div>
	<div id="progressbar">
		<div class="div_1">
			<div id="p1" class="p1"><div style="float:right;"><img src="img/exclamation2.png" /></div></div>
			<div id="p2" class="p2">
				<div id="p2-1" class="p2-1"></div>
				<div id="p2-2" class="p2-2"></div>
			</div>
		</div>
		<div class="div_2">
			<div id="p3" class="p3"></div>
			<div id="p4" class="p4"></div>
		</div>
		<!-- <div class="div_3">
			<div id="p5" class="p5"></div>
			<div id="p6" class="p6">
				<a href="javascript: return false;" onclick="cancelCall()" class="btn btn-primary">取消通話</a>
			</div>
		</div> -->
	</div>
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
	</div>
	<div class="content">
		<div class="content-title">
			聯絡人清單
		</div>
		<div class="contact-list">
			<form name="contactForm" id="contactForm" method="post" action="default.do">
	<table width="100%" >
		<tr><td align="right"><!-- <h4><strong><%=depart %></strong></h4> -->
				<a href="NewContact1.jsp"><img src="img/web/new_contact.png" class="newContact"></a>
		</td></tr>
		<tr><td>
		<ul id="items">
	<%
		String userPhone = (String)session.getAttribute("userphone");
		if(request.getAttribute("allContactList") != null){
			ArrayList<Contact> allContactList = (ArrayList<Contact>)request.getAttribute("allContactList");
			for(int i = 0; i < allContactList.size(); i++){
				Contact con = allContactList.get(i);
	%>
					<li class="list">
                    <div class="radius">
                    	<div class="div_outer">
                    		<div class="div_img">
                    			<a href="#" rel="tooltip" onclick="callbyimg('<%=con.getMobilePhone() %>','<%=con.getOfficePhone() %>','<%=userPhone %>','<%=con.getName() %>')" title="撥號"><img class="img_person"
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
                    				<a href="#" class="btn btn-custom btn-block" onclick="call('<%=con.getOfficePhone() %>','<%=userPhone %>','<%=con.getName() %>')" data-toggle="tooltip" data-placement="bottom" title="撥打免費分機">
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block btn-ht" onclick="call('<%=con.getOfficePhone() %>','<%=userPhone %>','<%=con.getName() %>')" data-toggle="tooltip" data-placement="bottom" title="撥打付費分機">
                    			<% } %>
                    				<img src="img/contact.png" width="14px" height="14px"><br><%=con.getOfficePhone() %>
                    				</a>
                    			</div>
                    			<div class="div_phone_inner">
                    			<% if(con.isMVPN()){ %>
                    				<a href="#" class="btn btn-custom btn-block" onclick="call('<%=con.getMobilePhone() %>','<%=userPhone %>','<%=con.getName() %>')" data-toggle="tooltip" data-placement="bottom" title="撥打免費手機">
                    			<% }else if("#".equals(con.getMobilePhone())){ %>
                    				<a href="#" class="btn btn-block">
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block btn-ht" onclick="call('<%=con.getMobilePhone() %>','<%=userPhone %>','<%=con.getName() %>')" data-toggle="tooltip" data-placement="bottom" title="撥打付費手機">
                    			<% } %>
                    				<img src="img/phone.png" width="14px" height="14px"><br>
                    				<%
                    					if(con.getMobilePhone().length() > 12){
                    				%>
                    				<font size="1"><%=con.getMobilePhone() %></font>
                    				<%
                    					}else{
                    				%>
                    				<%=con.getMobilePhone() %>
                    				<%
                    					}
                    				%>
                    				</a>
                    			</div>
                    		</div>
                    	</div>
                    	<div class="div_title">
                    		<strong><%=con.getName() %></strong>&nbsp;
							<input type="hidden" name="order" value="<%=con.getOrder() %>"/>
							<input type="hidden" name="uuidAry" value="<%=con.getUuid() %>"/>
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
		</div>
	</div>
</body>
<script type="text/javascript">

</script>
</html>