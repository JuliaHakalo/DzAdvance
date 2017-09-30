<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Order</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/cafe/${id}/order" method="POST" modelAttribute="order">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="table">Table:</label>
						<div class="col-10">
							<form:select class="form-control" path="table" items="${tables}" itemValue="id" itemLabel="id"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="meals">Meals:</label>
						<div class="col-10">
							<form:select class="form-control" path="meals" items="${meals}" multiple="multiple" itemValue="id" itemLabel="params" />
								<%-- <c:forEach var="meal" items="${meals}">  --%>
								<%-- <form:options items="${meals} itemLAbek/> --%>
								<%-- </c:forEach> --%>
<%-- 							</form:select> --%>
						<%-- <div class="col-10">
							<select class="form-control" id="meals" name="meals" multiple="multiple">
								<c:forEach var="meals" items="${meals}"> 
									<option value="${meal}">${meal}</option>
								</c:forEach>
							</select>
						</div> --%>
					</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">OrderId</th>
						<th class="text-center">Table</th>
						<th class="text-center">Meals</th>
						<th class="text-center">Options:</th>
					</tr>
					<c:forEach var="order" items="${orders}">
						<tr>
							<td>${order.id}</td>
							<td>${order.table.id}</td>
							<td>
								<c:forEach var="meal" items="${order.meals}">
									${meal.title} 
								</c:forEach>
							</td>
							<td class="text-center">
								<a href="/cafe/${id}/order/update/${order.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<a href="/cafe/${id}/order/delete/${order.id}" class="btn btn-outline-danger btn-sm">Delete</a>
								<a href="/cafe/${id}/order/addTable/${order.id}" class="btn btn-outline-warning">AddOrder</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>