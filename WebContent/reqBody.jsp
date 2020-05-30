<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<form action="/learn_springmvc/reqBody" method="post">
		用户名：<input type="text" name="username"/><br>
		密码：<input type="password" name="password"/><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>