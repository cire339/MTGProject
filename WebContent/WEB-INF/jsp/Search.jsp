<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<title>Search Results - MTG Project</title>
	<jsp:include page="./includes/header.jsp" />
	 <body>
	
	   <div class="page-header">
	     <div class="container">
	       <h2>Search Results</h2>
	     </div>
	   </div>
	
	   <div class="container">
	   <c:choose>
	    <c:when test="${not empty searchResult}">
	    	<div class=col-md-8>
			<table class="table table-bordered">
				<tr>
				<th>Search Results</th>
				</tr>
				<tr>
				<td><b>Name</b></td>
				<td><b>Set</b></td>
				</tr>
				<c:forEach var="card" items="${searchResult}" varStatus="loop">
				<tr>
				<td><a href="./cards?card=${card.getCardId()}">${card.getName()}</a></td>
				<td><i style="padding-right: 5px" class="ss ss-${card.getCardSet().getSetId().toLowerCase()}"></i><a href="./sets?set=${card.getCardSet().getSetId()}">${card.getCardSet().getSetName()}</a></td>
				</tr>
				</c:forEach>
			</table>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				No cards found.
			</div>
		</c:otherwise>
		</c:choose>
	   </div>
	 </body>
<jsp:include page="./includes/footer.jsp" />
</html>