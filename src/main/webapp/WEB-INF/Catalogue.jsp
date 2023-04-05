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
<title>Catalogue</title>
</head>
<body>
	<c:forEach items="${ listProduit }" var="element">
		<c:out value="${element.getLibelle() }" />
		<c:out value="${element.getPrix() }" />
	</c:forEach>
</body>
</html>
