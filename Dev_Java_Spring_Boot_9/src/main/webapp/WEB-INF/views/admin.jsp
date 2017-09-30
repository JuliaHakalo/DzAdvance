<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </head>
    <style>
        body{
            background-image: url("http://www.nmgncp.com/data/out/75/4170503-color-gradient-wallpaper-hd.png");
            background-size: cover;
            background-repeat: no-repeat;
            background-clip: border-box;
            background-attachment: fixed;
            background-position: 50% 50%;
            background-origin: border-box;
        }
    </style>

<title>Admin</title>
</head>
<body>


    <nav class="navbar navbar-expand-lg sticky-top navbar-light bg-dark">
  <a class="navbar-brand; btn btn-dark" style = "font-style: italic; font-weight: bold;  font-size: 1.875em;" href="/">LvivRest</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link; btn btn-outline-info " href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link; btn btn-outline-primary" href="/cafe">Show All Cafes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link; btn btn-outline-success" href="/admin/meal">Show All Meals</a>
      </li>
    
        <li class="nav-item dropdown">
        <!-- Example single danger button -->
<div class="btn-group">
  <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Action
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#">Action</a>
    <a class="dropdown-item" href="#">Another action</a>
    <a class="dropdown-item" href="#">Something else here</a>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="#">Separated link</a>
  </div>
</div>
        </li>
    </ul>
     <div >
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
		<form:form action="/logout">
			<button class="btn btn-outline-primary">Log Out</button>
		</form:form>
	</sec:authorize>
            	

            </ul>
        </div>
      
      
  </div>
        
</nav>
    
   
    
 


						
						     
						    
						
						<div class="container-fluid">
						  <div class="row" style="text-align:center">
						      <div class="col-lg-12">
						      	 <h1 style="color:#0771a3; font-style: italic; font-weight: bold;  font-size: 40pt;">Admin</h1>
						      </div>
						
						  </div>
						  <div class="row" style="text-align:center">
							      <div class="col-sm-4">
							      </div>
						    		<div class="col-sm-4">						
							
											<a href="/admin/cuisine" class="btn btn-success btn-lg">Cuisine</a>
											<a href="/admin/openclose"class="btn btn-success btn-lg">OpenClose</a>
											<a href="/admin/ingredient" class="btn btn-success btn-lg">Ingredient</a>
										      
						   
						
						      		</div>
								 <div class="col-sm-4">
								     </div>
						
						  </div>
						</div>




							
					 <nav class="navbar navbar-expand-lg fixed-bottom navbar-light bg-dark">
							  <a class="navbar-brand; btn btn-dark" style = "font-style: italic; font-weight: bold;  font-size: 1.875em;" href="/">LvivRest</a>
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
									<form:form action="/logout">
										<button class="btn btn-outline-primary">Log Out</button>
									</form:form>
								</sec:authorize>
							            	
							
							            </ul>
							        </div>
						</nav>

</body>
</html>