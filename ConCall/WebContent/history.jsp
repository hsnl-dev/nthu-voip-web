<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, 
org.json.JSONObject, org.json.JSONArray, java.util.Date, java.text.SimpleDateFormat, 
talk.account.service.xsd.WebContact, java.util.ArrayList, java.math.BigDecimal "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歷史紀錄</title>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/util-functions.js"></script>
<script type="text/javascript" src="js/clear-default-text.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- modal popup lite -->
<!-- <script src="js/modalPopLite.min.js"></script> -->
<script src="js/modalPopLite.js"></script>
<link href="css/modalPopLite.css" rel="stylesheet">
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
.content-text{
	float:left;
	width:40%;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:40px;
	color:#611987;
	padding:0px 0 0 0px;	
}
.content-top{
	padding:100px 0 0 160px;
}
.content-body{
	padding:70px 0 100px 0px;
}
#content-table{
	width:950px;
}
#content-table tr{
	border-bottom:1px solid #000000;
}
#content-table th{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:36px;
	color:#611987;
	text-align:center;
}
#content-table td{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	color:#000000;
	text-align:center;
}
#popup-wrapper{
	width:780px;
	height:400px;
	background-color:#fff;
	padding:10px;
	-webkit-border-radius: 1em;
	-moz-border-radius: 1em;
	border-radius: 1em;	
}
.wrapper-close{
	float:right;
    position:relative;
    top:-25px;
    right:-25px;
    height:40px;
    width:40px;
}
hr{
	display: block; 
	height: 1px;
    border: 0; 
    border-top: 1px solid #611987;
    margin: 1em 0; 
    padding: 0;
}
.popuptitle{
	text-align:center;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	color:#611987;
	font-size:30px;
	font-weight:bold;
	padding:5px 0 0px 0;
}
.centerstyle{
	text-align:center;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	padding:10px 0 0 0;
}
</style>
<script type="text/javascript">
$(function () {     
	$('#popup-wrapper').modalPopLite({ 
		openButton: '#clicker', 
		closeButton: '#close-btn',
		isModal: true
	}); 
});

function popbox(pastListStr,startTime,endTime,cost,numberStr,millitimes,imgStr){
	var times = Math.round(millitimes/1000);
	var sec = times % 60;
	var min = (times - sec)/60;
	
	$( "#clicker" ).trigger( "click" );
	document.getElementById("popup_member").innerHTML = pastListStr;
	document.getElementById("popup_time").innerHTML = startTime + "&nbsp; ~ &nbsp;" + endTime;
	document.getElementById("popup_times").innerHTML = "共" + min + "分" + sec + "秒";
	document.getElementById("popup_cost").innerHTML = cost;
	document.getElementById("numberStr").value = numberStr;
	document.getElementById("imgStr").value = imgStr;
	document.getElementById("pastListStr").value = pastListStr;
}
function submitform(){
	document.getElementById("historyForm").submit();
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

		<div class="content-top">
			<div class="content-text">
				通話紀錄
			</div>
			<div class="content-body">
				<table id="content-table">
					<tr height="40px">
						<th>與會人員</th>
						<th>會議時間</th>
						<th>通話費</th>
						<th></th>
					</tr>
			<%
			String status = (String)request.getAttribute("status");
			String userphone = (String)session.getAttribute("userphone");
			WebContact[] contactList = (WebContact[])request.getAttribute("contactList");
			if("SUCCESS".equals(status)){
				JSONArray infoList = (JSONArray)request.getAttribute("infoList");
				if(infoList != null && infoList.length() > 0){
					for(int i = infoList.length()-1; i >= 0; i--){
						String jsonStr = (String)infoList.get(i);
						JSONObject record = new JSONObject(jsonStr);
						Date startTime = new Date(record.getLong("startTime"));
						Date endTime = new Date(record.getLong("endTime"));
						double times = record.getLong("endTime") - record.getLong("startTime");
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						double costvalue = record.getDouble("cost");
						BigDecimal bd = new BigDecimal(costvalue);
						
						String pastListStr = "";
						String numberStr = "";
						String showStr = "";
						String imgSrcStr = "";
						JSONArray pastList = record.getJSONArray("pastList");
						if(pastList != null && pastList.length() > 0){
							int n = 0;
							for(int j = 0; j < pastList.length(); j++){
								String member = (String)pastList.get(j);
								if(contactList != null && contactList.length > 0 & (!userphone.equals(member))){
									for(int k = 0; k < contactList.length; k++){
										if(member.equals(contactList[k].getMobilePhone())){
											pastListStr += contactList[k].getName();
											numberStr += member;
											imgSrcStr += contactList[k].getPic();
											if(n < 2){
												showStr += contactList[k].getName();
											}
										}else if(member.equals(contactList[k].getOfficePhone())){
											pastListStr += contactList[k].getName();
											numberStr += member;
											imgSrcStr += contactList[k].getPic();
											if(n < 2){
												showStr += contactList[k].getName();
											}
										}
									}
									pastListStr += ",";
									numberStr += ",";
									imgSrcStr += ",";
									if(n < 2){
										showStr += ",";
									}
									n++;
								}
							}
							if(pastListStr.length() > 0){
								pastListStr = pastListStr.substring(0,pastListStr.length()-1);
							}
							if(numberStr.length() > 0){
								numberStr = numberStr.substring(0,numberStr.length()-1);
							}
							if(showStr.length() > 0){
								showStr = showStr.substring(0, showStr.length()-1);
							}
							if(imgSrcStr.length() > 0){
								imgSrcStr = imgSrcStr.substring(0, imgSrcStr.length()-1);
							}
							if(pastList.length() > 3){
								showStr += "等" + (pastList.length()-1) + "人";
							}
						}
			%>
				<tr height="28px">
					<td><%=showStr %></td>
					<td><%=sdf.format(startTime) %></td>
					<td><%=bd.setScale(2, 2) %></td>
					<td><button class="btn" onclick="popbox('<%=pastListStr %>','<%=sdf.format(startTime) %>','<%=sdf.format(endTime) %>','<%=bd.setScale(2, 2) %>','<%=numberStr%>','<%=times%>','<%=imgSrcStr%>')">詳細資訊</button></td>
				</tr>
			<%
					}
				}
			}
			%>
				</table>
				<form id="historyForm" class="bs-docs-example form-horizontal" method="post" action="history.do">
					<input type="hidden" id="action" name="action" value="startMeeting" >
					<input type="hidden" id="numberStr" name="numberStr" value="" >
					<input type="hidden" id="pastListStr" name="pastListStr" value="" >
					<input type="hidden" id="imgStr" name="imgStr" value="" >
				</form>
			</div>
		</div>
		<div id="popup-wrapper">
			<a href="#" id="close-btn"><img class="wrapper-close" src="img/web/close.png"></a>
			<div></div>
			<p class="popuptitle">會議詳細資訊</p>
			<hr>
			<p class="centerstyle"><font color="#611987">與會人員:</font></p>
			<p id="popup_member" class="centerstyle">
			</p>
			<p class="centerstyle"><font color="#611987">起訖時間:</font></p>
			<p id="popup_time" class="centerstyle">
			</p>
			<p id="popup_times" class="centerstyle">
			</p>
			<p class="centerstyle"><font color="#611987">通話費:</font></p>
			<p id="popup_cost" class="centerstyle">
			</p>
			<p class="centerstyle">
				<a href="#" class="btn btn-primary" onclick="submitform()" id="close-btn">開啟會議</a>
			</p>
		</div>
		<div id="clicker"></div>
	</div>
</body>
</html>