<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.calling.service.xsd.MappingPhone" %>
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

<!-- colorbox -->
<link href="css/colorbox.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="js/jquery.colorbox.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="//code.jquery.com/jquery.js"></script> -->

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<!-- alertify plugin -->
<script src="js/alertify.min.js"></script>
<link href="css/alertify.core.css" rel="stylesheet">
<link href="css/alertify.default.css" rel="stylesheet">

<!-- modal popup lite -->
<script src="js/modalPopLite.min.js"></script>
<link href="css/modalPopLite.css" rel="stylesheet">


<!-- main css -->
<link href="css/main.css" rel="stylesheet">
<title>離線通</title>
<style type="text/css">
.mapping_content{
	float:left;
	width:45%
}
.mapping-title{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:60px;
	color:#611987;
	padding:20px 0 0px 100px;	
}
.mapping-subtitle{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:28px;
	color:#611987;
	padding:0px 0 0px 100px;
}
.mapping-text{
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:22px;
	/*color:#585657;*/
	color:#000000;
	padding:10px 0 10px 100px;
}
.section_mapping{
	float:right;
	width:51%;
	height:600px;
	padding:100px 0px 0 0;
}
.mapping-table{
	padding:50px 0 0 0px;
}
#table1{
	width:600px;
	border:1px solid #611987;
}
#table1 tr{
	height:43px;
	align:center;
}
#table1 th{
	background-color:#611987;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	font-size:20px;
	color:white;
	text-align:center;
}
#table1 td{
	font-size:20px;
	border-right:1px solid #611987;
}
.mapping-btn{
	padding:20px 0px 0 400px;
}
</style>
<%
String status = (String)request.getAttribute("status");
String numberStr = (String)request.getAttribute("numberStr");
%>
<script type="text/javascript">
$(document).ready(function(){
	$(".group1").colorbox({rel:'group1'});
});
//$(function () {     
//	$('#popup-wrapper').modalPopLite({ 
//		openButton: '#clicker', 
//		closeButton: '#close-btn',
//		isModal: true
//		}); 
//	});
function check(){
	if("<%=status%>" == "success"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("配對號碼已儲存成功!");
	}else if("<%=status%>" == "failed"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("配對號碼儲存失敗，請重新輸入!");
	}else if("<%=status%>" == "nomvpn"){
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.alert("聯絡人號碼 " + '<%=numberStr%>' + " 非清華大學 MVPN 群組，請重新輸入!");
	}
}
function formsubmit(){
	var thisForm = document.getElementById("mappingForm");
	thisForm.submit();
}
function clearcell(num){
	var tempphone = document.getElementsByName("mappedPhone")[num];
	var tempname = document.getElementsByName("contact")[num];
	tempphone.value = "";
	tempname.value = "";
}
</script>
</head>
<body onload="check()">
<!-- <img src="img/bg2.jpg" class="bg"> -->
	<div class="header">
		<div class="header-top">
			<div class="header-top-group">
				<div class="header-top-phone">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-top-text">
						<%=session.getAttribute("userphone") %>
					</div>
				</div>
				<div class="header-top-logout">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="mapping.do?action=logout" >登出</a>
					</div>
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
				</div>
			</div>
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="mapping.do?action=getMappingList" >配對清單</a>
					</div>
				</div>
				<div class="header-bot-qa">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="chgPwd.jsp">變更密碼</a>
					</div>
				</div>
				<div class="header-bot-contactus">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="contactUs.jsp" >聯絡我們</a>
					</div>
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="mapping_content">
			<div class="mapping-title">
				離線通
			</div>
			<div class="mapping-subtitle">
				服務說明
			</div>
			<div class="mapping-text">
				聯絡人號碼必需加入<font color="red">清華大學 MVPN 群組</font>或是<font color="red">清大校內分機 ( TANet 門號 ) </font>才能撥打並且享受免費通話。
				<!-- <div id="clicker">
					Click Me!
				</div>
		
				<div id="popup-wrapper">
					I am a popup box. Content can be anything. <br />
					<a href="#" id="close-btn">Close</a>
				</div>
				 -->
			</div>
			<div class="mapping-subtitle">
				操作步驟
			</div>
			<div class="mapping-text">
				<ol type="1">
					<li>
						請在表格中設定配對聯絡人名稱及電話。例 : 配對號碼 0917710459 設定
						聯絡人名稱為小安，聯絡人號碼為 0912345678 。
					</li>
				<!-- <p>
				<a class="group1" href="img/guide1.JPG" title="配對示意圖">配對示意圖</a>
				</p> -->
					<li>
						到個人手機電話簿中新增聯絡人小安，將電話號碼設定成配對號碼 0917710459 ，取名為"小安 2 "。
					</li>
					<li>
						想打免費電話給聯絡人小安，只要撥給"小安 2 " ( 0917710459 ) 。
					</li>
					<li>
						接通後，會先斷線，雲端獲知您其實是要打給小安，系統會主動利用配對電話撥號給小安。
					</li>
					<li>
						雲端秘書會將您及小安 ( 0912345678 ) 接通。
					</li>
				</ol>
			</div>
		</div>
		<div class="section_mapping">
			<div class="mapping-table">
			<form id="mappingForm" class="bs-docs-example form-horizontal" method="post" action="mapping.do" >
            	<table id="table1">
            		<tr>
            			<th width="200px">配對號碼</th>
            			<th width="200px">聯絡人號碼</th>
            			<th width="140px">聯絡人名稱</th>
            			<th width="60px">清除</th>
            		</tr>
            		<%
            		int j = 0;
            		if(request.getAttribute("mappedList") != null){
            			MappingPhone[] mappedList = (MappingPhone[])request.getAttribute("mappedList");            			
            			for(int i = 0; i < mappedList.length; i++){
            		%>
            			<tr <%if(j%2 == 1){%>style="background-color:#e3e3e3;"<%} %>>
            				<td align="center"><%=mappedList[i].getMappingNumber() %></td>
            				<td align="center"><input type="text" name="mappedPhone" id="mappedPhone" style="width:9em;" value="<%=mappedList[i].getNumber() %>" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="10" placeholder="請輸入聯絡人號碼"></td>
            				<td align="center"><input type="text" name="contact" id="contact" style="width:9em;" value="<%=mappedList[i].getName() %>" placeholder="請輸入聯絡人名稱"></td>
            				<td align="center">
            				<input type="hidden" id="mappingNum" name="mappingNum" value="<%=mappedList[i].getMappingNumber() %>">
            				<button type="button" class="btn btn-default" onclick="clearcell('<%=j %>')">
            					<span class="glyphicon glyphicon-minus"></span>
            				</button>
            				</td>
            			</tr>
            		<%
            			j++;
            			}
            		}
            		%>
            		<%
            		if(request.getAttribute("mappingList") != null){
            			String[] mappingList = (String[])request.getAttribute("mappingList");
            			for(int i = 0; i < mappingList.length; i++){
            		%>
            			<tr <%if(j%2 == 1){%>style="background-color:#e3e3e3;"<%} %>>
            				<td align="center"><%=mappingList[i] %></td>
            				<td align="center"><input type="text" name="mappedPhone" id="mappedPhone" style="width:9em;" value="" onkeyup="value=value.replace(/[^-_A-Z0-9]/g,'')" maxLength="10" placeholder="請輸入聯絡人號碼"></td>
            				<td align="center"><input type="text" name="contact" id="contact" style="width:9em;" value="" placeholder="請輸入聯絡人名稱"></td>
            				<td align="center">
            				<input type="hidden" id="mappingNum" name="mappingNum" value="<%=mappingList[i] %>">
            				<button type="button" class="btn btn-default" onclick="clearcell('<%=j %>')">
            					<span class="glyphicon glyphicon-minus"></span>
            				</button>
            				</td>
            			</tr>
            		<%
            			j++;
            			}
            		}
            		%>
            	</table>
           		<input type="hidden" id="action" name="action" value="saveMappingList">
          	</form>
          	</div>
          	<div class="mapping-btn">
          		<a href="#" onclick="formsubmit()"><img src="img/save_btn.png" height="70px" width="70px"></a>
          	</div>
		</div>
	</div>
</body>
</html>