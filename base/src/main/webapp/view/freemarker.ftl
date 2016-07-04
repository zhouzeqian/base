<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<table border="1">
	<tr>
	<th>用户ID</th>
	<th>唯一标识符</th>
	<th>用户名</th>
	<th>email</th>
	<th>创建时间</th>
	<th>是否激活</th>
	</tr>
	<#list userList as user>
	<tr>
	<th>${user.id}</th>
	<th>${user.guid}</th>
	<th>${user.username}</th>
	<th>${user.email}</th>
	<th>${user.createTime?string('dd.MM.yyyy HH:mm:ss')}</th>
	<th>${user.archived?c}</th>
	</tr>
	</#list>
</table>
</body>
</html>
