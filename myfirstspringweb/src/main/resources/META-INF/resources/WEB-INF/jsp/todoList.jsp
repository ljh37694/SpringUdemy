<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>todo</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<h1 class="mt-3">User: ${name}</h1>
		
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todoList}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Edit</a></td>
							<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">X</a></td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add Todo</a>	
		</div>

		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	</body>
</html>