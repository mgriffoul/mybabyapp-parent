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


<form:form method="POST" action="/inscription/signupuser" commandName="userCreationModel">


	<form:label path="mail">mail</form:label>
	<form:input path="mail"/>


	<form:label path="password">mot de passe</form:label>
	<form:input path="password"/>

	<form:label path="passwordConfirm">Confirmez votre mot de passe</form:label>
	<form:input path="passwordConfirm"/>

	<input type="hidden"
		   name="${_csrf.parameterName}"
		   value="${_csrf.token}"/>

	<input type="submit" value="Submit"/>


	<p>
		<springForm:errors path="*" cssClass="error" cssStyle="color: red"/>
	</p>
</form:form>

<p><a href="/connection">J'ai déjà un compte</a></p>
<%--<script src="js/scripts.js"></script>--%>


</body>
</html>
