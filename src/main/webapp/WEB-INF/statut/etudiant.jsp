<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events Etudiants</title>
</head>
<body>

        <p>PAGE ETUDIANT</p>
     <p>Vous êtes ${ sessionScope.id } ${ sessionScope.surname } !</p>
        
        
	<form method="get" action="EventList">
		<input type="submit" value="Redirection vers la page etudiant" />
		<input type="hidden" name="id" value ="${id}">
	</form>	
	
	<form method="get" action="Deconnexion">
		<input type="submit" value="Se deconnecter" />
	</form>
      

	<form method="get" action="EventList">
		<fieldset>
			<legend>INFORMATIONS PERSONNELLES</legend>
        	 <p>Vous êtes ${ sessionScope.id } 
        	 ${ sessionScope.surname } !</p>
		</fieldset>
		
		<fieldset>
			<legend>MES RESERVATIONS ET MES BILLETS</legend>
		</fieldset>
	
		<fieldset>
    		<legend>LISTE DES EVENEMENTS</legend>
		<ul>
        <c:forEach var="event" items="${events}">
            <li><c:out value="${event.id} le ${event.date}:${event.time} à ${event.conferenceRoom}" /></li>
        </c:forEach>
    	</ul>    
      </fieldset>
    </form>
 
 
     <form method="get" action="EventBuy">		
		<input type="hidden" name="id" value ="${param.id}">
		<input 	type="submit" value="ACHETER" name="ACHETER">			
     </form>

</body>
</html>