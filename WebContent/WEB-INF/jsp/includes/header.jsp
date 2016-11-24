<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<head>
	    <spring:url value="/resources/css/keyrune.css" var="keyruneCss" />
		<spring:url value="/resources/css/mana.css" var="manaCss" />
		<spring:url value="/resources/js/script.js" var="scriptJs" />
		<link href="${keyruneCss}" rel="stylesheet" />
		<link href="${manaCss}" rel="stylesheet" />
		<script src="${scriptJs}"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

		<meta charset="UTF-8">
		<jsp:include page="menu.jsp" />
	</head>