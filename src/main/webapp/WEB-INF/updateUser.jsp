<%@page import="beans.User"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
User utilisateur = (User) request.getAttribute("utilisateur");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modification d'un utilisateur</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="inc/menu.jsp"/>	
	<div class="container d-flex justify-content-center align-items-center vh-100">
		<div class="w-50">
			<h1 id="titre-principal" class="text-center my-4">Modification d'un utilisateur</h1>
			<form method="post">
				<div class="form-group">
					<label for="nom">Nom</label>
					<input type="text" class="form-control" id="nom" name="nom" value="${user.lastName}">
				</div>
				<div class="form-group">
					<label for="prenom">Prenom</label>
					<input type="text" class="form-control" id="prenom" name="prenom" value="${user.firstName}">
				</div>
				<div class="form-group">
					<label for="login">Login</label>
					<input type="text" class="form-control" id="login" name="login" value="${user.login}">
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<input type="password" class="form-control" id="password" name="password" value="${user.password}">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Modifier</button>
				</div>
			</form>
		</div>
	</div>
	<div id="pied" class="text-center mt-4">Copyright DIC3 ESP 2024 &copy; Saliou Samba DIAO</div>
</body>
</html>