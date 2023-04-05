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
<title>Panier</title>
<%@ include file="/header.jsp" %>
</head>
<body>
	<c:set var="pan" value="${panier}"/>
	<c:set var="ope" value="${oper}"/>
	<c:forEach items="${pan}" var="elem">
	<p>${ elem.toString() }</p>
		<p>${ elem.getProduit().getLibelle() }</p>
		<p>${ elem.getProduit().getPrix() }</p>
		<p>${ elem.getQuantite() }</p>
		
		<form action="PanierServlet" method="post">
			<input type="hidden" value="${pan.indexOf(elem)}" name="elemPanier">
			<input type="hidden" value="${ope[0]}" name="operation">
			<input type="submit" value="+">
		</form>
		<form action="PanierServlet" method="post">
			<input type="hidden" value="${pan.indexOf(elem)}" name="elemPanier">
			<input type="hidden" value="${ope[1]}" name="operation">
			<input type="submit" value="-">
		</form>
		<form action="PanierServlet" method="post">
			<input type="hidden" value="${pan.indexOf(elem)}" name="elemPanier">
			<input type="hidden" value="${ope[2]}" name="operation">
			<input type="submit" value="supprimer">
		</form>
	</c:forEach>
	<form action="PaiementServlet" method="get">
			<input type="submit" value="Valider le panier">
		</form>
</body>
</html>