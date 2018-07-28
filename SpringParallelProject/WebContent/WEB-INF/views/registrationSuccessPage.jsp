<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<h4 align="center">You've been successfully registered....</h4>
	<table align="center">
		<tr>
			<td align="center">Welcome:${customer.name}</td>
		</tr>
		<tr>
			<td align="center">Your registered mobile number is
				${customer.mobileNo}</td>
		</tr>
		<tr>
			<td align="center">Your current balance is
				${customer.wallet.balance}</td>
		</tr>
	</table>
	<table align="center">
		<tr>
			<td><a href="login">Sign In</a></td>
		</tr>
		<tr>
			<td><a href="register">Sign Up</a></td>
		</tr>
	</table>
</body>
</html>