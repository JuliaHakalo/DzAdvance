<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>

<title>Cafe</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/adminCafe/cafe" method="POST"
					modelAttribute="cafe">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input class="form-control" id="name" path="name" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="address">Address:</label>
						<div class="col-10">
							<form:input class="form-control" id="address" path="address" />
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10">
							<form:hidden path="user" value="" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="rate">Rate:</label>
						<div class="col-10">
							<form:input class="form-control" id="rate" path="rate" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="photoUrl">PhotoUrl:</label>
						<div class="col-10">
							<form:input class="form-control" id="photoUrl" path="photoUrl" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="fullDescription">FullDescription:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="fullDescription"
								path="fullDescription" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="shortDescription">ShortDescription:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="shortDescription"
								path="shortDescription" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="phone">Phone:</label>
						<div class="col-10">
							<form:input class="form-control" id="phone" path="phone" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="type">Type:</label>
						<div class="col-10">
							<form:select path="type" items="${types}" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="type">Open:</label>
						<div class="col-10">
							<form:select path="open" items="${times}" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="type">Close:</label>
						<div class="col-10">
							<form:select path="close" items="${times}" class="form-control" />
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
				<div class="row">
					<div class="col-2 text-center">
						<button class="dropdown-toggle btn btn-outline-primary btn-sm"
							type="button" data-toggle="dropdown">Sort</button>
						<div class="dropdown-menu">
							<custom:sort innerHtml="Rate asc" paramValue="rate" />
							<custom:sort innerHtml="Rate desc" paramValue="rate,desc" />
						</div>
					</div>
					<div class="col-2 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${cuisines.size}" />
					</div>
				</div>
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">FullDescription</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Type</th>
						<th class="text-center">Open</th>
						<th class="text-center">Close</th>
						<th class="text-center">PhotoUrl</th>
						<th class="text-center">Email</th>
						<th class="text-center">Rate</th>
						<th class="text-center">Option</th>


					</tr>
					<c:forEach var="cafe" items="${cafes.content}">
						<tr>
							<td>${cafe.name}</td>
							<td>${cafe.address}</td>
							<td>${cafe.fullDescription}</td>
							<td>${cafe.phone}</td>
							<td>${cafe.type}</td>
							<td>${cafe.open}</td>
							<td>${cafe.close}</td>
							<td>${cafe.photoUrl}</td>
							<td>${cafe.email}</td>
							<td>${cafe.rate}</td>
							<td class="text-center"><a
								href="/adminCafe/cafe/update/${cafe.id}"
								class="btn btn-outline-warning btn-sm">Update</a> <a
								href="/adminCafe/cafe/delete/${cafe.id}"
								class="btn btn-outline-danger btn-sm">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="row">
					<div class="col-12 text-center">
						<custom:pageable page="${cafes}" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>