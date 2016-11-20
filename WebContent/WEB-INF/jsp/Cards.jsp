<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<title>Cards - MTG Project</title>
	<jsp:include page="./includes/header.jsp" />
	 <body>
	
	   <div class="page-header">
	     <div class="container">
	       <h2>${cardInfo.getName()}</h2>
	     </div>
	   </div>
	
	   <div class="container">
	    <c:if test="${not empty cardInfo}">
	    	<div class=col-md-8>
			<table class="table table-bordered">
				<tr>
				<td>Name</td>
				<td>${cardInfo.getName()}</td>
				</tr>
				<tr>
				<td>Mana Cost</td>
				<td>${cardInfo.getManaCost()}</td>
				</tr>
				<tr>
				<td>Type</td>
				<td>${cardInfo.getCardType()}</td>
				</tr>
				<tr>
				<td>Text</td>
				<td>${cardInfo.getText()}</td>
				</tr>
				<c:if test="${not empty cardInfo.getCardPower()}">
					<c:if test="${not empty cardInfo.getToughness()}">
						<tr>
						<td>Power/Toughness</td>
						<td>${cardInfo.getCardPower()}/${cardInfo.getToughness()}</td>
						</tr>
					</c:if>
				</c:if>
				<c:choose>
					<c:when test="${not empty cardPrice.getPrice()}">
						<tr>
						<td>Price</td>
						<td>$${cardPrice.getPrice()}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
						<td>Price</td>
						<td>N/A</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
			</div>
			<div class=col-md-4>
			<img src="http://gatherer.wizards.com/Handlers/Image.ashx?type=card&multiverseid=${cardInfo.getMultiverseId()}" alt="${cardInfo.getName()}">
			</div>
		</c:if>
	   </div>
	 </body>
<jsp:include page="./includes/footer.jsp" />
</html>