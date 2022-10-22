<!DOCTYPE html>
<html>
<head>
<title>Achat</title>
<link rel="stylesheet" href="./style/studentstyle.css">
<link rel="stylesheet" href="./style/style.css">
</head>
<body>

<div id="container">

		<div id="infoPerso">
			<legend class="titre">Informations personnelles</legend>
        	 - ${ sessionScope.surname } ${ sessionScope.firstname }
		</div>
		
		<div id="mesreservation">
			<legend class="titre">Mes réservations et mes billets</legend>
		</div>
	
		 <div id="events">
	  		<legend id ="titre"> Acheter un billet</legend>
	  		
	  		<div id="select">
				<select name ="listEvent">
				    <c:forEach var="event" items="${events}">
				     	<option value = "${event.name}">${event.name}</option>
				    </c:forEach>
				</select>	
			</div>
		</div> 

		<form method="post" action="EventBuy">
			<input 	type="submit" value="buyTickets" name="buyTickets">
			<input type="hidden" name="id" value ="${param.id}">			
		</form>

	<form method="get" action="Deconnexion" id="deconnexion">
		<input type="submit" value="Se deconnecter" />
	</form>
	
</div> 



		
		


</body>
</html>