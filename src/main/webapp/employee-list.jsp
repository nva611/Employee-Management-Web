<%@page import="com.ute.an.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
List<Employee> listEmployee = (List<Employee>) request.getAttribute("listEmployee");
//String found = String.valueOf(request.getAttribute("found"));
%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
            style="background-color: tomato;">
            <div>
                <a href="https://www.facebook.com/ON.611.02"  class="navbar-brand">My Facebook </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list"
                    class="nav-link">Employees</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="container">
            <h3 class="text-center">List of Employees</h3>
            <hr>
            <div class="container text-left">

                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                    New Employee</a>
                <a href="<%=request.getContextPath()%>/list" class="btn btn-success">Show All</a>
                <br>
                 <br>
                <form action="search" method="get">
                    <input type="text" name="id">
                    <button class="btn btn-success" type="submit">Search</button>
                    
                </form>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Sex</th>
                        <th>Birth Date</th>
                        <th>Home Town</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Status</th>
                        <th>Option</th>
                    </tr>
                </thead>
                <tbody>
                
                <%
                if(listEmployee.size() != 0) %>
	               <%@include file="includes/employeeList.jsp"%>
                <%if(listEmployee.size() == 0) { %>
                    <h1 style="color:red">Not Found</h1>
                <%}%>
                </tbody>

            </table>
        </div>
    </div>
</body>
</html>
