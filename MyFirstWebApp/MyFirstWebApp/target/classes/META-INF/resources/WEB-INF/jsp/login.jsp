<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Page</title>
</head>
<body>
	<div class="container">
		<h1>Login Page</h1>
		<pre>${error}</pre>
		<form method="post" autocomplete="off">
			Name :<input type="text" name="name" placeholder="Enter Name ">
			Password :<input type="password" name="password"
				placeholder="Enter Password"> <input type="submit"
				value="SUBMIT">
		</form>
	</div>
</body>
</html>