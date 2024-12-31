<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>todo</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
	</head>
	
	<body>
		<h1>User: ${name}</h1>
		
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Targe Date</th>
					<th>Is Done</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todoList}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	</body>
</html>