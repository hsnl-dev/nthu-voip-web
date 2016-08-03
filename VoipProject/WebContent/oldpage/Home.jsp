<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- for IE 8 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>首頁</title>

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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<!-- backgroud size cover -->
<!-- <script type="text/javascript" src="js/jquery.backgroundSize.js"></script> -->
<!-- main css -->
<link href="css/main.css" rel="stylesheet">

<style type="text/css">
	.section1{
		margin:50px 120px;
		height:400px;
		background-color:white;
		border: 1px solid #CCC;
		moz-box-shadow: 1px 1px 2px 2px #DDD; /* Firefox */
		-webkit-box-shadow: 1px 1px 2px 2px #DDD; /* Safari 和 Chrome */
		box-shadow: 1px 1px 2px 2px #DDD; /* Opera 10.5 + */
	}
	.sec1_text{
		float:left;
		width:50%;
		height:400px;
	}
	.sec1_text p {
		font: 16px "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
		padding:10px 0 0 10px;
	}
	.sec1_login{
		float:right;
		width:40%;
		padding:20px 0 0 10px;
		margin: 0px auto;
	}
	.sec1_login div{
		width:250px;
		padding:10px 0 0 0;
	}
</style>
<%
	String status = (String)request.getAttribute("status");
%>
<script type="text/javascript">
//$("#navbar-minestyle").css("backgroundSize", "cover");
function check(){
	if("<%=status%>" == "failed"){
		alert("帳號或密碼有誤，請重新輸入!");
	}else if("<%=status%>" == "nouser"){
		alert("無此帳號或帳號審核中!");
	}else if("<%=status%>" == "error"){
		alert("登入失敗!");
	}else if("<%=status%>" == "register"){
		alert("帳號申請已送出，請等待審核，謝謝!");
	}else if("<%=status%>" == "verifysuccess"){
		alert("帳號驗證通過，歡迎使用網頁撥號系統!");
	}else if("<%=status%>" == "verifyfail"){
		alert("帳號驗證失敗，請重新驗證!");
	}
}

function checkForm(thisForm){
	if(thisForm.userphone.value == ""){
		alert("請輸入分機號碼!");
		thisForm.userphone.focus();
		return false;
	}
	if(thisForm.inputPassword.value == ""){
		alert("請輸入密碼!");
		thisForm.inputPassword.focus();
		return false;
	}
}
</script>
</head>
<body onload="check()">
	<div class="header">
	<nav class="navbar navbar-minestyle navbar-fixed-top" role="navigation">
  		<!-- Brand and toggle get grouped for better mobile display -->
  		<div class="navbar-header">
    		<a class="navbar-brand" href="Home.jsp"><img src="img/6talk_logo.png"></a>
    	</div>
    	<div id="content">
        	
    	</div>
	</nav>
	</div>
	<div class="content">
		<div class="leftsection">
			
		</div>
		<div class="rightsection">
			
		</div>
		<div class="section1">
			<div class="sec1_text">
				<h2>網頁撥號系統</h2>
				<ul><p>系統特色</p>
					<li><p>分機免費撥打中華電信、遠傳及台灣大哥大等電信業者之MVPN群組行動電話</p></li>
					<li><p>方便簡單的撥號方式，使打電話更加輕鬆。</p></li>
					<li><p>輕鬆匯入單位常用預設聯絡人，拉動頭像可輕易的編輯排列順序，讓所有重要的聯絡人都擺在最上面。</p></li>
					<li><p>使用分機無電磁波對人體的危害。</p></li>
				</ul>
			</div>	
			<div class="sec1_login">
				<h2><span class="label label-success">帳號登入</span></h2>
				<form id="webForm" class="bs-docs-example form-horizontal" method="post" action="login.do" onsubmit="return checkForm(this)">
            		<div class="input-group-sm">
              			分機號碼:&nbsp;
                		<input type="text" class="form-control input-lg" id="userphone" name="userphone" placeholder="請輸入930+分機號碼">
            		</div>
            		<div class="input-group-sm">
              			密碼:&nbsp;              
                		<input type="password" class="form-control input-lg" id="inputPassword" name="inputPassword" placeholder="請輸入密碼">
            		</div>
            		<div class="control-group">
                		<button type="submit" class="btn btn-primary">登入</button>
                		<a href="Home.jsp" class="btn btn-default" >取消</a>
           			</div>
           			<input type="hidden" id="action" name="action" value="login">
          		</form>
          		<div>
          			<a href="applicationform.html"><img src="img/right-arrow.png">&nbsp;申請單位管理者帳號</a>
          		</div>
			</div>	
		</div>
	</div>
</body>
</html>