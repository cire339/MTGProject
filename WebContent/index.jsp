<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="${pageContext.request.contextPath}/resources/css/keyrune.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/resources/css/mana.css" rel="stylesheet" type="text/css" />
		<meta charset="UTF-8">
		<title>My MTG Project</title>
		<jsp:include page="./WEB-INF/jsp/includes/menu.jsp" />
	</head>
  <body>
  
  	

    <div class="jumbotron">
      <div class="container">
        <h1>My MTG Project</h1>
        <p>Testing</p>
      </div>
    </div>
	
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <h2>Hi</h2>
          <i class="ms ms-w ms-cost ms-shadow"></i>
          <i class="ms ms-u ms-cost ms-shadow"></i>
          <i class="ms ms-b ms-cost ms-shadow"></i>
          <i class="ms ms-r ms-cost ms-shadow"></i>
          <i class="ms ms-g ms-cost ms-shadow"></i>
          <i class="ms ms-c ms-cost ms-shadow"></i>
          <i class="ms ms-0 ms-cost ms-shadow"></i>
          <i class="ms ms-1 ms-cost ms-shadow"></i>
          <i class="ms ms-2 ms-cost ms-shadow"></i>
        </div>
      </div>

      <hr>
    </div>
  </body>
<jsp:include page="./WEB-INF/jsp/includes/footer.jsp" />
</html>