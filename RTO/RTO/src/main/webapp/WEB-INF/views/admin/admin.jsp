<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Last Action Status : ${requestScope.message}</h5>
	<table style="background-color: cyan; margin: auto;">
		<caption>User List</caption>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Status</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${requestScope.user_list}">
				<tr>
					<td>${u.firstName}</td>
					<td>${u.lastName}</td>
					<td>${u.email}</td>
					<td><a href="<spring:url value='/admin/edit?vid=${u.id}'/>">Edit</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>