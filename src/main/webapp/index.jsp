<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>   
 <%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
<title>Index</title>
</head>
<body>
	<div class="">
		<form action="ConnexionServlet" class="" method="get">
			<p>Connexion :</p>
			<div>
				<label>email</label>
				<input type="email" required name="emailConnect">
			</div>
			<div>
				<label>Mot de passe</label><input type="password" required name="passwordConnect">
				<input type="submit" value="Se connecter">
			</div>
		</form>
		
		<form action="InscriptionServlet" class ="" method="post">
			<p>Inscription :</p>
			<div>
				<label>email</label>
				<input type="email" required name="emailInscript">
			</div>
			<div>
				<label>Mot de passe</label>
				<input type="password" required name="mdpInscript">
			</div>
			<div>
				<label>Nom</label>
				<input type="nom" required name="nomInscript">
			</div>
			<div>
				<label>Prenom</label>
				<input type="prenom" required name="prenomInscript" value="S'inscrire">
			</div>
			<input type="submit">
		</form>
	</div>	
	<form action="CatalogueServlet" class="" method="get">
		<input type="submit" value="Consulter le catalogue">
	</form>
</body>
</html>
