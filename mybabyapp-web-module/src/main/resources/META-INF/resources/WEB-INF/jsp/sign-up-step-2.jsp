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
	<title>MyBabyApp/Inscription suite</title>
	<meta name="description" content="Connection page of Mababyapp">
	<link rel="stylesheet" href="css/styles.css?v=1.0">
</head>

<body>

<p>Plus que quelques informations à entrer pour pouvoir utiliser My Baby-app</p>

<h1>Vos informations</h1>

<form:form method="POST" action="/sign-up/moreuserinfo" commandName="userInformationsModel">

	<br>
	<form:label path="firstName">votre prénom</form:label>
	<form:input path="firstName"/>
	<br>

	<form:label path="lastName">votre nom</form:label>
	<form:input path="lastName"/>

	<br>
	<br>

	<h1>Votre bébé</h1>
	<br>
	<form:label path="babyFirstName">prénom de votre bébé</form:label>
	<form:input path="babyFirstName"/>

	<br>

	<form:label path="sexe" >Mon bébé est :</form:label>
	<form:radiobutton path="sexe" value="F"/> Une fille
	<form:radiobutton path="sexe" value="M"/> Un garçon


	<br>

	<form:label path="birthDate">Date de naissance de votre bébé</form:label>
	<form:input type="date" path="birthDate"/>

	<input type="hidden"
		   name="${_csrf.parameterName}"
		   value="${_csrf.token}"/>

	<br>
	<br>

	<input type="submit" value="Submit"/>


	<p>
		<springForm:errors path="*" cssClass="error" cssStyle="color: red"/>
	</p>
</form:form>


</body>
</html>
