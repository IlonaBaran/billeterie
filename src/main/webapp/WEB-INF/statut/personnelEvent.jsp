<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events Etudiants</title>
</head>
<body>

        <p>PAGE ETUDIANT</p>
        
    <form method="post" action="Profil">
		<input type="submit" name="surname"/>
		<c:out value = "${surname }"/>
	</form>
	
		<form method="get" action="Etudiant">
		<input type="submit" value="Billets/Reservations"/>
	</form>
	
	<form method="get" action="Etudiant">
		<input type="submit" value="Acheter un billet"/>
	</form>
	
	<form method="get" action="EventEtudiant">
		<input type="submit" value="Liste des évenements"/>
		
			   <fieldset>
    		<legend>LISTE DES EVENEMENTS</legend>
		<ul>
        <c:forEach var="event" items="${events}">
            <li><c:out value="${event.name} le ${event.date} à ${event.conferenceRoom}" /></li>
        </c:forEach>
    	</ul>    
      </fieldset>
	</form>

</body>
</html>