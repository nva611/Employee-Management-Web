<%@page import="java.util.Date"%>
<%@page import="com.ute.an.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Employee employee = (Employee) request.getAttribute("employee");
String date = String.valueOf(request.getAttribute("date"));
%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.facebook.com/ON.611.02" class="navbar-brand">My Facebook</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<!-- INSERT -->
			<%
            if(employee == null) { %>       
                <%@include file="includes/insert.jsp"%>
            <%}%>
            
            <!-- UPDATE -->
            <% if(employee != null) { %>
                 <%@include file="includes/update.jsp"%>
            <%} %>
            
				
			</div>
		</div>
	</div>
</body>
</html>
