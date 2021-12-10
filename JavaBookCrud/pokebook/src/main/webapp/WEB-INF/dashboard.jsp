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
		<h1>Dashboard</h1>
		
		<table class="table table-dark table-striped table-hover">
			<thead>
				<tr>
					<th class="align-middle">Expense</th>
					<th class="align-middle">Vendor</th>
					<th class="align-middle">Amount</th>
					<th class="align-middle">Description</th>
					<th class="align-middle">Actions</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="i" items="${expenses}">
					<tr>
						<td>
							<a href="/oneExpense/${i.id}">
								<c:out value="${i.name}"></c:out>
							</a>
						</td>
						<td><c:out value="${i.vendor}"></c:out></td>
						<td><c:out value="${i.amount}"></c:out></td>
						<td><c:out value="${i.description}"></c:out></td>
						<td>
							<a href="/editExpense/${i.id}">
								Edit
							</a>
							<a href="/delete/${i.id}">
								Delete
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>