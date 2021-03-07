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
<h5 align="center" style="color: blue; font-family: Calibri" hidden=true>${sessionScope.status}</h5>
	<form:form method="post" modelAttribute="appointment">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Created At</td>
				<td><form:input path="createdAt" /></td>
				<td><form:errors path="createdAt" /></td>
			</tr>
			<tr>
				<td>Test Date: </td>
				<td><form:input type="date" path="appointmentDate" /></td>
				<td><form:errors path="appointmentDate" /></td>
			</tr>

			<tr>
				<td>Test Time</td>
				<td><form:input type="time" path="appointmentTime" /></td>
				<td><form:errors path="appointmentTime" /></td>
			</tr>

			<tr>
				<td>Slot Status</td>
				<td><form:input path="appointmentStatus" /></td>
				<td><form:errors path="appointmentStatus" /></td>
			</tr>
			<tr>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>