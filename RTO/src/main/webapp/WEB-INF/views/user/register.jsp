<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import spring suppiled JSP tag lib for URL rewriting --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--import , for the form binding tech , spring supplied form tag lib  --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--step 2 of data binding using form tag lib --%>
	<form:form method="post" modelAttribute="user">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter First Name</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>

			<tr>
				<td>Enter User Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>

			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			
			

			<tr>
				<td><input type="submit" value="Register New Vendor" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>