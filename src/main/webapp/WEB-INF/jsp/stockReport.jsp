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
  <h2>Stock Report</h2>
  <table class="table">
    <thead>
      <tr>
        <th>Stock Name</th>
        <th>Buyer</th>
        <th>Seller</th>
        <th>Owner</th>
        <th>Quote Price</th>
        <th>Transaction Date</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="stockReport" items="${stockTradeList}">
      <tr>
        <td>${stockReport.stock.name}</td>
        <td>${stockReport.buyer.name}</td>
        <td>${stockReport.seller.name}</td>
        <td>${stockReport.stock.broker.name}</td>
        <td>${stockReport.quotePrice}</td>
        <td>${stockReport.createdDate}</td>
        <td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
