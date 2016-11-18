<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta charset="UTF-8">
		<title>My MTG Project</title>
		<jsp:include page="./includes/menu.jsp" />
	</head>
	 <body>
	
	   <div class="page-header">
	     <div class="container">
	       <h2>${cardInfo.getName()}</h2>
	     </div>
	   </div>
	
	   <div class="container">
	    <c:if test="${not empty cardInfo}">
			<ul>
				<li class="list">Name: ${cardInfo.getName()}</li>
				<li class="list">Mana Cost: ${cardInfo.getManaCost()}</li>
				<li class="list">Type: ${cardInfo.getCardType()}</li>
				<li class="list">Text: ${cardInfo.getText()}</li>
				<c:if test="${not empty cardInfo.getCardPower()}">
					<c:if test="${not empty cardInfo.getToughness()}">
						<li class="list">Power/Toughness: ${cardInfo.getCardPower()}/${cardInfo.getToughness()}</li>
					</c:if>
				</c:if>
			</ul>
			<img src="http://gatherer.wizards.com/Handlers/Image.ashx?type=card&multiverseid=${cardInfo.getMultiverseId()}" alt="${cardInfo.getName()}">
		</c:if>
	   </div>
	 </body>
<jsp:include page="./includes/footer.jsp" />
</html>