<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/login.css" var="loginCss"/>
<link href="${loginCss}" rel="stylesheet" />

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>

<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
	 .topcorner{
	   position:absolute;
	   top:5px;
	   right:5px;
	  }
 </style>
 <script type="text/javascript">
        
        function logout() {
        	window.location.href = 'http://localhost:8080/hotstock/login';
	        return false;
        }
   </script>		

</head>

<div class="topcorner">
	<button type="button" onclick="logout()" class="btn btn-default btn-sm">
	    <span class="glyphicon glyphicon-log-out"></span> Log out
	 </button>
 </div>
<div class="container">
        <div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form1" action="http://localhost:8080/hotstock/createStock" method="post" role="form" style="display: block;">
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Create Stock">
											</div>
										</div>
									</div>
								</form>
								<form id="login-form2" action="http://localhost:8080/hotstock/adminStockList" method="post" role="form" style="display: block;">
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Stock List">
											</div>
										</div>
									</div>
								</form>
								<form id="login-form3" action="http://localhost:8080/hotstock/stockReport" method="post" role="form" style="display: block;">
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Stock Report">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>