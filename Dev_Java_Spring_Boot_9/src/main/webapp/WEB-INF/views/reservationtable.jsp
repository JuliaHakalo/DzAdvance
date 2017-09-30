<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<title>Table</title>
</head>
<style>
body {
	background-image:
		url("http://www.nmgncp.com/data/out/75/4170503-color-gradient-wallpaper-hd.png");
	background-size: cover;
	background-repeat: no-repeat;
	background-clip: border-box;
	background-attachment: fixed;
	background-position: 50% 50%;
	background-origin: border-box;
}

#mycardstylel {
	font-weight: bold;
	font-family: system-ui;
	font-size: larger;
	color: #139030;
	margin: 0;
	padding: 0;
}

#mycardstyler {
	font-family: cursive;
	color: #089bbb;
	margin: 0;
	padding: 0;
}

#desc {
	opacity: 0.7;
	transition-duration: 3s;
}

#desc:hover {
	opacity: 1;
	/*         	        background:#ffebaf; */
	background: #ecd3b4;
	font-family: system-ui;
	transition-duration: 1s;
}
</style>
<body>

	<nav class="navbar navbar-expand-lg sticky-top navbar-light bg-dark">
		<a class="navbar-brand; btn btn-dark"
			style="font-style: italic; font-weight: bold; font-size: 1.875em;"
			href="#">LvivRest</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a
					class="nav-link; btn btn-outline-info " href="#">Home <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a
					class="nav-link; btn btn-outline-primary" href="#">Features</a></li>
				<li class="nav-item"><a
					class="nav-link; btn btn-outline-success" href="#">Pricing</a></li>

				<li class="nav-item dropdown">
					<!-- Example single danger button -->

				</li>
			</ul>
			<div>
				<ul class="navbar-nav">
					<sec:authorize access="isAnonymous()">
						<li class="nav-item active"><a
							class="nav-link; btn btn-outline-info " href="/registration"><span
								class="glyphicon glyphicon-user"></span>Sign Up <span
								class="sr-only">(current)</span></a></li>
						<li class="nav-item"><a
							class="nav-link; btn btn-outline-primary" href="/logind"><span
								class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
					</sec:authorize>

					<sec:authorize access="isAuthenticated()">
						<form:form action="/logout">
							<button class="btn btn-outline-primary">Log Out</button>
						</form:form>
					</sec:authorize>


				</ul>
			</div>


		</div>

	</nav>



	<div class="row">
		<div class="col-12">
			<table class="table table-bordered">
				<tr>
					<th class="text-center">Free:</th>
					<th class="text-center">CountOfpeople</th>
					<th class="text-center">Cafe</th>
				</tr>

				<tr>
					<td>${table.isFree}</td>
					<td>${table.countOfPeople}</td>
					<td>${table.cafe.name},${table.cafe.address}</td>
				</tr>

			</table>
		</div>
	</div>



	<h1 class="text-center mt-3"
		style="font-weight: bold; font-family: cursive; color: #069f95; margin-top: 25px; margin-bottom: 25px">RESERVATION</h1>





	<div class="row">
		<div class="col-12">
			<form:form action="/cafe/${id}/tables/${id2}" method="POST"
				modelAttribute="UserReserver">
				<div class="form-group row">
					<label class="col-2 col-form-label" for="name">Name And
						LastName:</label>
					<div class="col-8">
						<form:input class="form-control" id="name" path="name" />
					</div>

					<div class="form-group row">
						<div class="col-12">
							<button class="btn btn-sm btn-outline-success">Save</button>
						</div>
					</div>

				</div>
			</form:form>
		</div>
	</div>







	<nav class="navbar navbar-expand-lg fixed-bottom navbar-light bg-dark">
		<a class="navbar-brand; btn btn-dark"
			style="font-style: italic; font-weight: bold; font-size: 1.875em;"
			href="#">LvivRest</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown1" aria-controls="navbarNavDropdown1"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown1">

			<ul class="navbar-nav">
				<sec:authorize access="isAnonymous()">
					<li class="nav-item active"><a
						class="nav-link; btn btn-outline-info " href="/registration"><span
							class="glyphicon glyphicon-user"></span>Sign Up <span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a
						class="nav-link; btn btn-outline-primary" href="/login"><span
							class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<form:form action="/logout">
						<button class="btn btn-outline-primary">Log Out</button>
					</form:form>
				</sec:authorize>


			</ul>
		</div>
	</nav>
</body>
</html>

