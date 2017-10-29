<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext['request'].contextPath}"/>


<!doctype html>

<html lang="en">
<head>
	<meta charset="utf-8">
	<title>MyBabyApp/Inscription</title>
	<meta name="description" content="Connection page of Mababyapp">
	<link rel="stylesheet" href="css/styles.css?v=1.0">
</head>

<body>

<h1>Inscription</h1>

<h1>Welcome home</h1>

login : <p>${userLogin}</p>
name : <p>${userName}</p>
first name : <p>${userFisrtName}</p>
baby's sexe : <p>${sexe}</p>

<c:url var="logoutUrl" value="/logout"/>
<form:form action="${logoutUrl}"
		   method="post">
	<input type="submit"
		   value="Log out"/>
	<input type="hidden"
		   name="${_csrf.parameterName}"
		   value="${_csrf.token}"/>
</form:form>

</body>
</html>
