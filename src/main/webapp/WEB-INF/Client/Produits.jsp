<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>   
 <%@ page isELIgnored="false" %>
 <%@page import="org.dom4j.rule.Action"%>
<%@page import="fr.afpa.model.Produit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produits</title>
<%@ include file="/header.jsp" %>
</head>
<body>
	<c:forEach items="${ listProduit }" var="element">
		<form action="ProduitsClientServlet" method="post">
			<input type="hidden" name="idProduit" value="${ element.getIdProduit() }">
			<p>${ element.getLibelle() }</p>
			<p>${ element.getPrix() }</p>
			<input type="number" min="1" name="quantite" required>
			<input type="submit" value="Ajouter">
		</form>
	</c:forEach>
</body>
</html>