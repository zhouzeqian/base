<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>WebSocket示例</title>
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<script type="text/javascript">
	function getName() {
	
		if ($("#uid").val() == 1)
			$("#username").val("张三");
		if ($("#uid").val() == 2)
			$("#username").val("李四");
		if ($("#uid").val() == 3)
			$("#username").val("王五");
	}
</script>
<body>
	<form action="websocket/login" method="post">
		用户名: <select name="id" id="uid" onchange="getName()">
			<option value="1">张三</option>
			<option value="2">李四</option>
			<option value="3">王五</option>
		</select><br> 
		姓名: <input name="name" id="username" type="text"><br>
		密码: <input name="password" type="text" value="123456"> <br> 
		<input type="submit" value="登录">
	</form>
</body>

</html>
