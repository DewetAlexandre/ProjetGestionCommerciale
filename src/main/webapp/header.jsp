<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>   
 <%@ page isELIgnored="false" %>
 <%@page import="org.dom4j.rule.Action"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
</head>
<body>
		<c:if test="${ utilisateurSession.getRole_Utilisateur().getIdRole() == 1 }">
			<nav class="navbar navbar-expand-lg bg-success ">
				<a class="navbar-brand" href="#">Navbar</a>
			  	<div class="">  
				    <form action="CatalogueServlet" method="get"><input type="submit" value="Catalogue"></form>
				    <form action="ProduitServlet" method="get"><input type="submit" value="Modifier produits"></form>
					<form action="CommandeServlet" method="post"><input type="submit" value="Consulter les commandes des clients"></form>
				    <form action="DeconnectionServlet" method="post"><input type="submit" value="Déconnexion"></form>
			  </div>
			</nav>
		</c:if>
		<c:if test="${ utilisateurSession.getRole_Utilisateur().getIdRole() == 2 }">
			<nav class="navbar navbar-expand-lg bg-success ">
				<a class="navbar-brand" href="#">Navbar</a>
			  	<div class="">  
				    <form action="ProduitsClientServlet" method="get"><input type="submit" value="Ajouter un produit au panier"></form>
				    <form action="PanierServlet" method="get"><input type="submit" value="Panier"></form>
				    <form action="CommandeServlet" method="post"><input type="submit" value="Consulter vos commandes"></form>
				    <form action="DeconnectionServlet" method="post"><input type="submit" value="Déconnexion"></form>
			  </div>
			</nav>
		</c:if>
</body>
</html>