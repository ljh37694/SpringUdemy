<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>add todo</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<h1>Enter Todo Detail</h1>
			
			<form:form method="POST" modelAttribute="todo">
				<div class="d-flex">
					<p class="me-2">Description: </p>
					<form:input path="description" type="text" name="description" class="me-2" required="required" />
					<form:input path="id" type="hidden" name="id" />
					<form:input path="done" type="hidden" name="done" />
					<button type="submit" class="btn btn-success">Add</button>
				</div>
			</form:form>
		</div>
		
		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	</body>
</html>