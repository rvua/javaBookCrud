<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
	<a href="/newExpense">New Expense</a>
	<a href="/editExpense">Edit Expense</a>
	<a href="/oneExpense">One Expense</a>
	<a href="/dashboard">Dashboard</a>
	<div class="container">
		<h1>One Expense</h1>
		<h4>
			<c:out value="${expense.name}"></c:out>
		</h4>
		
		<br>
		
		<h3>Vendor</h3>
		<p>
			<c:out value="${expense.vendor}"></c:out>
		</p>
		
		<br>
		
		<h3>Amount</h3>
		<p>
			<c:out value="${expense.amount}"></c:out>
		</p>
		
		<br>
		
		<h3>Description</h3>
		<p>
			<c:out value="${expense.description}"></c:out>
		</p>
	</div>
</body>
</html>