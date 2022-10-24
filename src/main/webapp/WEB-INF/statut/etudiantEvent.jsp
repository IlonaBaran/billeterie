<!DOCTYPE html>
<html>
<head>
<title>Page personnelle</title>
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
			<ul>
	        <c:forEach var="event" items="${eventsUser}">
	            <li><c:out value="${event.idEvent}" /></li>
	        </c:forEach>
	    	</ul>    
		</div>
	
		<div id="events">
		
		     <form method="get" action="EventBuy" id="eventbuy">		
				<input type="hidden" name="id" value ="${param.id}">
				<input 	type="submit" value="ACHETER" name="ACHETER">			
		     </form>
     
    		<legend class="titre">Evenements à venir</legend>
			<ul>
	        <c:forEach var="event" items="${events}">
	            <li><c:out value="${event.id} le ${event.date}:${event.time} à ${event.conferenceRoom}" /></li>
	        </c:forEach>
	    	</ul>    
      	</div>

	<form method="get" action="Deconnexion" id="deconnexion">
		<input type="submit" value="Se deconnecter" />
	</form>
	
</div>      

</body>
</html>