<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update.do" method="post">
<table border="1">
	<tr>
		<td>
			id：<input type="text" name="id" value="${user.id }" readonly="readonly"/>
		</td>
	</tr>
	<tr>
		
		<td>
			name：<input type="text" name="name" value="${user.name}"/>
		</td>
	</tr>
	<tr>
		<td>
			pwd:<input type="password" name="pwd" value="${user.pwd}"/>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="修改"/>
			<input type="reset" value="重置"/>
		</td>
	</tr>
	
</table>
</form>
</body>
</html>