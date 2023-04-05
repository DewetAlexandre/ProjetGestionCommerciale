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
		<p><c:out value="${ elem.getIdCommande() }"/></p>
		<p><c:out value="${ elem.getMontant() }"/></p>
		<p><c:out value="${ elem.getUtilisateur().getNom() }"/></p>
		<p><c:out value="${ elem.getUtilisateur().getPrenom() }"/></p>
		<c:forEach items="${elem.getCommande_produitList()}" var="elemCmd">
		<p>Liste d'articles :</p>
		<p>---</p>
			<p><c:out value="${ elemCmd.getProduit().getLibelle() }"/></p>
			<p><c:out value="${ elemCmd.getQuantite() }"/></p>
		</c:forEach>
		
		<form action="ConnexionServlet" method="post">
			<input type="submit" value="Retour au menu principal">	
		</form>
	</c:forEach>
</body>
</html>