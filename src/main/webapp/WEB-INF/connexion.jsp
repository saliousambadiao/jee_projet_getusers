<%@ page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% final String APP_ROOT = request.getContextPath() ; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion utilisateur</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
	<div class="w-50">
		<fieldset>
			<legend class="text-center my-4">Connexion utilisateur</legend>
			<form method="post" action="login">
				<div class="form-group">
					<label for="login">Login</label>
					<input type="text" class="form-control" id="login" name="login" placeholder="Enter login">
				</div>
				
				<div class="form-group">
					<label for="password">Password</label>
					<input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
				</div>
				
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Connect</button>
				</div>
			</form>
		</fieldset>
		<div id="pied" class="text-center mt-4">Copyright DIC3 ESP 2024 &copy; Saliou Samba DIAO</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
