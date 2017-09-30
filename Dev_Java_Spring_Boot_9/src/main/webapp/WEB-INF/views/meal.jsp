<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meal</title>
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
					class="nav-link; btn btn-outline-primary" href="#">Features</a></li>
				<li class="nav-item"><a
					class="nav-link; btn btn-outline-success" href="#">Pricing</a></li>

				<li class="nav-item dropdown">
					<!-- Example single danger button -->
					<div class="btn-group">
						<button type="button" class="btn btn-info dropdown-toggle"
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






	<sec:authorize access="hasRole('ROLE_CAFE')">
		<div class="container" style="margin-top: 15px">
			<div class="row">
				<div class="col-12">
					<form:form action="/cafe/${id}/meal" method="POST" modelAttribute="meal">
						<div class="form-group row">
							<label class="col-2 col-form-label" for="title">Title:</label>
							<div class="col-10">
								<form:input class="form-control" id="title" path="title" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-2 col-form-label" for="description">Description:</label>
							<div class="col-10">
								<form:textarea class="form-control" id="description"
									path="description" rows="5" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-2 col-form-label" for="price">Price:</label>
							<div class="col-10">
								<form:input class="form-control" id="price" path="price" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-2 col-form-label" for="weight">Weight:</label>
							<div class="col-10">
								<form:input class="form-control" id="weight" path="weight" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-2 col-form-label" for="cuisine">Cuisine:</label>
							<div class="col-10">
								<form:select path="cuisine" items="${cuisines}"
									class="form-control" itemValue="id" itemLabel="name"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-2 col-form-label" for="ingredients">Ingredients:</label>
							<div class="col-10">
								<form:select path="ingredients" items="${ingredients}"
									class="form-control" multiple="multiple" itemValue="id" itemLabel="name"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-10 mr-left">
								<button class="btn btn-lg btn-outline-success">Save</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<table class="table table-bordered">
						<tr>
							<th class="text-center">Title</th>
							<th class="text-center">Description</th>
							<th class="text-center">Price</th>
							<th class="text-center">Cuisine</th>
							<th class="text-center">Weight</th>
							<th class="text-center">Ingredients</th>
							<th class="text-center">Options</th>
						</tr>
						<c:forEach var="meal" items="${meals.content}">
							<tr>
								<td>${meal.title}</td>
								<td>${meal.description}</td>
								<td>${meal.price}</td>
								<td>${meal.cuisine}</td>
								<td>${meal.weight}</td>
								<td><c:forEach var="ingredient" items="${meal.ingredients}">
														${ingredient} 
													</c:forEach></td>
								<td class="text-center"><a
									href="/cafe/${id}/meal/update/${meal.id}"
									class="btn btn-outline-warning btn-sm">Update</a> <a
									href="/cafe/${id}/meal/delete/${meal.id}"
									class="btn btn-outline-danger btn-sm">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>

		</div>
	</sec:authorize>



	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/meal" method="GET" modelAttribute="MealFilter">

					<div class="form-group row">
						<div class="col-6">
							<form:input path="minWeight" class="form-control"
								placeholder="Min weight" />
						</div>
						<div class="col-6">
							<form:input path="maxWeight" class="form-control"
								placeholder="Max weight" />
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minPrice" class="form-control"
								placeholder="Min price" />
						</div>
						<div class="col-6">
							<form:input path="maxPrice" class="form-control"
								placeholder="Max price" />
						</div>
					</div>
					<div class="col-6">
						<form:input class="form-control" path="serchTitle"
							placeholder="Title" />
					</div>
					<div class="form-group row">
						<label>Cuisines</label>
						<div class="col-12">
							<form:checkboxes items="${cuisines}" path="cuisinesIds"
								element="div" itemLabel="name" itemValue="id" />
						</div>
					</div>
					<div class="form-group row">
						<label>Ingredients</label>
						<div class="col-12">
							<form:checkboxes items="${ingredients}" path="ingredientIds"
								element="div" itemLabel="name" itemValue="id" />
						</div>
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
					<custom:sort innerHtml="Price asc" paramValue="price" />
					<custom:sort innerHtml="Price desc" paramValue="price,desc" />
				</div>
			</div>
			<div class="col-2 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${meals.size}" />
			</div>
		</div>

	</div>













	<c:forEach var="meal" items="${meals.content}">
		<div class="container mb-2 mt-2 "  onclick="window.location.href='/meal/${meal.id}'; return false" onmouseover="this.style.backgroundColor='#c1fbff';" onmouseout="this.style.backgroundColor='';">
			<div class="row justify-content-center">

				<div class="col-lg-7 col-sm-12" style="padding: 0; height: auto">
					<div class="card" style="height: 100%">
						<div class="card-header  border border-info " id="desc">
							<div class="container-fluid">
								<img
									src="http://eatsmart.ua/multimedia/files_asset/5/4/9/2/myata_(4)_642_355_1.jpg"
									class="img-fluid" alt="Responsive image"
									style="height: 100%; width: 100%">
							</div>
							<h4 class="text-center mt-3"
								style="font-weight: bold; font-family: cursive; color: #069f95">${meal.title}</h4>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-12" id="mycardstylel"
									style="text-align: center">
									<h4>Description:</h4>
								</div>

							</div>
							<div class="row">

								<div class="col-lg-12" id="mycardstyler">
									<p>"${meal.description}"</p>
								</div>
							</div>
						</div>

					</div>
				</div>

				<div class="col-lg-5 col-sm-12" style="padding: 0; height: auto" >
					<div class="card" style="height: 100%">
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Price:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>***___ ${meal.price} ___***</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Cuisine:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>***___ ${meal.cuisine} ___***</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-4" id="mycardstylel">
									<p>Weight:</p>
								</div>
								<div class="col-lg-8 col-sm-8" id="mycardstyler">
									<p>***___ ${meal.weight} ___***</p>
								</div>
							</div>
						</div>
						<div class="card-body border border-info" id="desc">
							<div class="row">
								<div class="col-lg-4 col-sm-3" id="mycardstylel">
									<p>Ingredients:</p>
								</div>
								<div class="col-lg-8 col-sm-9" id="mycardstyler">

									<ul>
										<c:forEach var="ingredient" items="${meal.ingredients}">
											<li>${ingredient.name}</li>
										</c:forEach>
									</ul>
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
			<custom:pageable page="${meals}" />
		</div>
	</div>






	<nav class="navbar navbar-expand-lg fixed-bottom navbar-light bg-dark"
		style="position: relative">
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




























