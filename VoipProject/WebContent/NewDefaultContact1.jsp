<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,util.Nation,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, talk.calling.service.xsd.NationalCode, util.Utility "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增預設聯絡人</title>
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
.content1{
	padding:30px 0 0 160px;
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
.content-img{
	float:left;
	width:20%;
	border:1px solid #611987;
}
.content-form{
	float:right;
	width:28%;
	padding:0px 0px 0 20px;
}
.content-btn{
	float:right;
	width:50%;
	padding:0px 0px 0 0;
}
.content-search{
	padding:20px 50px 0 0;
}
.content-search-text{
	padding:27px 50px 0 0;
}
.content-search-result{
	height:100px;
	padding:20px 50px 0 0px;
}
.content-office{
	padding:0px 0px 20px 0px;
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
<script src="http://www.google.com/jsapi?key=ABQIAAAAr19Eul_kZsYCBnyMjSJbPhSS8zuUzs-phHbAd9SKTtjFtv728xQ8NcR0mWFbQ0Ita4R2Wzc7rTuWUQ" type="text/javascript"></script>

    <script type="text/javascript">
     
    google.load("search", "1", {"nocss" : true});
    
    // function will bind event to all images
    function bind_event(){
        $("a.gs-image").bind("click", function(e){
          $("#imageContainer").html('<img src="' + $(this).attr('href') + '" alt="Loading Image..." />');

          $("a.gs-image img").removeClass();
          $("a.gs-image img").addClass("gs-image");
          $(this).find("img").removeClass();
          $(this).find("img").addClass("selectImage");
          
          imgurl = $(this).find("img").attr('src');
          imgtitle = $(this).find("img").attr('title');
          document.getElementById("imgUrl").value = imgurl;
          document.getElementById("imgTitle").value = imgTitle;
          //alert("img url = " + imgurl);
          return false;
          
          //if($(".gs-imageResult").length <= 0){
          //    $("#gsearchErr").css("display","block");
          //}else{
          //    $("#gsearchErr").css("display","none");
          //}          

          //return false;
        });
        
        $("div.gsc-cursor").prepend("<div class='clear' style='margin-top:10px;clear:both;'></div>");
        
        $(".gsc-trailing-more-results").css("display","none");
        
    }

     // the se class encapsulates a left and right search control
    // both controls are driven by a shared search form
    function OnLoad() {
        var cname = document.getElementById("cname").value;
        // create a tabbed mode search control
        var tabbed = new google.search.SearchControl();        
        
        //restrict results: search only moderated
        //tabbed.setRestriction(google.search.RESTRICT_SAFESEARCH, google.search.SAFESEARCH_STRICT);
        
        // Set the Search Control to get the most number of results
        tabbed.setResultSetSize(google.search.Search.LARGE_RESULTSET);
        
        // create image searchers.
        tabbed.addSearcher(new google.search.ImageSearch());
        
        // proprofscc: On search completeion
        tabbed.setSearchCompleteCallback(this, bind_event);
        
        // draw in tabbed layout mode
        var drawOptions = new google.search.DrawOptions();
        drawOptions.setDrawMode(google.search.SearchControl.DRAW_MODE_TABBED);
        
        // Draw the tabbed view in the content div
        tabbed.draw(document.getElementById("imgSearchControl"), drawOptions);
        
        // Search!
        tabbed.execute(cname);
    }
    
    google.setOnLoadCallback(OnLoad);
    
    </script>
    <style type="text/css">
        
        body{color:#888;}
        
        .search-control {
            width : auto;
            font-size:0.9em;
            color:#777;
        }
        
/*---- Override existing Google Image Search Layout----------- **/
        .gs-text-box, .gsc-tabhActive, .gs-watermark, .gsc-branding, .gsc-twiddle, .gsc-stats, .gsc-results-selector, .gsc-all-results-active{display:none;}
        
        /*-----Search Box---*/
        .gsc-input input{font-size: 1.56em; width: 300px; padding:6px 5px 6px 5px; margin-top: 5px; color:#aaa; border:2px solid #ccc; -moz-border-radius:4px; -webkit-border-radius:4px;}
        input.gsc-search-button, .ui-widget button{font-size: 2.1em; margin: 5px 0 0 5px;}
        
        /*-----Image ---*/
        img.gs-image{float:left; margin:10px 10px 20px 0px; width:90px; height:80px; border:1px solid #fff; padding:1px; -moz-border-radius:4px; -webkit-border-radius:4px;}
        img.gs-image:hover{border:1px solid red;}
        img.selectImage{float:left; margin:10px 10px 20px 0px; width:90px; height:80px; border:1px solid red; padding:1px; -moz-border-radius:4px; -webkit-border-radius:4px;}

        /*--Paging---**/
        .gsc-cursor-page{float:left; text-shadow: 1px 1px 1px #fff; cursor: pointer; margin: 0px 8px 10px 0px; padding: 3px 7px 3px 7px; background: #ddd; color:#000; border:1px solid #999; -moz-border-radius:2px; -webkit-border-radius:2px;}
        .gsc-cursor-page:hover{ background: #fff; color:#333;}
        .gsc-cursor-current-page{background: #fff; color:#333;}
        
        /****Demo Page Formatting****/
        .clear{clear: both;}
        
        /**** Result Image ****/
        #imageContainer img{padding:1px; border:1px solid #ddd; width: auto; height: auto;}                      
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
      						<!-- <li><a href="NewContact.jsp"><span class="nav-mycolor">新增聯絡人</span></a></li> -->
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
			新增預設聯絡人
		</div>
		<div class="content1">
			<form id="contactForm" class="bs-docs-example form-horizontal" method="post" action="default.do" enctype="multipart/form-data">
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
				<div class="content-search-text">
					<!-- Search Image - <small>powered by 
					<img class="gsc-branding-img" style="vertical-align:middle" src="http://www.google.com/uds/css/small-logo.png" />
					</small> -->
				</div>
				<div class="content-search">
					<!-- <button class="btn btn-default" type="button" onclick="OnLoad()">搜尋圖片</button> -->
				</div>
				<!-- <div id="imgSearchControl" class="search-control">Loading...</div> -->
    
    			<!--Remove all floating-->

    			<div class="clear"></div>
    
    			<!--Image will be shown here-->
				<div id="imageContainer"></div>
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
            		List<Nation> nation= (List<Nation>)session.getAttribute("nation");
            		for(Nation one :nation){
            			if("台灣TAIWAN".equals(one.getNation())){
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
            	<div class="content-btn-btn">
            		<a href="#" onclick="formsubmit()"><img src="img/web/save_btn.png" width="70px" height="70px"></a>            			
            	</div>
			</div>
			<input type="hidden" name="action" id="action" value="insertDefaultContact"/>
        	<input type="hidden" name="imgUrl" id="imgUrl" value=""/>
        	<input type="hidden" name="imgTitle" id="imgTitle" value=""/>
		</form>
		</div>
	</div>
</body>
</html>