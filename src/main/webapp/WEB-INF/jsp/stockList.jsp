<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script type="text/javascript">
        
        function buyButton(stockName, brokerUserName) {
        	window.location.href = 'http://localhost:8080/hotstock/buyStock?stockName='+stockName+'&brokerUserName='+brokerUserName;
	        return false;
        }
        
        function sellButton(stockName, brokerUserName) {
        	window.location.href = 'http://localhost:8080/hotstock/sellStock?stockName='+stockName+'&brokerUserName='+brokerUserName;
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
<body>

<div class="topcorner">
	<button type="button" onclick="logout()" class="btn btn-default btn-sm">
	    <span class="glyphicon glyphicon-log-out"></span> Log out
	 </button>
 </div>
 
<div class="container">
  <h2>Stock List</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Symbol</th>
        <th>Price</th>
        <th>Owner</th>
        <th>Transaction</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="stock" items="${stockList}">
      <tr>
        <td>${stock.name}</td>
        <td>${stock.symbol}</td>
        <td>${stock.price}</td>
        <td>${stock.broker.name}</td>
        <c:choose>
        <c:when test= "${broker.name eq stock.broker.name }">
	        <td><button id="sellButton" type="button" onclick="sellButton('${stock.name}','${broker.username}')" class="btn btn-primary">
	      	 Sell
	    	</button>
	    </c:when>
	    <c:otherwise>
	    	<td><button id="buyButton" type="button" onclick="buyButton('${stock.name}','${broker.username}')" class="btn btn-primary">
	      	 Buy
	    	</button></td>
	    </c:otherwise>
	    </c:choose>
	    <td>${stock.status}</td>
        
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
