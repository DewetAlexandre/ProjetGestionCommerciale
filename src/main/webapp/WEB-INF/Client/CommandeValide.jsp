<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>   
 <%@ page isELIgnored="false" %>
 <%@page import="org.dom4j.rule.Action"%>
<%@page import="fr.afpa.model.Produit"%>
<%@page import="fr.afpa.model.Commande"%>
<%@page import="fr.afpa.model.Commande_Produit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commande confirmée</title>
<%@ include file="/header.jsp" %>
</head>
<body>
	<p><c:out value="${ commande.getIdCommande() }"/></p>
	<p><c:out value="${ commande.getMontant() }"/></p>
	<p><c:out value="${ commande.getUtilisateur().getNom() }"/></p>
	<p><c:out value="${ commande.getUtilisateur().getPrenom() }"/></p>
	<c:forEach items="${commande.getCommande_produitList()}" var="elem">
	<p>---</p>
		<p><c:out value="${ elem.getProduit().getLibelle() }"/></p>
		<p><c:out value="${ elem.getQuantite() }"/></p>
	</c:forEach>
	
	<form action="ConnexionServlet" method="post">
		<input type="submit" value="Retour au menu principal">	
	</form>
</body>
</html>