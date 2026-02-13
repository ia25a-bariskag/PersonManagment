<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="controller" method="post">
   		 	<input type="hidden" name="action" value="update"> 
    		<input type="hidden" id="uuid" name="uuid" value="${param.uuid}"><br>
			<label for="firstname"> Gib deinen Vornamen ein:</label>
			<input type="text" id="firstname" name="firstname" value="${param.vorname}"><br>
			<p></p>
			<label for="lastname">Gib deinen Nachnamen ein:</label>
			<input type="text" id="lastname" name="lastname" value="${param.nachname}"><br>
			<p></p>
    		<input type="submit" value="Update">
		</form>
		${error}
		${erfolgreich}
		<p></p>
		<a href="controller">
			<button>Zurück</button>
		</a>
	</body>
</html>