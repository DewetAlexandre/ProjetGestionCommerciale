<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>   
 <%@ page isELIgnored="false" %>
 <%@page import="org.dom4j.rule.Action"%>
<%@page import="fr.afpa.model.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Acceuil Admin</title>
</head>
<body>
<c:set var="toto" value="${utilisateurSession}"/>
<p>${ toto.getNom() }</p>
<p>${ utilisateurSession.getNom() }</p>
<p>${ utilisateurSession.getRole_Utilisateur().getIdRole() }</p>
</body>
</html>