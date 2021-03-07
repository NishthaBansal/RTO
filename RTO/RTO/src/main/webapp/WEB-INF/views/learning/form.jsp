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
<title>Learning License Form</title>
</head>
<body>

	<%--step 2 of data binding using form tag lib --%>
	<form:form method="post" modelAttribute="learningLicence">
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
				<td>Enter Aadhar No</td>
				<td><form:input path="aadharNo" /></td>
				<td><form:errors path="aadharNo" /></td>
			</tr>

			<tr>
				<td>Enter Mobile No</td>
				<td><form:input path="mobileNo" /></td>
				<td><form:errors path="mobileNo" /></td>
			</tr>

			<tr>
				<td>Choose Birth Date</td>
				<td><form:input type="date" path="dob" /></td>
			</tr>

			<tr>
				<td>Enter Gender</td>
				<td><form:input path="gender" /></td>
				<td><form:errors path="gender" /></td>
			</tr>

			<tr>
				<td>Enter Blood Group</td>
				<td><form:input path="bloodGroup" /></td>
				<td><form:errors path="bloodGroup" /></td>
			</tr>

			<tr>
				<td>Enter Identification Mark</td>
				<td><form:input path="identificationMark" /></td>
				<td><form:errors path="identificationMark" /></td>
			</tr>

			<tr>
				<td>Enter state</td>
				<td><form:input path="state" /></td>
				<td><form:errors path="state" /></td>
			</tr>

			<tr>
				<td>Enter district</td>
				<td><form:input path="district" /></td>
				<td><form:errors path="district" /></td>
			</tr>
			<tr>
				<td>Enter Pin code</td>
				<td><form:input path="pincode" /></td>
				<td><form:errors path="pincode" /></td>
			</tr>

			<tr>
				<td>Enter village</td>
				<td><form:input path="village" /></td>
				<td><form:errors path="village" /></td>
			</tr>

			<tr>
				<td>Enter landmark</td>
				<td><form:input path="landmark" /></td>
				<td><form:errors path="landmark" /></td>
			</tr>

			<tr>
				<td>Enter street</td>
				<td><form:input path="street" /></td>
				<td><form:errors path="street" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Book Your Test Slot" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>