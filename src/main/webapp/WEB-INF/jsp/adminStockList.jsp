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
      </tr>
    </thead>
    <tbody>
    <c:forEach var="stock" items="${stockList}">
      <tr>
        <td>${stock.name}</td>
        <td>${stock.symbol}</td>
        <td>${stock.price}</td>
        <td>${stock.broker.name}</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
