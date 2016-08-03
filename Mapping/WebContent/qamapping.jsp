<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>常見問題</title>
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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="//code.jquery.com/jquery.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!-- main css -->
<link href="css/main.css" rel="stylesheet">
<style type="text/css">
.section2{
		float:left;
		height:400px;
		width:85%;
		padding:20px 0 0 240px;
		overflow:auto;
		/*border:#585657 ridge 1px;*/
	}
</style>
</head>
<body>
<!-- <img src="img/bg2.jpg" class="bg"> -->
	<div class="header">
		<div class="header-top">
		
		</div>
		<div class="header-bot">
			<div class="header-bot-group">
				<div class="header-bot-home">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="Home.jsp" >首頁</a>
					</div>
				</div>
				<div class="header-bot-qa">
					<div class="header-bot-img">
						<img src="img/sp.png" height="30px" width="30px">
					</div>
					<div class="header-bot-text">
						<a href="qamapping.jsp" >常見問題</a>
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
		<div class="section_text">
			<div class="content-title">
				常見問題
			</div>
		</div>
		<div class="section2">
			<div id="q1" class="panel panel-default">
    			<div class="panel-heading">
      			<h4 class="panel-title">
          			什麼是無網配對通?
      			</h4>
    			</div>
      			<div class="panel-body">
        			利用最新的雲端技術，您只需上網設定配對的門號後，即是在沒有網路無法使用APP的情形下，也可以使用配對門號來撥打電話，享受免費通話。
      			</div>
  			</div>
  			<div id="q2" class="panel panel-default">
    			<div class="panel-heading">
      			<h4 class="panel-title">
          			無網配對通有什麼使用限制?
      			</h4>
    			</div>
      			<div class="panel-body">
        			您必須先加入清華大學MVPN群組，若您尚未加入，請先到<a href="http://cs-mvpn.vm.nthu.edu.tw/service.php"></a>清大MVPN申請網站</a>申請加入清華大學MVPN。
      			</div>
  			</div>
  			<div id="q2" class="panel panel-default">
    			<div class="panel-heading">
      			<h4 class="panel-title">
          			如何開始使用無網配對通?
      			</h4>
    			</div>
      			<div class="panel-body">
        			您必須先到<a href="http://140.114.71.169:8080/Mapping/Home.jsp"></a>無網配對通</a>註冊成為會員，成為會員後登入設定相關的配對門號即可使用。
      			</div>
  			</div>
  			<div id="q3" class="panel panel-default">
    			<div class="panel-heading">
      			<h4 class="panel-title">
          			為什麼撥通配對門號後，通話馬上被掛斷了?
      			</h4>
    			</div>
      			<div class="panel-body">
        			由於配對門號運作機制的關係，您再撥通配對門號後，系統會馬上切斷通話，並且再由雲端回撥電話至您的手機與設定好之聯絡人電話，當您接起電話後即可享有免費通話。
      			</div>
  			</div>
  			<div id="q4" class="panel panel-default">
    			<div class="panel-heading">
      			<h4 class="panel-title">
          			最多能設定幾組配對門號?
      			</h4>
    			</div>
      			<div class="panel-body">
        			目前系統共有7組配對門號可供設定。
      			</div>
  			</div>
		</div>
	</div>
</body>
</html>