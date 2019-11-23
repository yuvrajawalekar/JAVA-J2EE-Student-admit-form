<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admit Student</title>
</head>
<body>
	<h3 style="color: red;">${requestScope.fail}</h3>
	<sp:form method="post" modelAttribute="student">
		<table>
			<tr>
				<td>Enter Student Name</td>
				<td><sp:input path="name"/></td>
			</tr>
			<tr>
				<td>Enter Student Address</td>
				<td><sp:input path="address"/></td>
			</tr>
			<tr>
				<td>Enter Student CGPA</td>
				<td><sp:input path="cgpa"/></td>
			</tr>
			<tr>
				<td>Enter Date Of Birth</td>
				<td><sp:input type="date" path="dob"/></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Admit Student"/>
	</sp:form>
</body>
</html>