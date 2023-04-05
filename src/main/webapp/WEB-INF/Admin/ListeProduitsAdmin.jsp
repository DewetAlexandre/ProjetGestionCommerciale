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
<title>Liste produit admin</title>
<%@ include file="/header.jsp" %>
</head>
<body>
	<form action="ProduitServlet" class="" method="post">
	<label>Libelle : </label>
	<input type="text" name="libelle" required>
	<label>Prix : </label>
	<input type="number" min="1" name="prix" value="1" required>
	<label>Produit : </label>
	<select name="produitId" class="form-control">
		<c:forEach items="${ listProduit }" var="element">
	    	<option value="${ element.getIdProduit() }">${ element.toString()}</option>
	    </c:forEach>
	</select>
	<label>Produit : </label>
	<select name="crudId" class="form-control">
		<option value="1">Modifier</option>
		<option value="2">Créer</option>
		<option value="3">Supprimer</option>
	</form>
	<input type="submit" value="Valider">
</body>
</html>