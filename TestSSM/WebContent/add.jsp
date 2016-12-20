<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="add.do" method="post">
<table border="1">	
	<tr>
		<td colspan="2">添加用户信息</td>
	</tr>
	<tr>
		<td>name:</td>
		<td><input type="text" name="name"/></td>
	</tr>
	<tr>
		<td>pwd:</td>
		<td><input type="text" name="pwd"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="提交"/>
			<input type="reset" value="重置"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>