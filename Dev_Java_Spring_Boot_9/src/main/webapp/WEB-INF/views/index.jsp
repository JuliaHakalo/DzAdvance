<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<title>Cafe</title>
</head>
 <style>
        body{
            background-image: url("http://www.nmgncp.com/data/out/75/4170503-color-gradient-wallpaper-hd.png");
            background-size: 100%;
        }
    </style>
<body>
 
<nav class="navbar navbar-expand-lg sticky-top navbar-light bg-dark">
  <a class="navbar-brand; btn btn-dark" style = "font-style: italic; font-weight: bold;  font-size: 1.875em;" href="#">LvivRest</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
   	   <sec:authorize access="hasRole('ROLE_ADMIN')">
	     <li class="nav-item active">
	       <a class="nav-link; btn btn-outline-info " href="/admin">Admin <span class="sr-only">(current)</span></a>
	     </li>
       </sec:authorize>
        	
       <sec:authorize access="hasRole('ROLE_CAFE')">
      	 <li class="nav-item active">
       	   <a class="nav-link; btn btn-outline-info " href="/owner">Profile <span class="sr-only">(current)</span></a>
          </li>
       </sec:authorize>
      	 <li class="nav-item">
        	<a class="nav-link; btn btn-outline-primary" href="/cafe">Show All Cafes</a>
     	 </li>
      	 <li class="nav-item">
            <a class="nav-link; btn btn-outline-success" href="/meal">Show All Meals</a>
         </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <sec:authorize access="isAnonymous()">
          <li class="nav-item active">
        	<a class="nav-link; btn btn-outline-info " href="/registration"><span class="glyphicon glyphicon-user" ></span>Sign Up <span class="sr-only">(current)</span></a>
      	  </li>
          <li class="nav-item">
        	<a class="nav-link; btn btn-outline-primary" href="/login"><span class="glyphicon glyphicon-log-in" ></span> Sign In</a>
       	  </li>
         </sec:authorize>
         <sec:authorize access="isAuthenticated()">
           <li class="nav-item">
       		 <a class="nav-link; btn btn-outline-primary" href="/logout"><span class="glyphicon glyphicon-log-in" ></span> Log Out</a>
           </li>
          </sec:authorize>
     </ul> 
  </div>     
</nav>
     
     
     
    <div class="container mb-2 mt-2 justify-content-start">
	<div class="row ">
		<div class="col-lg-6 col-sm-12">
			<div class="card" onclick="window.location.href='/cafe/${cafe.id}'; return false" onmouseover="this.style.backgroundColor='#c1fbff';">
				<div class="card-header">
					<img src="http://www.sobaka.ru/images/image/00/62/26/27/_normal.jpg" class="img-fluid" alt="Responsive image тут кароче текст якийсь, назва кафе.">
						<p>INFO</p>
				</div>
				<div class="card-body">
					<h3 class="c-dark-olive-green"><a href="/cafe/${cafeindexview0.id}">${cafeindexview0.name}</a></h3>
					<p class="text-dark mb-2">${cafeindexview0.shortDescription}</p>
					<p class="font-italic text-dark"><i class="fa fa-map-marker" aria-hidden="true"></i> ${cafeindexview0.address}</p>
				</div>
			
			</div>
		</div>
		<div class="col-lg-6 col-sm-12">
			<div class="card">
				<div class="card-header">
				
					<img src="http://eatsmart.ua/multimedia/files_asset/5/4/9/2/myata_(4)_642_355_1.jpg" class="img-fluid" alt="Responsive image тут кароче текст якийсь, назва кафе.">
						<p>INFO</p>
				</div>
				<div class="card-body">
					CONTENT
				</div>
			
			</div>
		</div>
		
	</div>
	<div class="row">
		<div class="col-lg-6 col-sm-12">
			<div class="card">
				<div class="card-header">
					<img src="http://www.sobaka.ru/images/image/00/62/26/27/_normal.jpg" class="img-fluid" alt="Responsive image тут кароче текст якийсь, назва кафе.">
						<p>INFO</p>
				</div>
				<div class="card-body">
					CONTENT
				</div>
			
			</div>
		</div>
		<div class="col-lg-6 col-sm-12">
			<div class="card">
				<div class="card-header">
				
					<img src="http://eatsmart.ua/multimedia/files_asset/5/4/9/2/myata_(4)_642_355_1.jpg" class="img-fluid" alt="Responsive image тут кароче текст якийсь, назва кафе.">
						<p>INFO</p>
				</div>
				<div class="card-body">
					CONTENT
				</div>
			
			</div>
		</div>
		
	</div>
</div>  
       
       
       
       
       
<nav class="navbar navbar-expand-lg fixed-bottom navbar-light bg-dark">
  <a class="navbar-brand; btn btn-dark" style = "font-style: italic; font-weight: bold;  font-size: 1.875em;" href="#">LvivRest</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown1" aria-controls="navbarNavDropdown1" aria-expanded="false" aria-label="Toggle navigation">
  	<span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown1">
    <ul class="navbar-nav">
       <sec:authorize access="isAnonymous()">
       	<li class="nav-item active">
        	<a class="nav-link; btn btn-outline-info " href="/registration"><span class="glyphicon glyphicon-user" ></span>Sign Up <span class="sr-only">(current)</span></a>
      	</li>
      	<li class="nav-item">
       		 <a class="nav-link; btn btn-outline-primary" href="/login"><span class="glyphicon glyphicon-log-in" ></span> Sign In</a>
        </li>
       </sec:authorize>
       <sec:authorize access="isAuthenticated()">
          <li class="nav-item">
        	  <a class="nav-link; btn btn-outline-primary" href="/logout"><span class="glyphicon glyphicon-log-in" ></span> Log Out</a>
           </li>
        </sec:authorize>
      </ul>
    </div>
</nav>
<div class="container-fluid">
	<div class="d-flex justify-content-center">
	  <div class="p-2">
	  	<img class="d-block w-100" src="/resource/img/green_bg.jpg">
		    <img src="/resources/img/default_cafe.jpg" height="300px" class="rounded mb-2">
			<h3 class="c-dark-olive-green"><a href="/cafe/">dfffffffffffffffgfdgdfgfdgfdgfdgfdgfd</a></h3>
			<p class="text-dark mb-2">sfddddddddddddddddddddddddddddddddddgfdgfdgdfgfdg</p>
			<p class="font-italic text-dark"><i class="fa fa-map-marker" aria-hidden="true"></i> ydgjgfhjdffffffffffffff</p>
	  </div>
	</div>
	<div class="d-flex justify-content-center">
	  <div class="p-2">Flex item</div>
	</div>
	<div class="d-flex justify-content-center">
	  <div class="p-2">Flex item</div>
	</div>
	<div class="d-flex justify-content-center">
	  <div class="p-2">Flex item</div>
	</div>
	<div class="d-flex justify-content-center">
	  <div class="p-2">Flex item</div>
	</div>
</div>
<!-- <div class="container">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	  <ol class="carousel-indicators">
	    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	  </ol>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img class="d-block w-100 img-fluid" src="http://s.gvult.com/uploads/posts/2016-02/1454579129_12646969_1240982332595940_2366665344260414621_n.png" alt="First slide">
	    </div>
	    <div class="carousel-item">
	      <img class="d-block w-100 img-fluid" src="http://www.sushiya.ua/modules/pages/files/f56964590e22eed969b3651d41797252.jpg" alt="Second slide">
	    </div>
	    <div class="carousel-item">
	      <img class="d-block w-100 img-fluid" src="https://cdn.doordash.com/media/restaurant/cover/ChicagoPizzaPizzeria_Allen_TX.png" alt="Third slide">
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
    </div>
</div> -->



</body>
</html>