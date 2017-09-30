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
<title>CafeIndexView</title>
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
	paddong: 0;
}

#mycardstyler {
	font-family: cursive;
	color: #089bbb;
	margin: 0;
	paddong: 0;
}

#card-p {
	padding: 10px;
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
					class="nav-link; btn btn-outline-info " href="/">Home <span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a
					class="nav-link; btn btn-outline-primary" href="/meal">Show All
						Meals</a></li>
				

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


		</div>

	</nav>
	<div class="container">
		<div class="row ">
			<div class="col-lg-12 ">
				<h1
					style="font-weight: bold; font-family: cursive; color: #026c61; text-align: center">All
					Cafes</h1>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/profile" method="GET" modelAttribute="cafeFilter">

					<div class="form-group row">
						<div class="col-6">
							<form:input path="minRate" class="form-control"
								placeholder="Min rate" />
						</div>
						<div class="col-6">
							<form:input path="maxRate" class="form-control"
								placeholder="Max rate" />
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<div>
								<label>Pub <form:checkbox path="types" value="PUB" /></label> <label>Sushy
									<form:checkbox path="types" value="SUSHY" />
								</label> <label>Bar <form:checkbox path="types" value="BAR" /></label>
								<label>Cafe <form:checkbox path="types" value="CAFE" />
								</label> <label>Restaurant <form:checkbox path="types"
										value="RESTAURANT" /></label>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minOpen" class="form-control"
								placeholder="Min open" />
						</div>
						<div class="col-6">
							<form:input path="maxOpen" class="form-control"
								placeholder="Max open" />
						</div>
					</div>
					<div class="form-group row">
					<h1
					style="font-weight: bold; font-family: cursive; color: #026c61; text-align: center">All Meals</h1>
						<div class="col-12">
							<form:checkboxes items="${meals}" path="mealsIds" element="div"
								itemLabel="title" itemValue="id" />
						</div>
					</div>
					<div class="col-6">
							<form:input class="form-control" path="searchName" placeholder="Name of Cafe"/>
						</div>
					<div class="form-group row">
						<div class="col-12">
							<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		
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
		
	</div>


	<c:forEach var="cafe" items="${cafes.content}">
		<div class="container mb-2 mt-2 ">
			<div class="row justify-content-center">

				<div class="col-lg-8 col-sm-12">
					<div class="card"  onclick="window.location.href='/cafe/${cafe.id}'; return false" onmouseover="this.style.backgroundColor='#c1fbff';" onmouseout="this.style.backgroundColor='';">
						<div class="card-header  border border-info " id="desc">
							<div class="container-fluid">
								<img
									src="http://www.sobaka.ru/images/image/00/62/26/27/_normal.jpg"
									class="img-fluid" alt="Responsive image"
									style="height: 100%; width: 100%">
							</div>
							<h4 class="text-center mt-3"
								style="font-weight: bold; font-family: cursive; color: #069f95">
								${cafe.name}</h4>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Rate:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>........${cafe.rate}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Address:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>........${cafe.address}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Type:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>........${cafe.type}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Short description:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>........${cafe.shortDescription}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="row">
		<div class="col-12 text-center">
			<custom:pageable page="${cafes}" />
		</div>
	</div>



	<nav class="navbar navbar-expand-lg fixed-bottom navbar-light bg-dark"
		style="position: relative">
		<a class="navbar-brand; btn btn-dark"
			style="font-style: italic; font-weight: bold; font-size: 1.875em;"
			href="/">LvivRest</a>
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