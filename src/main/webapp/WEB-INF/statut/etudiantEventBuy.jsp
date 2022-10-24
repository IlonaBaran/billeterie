
<!DOCTYPE html>
<html>
<head>
<title>Achat personnel</title>
<link rel="stylesheet" href="./style/studentstyle.css">
<link rel="stylesheet" href="./style/style.css">

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
    		<legend class="titre">Acheter un billet</legend>
    		<form method="post" action="EventBuy">
				
				<div id="select">
				<select name ="listEvent">
				    <c:forEach var="event" items="${events}">
				     	<option value = "${event.id}">${event.name}</option>
				    </c:forEach>
				</select>	
				</div> 
				
				<input 	type="submit" value="buyTickets" name="buyTickets" class="button">
			</form>  
      	</fieldset>
		
</div> 
</body>
</html>







		

	



	
</div>      

</body>
</html>