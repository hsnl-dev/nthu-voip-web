<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.util.ArrayList, talk.account.service.xsd.WebAccount, talk.billing.service.xsd.Point, java.math.BigDecimal ,util.SubUser,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附屬帳號管理</title>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/util-functions.js"></script>
<script type="text/javascript" src="js/clear-default-text.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- alertify plugin -->
<script src="js/alertify.min.js"></script>
<link href="css/alertify.core.css" rel="stylesheet">
<link href="css/alertify.default.css" rel="stylesheet">

<!-- modal popup lite -->
<script src="js/modalPopLite.min.js"></script>
<link href="css/modalPopLite.css" rel="stylesheet">

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
img.newSub{
	width: auto; 
	max-width: 150px; 
	height: auto; 
	max-height: 35px;
}
img.tri{
	width: auto; 
	max-width: 30px; 
	height: auto; 
	max-height: 30px;
}
img.delBtn{
	width: auto; 
	max-width: 70px; 
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
.content-text{
	float:left;
	width:40%;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:60px;
	color:#611987;
	padding:0px 0 0 0px;	
}
.content-top{
	padding:100px 0 0 160px;
}
.content-top-btn{
	float:right;
	padding:0 170px 0 0px;
}
.content-top-table{
	padding:50px 0 0 0;
}
#table1{
	width:950px;
	border:1px solid #611987;
}
#table1 tr{
	height:43px;
}
#table1 th{
	background-color:#611987;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	color:white;
}
#table1 td{
	font-size:20px;
	border-right:1px solid #611987;
}
.content-img{
	padding:0 0 0 220px;
}
.content-bot{
	padding:0px 0 0 160px;
}
#table2{
	width:1070px;
	border:1px solid #727071;
}
#table2 tr{
	height:43px;
}
#table2 th{
	background-color:#727071;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	color:white;
}
#table2 td{
	font-size:20px;
	border-right:1px solid #727071;
}
.table-table{
	padding:0 0 0 42px;
	display:none;
}
#table3{
	width:1028px;
	border:1px solid #727071;
}
#table3 tr{
	height:43px;
}
#table3 th{
	background-color:#727071;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	color:white;
}
#table3 td{
	font-size:20px;
	border-right:1px solid #727071;
}
#popup-wrapper{
	width:500px;
	height:300px;
	background-color:#ccc;
	padding:10px;
		
}
#popup-wrapper2{
	width:500px;
	height:300px;
	background-color:#ccc;
	padding:10px;
		
}
.popupstyle{
	text-align:center;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
}
.popupstyle2{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	padding:5px 0 5px 30px;
}
</style>
<script type="text/javascript">
$(function () {     
	$('#popup-wrapper').modalPopLite({ 
		openButton: '#clicker', 
		closeButton: '#close-btn',
		isModal: true
	}); 
	$('#popup-wrapper2').modalPopLite({ 
		openButton: '#clicker2', 
		closeButton: '#close-btn',
		isModal: true
	});
});
function clickfunc(uuid, number){
	document.getElementById("uuid").value = uuid;
	document.getElementById("popup_content1").innerHTML = "目前點選" + number + ",";
	$( "#clicker" ).trigger( "click" );
}
function clickfunc2(uuid, number){
	document.getElementById("uuid").value = uuid;
	document.getElementById("popup_content2").innerHTML = "目前點選" + number + ",";
	$( "#clicker2" ).trigger( "click" );
}
function saveSubUser(){
	var tmp = document.getElementsByName("saveSubUser");
	var uuidStr = "";
	for(var i = 0; i < tmp.length; i++){
		if(tmp[i].checked == true){
			uuidStr += tmp[i].value + ",";
		}
	}
	if(uuidStr.length == 0){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請選擇至少一筆附屬帳號!");
	}else{
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.confirm("確定要儲存此設定嗎?", function (e) {
		    if (e) {
		        // user clicked "ok"
		        document.getElementById("uuidStr").value = uuidStr;
		    	document.getElementById("action").value = "saveSubUser";
				document.getElementById("subUserForm").submit();
		    } else {
		        // user clicked "cancel"
		    	return false;
		    }
		});
	}
}
function changelevel1(){
	var tmp = document.getElementsByName("changeuuid");
	var uuidStr = "";
	for(var i = 0; i < tmp.length; i++){
		if(tmp[i].checked == true){
			uuidStr += tmp[i].value + ",";
		}
	}
	if(uuidStr.length == 0){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("請選擇至少一筆附屬帳號!");
	}else{
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.confirm("確定要儲存此設定嗎?", function (e) {
		    if (e) {
		        // user clicked "ok"
		        document.getElementById("uuidStr").value = uuidStr;
		    	document.getElementById("action").value = "changelevel1";
				document.getElementById("subUserForm").submit();
		    } else {
		        // user clicked "cancel"
		    	return false;
		    }
		});
	}
}
function deleteSubUser(uuid){
	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	alertify.confirm("確定要刪除附屬帳號嗎?", function (e) {
	    if (e) {
	        // user clicked "ok"
	    	document.getElementById("uuid").value = uuid;
			document.getElementById("action").value = "deleteSubUser";
			document.getElementById("subUserForm").submit();
	    } else {
	        // user clicked "cancel"
	    	return false;
	    }
	});
}
function opendiv(id){
	var thisdiv = document.getElementById(id);
	if(thisdiv.style.display == "none"){
		thisdiv.style.display = "block";
	}else{
		thisdiv.style.display = "none";
	}
}
function degrade(uuid, number){
	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	alertify.confirm("確定要調降"+number+"此附屬帳號權限嗎?\n調降後此附屬帳號將成為第二層附屬帳號無法新增附屬帳號!", function (e) {
	    if (e) {
	        // user clicked "ok"
	    	document.getElementById("uuid").value = uuid;
			document.getElementById("action").value = "degrade";
			document.getElementById("subUserForm").submit();
	    } else {
	        // user clicked "cancel"
	    	return false;
	    }
	});
}
function levelup(uuid, number){
	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	alertify.confirm("確定要提升"+number+"此附屬帳號權限嗎?\n提升後此附屬帳號將成為第一層附屬帳號並且可以新增附屬帳號!", function (e) {
	    if (e) {
	        // user clicked "ok"
	    	document.getElementById("uuid").value = uuid;
			document.getElementById("action").value = "levelup";
			document.getElementById("subUserForm").submit();
	    } else {
	        // user clicked "cancel"
	    	return false;
	    }
	});
}
function resendMail(uuid, phone){
	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	alertify.confirm("確定要重寄認證信嗎?", function (e) {
	    if (e) {
	        // user clicked "ok"
	    	document.getElementById("uuid").value = uuid;
			document.getElementById("subUser").value = phone;
			document.getElementById("action").value = "resendMail";
			document.getElementById("subUserForm").submit();
	    } else {
	        // user clicked "cancel"
	    	return false;
	    }
	});
}
function updateLimit(uuid, phone, email, name, limit){
	document.getElementById("uuid").value = uuid;
	document.getElementById("subUser").value = phone;
	document.getElementById("subUserEmail").value = email;
	document.getElementById("subUserName").value = name;
	document.getElementById("limit").value = limit;
	document.getElementById("action").value = "updateLimit";
	document.getElementById("subUserForm").submit();
}
</script>
</head>
<body>
<!-- <img src="img/web/14.JPG" class="bg"> -->
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
			    	String cardId = (String)session.getAttribute("cardId");
			    	
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
		<div class="content-top">
			<div class="content-text">
				附屬帳號
			</div>
			<div class="content-top-btn">
				<a href="newSubUser1.jsp">
					<img src="img/web/new_sub.png" class="newSub">
				</a>
			</div>
			<div class="content-top-table">
			<table id="table1">
				<tr>
					<th width="56%" align="left">&nbsp;管理者分機號碼</th>
					<th width="18%" align="right">授權點數上限/每年</th>
					<th width="18%" align="right">今年累積使用點數</th>
				</tr>
				<tr>
					<td >&nbsp;<%=session.getAttribute("userphone") %></td>
					<% 
					
					
					
					Double userLimitPoint = (Double)request.getAttribute("userLimitPoint");
					Double userCostPoint = (Double)request.getAttribute("userCostPoint");
					Double userCurrentPoint = (Double)request.getAttribute("userCurrentPoint");
					Double userInitPoint = (Double)request.getAttribute("userInitPoint");
					String totalPoint = (String)request.getAttribute("totalPoint");
					%>
					<td align="right">
					<% 
						if("0".equals(level)){ // you are top leader
							if(userLimitPoint > 0){
					%>
							<%=userLimitPoint %>
					<%	    }else{ 
					%>
							-
					<%
							}
					%>
					</td>
					<td align="right">
						<%=userCostPoint %>
					</td> <!--you are a leader -->
					<%
						}else{
							String totalcost = Double.toString(userCostPoint);
					%>
						<%=userLimitPoint %>
					</td><!-- simple user td end -->
					<td align="right">
						<%=totalcost %>
					</td>	
					<%
						} 
					%>
				</tr>
				<tr style="background-color:#e3e3e3;">
					<td >&nbsp;附屬帳號累積點數</td>
					<td align="right">-</td>
					<td align="right"><%=totalPoint %></td>
				</tr>
			</table>
			</div>
		</div>
		<div class="content-img">
			<img src="img/web/tri.JPG" height="50px" width="50px">
		</div>
		<div class="content-bot">
			<table id="table2">
				<tr>
					<th width="4%"></th>
					<th width="11%">分機號碼</th>
					<th width="29.5%">電子郵件信箱</th>
					<th width="10%">使用人名稱</th>
					<th width="17.4%">授權點數上限/每年</th>
					<th width="17.4%">今年累積使用點數</th>
					<th width="120px" ></th>
				</tr>
			</table>
			
				<%
				if(request.getAttribute("subUserListNew")!=null){
					List<SubUser> subUserList = (ArrayList<SubUser>)request.getAttribute("subUserListNew");
					
					for(int i = 0; i < subUserList.size(); i++){
						String limit = "0";
						String cost = "0";
					
						
						if("0".equals(level) & subUserList.get(i).getLevel() == 1){
							limit = String.valueOf(subUserList.get(i).getLimitPoint());
							cost = String.valueOf(subUserList.get(i).getCostPoint());
						
				%>
				
				<table id="table2">
					<tr <%if(i%2 == 1){%>style="background-color:#e3e3e3;"<%} %>>
						<td align="center" width="4%"><a href="javascript: return false;" onclick="opendiv('div<%=i %>')"><img src="img/web/open.png" class="tri"></a></td>
						<td width="11%">&nbsp;<%=subUserList.get(i).getUsename() %></td>
						<td width="29.5%">&nbsp;<%=subUserList.get(i).getRegMail() %></td>
						<td width="10%">&nbsp;<%=subUserList.get(i).getName() %></td>
						<td align="right" width="17.4%"><%=limit %></td>
						<td align="right" width="17.4%"><%=cost %></td>
						<td style="background-color:#ffffff;" width="120px">
							<a href="javascript: return false;" class="btn" onclick="deleteSubUser('<%=subUserList.get(i).getAccountUuid()%>')">
							<!-- <img src="img/web/delete.png" class="delBtn"> -->
							刪除附屬帳號
							</a>
							<a href="#" class="btn" onclick="updateLimit('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>','<%=subUserList.get(i).getRegMail() %>','<%=subUserList.get(i).getName() %>','<%=limit %>')">編輯附屬帳號</a>
							<a href="#" class="btn" onclick="resendMail('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>')">重寄認證信</a>
							<a href="#" class="btn" onclick="clickfunc('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>')">增加附屬帳號</a>
							<a href="#" class="btn" onclick="degrade('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>')">帳號權限調降</a>
							<div id="clicker"></div>
						</td>
					</tr>
				</table>
				<div class="table-table" id="div<%=i %>">
				<%
							for(int j = 0; j < subUserList.size(); j++){
								if(subUserList.get(j).getLevel() == 2 & subUserList.get(j).getCardId().equals(subUserList.get(i).getAccountUuid())){
									limit = String.valueOf(subUserList.get(i).getLimitPoint());
									cost = String.valueOf(subUserList.get(i).getCostPoint());
								
				%>
				
					<table id="table3">
						<tr >
							<td width="11.4%">&nbsp;<%=subUserList.get(j).getUsename() %></td>
							<td width="30.7%">&nbsp;<%=subUserList.get(j).getRegMail() %></td>
							<td width="10.4%">&nbsp;<%=subUserList.get(j).getName() %></td>
							<td align="right" width="18.2%"><%=limit %></td>
							<td align="right" width="18.2%"><%=cost %></td>
							<td style="background-color:#ffffff;" width="120px">
								<a href="javascript: return false;" class="btn" onclick="deleteSubUser('<%=subUserList.get(j).getAccountUuid()%>')">
								<!-- <img src="img/web/delete.png" class="delBtn"> -->
								刪除附屬帳號
								</a>
								<a href="#" class="btn" onclick="updateLimit('<%=subUserList.get(j).getAccountUuid() %>','<%=subUserList.get(j).getUsename() %>','<%=subUserList.get(j).getRegMail() %>','<%=subUserList.get(j).getName() %>','<%=limit %>')">編輯附屬帳號</a>
								<a href="#" class="btn" onclick="resendMail('<%=subUserList.get(j).getAccountUuid() %>','<%=subUserList.get(j).getUsename() %>')">重寄認證信</a>
								<a href="#" class="btn" onclick="clickfunc2('<%=subUserList.get(j).getAccountUuid() %>','<%=subUserList.get(j).getUsename() %>')">變更所屬帳號</a>
								<div id="clicker2"></div>
							</td>
						</tr>
					</table>
				
				<%
								}
							}
				%>
				</div>
				
				<%
						}else if("0".equals(level) & subUserList.get(i).getLevel() == 2 & cardId.equals(subUserList.get(i).getCardId())){
							if(request.getAttribute("pointList") != null){
								limit = String.valueOf(subUserList.get(i).getLimitPoint());
								cost = String.valueOf(subUserList.get(i).getCostPoint());
							
							}
				%>
				<table id="table2">
					<tr <%if(i%2 == 1){%>style="background-color:#e3e3e3;"<%} %>>
						<td align="center" width="4%"></td>
						<td width="11%">&nbsp;<%=subUserList.get(i).getUsename() %></td>
						<td width="29.5%">&nbsp;<%=subUserList.get(i).getRegMail() %></td>
						<td width="10%">&nbsp;<%=subUserList.get(i).getName() %></td>
						<td align="right" width="17.4%"><%=limit %></td>
						<td align="right" width="17.4%"><%=cost %></td>
						<td style="background-color:#ffffff;" width="120px">
							<a href="javascript: return false;" class="btn" onclick="deleteSubUser('<%=subUserList.get(i).getAccountUuid()%>')">
							<!-- <img src="img/web/delete.png" class="delBtn"> -->
							刪除附屬帳號
							</a>
							<a href="#" class="btn" onclick="updateLimit('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>','<%=subUserList.get(i).getRegMail() %>','<%=subUserList.get(i).getName() %>','<%=limit %>')">編輯附屬帳號</a>
							<a href="#" class="btn" onclick="resendMail('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>')">重寄認證信</a>
							<a href="#" class="btn" onclick="levelup('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>')">提升帳號權限</a>
						</td>
					</tr>
				</table>
				<%
						}else if("1".equals(level) & subUserList.get(i).getLevel() == 2){
							if(request.getAttribute("pointList") != null){
								
								limit = String.valueOf(subUserList.get(i).getLimitPoint());
								cost = String.valueOf(subUserList.get(i).getCostPoint());
							
							}
				%>
				<table id="table2">
					<tr <%if(i%2 == 1){%>style="background-color:#e3e3e3;"<%} %>>
						<td align="center" width="4%"><%=i+1 %></td>
						<td width="11%">&nbsp;<%=subUserList.get(i).getUsename() %></td>
						<td width="29.5%">&nbsp;<%=subUserList.get(i).getRegMail() %></td>
						<td width="10%">&nbsp;<%=subUserList.get(i).getName() %></td>
						<td align="right" width="17.4%"><%=limit %></td>
						<td align="right" width="17.4%"><%=cost %></td>
						<td style="background-color:#ffffff;" width="120px">
							<a href="javascript: return false;" class="btn" onclick="deleteSubUser('<%=subUserList.get(i).getAccountUuid()%>')">
							<!-- <img src="img/web/delete.png" class="delBtn"> -->
							刪除附屬帳號
							</a>
							<a href="#" class="btn" onclick="updateLimit('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>','<%=subUserList.get(i).getRegMail() %>','<%=subUserList.get(i).getName() %>','<%=limit %>')">編輯附屬帳號</a>
							<a href="#" class="btn" onclick="resendMail('<%=subUserList.get(i).getAccountUuid() %>','<%=subUserList.get(i).getUsename() %>')">重寄認證信</a>
						</td>
					</tr>
				</table>
				<%
						}
					}
				%>
				
				<div id="popup-wrapper">
					<p id="popup_content1" class="popupstyle"></p>
					<p class="popupstyle">請選擇第二層附屬帳號加入此第一層附屬帳號<br>成為此第一層附屬帳號的附屬帳號</p>
					<p class="popupstyle2">
				<%
					for(int i = 0; i < subUserList.size(); i++){
						if("0".equals(level) & subUserList.get(i).getLevel() == 2 & cardId.equals(subUserList.get(i).getCardId())){
							
				%>
					<input type="checkbox" name="saveSubUser" value="<%=subUserList.get(i).getAccountUuid() %>"><%=subUserList.get(i).getUsename() %>,<%=subUserList.get(i).getName() %><br>
				<%
						}
					}
				%>
					</p>
					<p class="popupstyle">
						<a href="#" class="btn" id="close-btn">取消</a>
						<a href="#" class="btn btn-primary" onclick="saveSubUser()" id="save-btn">儲存</a>
					</p>
				</div>
				<div id="popup-wrapper2">
					<p id="popup_content2" class="popupstyle"></p>
					<p class="popupstyle">請選擇第一層附屬帳號，儲存成功後<br>此第二層附屬帳號將轉移至選擇的第一層附屬帳號下。</p>
					<p class="popupstyle2">
				<%
					for(int i = 0; i < subUserList.size(); i++){
						if("0".equals(level) & subUserList.get(i).getLevel() == 1){
							
				%>
					<input type="radio" name="changeuuid" value="<%=subUserList.get(i).getAccountUuid() %>"><%=subUserList.get(i).getUsename() %>,<%=subUserList.get(i).getName() %><br>
				<%
						}
					}
				%>
					</p>
					<p class="popupstyle">
						<a href="#" class="btn" id="close-btn">取消</a>
						<a href="#" class="btn btn-primary" onclick="changelevel1()" id="save-btn">儲存</a>
					</p>
				</div>
				<%
				}
				%>
			<!-- </table> -->
			<form method="post" action="webSubUser.do" id="subUserForm">
				<input type="hidden" name="uuid" id="uuid" value=""/>
				<input type="hidden" name="uuidStr" id="uuidStr" value=""/>
				<input type="hidden" name="subUser" id="subUser" value=""/>
				<input type="hidden" name="subUserName" id="subUserName" value=""/>
				<input type="hidden" name="subUserEmail" id="subUserEmail" value=""/>
				<input type="hidden" name="limit" id="limit" value=""/>
				<input type="hidden" name="action" id="action" value=""/>
			</form>
		</div>
	</div>
</body>
</html>