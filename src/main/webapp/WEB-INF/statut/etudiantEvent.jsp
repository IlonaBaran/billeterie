<!DOCTYPE html>
<html>
<head>
<title>Page personnelle</title>
<link rel="stylesheet" href="./style/studentstyle.css">
<link rel="stylesheet" href="./style/style.css">


</head>
<body>

<div id="container">

		<fieldset id="infoPerso" class="border">
		    <form method="get" action="Deconnexion" id="deconnexion">
				<input type="submit" value="Se deconnecter" class="button" id="deconnexionbutton"/>
			</form>
			<legend class="titre">Informations personnelles</legend>
        	 ${ sessionScope.surname } ${ sessionScope.firstname }
		</fieldset>
		
		<fieldset id="mesreservation">
			<legend class="titre">Mes réservations et mes billets</legend>
			<ul>
	        <c:forEach var="event" items="${eventsUser}">
	            <li><c:out value="${event.idEvent}" /></li>
	        </c:forEach>
	    	</ul>    
		</fieldset>
	
		<fieldset id="events">
		     <form method="get" action="EventBuy" >		
				<input 	class="button" type="submit" value="ACHETER" name="ACHETER" id="eventbuy">			
		     </form>
     
    		<legend class="titre">Evenements à venir</legend>
			<ul>
	        <c:forEach var="event" items="${events}">
	            <li><c:out value="${event.id} le ${event.date}:${event.time} à ${event.conferenceRoom}" /></li>
	        </c:forEach>
	    	</ul>    
      	</fieldset>


	
</div>      

</body>
</html>