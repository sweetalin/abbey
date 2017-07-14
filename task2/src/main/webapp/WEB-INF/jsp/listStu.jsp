<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员显示</title>
</head>
<body>
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>id</td>
			<td>name</td>
		</tr>
		<c:forEach items="${ls}" var="l" varStatus="st">
			<tr>
				<td>${l.id }</td>
				<td>${l.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>