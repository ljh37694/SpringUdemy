<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>login page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body>
		<div>
			<p>${errorMessage}</p>
			<form method="POST">
				<input type="text" placeholder="id" name="name" />
				<input type="password" placeholder="password" name="password" />
				<button type="submit">로그인</button>
			</form>
		</div>
		
		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	</body>
</html>