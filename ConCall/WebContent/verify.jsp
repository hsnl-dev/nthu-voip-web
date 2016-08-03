<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帳號驗證</title>
<%
String email = request.getParameter("email");
String querystr = request.getQueryString();
String authCode = querystr.split("authCode=")[1];
%>
<script type="text/javascript">
function verify(){
	document.getElementById("email").value = '<%=email %>';
	document.getElementById("authCode").value = '<%=authCode %>';
	document.getElementById("webForm").submit();
}
</script>
</head>
<body onload="verify()">
<form id="webForm" method="post" action="web.html">
	<input type="hidden" id="email" name="email" value="">
	<input type="hidden" id="authCode" name="authCode" value="">
	<input type="hidden" name="action" value="verify">
</form>
</body>
</html>