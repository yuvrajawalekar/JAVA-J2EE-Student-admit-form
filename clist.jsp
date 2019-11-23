<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center" style="color: green;">${requestScope.done}</h3>
	<h3 align="center" style="color: red;">${requestScope.delmsg}</h3>
	<h3 align="center" style="color: red;">${requestScope.fail}</h3>
	<h2 align="center">Course List</h2>
	<table style="font-size: large; margin: auto;" border="1">
		<thead>
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>ADMIT</td>
				<td>DELETE</td>
			</tr>
		</thead>
		<c:forEach var="v" items="${sessionScope.clist}">
			<tr>
				<td>${v.id}</td>
				<td>${v.cname}</td>
				<td><a href="<spring:url value='/course/form?cid=${v.id}'/>">ADMIT</a></td>
				<td><a href="<spring:url value='/course/del?cid=${v.id}'/>">DELETE</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>