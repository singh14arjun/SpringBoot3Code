
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Todos list</title>
</head>
<body>

	<h1>Welcome to ${name}</h1>
	<div class="container">
	<h1>List Todo page</h1>

	<table style="background-color: magenta" class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>TargetDate</th>
				<th>IsDone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>