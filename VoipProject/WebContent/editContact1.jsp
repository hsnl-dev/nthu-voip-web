<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,util.Nation,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.http.HttpSession, util.Contact, talk.calling.service.xsd.NationalCode, util.Utility "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"></link> 
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script> 
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/sorttable.js"></script>
<script type="text/javascript" src="js/spin.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- alertify plugin -->
<script src="js/alertify.min.js"></script>
<link href="css/alertify.core.css" rel="stylesheet">
<link href="css/alertify.default.css" rel="stylesheet">

<title>編輯聯絡人</title>
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
.content1{
	padding:30px 0 0 160px;
}
.content-img{
	float:left;
	width:20%;
	border:1px solid #611987;
}
.content-form{
	float:right;
	width:28%;
	padding:0px 100px 0 0;
}
.content-delete-contact{
	padding:0 0px 0 130px;
}
.content-btn{
	float:right;
	width:36%;
	padding:250px 50px 0 0;
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
function deleteContact(){
	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	alertify.confirm("確定要刪除聯絡人嗎?", function (e) {
	    if (e) {
	        // user clicked "ok"
	    	document.getElementById("action").value = "deleteContact";
			document.getElementById("contactForm").submit();
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
      						<li><a href="contact.do?action=editMode"><span class="nav-mycolor">編輯聯絡人</span></a></li>
    					</ul>
  					</li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
					<% 
					String depart = (String)session.getAttribute("depart");
			    	String level = (String)session.getAttribute("level");
			    	%>
  					<li><a href="default.do?action=editDefault"><span class="nav-mycolor">預設聯絡人</span></a></li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
			    	<li><a href="webSubUser.do?action=usedPoint"><span class="nav-mycolor">使用點數</span></a></li>
			    	<li><img src="img/web/sp.png" class="sbar"></li>
			    	<li><a href="phone1.jsp"><span class="nav-mycolor">變更通話分機</span></a></li>
			    	<li><img src="img/web/sp.png" class="sbar"></li>
    				<li><a href="chgPassword1.jsp"><span class="nav-mycolor">變更密碼</span></a></li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
  					<li><a href="contactUs1.jsp"><span class="nav-mycolor">聯絡我們</span></a></li>
  					<li><img src="img/web/sp.png" class="sbar"></li>
				</ul>
    		</div>
		</nav>
	</div>
	<div class="content">
		<%
		Contact contact = (Contact)session.getAttribute("editContact");
		%>
		<div class="content-title">
			編輯聯絡人
		</div>
		<div class="content1">
		<form id="contactForm" class="bs-docs-example form-horizontal" method="post" action="contact.do" enctype="multipart/form-data">
			<div class="content-img">
				<img src="img/<%=contact.getPic() %>" id="blah">
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
				<div class="content-delete-contact">
					<a href="#" onclick="deleteContact()">
						<img src="img/web/delete_contact.png" height="35px" width="150px">
					</a>
				</div>
				<div class="content-text">
					聯絡人姓名
				</div>
				<div class="input-group-lg content-cname">
            		<input type="text" class="form-control input-lg" style="border:1px solid #611987;" id="cname" name="cname" value="<%=contact.getName() %>" placeholder="請輸入聯絡人姓名">
            	</div>
            	<div class="content-text">
					電話號碼
				</div>
            	<div class="input-group-lg content-mobile">
            	<%
            	String precode = "";
            	if(session.getAttribute("nation") != null){
            	%>
            	<select name="nationCode" onchange="changeNation(this)">
            	<%
            		List<Nation> nation = (List<Nation>)session.getAttribute("nation");
            		for(Nation one:nation){
            			if(contact.getMobilePhone().startsWith(one.getNationalPreCode())){
            				precode = one.getNationalPreCode();
            	%>
            		<option value="<%=one.getNationalPreCode() %>" selected="selected"><%=one.getNation() %></option>
            	<%
            			}else if(!contact.getMobilePhone().startsWith("+") & "台灣TAIWAN".equals(one.getNation())){
            	%>
            		<option value="<%=one.getNationalPreCode() %>" selected="selected"><%=one.getNation() %></option>
            	<%
            			}else{
            	%>
            		<option value="<%=one.getNationalPreCode() %>"><%=one.getNation() %></option>
            	<%
            			}
            		}
            	%>
            	</select>
            	<%
            	}
            	%>
            	<% 
            		if(!contact.getMobilePhone().startsWith("+")){
            	%>
            		<input type="hidden" id="ncode" name="ncode" value="">
            		<div>
            			<div id="ncodedisplay" style="display:none;"></div>
            			<div id="ncodeinput"><input type="text"  style="border:1px solid #611987;" size="12" id="mobile" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="10" name="mobile" value="<%=contact.getMobilePhone() %>" placeholder="請輸入電話號碼"></div>
            		</div>
            	<%
            		}else{
            	%>
            		<input type="hidden" id="ncode" name="ncode" value="<%=precode %>">
            		<div>
            			<div id="ncodedisplay"><%=precode %></div>
            			<div id="ncodeinput"><input type="text"  style="border:1px solid #611987;width:11em;" id="mobile" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="10" name="mobile" value="<%=contact.getMobilePhone().substring(precode.length()) %>" placeholder="請輸入電話號碼"></div>
            		</div>
            	<%
            		}
            	%>
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
            	String[] pcode = util.getPreCode(); 
            	%>
            	<select name="preCode" onchange="changePreCode(this)">
            	<%
            	String pc = "";
            	for(int i = 0; i < college.length; i++){
            		if(contact.getOfficePhone() != null & !"".equals(contact.getOfficePhone())){
            			if(contact.getOfficePhone().startsWith(pcode[i])){
            				pc = pcode[i];
            	%>
            		<option value="<%=pcode[i] %>" selected="selected"><%=college[i] %></option>
            	<%
            			}else{
            	%>
            		<option value="<%=pcode[i] %>" ><%=college[i] %></option>
            	<%
            			}
            		}else{
            			if("國立清華大學".equals(college[i])){
            				pc = pcode[i];
                %>
                    <option value="<%=pcode[i] %>" selected="selected"><%=college[i] %></option>
                <%
                        }else{
                %>
                    <option value="<%=pcode[i] %>" ><%=college[i] %></option>
                <%
                        }
            		}
            	}
            	%>
            	</select>
            		<input type="hidden" id="pcode" name="pcode" value="<%=pc %>">
            		<div>
            			<div id="precodedisplay"><%=pc+" -" %></div>
            			<div id="precodeinput">
            			<input class="span2" type="text" style="border:1px solid #611987;width:11em;" name="office" id="office" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="8" 
            			value="<% if(contact.getOfficePhone() != null & !"".equals(contact.getOfficePhone())){ %><%=contact.getOfficePhone().substring(pc.length()) %><% } %>" placeholder="請輸入分機號碼">
            			</div>
            		</div>
            	</div>
			</div>
			<input type="hidden" name="action" id="action" value="updateContact"/>
        	<input type="hidden" name="imgUrl" id="imgUrl" value=""/>
        	<input type="hidden" name="imgTitle" id="imgTitle" value=""/>
		</form>
		</div>
	</div>
</body>
</html>