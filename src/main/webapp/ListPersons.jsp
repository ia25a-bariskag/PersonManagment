<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste von Personen</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" href="list.css" type="text/css">
		
		<script>
			function deleteItem(uuid) {
			    fetch('http://localhost:8080/Personmanagment/controller?uuid=' + uuid, {
			        method: 'DELETE'
			    })
			    .then(response => {
			        if (response.ok) {
			            window.location.reload();
			        } else {
			            console.error("Server returned an error.");
			        }
			    })
			    .catch(error => console.error('Network error:', error));
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div calss="row">
				<div class="col-12">
					<h1>Personen:</h1>
				</div>
				<table class="person-table">
				    <thead>
				        <tr>
				            <th>Vorname</th>
				            <th>Nachname</th>
				            <th>UUID</th>
				            <th>Aktionen</th>
				        </tr>
				    </thead>
    				<tbody>
				        <c:forEach var="item" items="${persons}">
				            <tr>
				                <td>${item.vorname}</td>
				                <td>${item.nachname}</td>
				                <td>${item.uuid}</td>
				                <td>
				                    <button type="button" onclick="deleteItem('${item.uuid}')">
				                        Delete
				                    </button>
				
				                    <form action="http://localhost:8080/Personmanagment/update.jsp" style="display:inline;">
				                        <input type="hidden" name="action" value="update">
				                        <input type="hidden" name="uuid" value="${item.uuid}">
				                        <input type="hidden" name="firstname" value="${item.vorname}">
				                        <input type="hidden" name="lastname" value="${item.nachname}">
				                        <input type="submit" value="Update">
				                    </form>
				                </td>
				            </tr>
				        </c:forEach>
				    </tbody>
				</table>
				<p></p>
				<a href="CreatePerson.jsp">
					<button class="zurueck">Zurück</button>
				</a>
			</div>
		</div>
	</body>
</html>