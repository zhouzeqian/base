<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>freemaker测试</title>
</head>
<body>
 
<h1>${kxll["name"]}  ${kxll.time?string("yyyy-MM-dd HH:mm:ss zzzz")}</h1>
 
<#list kxll.list as week>
	${week}
</#list>
</body>
</html>