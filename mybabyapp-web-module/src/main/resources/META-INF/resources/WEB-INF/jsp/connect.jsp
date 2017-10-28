<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext['request'].contextPath}"/>


<!doctype html>

<html lang="en">

<body>

<h1>Connexion</h1>


<p style="color: red">${failureMessage}</p>

<form method = "POST" action = "login" name="f">


	<label for="username">Username</label>
	<input type="text" id="username" name="username"/>

	<label for="password">Password</label>
	<input type="password" id="password" name="password"/>

	<input type="hidden"
		   name="${_csrf.parameterName}"
		   value="${_csrf.token}"/>

	<button type="submit" class="btn">Log in</button>

</form>

<p>Pas encore inscrit ? cliquez <a href="/sign-up">ici</a></p>




</body>
</html>
