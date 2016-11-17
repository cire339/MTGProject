<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta charset="ISO-8859-1">
		<title>My MTG Project</title>
		<jsp:include page="./includes/menu.jsp" />
	</head>
	 <body>
	
	   <div class="page-header">
	     <div class="container">
	       <h2>All Sets</h2>
	     </div>
	   </div>
	
	   <div class="container">
	    <c:if test="${not empty setList}">
			<ul>
				<c:forEach var="set" items="${setList}">
					<li class="list"><a href="./Sets.htm?set=${set.getSetId()}">${set.getSetName()}</a></li>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${not empty cardList}">
			<ul>
				<c:forEach var="card" items="${cardList}">
					<li class="list"><a href="./Card.htm?card=${card.getCardId()}">${card.getName()}</a></li>
				</c:forEach>
			</ul>
		</c:if>
	
		<footer>
		  <p>&copy; 2016 - Eric Picot</p>
		</footer>
	   </div>
	 </body>
</html>