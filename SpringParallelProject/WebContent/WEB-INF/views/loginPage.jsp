<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h2 align="center">Welcome to the Login Page!</h2>
	<hr>
	<form:form method="post" action="loginCustomer">
		<table align="center">

			<tr>
				<td>Enter the registered mobile number:
				<td><input type="text" name="mobileNo">
			</tr>
			<tr align="center">
				<td align="center"><input type="submit" value="Submit" />
			</tr>
		</table>
	</form:form>

	<div align="center">
		<font color='red'><c:if test="${not empty errorMessage}">
		${errorMessage }
	</c:if> </font>
	</div>
</body>
</html>