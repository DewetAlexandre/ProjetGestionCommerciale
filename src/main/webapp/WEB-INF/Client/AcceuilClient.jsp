<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>   
 <%@ page isELIgnored="false" %>
 <%@page import="org.dom4j.rule.Action"%>
<%@page import="fr.afpa.model.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil Client</title>
<%@ include file="/header.jsp" %>
</head>
<body>
<c:set var="utilisateur" value="${utilisateurSession}"/>
<p>${ utilisateurSession.getNom() }</p>
<p>${ utilisateurSession.getRole_Utilisateur() }</p>

</body>
</html>