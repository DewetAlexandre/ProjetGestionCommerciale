<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>   
 <%@ page isELIgnored="false" %>
 <%@page import="org.dom4j.rule.Action"%>
<%@page import="fr.afpa.model.Produit"%>
<%@page import="fr.afpa.model.Commande_Produit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vos commandes</title>
<%@ include file="/header.jsp" %>
</head>
<body>
	<c:forEach items="${commandes}" var="elem">
		<p>================================================================</p>
		<p><c:out value="Id commande : ${ elem.getIdCommande() }"/></p>
		<p><c:out value="Montant total : ${ elem.getMontant() }"/></p>
		<p>=================
		<p>Liste d'articles :</p>
		<c:forEach items="${elem.getCommande_produitList()}" var="elemCmd">
		
			<p>---------------</p>
			<p><c:out value="Nom produit : ${ elemCmd.getProduit().getLibelle() }"/></p>
			<p><c:out value="Quantité : ${ elemCmd.getQuantite() }"/></p>
		</c:forEach>
		<p>=================
	</c:forEach>
	<form action="ConnexionServlet" method="post">
		<input type="submit" value="Retour au menu principal">	
	</form>
</body>
</html>