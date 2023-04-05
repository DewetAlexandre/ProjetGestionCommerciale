<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paiement</title>
<%@ include file="/header.jsp" %>
</head>
<body>
	<form action="PaiementServlet" method="post">
		<label>Numéro de carte</label>
		<input type="text" pattern="[0-9]{16}" required>
		<label for="start">Date d'expiration</label>
		<input type="month" id="start" name="start"
       min="2023-05" value="2030-12">
		<label>Code</label>
		<input type="password" pattern="[0-9]{3}" required>
		<input type="submit" value="Valider la commande" required>
	</form>
</body>
</html>