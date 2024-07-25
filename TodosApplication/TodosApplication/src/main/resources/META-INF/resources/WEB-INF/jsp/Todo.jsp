
<%@ include file="common/header.jspf"%>

<title>Add Todo Page</title>


</head>
<body>
	<%@ include file="common/navigation.jspf"%>

	<h1 style="background-color: maroon; color: white; text-align: center;">Welcome
		to Add Todo Page ${name}</h1>

	<hr>
	<div class="container bg-color-cyan">
		<h2>Enter Tour Todo Details</h2>
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description : </form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date : </form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />
			<input type="Submit" class="btn btn-success">
		</form:form>
	</div>

	<script>
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>
	
	<%@ include file="common/footer.jspf"%>
	