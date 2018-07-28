<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit Page</title>
</head>
<body>
	<h3 align="center">Welcome to the Withdraw Page!</h3>
	<hr>
	<table align="center">
		<form:form action="withdrawAmount" method="post">
			<tr>
				<td>Enter Withdraw Amount:</td>
				<td><input type="text" name="amount"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>