<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.calling.service.xsd.NationalCode, util.Utility "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增聯絡人</title>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/util-functions.js"></script>
<script type="text/javascript" src="js/clear-default-text.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- alertify plugin -->
<script src="js/alertify.min.js"></script>
<link href="css/alertify.core.css" rel="stylesheet">
<link href="css/alertify.default.css" rel="stylesheet">

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
.content1{
	padding:30px 0 0 160px;
}
.content-title{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:40px;
	color:#611987;
	padding:100px 0 0 160px;	
}
.content-text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	color:#585657;
	padding:15px 0 15px 0;
}
.content-mobile{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:14px;
	color:#585657;
	height:65px;
	padding:0px 0 0 0;
}
.content-note{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:14px;
	color:#585657;
	padding:5px 0 0 0;
}
.content-img{
	float:left;
	width:20%;
	border:1px solid #611987;
}
.content-form{
	float:left;
	width:28%;
	padding:0px 100px 0 10px;
}
.content-btn{
	float:right;
	width:36%;
	padding:250px 0px 0 0;
}
.content-btn-btn{
	height:70px;
	width:70px;
}
.content-text a,a:link,a:visited,a:hover{
	text-decoration:none;
}
#ncodedisplay{
	float:left;
	width:55px;
	display:none;
	padding:5px 0 0 0;
}
#ncodeinput{
	float:left;
}
#precodedisplay{
	float:left;
	width:55px;
	padding:5px 0 0 0;
}
</style>
<script type="text/javascript">
function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}
function changeNation(sel){
	var value = sel.options[sel.selectedIndex].value;
	if("+886" == value){
		document.getElementById("ncodedisplay").style.display = 'none';
		document.getElementById("ncode").value = '';
	}else{
		document.getElementById("ncodedisplay").style.display = 'block';
		document.getElementById("ncodedisplay").innerHTML = value + ' -';
		//document.getElementById("mobile").width = '200px';
		document.getElementById("ncode").value = value;
	}
}
function changePreCode(sel){
	var value = sel.options[sel.selectedIndex].value;
	document.getElementById("precodedisplay").innerHTML = value + ' -';
	document.getElementById("pcode").value = value;
}
function formsubmit(){
	var contactForm = document.getElementById("contactForm");
	if(contactForm.cname.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入聯絡人姓名!");
		contactForm.cname.focus();
		return false;
	}else if(contactForm.mobile.value == "" && contactForm.office.value == ""){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請輸入行動電話號碼或分機號碼!");
		contactForm.mobile.focus();
		return false;
	}else{
		contactForm.submit();
	}
}

</script>
</head>
<body>
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
			新增聯絡人
		</div>
		<div class="content1">
		<form id="contactForm" class="bs-docs-example form-horizontal" method="post" action="contact.do" enctype="multipart/form-data">
			<div class="content-img">
				<img src="img/web/default_user.png" id="blah">
				<br>
				<input type="file" id="pic" name="pic"  value="瀏覽.." onchange="readURL(this)">
				<!-- 
				<a href="#">
					<img src="img/web/upload_pic.png" height="35px" width="100px">
				</a>
				 -->
			</div>
			<div class="content-btn">
				<div class="content-btn-btn">
            		<a href="#" onclick="formsubmit()"><img src="img/web/save_btn.png" height="70px" width="70px"></a>
            	</div>
			</div>
			<div class="content-form">
				<div class="content-text">
					聯絡人姓名
				</div>
				<div class="input-group-lg content-cname">
            		<input type="text" class="form-control input-lg" style="border:1px solid #611987;" id="cname" name="cname" placeholder="請輸入聯絡人姓名">
            	</div>
            	<div class="content-text">
					電話號碼
				</div>
            	<div class="input-group-lg content-mobile">
            	<%
            	if(session.getAttribute("nation") != null){
            	%>
            	<select name="nationCode" onchange="changeNation(this)">
            	<%
            		NationalCode[] nation = (NationalCode[])session.getAttribute("nation");
            		for(int i = 0; i < nation.length; i++){
            			if("台灣TAIWAN".equals(nation[i].getNation())){
            	%>
            		<option value="<%=nation[i].getNationalPreCode() %>" selected="selected"><%=nation[i].getNation() %></option>
            	<%
            			}else{
            	%>
            		<option value="<%=nation[i].getNationalPreCode() %>"><%=nation[i].getNation() %></option>
            	<%
            			}
            		}
            	%>
            	</select>
            	<%
            	}
            	%>
            		<input type="hidden" id="ncode" name="ncode" value="">
            		<div>
            			<div id="ncodedisplay"></div>
            			<div id="ncodeinput"><input type="text"  style="border:1px solid #611987;width:11em;" id="mobile" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="10" name="mobile" placeholder="請輸入電話號碼"></div>
            		</div>
            	</div>
            	<div class="content-note">
					*台灣行動電話請輸入09xxxxxxxx，<br>
					市話請輸入區碼+電話號碼，例035715131
					<br>國際電話請選擇國碼後輸入電話號碼。
				</div>
            	<div class="content-text">
					分機號碼
				</div>
            	<div class="input-group-lg content-office">
            	<%
            	Utility util = new Utility();
            	String[] college = util.getCollegeName(); 
            	String[] precode = util.getPreCode(); 
            	%>
            	<select name="preCode" onchange="changePreCode(this)">
            	<%
            	for(int i = 0; i < college.length; i++){
            		if("國立清華大學".equals(college[i])){
            	%>
            		<option value="<%=precode[i] %>" selected="selected"><%=college[i] %></option>
            	<%
            		}else{
            	%>
            		<option value="<%=precode[i] %>" ><%=college[i] %></option>
            	<%
            		}
            	}
            	%>
            	</select>
            		<input type="hidden" id="pcode" name="pcode" value="930">
            		<div>
            			<div id="precodedisplay">930 -</div>
            			<div id="precodeinput"><input class="span2" type="text" style="border:1px solid #611987;width:11em;" name="office" id="office" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="8" placeholder="請輸入分機號碼"></div>
            		</div>
            	</div>
			</div>
			<input type="hidden" name="action" id="action" value="insertNewContact"/>
        	<input type="hidden" name="imgUrl" id="imgUrl" value=""/>
        	<input type="hidden" name="imgTitle" id="imgTitle" value=""/>
		</form>
		</div>
	</div>
</body>
</html>