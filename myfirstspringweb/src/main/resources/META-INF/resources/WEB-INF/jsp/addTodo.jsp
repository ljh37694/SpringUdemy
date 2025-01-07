<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>add todo</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
		<link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<h1>Enter Todo Detail</h1>
			
			<form:form method="POST" modelAttribute="todo">
				<div class="d-flex flex-column align-items-start">
					<fieldset class="mt-2">
						<form:label path="description" class="me-2 mb-0">Description</form:label>
						<form:input path="description" type="text" name="description" class="me-2" required="required" />
						<form:errors cssClass="ms-2 text-danger" path="description" />
					</fieldset>
					
					<fieldset class="mt-2">
						<form:label path="targetDate" class="me-2 mb-0">Target Date</form:label>
						<form:input path="targetDate" type="text" name="description" class="me-2" required="required" />
						<form:errors cssClass="ms-2 text-danger" path="targetDate" />
					</fieldset>
					
					<form:input path="id" type="hidden" name="id" />
					<form:input path="done" type="hidden" name="done" />
					<button type="submit" class="btn btn-success mt-2">Submit</button>
				</div>
			</form:form>
		</div>
		
		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
		<script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>
		
		<script type="text/javascript">
			$('#targetDate').datepicker({
			    format: 'yyyy-mm-dd',
			});
		</script>
	</body>
</html>