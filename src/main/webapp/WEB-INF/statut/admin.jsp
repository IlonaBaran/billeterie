
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PAGE ADMIN</title>
</head>
<body>
	<p>PAGE ADMIN</p>

	<form method="post" action="Admin">      
        <fieldset>
    	<legend> AJOUTER UNE SALLE</legend>
			<label for="name">Nom : </label>
			<input type="text" name="name" id="name" />
			<label for="seats">Nombre de place : </label>
			<input type="number" name="seats" id="seats"  min="0" max="500"/>

      	<input type="submit"/>
      </fieldset>

        <fieldset>
    	<legend> AJOUTER UN EVENEMENT</legend>
			<label for="nameEvent">Nom : </label>
			<input type="text" name="nameEvent" id="nameEvent" />
			
			<label for="conferenceRoom">Salle de conférence : </label>
			<select name ="conferenceRoom">
			    <c:forEach var="room" items="${rooms}">
			     	<option value = "${room.name}">${room.name}</option>
			    </c:forEach>
			</select>			
			
			<label for="date">Date : </label>
			<input type="date" name="date" id="date" />
			
			<label for="time">Horaire de début : </label>
			<input type="time" name="time" id="time" />
			
			<input type="radio" name="covidMode" id="oui" value="1"/>
            <label for="etudiant">Covid : </label>
			<input type="radio" name="covidMode" id="non" value="2"/>
		    <label for="personnel">Pas covid : </label>

      	<input type="submit"/>
      </fieldset>
      
      </form>
      
            	<fieldset>
    		<legend>LISTE DES EVENEMENTS</legend>
		<ul>
        <c:forEach var="event" items="${events}">
            <li><c:out value="${event.name} le ${event.date}:${event.time} à ${event.conferenceRoom}" /></li>
        </c:forEach>
    	</ul>    
      </fieldset>


		<fieldset>
    		<legend>LISTE DES SALLES</legend>
		<ul>
        <c:forEach var="room" items="${rooms}">
            <li><c:out value="Salle ${room.name}, nombre de place : ${room.seats}" /></li>
        </c:forEach>
    	</ul>    
      </fieldset>
 
      

		


</body>
</html>