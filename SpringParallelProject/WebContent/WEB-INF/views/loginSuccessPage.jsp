<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table align="center">
		<tr>
			<td>Welcome:${customer.name}</td>
		</tr>
	</table>
	<table align="center">
		<tr align="center">
			<td align="center">Menu
		</tr>
		<tr>
			<td align="center"><a href="deposit">Deposit Amount</a>
		</tr>
		<tr>
			<td align="center"><a href="withdraw">Withdraw Amount</a>
		</tr>
		<tr>
			<td align="center"><a href="transferFund">Fund Transfer</a>
		</tr>
		<tr>
			<td align="center"><a href="transactions">Show Transactions</a>
		</tr>
		<tr>
			<td align="center"><a href="lowbalancecustomers">Below 1000 Balance</a>
		</tr>
		<tr>
			<td align="center"><a href="allcustomers">All Customers</a>
		</tr>
		<tr>
			<td align="center"><a href="logout">LogOut</a>
		</tr>
	</table>
</body>
</html>