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
<title>CafeView</title>
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
	background: #feffdb;
	font-family: system-ui;
	transition-duration: 1s;
}
</style>
<body>

	<nav class="navbar navbar-expand-lg sticky-top navbar-light bg-dark">
		<a class="navbar-brand; btn btn-dark"
			style="font-style: italic; font-weight: bold; font-size: 1.875em;"
			href="#">RomashkaRest</a>
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
					class="nav-link; btn btn-outline-primary" href="#">Features</a></li>
				<li class="nav-item"><a
					class="nav-link; btn btn-outline-success" href="#">Pricing</a></li>

				<li class="nav-item dropdown">
					<!-- Example single danger button -->
					<div class="btn-group">
						<button type="button" class="btn btn-secondary dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Action</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a> <a
								class="dropdown-item" href="#">Something else here</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Separated link</a>
						</div>
					</div>
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
		<sec:authorize access="hasRole('ROLE_CAFE')">
			<c:if test="${isHISCafe}">
				<%-- <div class="row">
					<div class="col-12">
						<form:form action="/cafe" method="POST" modelAttribute="cafe">
							<div class="form-group row">
								<label class="col-2 col-form-label" for="name">Name:</label>
								<div class="col-10">
									<form:input class="form-control" id="name" path="name" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="fullDescription">FullDescription:</label>
								<div class="col-10">
									<form:textarea class="form-control" id="fullDescription"
										path="fullDescription" rows="5" />
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
								<label class="col-2 col-form-label" for="version">Version:</label>
								<div class="col-10">
									<form:input class="form-control" id="version" path="version" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="address">Address:</label>
								<div class="col-10">
									<form:input class="form-control" id="address" path="address" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="type">Type:</label>
								<div class="col-10">
									<form:select path="type" items="${types}" class="form-control" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="phone">Phone:</label>
								<div class="col-10">
									<form:input class="form-control" id="phone" path="phone" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="open">Open:</label>
								<div class="col-10">
									<form:input class="form-control" id="open" path="open" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="close">Close:</label>
								<div class="col-10">
									<form:input class="form-control" id="close" path="close" />
								</div>
							</div>


						</form:form>
					</div>
				</div> --%>

				<td class="text-center">
					<a href="/adminCafe/cafe"class="btn btn-warning ">Update Or Add New cafe</a> 
					<a href="/cafe/${cafe.id}/order" class="btn btn-warning ">Do order</a>
					<a href="/cafe/${cafe.id}/meal" class="btn btn-warning ">Add meal for this cafe</a>
					<%-- <a
					href="/cafe/delete/${cuisine.id}<custom:allParams/>"
					class="btn btn-outline-success btn-sm">Safe</a> --%></td>
			</c:if>
		</sec:authorize>


		<div class="container"
			style="height: auto; margin-bottom: 15px; padding: 10px"
			onclick="window.location.href='/cafe/${cafe.id}/tables'; return false"
			onmouseover="this.style.backgroundColor='';">
			<div class="row justify-content-center" style="height: auto">

				<div class="col-lg-4 col-sm-4" style="padding: 0; height: auto">
					<div class="card" style="height: 100%">

						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Rate:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>${cafe.rate}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Address:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>${cafe.address}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Type:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>${cafe.type}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Phone:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>${cafe.phone}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Open:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>${cafe.open}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Close:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>${cafe.close}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Email:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>${cafe.email}</p>
								</div>
							</div>
						</div>

					</div>
				</div>

				<div class="col-lg-8 col-sm-8" style="padding: 0; height: auto;">
					<div class="card" style="height: 100%">
						<div class="card-header  border border-info " id="desc">
							<div class="container-fluid">
								<img
									src="http://www.weast.com.au/productimage/weast_59489b1a3db01.jpg"
									class="img-fluid" alt="Responsive image"
									style="height: 100%; width: 100%">
							</div>
							<h4 class="text-center mt-3"
								style="font-weight: bold; font-family: cursive; color: #069f95">ROMASHECZKA</h4>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-3 col-sm-3" id="mycardstylel">
									<p>Full Description:</p>
								</div>
								<div class="col-lg-9 col-sm-9" id="mycardstyler">
									<p>${cafe.fullDescription}</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-3 col-sm-3" id="mycardstylel">
									<p>Meals:</p>
								</div>
								<div class="col-lg-9 col-sm-9" id="mycardstyler">
									<c:forEach var="meal" items="${meals}">
										<ul>
											<li>${meal.title}<c:forEach var="ingredient"
													items="${meal.ingredients}">
													<ul>
														<li>${ingredient.name}</li>

													</ul>

												</c:forEach>
											</li>
										</ul>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div class="row">

			<div class="col-sm-4" style="text-align: center">

				<a href="/cafe/${cafe.id}/tables" class="btn btn-primary btn-lg">Order
					table</a> <a href="#" class="btn btn-secondary btn-lg">Write a
					comment</a>


			</div>

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