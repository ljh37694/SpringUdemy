<%@ include file="common/header.jspf" %>

<div class="container">
	<%@ include file="common/navigation.jspf" %>
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

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd',
	});
</script>