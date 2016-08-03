<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.account.service.xsd.WebContact, java.util.ArrayList "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聯絡人清單</title>
<!-- 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css"></link> 
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script> 
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
 -->
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="js/sorttable.js"></script>
<script type="text/javascript" src="js/spin.js"></script>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- modal popup lite -->
<script src="js/modalPopLite.js"></script>
<link href="css/modalPopLite.css" rel="stylesheet">

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
	font-size:40px;
	color:#611987;
	padding:70px 0 0 120px;	
}
.contact-list{
	padding:0px 120px 0 120px;
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
#wrapper-top{
	width:780px;
	height:40px;
}
#wrapper-top-left{
	float:left;
	width:40px;
	height:40px;
}
#wrapper-top-mid{
	float:left;
	width:700px;
	height:40px;
}
#wrapper-top-right{
	float:left;
	width:40px;
	height:40px;
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
	font-weight:bold;
	color:#611987;
	font-size:30px;
	padding:5px 0 0px 0;
}
#wrapper-content{
	float:left;
	width:780px;
}
.new_div{
	float:left;
	font-family: "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
	color:#611987;
	font-size:18px;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	background-color:#CACACA;
}
.img_close{
	float:right;
    position:relative;
    top:-12px;
    right:-12px;
    height:24px;
    width:24px;
}
.wrapper-img{
	float:left;
	height:96px;
	width:96px;
	padding:2px 0 2px 0px;
}
.wrapper-child{
	float:left;
	height:100px;
	width:76px;
	padding:0 0 0 4px;
}
.wrapper-name{
	float:left;
	display: table-cell;
    vertical-align: bottom;
	height:40px;
	width:78px;
	padding:0px 0 0 0px;
}
.wrapper-text{
	float:left;
	height:20px;
	width:78px;
	padding:2px 0 0 0px;
	color:#0000ff;
}
.img-class{
	border: 1px solid #611987;
	/*width:96px;*/
	height:96px;
}
</style>
<%
	String status = (String)request.getAttribute("status");
	String numberStr = (String)request.getAttribute("numberStr");
	String pastListStr = (String)request.getAttribute("pastListStr");
	String userPhone = (String)session.getAttribute("userphone");
	String imgStr = (String)request.getAttribute("imgStr");
%>
<script type="text/javascript">
$(function () {     
	$('#popup-wrapper').modalPopLite({ 
		openButton: '#clicker', 
		closeButton: '#close-btn',
		isModal: true
	}); 
});

var concalluuid = null;
var intervalobject = null;
var usernumber;
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

function check(){
	var pastlist = '<%=pastListStr%>';
	var numberstr = '<%=numberStr%>';
	var imgstr = '<%=imgStr%>';
	usernumber = '<%=userPhone%>';
	var pastary = pastlist.split(",");
	var numberary = numberstr.split(",");
	var imgary = imgstr.split(",");
	
	$.ajax({
	    url:"contact.do",
	    type:"POST",
        data: "action=callByHistory&number=" + "<%=numberStr%>",
	    error:function(response){
	      //alert("error");
	    },
	    success:function(response){
	      //alert("success");
	    	concalluuid = response;
	    	$( "#clicker" ).trigger( "click" );
	    	for(var i = 0; i < numberary.length; i++){
	    		var childdiv = document.createElement('div');
	    		childdiv.id = "div_"+numberary[i];
	    		childdiv.className = "new_div";
	    		childdiv.style.width  = '180px';
	    		childdiv.style.height = '102px';
	    		childdiv.style.border = '1px solid #611987';
	    		childdiv.style.padding = '0px 2px 2px 2px';
	    		childdiv.style.margin = '2px 2px 2px 2px';
	    		var src = "img/web/default_user.png";
	    		if(imgary[i] != "No" && imgary[i] != "" && imgary[i] != null){
	    			src = "img/" + imgary[i];
	    		}
	    		
	    		var nameStr = "<div class='wrapper-name'>" + pastary[i] + "</div>";
	    		if(pastary[i].length > 6){
	    			nameStr = "<div class='wrapper-name' style='font-size:14px;'>" + pastary[i] + "</div>";
	    		}
	    		
	    		childdiv.innerHTML = 
	    			"<a href='#' onclick='kickMember(\"" + numberary[i] + "\")'><img class='img_close' src='img/web/endcall.png'></a>" + 
	    			"<div class='wrapper-img'><img class='img-class' src='" + src + "' ></div>" + 
	    			"<div class='wrapper-child'>" + 
	    			nameStr +
	    			"<div id='wrapper-text-" + numberary[i] + "' class='wrapper-text'>撥號中</div></div>";
	    		var parentdiv = document.getElementById("wrapper-content");
	    		parentdiv.appendChild(childdiv);
	    	}
	    	var callStatus = document.getElementById("callStatus").value;
    		if(callStatus != "invite"){
    			getConCallMessage();
    			intervalobject = setInterval("getMeetingInfo()",4000);
    		}
	    },
	  });
}
$(document).ready(function(){
	if("<%=status%>" == "startMeetingByHistory"){
		var tmp = "確定要撥號給" + "<%=pastListStr %>" + "來開啟多人線上會議嗎?";
		alertify.set({ labels : { ok: "確定", cancel: "取消" } });
		alertify.confirm(tmp, function (e) {
			if(e){
				check();
			}
		});
	}else{
		return false;
	}
});

function hideProgressbar(number,calleename,pic){
	
	var callstatus = document.getElementById("callStatus").value;
	
	if(callstatus != "invite"){
		document.getElementById("progressbar").style.display = "none";
		$("#cover").fadeOut(100);
		spinner.stop();
	}
	$( "#clicker" ).trigger( "click" );
	//新增div
	var childdiv = document.createElement('div');
	childdiv.id = "div_"+number;
	childdiv.className = "new_div";
	childdiv.style.width  = '180px';
	childdiv.style.height = '102px';
	childdiv.style.border = '1px solid #611987';
	childdiv.style.padding = '0px 2px 2px 2px';
	childdiv.style.margin = '2px 2px 2px 2px';
	var src = "img/web/default_user.png";
	if(pic != "No" && pic != "" && pic != null){
		src = "img/" + pic;
	}
	var nameStr = "<div class='wrapper-name'>" + calleename + "</div>";
	if(calleename.length > 6){
		nameStr = "<div class='wrapper-name' style='font-size:14px;'>" + calleename + "</div>";
	}
	
	childdiv.innerHTML = 
		"<a href='#' onclick='kickMember(\"" + number + "\")'><img class='img_close' src='img/web/endcall.png'></a>" + 
		"<div class='wrapper-img'><img class='img-class' src='" + src + "'></div>" + 
		"<div class='wrapper-child'>" + 
		nameStr +
		"<div id='wrapper-text-" + number + "' class='wrapper-text'>撥號中</div></div>";
	var parentdiv = document.getElementById("wrapper-content");
	parentdiv.appendChild(childdiv);
	
	
	var callStatus = document.getElementById("callStatus").value;
	if(callStatus != "invite"){
		getConCallMessage();
		intervalobject = setInterval("getMeetingInfo()",2000);
	}	
}
function getConCallMessage(){
	$.ajax({
	    url:"getStatus.do",
	    type:"POST",
        data: "action=getConCallMessage",
	    error:function(response){
	      //alert("error");
	    },
	    success:function(response){
	      //alert("success");
	    },
	  });
}
function getMeetingInfo(){
	$.ajax({
	    url:"meetingInfo.do",
	    type:"POST",
        data: "action=getMeetingInfo",
	    error:function(response){
	      //alert("error");
	    	//console.log("AJAX error in request: " + response);
	    },
	    success:function(response){
	      //alert("success");
	      console.log("AJAX success in request:" + response);
	      if(response != null && response != "" && response.length > 0){
	    	  if(response == "meeting close"){
	    		  window.clearInterval(intervalobject);
	    		  var parent = document.getElementById("wrapper-content");
	    		  while(parent.firstChild) {
	    			  parent.removeChild(parent.firstChild);
	    		  }
	    		  document.getElementById("callStatus").value = "";
	    		  concalluuid = null;
	    		  document.getElementById("meetingroom").style.display = "none";
	    		  $( "#close-btn" ).trigger( "click" );
	    	  }else{
	    		  var numAry = response.split(",");
		    	  for(var i = 0; i < numAry.length; i++){
		    		  var recAry = numAry[i].split(":");
		    		  console.log("usernumber:" + usernumber + ",reponsenumber:" + recAry[0] + ",status:" + recAry[1]);
			    	  if(recAry[0] == usernumber && recAry[1] == "terminate"){
			    		  window.clearInterval(intervalobject);
			    		  var parent = document.getElementById("wrapper-content");
			    		  while(parent.firstChild) {
			    			  parent.removeChild(parent.firstChild);
			    		  }
			    		  document.getElementById("callStatus").value = "";
			    		  concalluuid = null;
			    		  document.getElementById("meetingroom").style.display = "none";
			    		  $( "#close-btn" ).trigger( "click" );
			    	  }
			    	  if(recAry[0] != usernumber && recAry[1] == "terminate"){
			    		  var tmp = "wrapper-text-" + recAry[0];
			    		  var obj = document.getElementById(tmp);
			    		  if(obj != null){
			    			  document.getElementById(tmp).style.color = "#ff0000";
				    		  document.getElementById(tmp).innerHTML = "已中斷" + 
				    		  "<a href='#' onclick='recall(\"" + recAry[0] + "\")'><img src='img/web/recall.png' width='18px' height='18px'></a>";  
			    		  }else{
			    			  setTimeout(function(){
			    				  obj = document.getElementById(tmp);
			    				  document.getElementById(tmp).style.color = "#ff0000";
					    		  document.getElementById(tmp).innerHTML = "已中斷" + 
					    		  "<a href='#' onclick='recall(\"" + recAry[0] + "\")'><img src='img/web/recall.png' width='18px' height='18px'></a>";
			    			  },2000);
			    		  }
			    	  }else if(recAry[0] != usernumber && recAry[1] == "meeting"){
			    		  var tmp = "wrapper-text-" + recAry[0];
			    		  var obj = document.getElementById(tmp);
			    		  if(obj != null){
			    			  document.getElementById(tmp).style.color = "#00ff00";
				    		  document.getElementById(tmp).innerHTML = "會議中";
			    		  }else{
			    			  setTimeout(function(){
			    				  obj = document.getElementById(tmp);
			    				  document.getElementById(tmp).style.color = "#00ff00";
					    		  document.getElementById(tmp).innerHTML = "會議中";
			    			  },2000);
			    		  }
			    	  }
			    	  else if(recAry[0] != usernumber && recAry[1] == "busy"){
			    		  var tmp = "wrapper-text-" + recAry[0];
			    		  var obj = document.getElementById(tmp);
			    		  if(obj != null){
			    			  document.getElementById(tmp).style.color = "#0000ff";
				    		  document.getElementById(tmp).innerHTML = "忙線中";
			    		  }else{
			    			  setTimeout(function(){
			    				  obj = document.getElementById(tmp);
			    				  document.getElementById(tmp).style.color = "#0000ff";
					    		  document.getElementById(tmp).innerHTML = "忙線中";
			    			  },2000);
			    		  }
			    	  }
		    	  }
	    	  }
	      }
	    },
	  });
}
function hideProgressbar2(){
	document.getElementById("p4").innerText = '取消撥號中...';
	document.getElementById("progressbar").style.display = "none";
	$("#cover").fadeOut(100);
	spinner.stop();
}
function changeText(number,userPhone,calleename,pic){
	
	//document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone + '\n撥號中...';
	//document.getElementById("p6").style.display = "none";
	
	var callstatus = document.getElementById("callStatus").value;
	var wait = 5000;
	if(callstatus == "invite"){
		wait = 300;
	}
	
	$.ajax({
	    url:"contact.do",
	    type:"POST",
        data: "action=call&number="+number,
	    error:function(response){
	      //alert("error");
	      document.getElementById("progressbar").style.display = "none";
	  	  $("#cover").fadeOut(100);
	  	  spinner.stop();
	    },
	    success:function(response){
	      //alert("success");
	        concalluuid = response;
	    	setTimeout("hideProgressbar('" + number + "','" + calleename + "','" + pic + "')",wait);
	    },
	  });
}
var timer;
function call(number,userPhone,calleename,pic){
	usernumber = userPhone;
	
	var callstatus = document.getElementById("callStatus").value;
	
	if(callstatus != "invite"){
		var target = document.getElementById("p3");
		document.getElementById("p2-1").innerText = '雲端接線生立即幫您接通';
		var showtext = calleename+'('+number.toString()+')';
		if(calleename > 9){
			showtext = calleename;
		}
		document.getElementById("p2-2").innerText = showtext;
		//document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone;
		document.getElementById("p4").innerText = '您的電話即將響鈴，請放心接聽';
		spinner = new Spinner(opts).spin(target);
		$("#cover").fadeIn(100);
		document.getElementById("progressbar").style.display = "block";
		//document.getElementById("p6").style.display = "block";
		timer = setTimeout("changeText('" + number + "','" + userPhone + "','" + calleename + "','" + pic + "')", 300);
	}else{
		timer = setTimeout("changeText('" + number + "','" + userPhone + "','" + calleename + "','" + pic + "')", 0);
	}
	
	
}
function callbyimg(mobile, office,userPhone,calleename,pic){
	usernumber = userPhone;
	var number;
	if(mobile == "" | mobile == null){
		number = office;
	}else{
		number = mobile;
	}
	

	var callstatus = document.getElementById("callStatus").value;
	
	if(callstatus != "invite"){
		var target = document.getElementById("p3");
		document.getElementById("p2-1").innerText = '雲端接線生立即幫您接通';
		var showtext = calleename+'('+number.toString()+')';
		if(calleename > 9){
			showtext = calleename;
		}
		document.getElementById("p2-2").innerText = showtext;
		//document.getElementById("p4").innerText = '透過您的電話 : ' + userPhone;
		document.getElementById("p4").innerText = '您的電話即將響鈴，請放心接聽';
		spinner = new Spinner(opts).spin(target);
		$("#cover").fadeIn(100);
		document.getElementById("progressbar").style.display = "block";
		//document.getElementById("p6").style.display = "block";
		timer = setTimeout("changeText('" + number + "','" + userPhone + "','" + calleename + "','" + pic + "')", 300);
	}else{
		timer = setTimeout("changeText('" + number + "','" + userPhone + "','" + calleename + "','" + pic + "')", 0);
	}
}
function cancelCall(){
	var text1 = document.getElementById("p2").innerText;
	var callee = text1.substring(11);
	clearTimeout(timer);
	setTimeout("hideProgressbar2()",2000);
}
function kickMember(number){
	var tmp = "wrapper-text-" + number;
	var innerH = document.getElementById(tmp).innerHTML;
	if(innerH == "會議中" | innerH == "撥號中"){
		$.ajax({
		    url:"contact.do",
		    type:"POST",
	        data: "action=kickMemberToMeeting&number="+number,
		    error:function(response){
		      //alert("error");
		    },
		    success:function(response){
		      //alert("success");
		    	var tmp = "div_" + number;
		    	var childdiv = document.getElementById(tmp);
		    	var parentdiv = document.getElementById("wrapper-content");
		  		parentdiv.removeChild(childdiv);
		    },
		  });
	}else{
		var tmp = "div_" + number;
    	var childdiv = document.getElementById(tmp);
    	var parentdiv = document.getElementById("wrapper-content");
  		parentdiv.removeChild(childdiv);
	}	
}
function recall(number){
	$.ajax({
	    url:"contact.do",
	    type:"POST",
        data: "action=inviteMemberToMeeting&number="+number,
	    error:function(response){
	      //alert("error");
	    },
	    success:function(response){
	      //alert("success");
	    	var tmp = "wrapper-text-" + number;
	    	document.getElementById(tmp).style.color = "#0000ff";
  		  	document.getElementById(tmp).innerHTML = "撥號中";
	    },
	  });
}
function meetingTerminate(){
	var tmp = "確定要結束此次會議嗎?";
	alertify.set({ labels : { ok: "確定", cancel: "取消" } });
	alertify.confirm(tmp, function (e) {
		if(e){
			document.getElementById("meetingroom").style.display = "none";
			$( "#close-btn" ).trigger( "click" );
			$.ajax({
			    url:"contact.do",
			    type:"POST",
		        data: "action=meetingTerminate&conuuid="+concalluuid,
			    error:function(response){
			      //alert("error");
			    },
			    success:function(response){
			      //alert("success");
			    	
			    },
			  });
		}
	});
}
function changeCallStatus(){
	document.getElementById("callStatus").value = "invite";
	$( "#close-btn" ).trigger( "click" );
	document.getElementById("meetingroom").style.display = "block";
}
function openMeetingRoom(){
	$( "#clicker" ).trigger( "click" );
	document.getElementById("meetingroom").style.display = "none";
}
function setcookie(){
	var date = new Date();
	var minutes = 30;
	date.setTime(date.getTime() + (minutes * 60 * 1000));
	$.cookie("expiretime", "30", { expires: date });
}
</script>
</head>
<body">
	<div id="popup-wrapper">
		<a href="#" onclick="meetingTerminate()"><img class="wrapper-close" src="img/web/close.png"></a>
		<div id="wrapper-top">
			<div id="wrapper-top-left">
				<a href="#" onclick="changeCallStatus()"><img src="img/web/invite.png" width="38px" height="38px"></a>
			</div>
			<div id="wrapper-top-mid"><p class="popuptitle">多方通話會議</p></div>
			<div id="wrapper-top-right">
			</div>
		</div>
		<hr>
		<div id="wrapper-content">
		</div>
		<div id="close-btn"></div>
	</div>
	<div id="clicker"></div>
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
				<%=userPhone %>
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
			聯絡人清單
		</div>
		<div class="contact-list">
			<form name="contactForm" id="contactForm" method="post" action="default.do">
	<table width="100%" >
		<tr>
		<td width="56%" align="right">
			<!-- 
			<a href="NewContact1.jsp" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="新增聯絡人"><i class="icon-plus"></i></a>
			<a href="contact.do?action=editMode" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="編輯聯絡人"><i class="icon-pencil"></i></a>
			 -->
			<a href="NewContact1.jsp" data-toggle="tooltip" data-placement="bottom" title="新增聯絡人"><img src="img/web/plus1.png" style="border:1px solid"></a>
			&nbsp;
			<a href="contact.do?action=editMode" data-toggle="tooltip" data-placement="bottom" title="編輯聯絡人"><img src="img/web/edit1.png" style="border:1px solid"></a>
		</td>
		<td width="16%">
			<a href="javascript:return false" class="btn btn-primary" id="meetingroom" style="display:none;" onclick="openMeetingRoom()">開啟會議室</a>
		</td>
		<td width="28%" align="right">
			<!-- 
			<a href="NewContact1.jsp"><img src="img/web/new_contact.png" class="newContact"></a>
			 -->
		</td>
		</tr>
		<tr><td colspan="3">
		<ul id="items">
	<%
		if(request.getAttribute("contactList") != null){
			WebContact[] contactList = (WebContact[])request.getAttribute("contactList");
			for(int i = 0; i < contactList.length; i++){
	%>
					<li class="list">
                    <div class="radius">
                    	<div class="div_outer">
                    		<div class="div_img">
                    			<a href="#" rel="tooltip" onclick="callbyimg('<%=contactList[i].getMobilePhone() %>','<%=contactList[i].getOfficePhone() %>','<%=userPhone %>','<%=contactList[i].getName() %>','<%=contactList[i].getPic() %>')" title="撥號"><img class="img_person"
                    			<% if("No".equals(contactList[i].getPic()) | "".equals(contactList[i].getPic()) | null == contactList[i].getPic()){ %> 
                    				src="img/web/default_user.png" />
                    			<% }else{ %>
                    				src="img/<%=contactList[i].getPic() %>" />
                    			<% } %>
                    			</a>
                    		</div>
                    		<div class="div_phone">
                    			<div class="div_phone_inner">
                    			<% if("#".equals(contactList[i].getOfficePhone())) { %>
                    				<a href="#" class="btn btn-block">
                    			<% }else if(contactList[i].getOfficePhone().startsWith("9") && contactList[i].getOfficePhone().length()<10){ %>
                    				<a href="#" class="btn btn-custom btn-block" onclick="call('<%=contactList[i].getOfficePhone() %>','<%=userPhone %>','<%=contactList[i].getName() %>','<%=contactList[i].getPic() %>')" data-toggle="tooltip" data-placement="bottom" title="撥打免費分機">
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block btn-ht" onclick="call('<%=contactList[i].getOfficePhone() %>','<%=userPhone %>','<%=contactList[i].getName() %>','<%=contactList[i].getPic() %>')" data-toggle="tooltip" data-placement="bottom" title="撥打付費分機">
                    			<% } %>
                    				<img src="img/contact.png" width="14px" height="14px"><br><%=contactList[i].getOfficePhone() %>
                    				</a>
                    			</div>
                    			<div class="div_phone_inner">
                    			<% if(contactList[i].getMVPN()){ %>
                    				<a href="#" class="btn btn-custom btn-block" onclick="call('<%=contactList[i].getMobilePhone() %>','<%=userPhone %>','<%=contactList[i].getName() %>','<%=contactList[i].getPic() %>')" data-toggle="tooltip" data-placement="bottom" title="撥打免費手機">
                    			<% }else if("#".equals(contactList[i].getMobilePhone())){ %>
                    				<a href="#" class="btn btn-block">
                    			<% }else{ %>
                    				<a href="#" class="btn btn-block btn-ht" onclick="call('<%=contactList[i].getMobilePhone() %>','<%=userPhone %>','<%=contactList[i].getName() %>','<%=contactList[i].getPic() %>')" data-toggle="tooltip" data-placement="bottom" title="撥打付費手機">
                    			<% } %>
                    				<img src="img/phone.png" width="14px" height="14px"><br>
                    				<%
                    					if(contactList[i].getMobilePhone().length() > 12){
                    				%>
                    				<font size="1"><%=contactList[i].getMobilePhone() %></font>
                    				<%
                    					}else{
                    				%>
                    				<%=contactList[i].getMobilePhone() %>
                    				<%
                    					}
                    				%>
                    				</a>
                    			</div>
                    		</div>
                    	</div>
                    	<div class="div_title">
                    		<strong><%=contactList[i].getName() %></strong>&nbsp;
							<input type="hidden" name="order" value="<%=contactList[i].getOrder() %>"/>
							<input type="hidden" name="uuidAry" value="<%=contactList[i].getUUID() %>"/>
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
	<input type="hidden" name="concalluuid" id="concalluuid" value=""/>
	<input type="hidden" name="callStatus" id="callStatus" value=""/>
	</td></tr>
	</table>
</form>
		
		</div>
	</div>
</body>
</html>