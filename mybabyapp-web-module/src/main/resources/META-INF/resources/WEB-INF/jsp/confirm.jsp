<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext['request'].contextPath}"/>


<!doctype html>

<html lang="en">
<head>
	<meta charset="utf-8">
	<title>MyBabyApp/Sign up Confirmation</title>
	<meta name="description" content="Connection page of Mababyapp">
	<link rel="stylesheet" href="css/styles.css?v=1.0">
</head>

<body>

<h1>Confirmation</h1>


<p>Merci pour votre inscription !</p>
<p>Votre compte ${user.mail} a correctement été créé !</p>


<%--<script src="js/scripts.js"></script>--%>


</body>
</html>
