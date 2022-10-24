
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./style/adminstyle.css">
<link rel="stylesheet" href="./style/style.css">
<title>PAGE ADMIN</title>
</head>


<body>
<div id="container">

	<form method="post" action="Admin" id="addSalle">      
        <fieldset class="border" >
    	<legend class="subtitre"> Ajouter une salle </legend>
			<input type="text" name="name" id="name" placeholder="Nom de la salle"/>
			<input type="number" name="seats" id="seats"  min="0" max="500" placeholder="Nombre de place"/>

      	<input type="submit" class="button"/>
      </fieldset>
     </form>
      

	<form method="post" action="AdminEvent"  id="addEvent">      
        <fieldset class="border">
    	<legend class="subtitre"> Ajouter un évenement</legend>
    		<div id="1">
    			<label for="nameEvent">Nom : </label>
    			<input type="text" name="nameEvent" id="nameEvent" placeholder="Nom de l'évenement"/>
    		</div>
			
			<div id="2">
				<label for="conferenceRoom">Lieu :</label>
				<select name ="conferenceRoom" id="lieu">
				    <c:forEach var="room" items="${rooms}">
				     	<option value = "${room.id}">${room.name}</option>
				    </c:forEach>
				</select>			
			</div>
			
			<div id="3">
				<label for="date">Date : </label>
				<input type="date" name="date" id="date" />
			</div>
			
			<div id="4">
				<label for="time">Horaire : </label>
				<input type="time" name="time" id="time" />
			</div>
			
			<div id="5">
				<label for="oui">Covid : </label>
				<input type="radio" name="covidMode" id="oui" value="1"/>
				
			    <label for="non">Pas covid : </label>				
				<input type="radio" name="covidMode" id="non" value="2"/>
		    </div>
		    
		    <div id="6">
				<input type="text" id="description" name="description" placeholder="Description"/>
			</div>	
			
      		<input type="submit" class="button"/>
      </fieldset>
      </form>
      
      	<form method="post" action="Admin" id="addAdmin">      
        <fieldset class="border">
    	<legend class="subtitre"> Ajouter un administrateur</legend>
			<label for="nameEvent">Nom : </label>
			<input type="text" name="nameEvent" id="nameEvent" />
			
      		<input type="submit" class="button"/>
      </fieldset>
      </form>
      
      
      
      
      
      <div id="subContainer">
      
      	<div id="administration">
      		<fieldset id ="infoPerso" class="border">
				<legend class="subtitre">Informations personnelles</legend>
		       	 - ${sessionScope.surname} ${sessionScope.firstname}
		       	<form method="get" action="Deconnexion" id="deconnexion">
					<input type="submit" value="Se deconnecter" />
				</form>
	       	 </fieldset>
	       	 
	       	  <fieldset id ="infoAdmin" class="border">
				<legend class="subtitre">Autres utilisateurs</legend>
				
				<form method="post" action="Admin">
					<input type="submit" value="Etudiants" name="Etudiants" class="button"/>
					<input type="submit" value="Personnels" name="Personnel" class="button"/>
					<input type="submit" value="Administrateurs" name="Administrateur" class="button"/>
				</form>
				
				<div id = "infosUsers" class="scroll">
					<ul>
			        <c:forEach var="nom" items="${noms}">
			            <li><c:out value="${nom.surname} ${nom.firstname}" /></li>
			        </c:forEach>
			    	</ul>   
				</div>
	       	 </fieldset>
		</div>
		
		
	
       <fieldset class="scroll" id="nextEvent" class="border">
    		<legend class="titre">Evenements à venir</legend>
			<ul>
	        <c:forEach var="event" items="${events}">
	            <li><c:out value="Evenement ${event.name} le ${event.date}:${event.time} à ${event.conferenceRoom}. ${event.description} " /></li>
	        </c:forEach>
	    	</ul>    
		</fieldset>

		<fieldset class="scroll" id="availableRoom" class="border">
    		<legend class="titre">Salles disponibles</legend>
			<ul>
	        <c:forEach var="room" items="${rooms}">
	            <li><c:out value="Salle ${room.name}, nombre de place : ${room.seats}" /></li>
	        </c:forEach>
	    	</ul>    
      	</fieldset>
      </div>
 
</div>      

</body>
</html>