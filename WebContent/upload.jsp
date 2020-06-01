<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<form action="/learn_springmvc/upload" method="post" enctype="multipart/form-data">
		用户名：<input type="text" name="username"/><br>
		<input type="file" name="file"/><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>