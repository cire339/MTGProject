<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<title>Sets - MTG Project</title>
	<jsp:include page="./includes/header.jsp" />
	 <body>
	
	<c:if test="${not empty setList}">
	   <div class="page-header">
	     <div class="container">
	       <h2>All Sets</h2>
	     </div>
	   </div>
	</c:if>
	<c:if test="${not empty cardList}">
	   <div class="page-header">
	     <div class="container">
	       <h2>${cardList.get(0).getCardSet().getSetName()}</h2>
	     </div>
	   </div>
	</c:if>
	
	<div class=container>
		<div class="row">
		    <c:if test="${not empty setList}">
		    	<div class="col-md-4">
					<table class="table table-striped">
						<c:forEach var="set" items="${setList}" varStatus="loop">
							<c:if test="${not loop.first and loop.index % 35 == 0}"> 
		            </table>
		        </div>
		        <div class="col-md-4">
		        	<table class="table table-striped">
		                    </c:if>
							<tr><td><i style="padding-right: 5px" class="ss ss-${set.getSetId().toLowerCase()}"></i><a href="./sets?set=${set.getSetId()}">${set.getSetName()}</a></td></tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
			<c:if test="${not empty cardList}">
		    	<div class="col-md-4">
					<table class="table table-striped">
						<c:forEach var="card" items="${cardList}" varStatus="loop">
							<c:if test="${not loop.first and loop.index % 50 == 0}"> 
		            </table>
		        </div>
		        <div class="col-md-4">
		        	<table class="table table-striped">
		                    </c:if>
							<tr><td><a href="./cards?card=${card.getCardId()}">${card.getName()}</a></td></tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
		   </div>
	   </div>
	   <jsp:include page="./includes/footer.jsp" />
	 </body>
</html>