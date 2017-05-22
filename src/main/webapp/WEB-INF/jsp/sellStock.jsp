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
		
		  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
  <script type="text/javascript">
        
  function acceptButton(stockName, brokerUserName) {
  	window.location.href = 'http://localhost:8080/hotstock/acceptOffer?stockName='+stockName+'&brokerUserName='+brokerUserName;
      return false;
  }
  
  function rejectButton(stockName, brokerUserName) {
  	window.location.href = 'http://localhost:8080/hotstock/rejectOffer?stockName='+stockName+'&brokerUserName='+brokerUserName;
      return false;
  }
  
  function logout() {
  	window.location.href = 'http://localhost:8080/hotstock/login';
      return false;
  }
  </script>
  
  <style type="text/css">
	 .topcorner{
	   position:absolute;
	   top:5px;
	   right:5px;
	  }
 </style>
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
							<form id="login-form" method="post" role="form"
								style="display: block;">
								<div class="form-group">
									Stock Name :
									<c:out value="${stock.name}"></c:out>
								</div>
								<div class="form-group">
									Symbol :
									<c:out value="${stock.symbol}"></c:out>
								</div>
								<div class="form-group">
									Price :
									<c:out value="${stock.price}"></c:out>
								</div>
								<div class="form-group">
									Quote Price :
									<c:out value="${ stockTrade.quotePrice}"></c:out>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<button id="accept" type="button"
												onclick="acceptButton('${stock.name}','${broker.username}')"
												class="btn btn-primary">Accept</button>

											<button id="reject" type="button"
												onclick="rejectButton('${stock.name}','${broker.username}')"
												class="btn btn-primary">Reject</button>
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