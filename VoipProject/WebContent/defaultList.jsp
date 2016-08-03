<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,util.Contact,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.account.service.xsd.WebContact "%>
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
img.newDefaultContact{
	width: auto; 
	max-width: 150px; 
	height: auto; 
	max-height: 30px;
}
img.editIcon{
	width: auto; 
	max-width: 30px; 
	height: auto; 
	max-height: 30px;
}
img.saveOrder{
	width: auto; 
	max-width: 140px; 
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
	/*var content = new Array;
	for(var key in orderAry){
		content.push(orderAry[key].value);
	}
	var uuidContent = new Array;
	for(var key in uuidAry){
		uuidContent.push(uuidAry[key].value);
	}*/
	var content = "";
	for(var i = 0; i < orderAry.length; i++){
		if(i != 0){
			content = content + ",";
		}
		content = content + orderAry[i].value;
	}
	var uuidContent = "";
	for(var i = 0; i < uuidAry.length; i++){
		if(i != 0){
			uuidContent = uuidContent + ",";
		}
		uuidContent = uuidContent + uuidAry[i].value;
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
			預設聯絡人清單
		</div>
		<div class="contact-list">
			<form name="contactForm" id="contactForm" method="post" action="default.do">
	<table width="100%" >
		<tr><td align="right"><!-- <h4><strong><%=depart %></strong></h4> -->
				<a href="NewDefaultContact1.jsp"><img src="img/web/new_default.png" class="newDefaultContact"></a>
				<br>
				<!-- <a href="#" onclick="saveorder()" ><img src="img/web/edit.png" class="editIcon"><img src="img/web/save_order.png" class="saveOrder"></a> -->
				
		</td></tr>
		<tr><td>
		<ul id="items">
	<%
		if(((List<Contact>)request.getAttribute("defaultList")).size() >0){
			List<Contact> defaultList = (List<Contact>)request.getAttribute("defaultList");
			for(Contact one:defaultList){
	%>
					<li class="list">
                    <div class="radius">
                    	<div class="div_outer">
                    		<div class="div_img">
                    			<a href="#" rel="tooltip" title="編輯聯絡人" onclick="editContact('<%=one.getUuid() %>','<%=one.getName() %>','<%=one.getMobilePhone() %>','<%=one.getOfficePhone() %>','<%=one.getPic() %>','<%=one.getOrder() %>')"><img class="img_person" 
                    			<% if("No".equals(one.getPic()) | "".equals(one.getPic()) | null == one.getPic()){ %> 
                    				src="img/nthu_cs/user.png" />
                    			<% }else{ %>
                    				src="img/<%=one.getPic() %>" />
                    			<% } %>
                    			</a>
                    		</div>
                    		<div class="div_phone">
                    			<div class="div_phone_inner">
                    			<% if("#".equals(one.getOfficePhone())) { %>
                    				<a href="#" class="btn btn-block" >
                    			<% }else if(one.getOfficePhone().startsWith("9") && one.getOfficePhone().length()<10){ %>
                    				<a href="#" class="btn btn-custom btn-block" >
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block btn-ht" >
                    			<% } %>
                    				<img src="img/contact.png" width="14px" height="14px"><br><%=one.getOfficePhone() %>
                    				</a>
                    			</div>
                    			<div class="div_phone_inner">
                    			<% if(one.isMVPN()){ %>
                    				<a href="#" class="btn btn-custom btn-block">
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block btn-ht" >
                    			<% } %>
                    				<img src="img/phone.png" width="14px" height="14px"><br>
                    				<%
                    					if(one.getMobilePhone().length() > 12){
                    				%>
                    				<font size="1"><%=one.getMobilePhone() %></font>
                    				<%
                    					}else{
                    				%>
                    				<%=one.getMobilePhone() %>
                    				<%
                    					}
                    				%>
                    				</a>
                    			</div>
                    		</div>
                    	</div>
                    	<div class="div_title">
                    		<strong><%=one.getName() %></strong>&nbsp;
							<input type="hidden" name="order" value="<%=one.getOrder() %>"/>
							<input type="hidden" name="uuidAry" value="<%=one.getUuid() %>"/>
							</div>
					</div>
					</li>
				<%
			}
		}else{
	%>
			<h4><%=depart %>目前尚無預設聯絡人，請<a href="NewDefaultContact1.jsp">點此新增預設聯絡人</a>!</h4>
	<%
		}
	%>
	</ul>
	<input type="hidden" name="action" id="action" value=""/>
	<input type="hidden" name="cname" id="cname" value=""/>
	<input type="hidden" name="mobile" id="mobile" value=""/>
	<input type="hidden" name="office" id="office" value=""/>
	<input type="hidden" name="uuid" id="uuid" value=""/>
	<input type="hidden" name="contactOrder" id="contactOrder" value=""/>
	<input type="hidden" name="pic" id="pic" value=""/>
	</td></tr>
	</table>
</form>
		</div>
	</div>
</body>
</html>