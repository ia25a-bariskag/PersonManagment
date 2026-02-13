<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Person</title>
	</head>
	<body>
		<h1>Person erstellen</h1>
		<form action="controller" method="POST">
			<input type="hidden" name="action" value="insert">
			
			<label for="firstname"> Gib deinen Vornamen ein:</label>
			<input type="text" id="firstname" name="firstname" required><br>
			<p></p>
			<label for="lastname">Gib deinen Nachnamen ein:</label>
			<input type="text" id="lastname" name="lastname" required><br>
			<p></p>
			<input type="submit" value="Erstellen">
		</form>
		<p></p>
		<a href="controller">
			<button>Liste anzeigen</button>
		</a>
	</body>
</html>