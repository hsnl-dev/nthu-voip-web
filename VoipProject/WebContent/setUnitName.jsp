<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>設定單位名稱</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

<!-- main css -->
<link href="css/main.css" rel="stylesheet">

<style type="text/css">
	.section1{
		margin:50px 120px;
		height:600px;
		background-color:white;
		border: 1px solid #CCC;
		moz-box-shadow: 1px 1px 2px 2px #DDD; /* Firefox */
		-webkit-box-shadow: 1px 1px 2px 2px #DDD; /* Safari 和 Chrome */
		box-shadow: 1px 1px 2px 2px #DDD; /* Opera 10.5 + */
	}
	.sec1_text{
		width:100%;
		height:600px;
		margin:0px auto;
		padding:10px 35% 0 35%;
	}
	.sec1_text p {
		font: 16px "微軟正黑體","Lucida Grande","Lucida Sans Unicode",Helvetica,Arial,Verdana,sans-serif;
		padding:10px 0 0 10px;
	}
	.sec1_text div{
		padding:10px 0 0 0;
	}
</style>

<script type="text/javascript">
function check(thisForm){
	if(thisForm.depart.value == ""){
		alert("請輸入單位名稱");
		thisForm.depart.focus();
		return false;
	}else{
		var r=confirm("單位名稱確定?");
		if (r==true){
			alert("已設定單位名稱!");
		}else{
			return false;
		}
	}
	
}
</script>

</head>
<body>
	<div class="header">
	<nav class="navbar navbar-minestyle navbar-fixed-top" role="navigation">
  		<!-- Brand and toggle get grouped for better mobile display -->
  		<div class="navbar-header">
    		<a class="navbar-brand" href="home.html"><img src="img/6talk_logo.png"></a>
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
				<h2><span class="label label-success">請設定單位名稱</span></h2>
				<form class="bs-docs-example form-horizontal" method="post" onsubmit="return check(this)" action="web.html">
            		<div class="input-group input-group-lg">
              			單位名稱:&nbsp;
                		<input type="text" class="form-control input-lg" id="depart" name="depart" placeholder="請輸入單位名稱" required>
            		</div>
            		<div class="control-group">
                		<button type="submit" class="btn btn-primary">送出</button>
           			</div>
           			<input type="hidden" name="action" value="setUnitName">
          		</form>
			</div>		
		</div>
	</div>
</body>
</html>