<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>PAGE ENREGISTREMENT</p>
	    <form method="post" action="Enregistrer">
        <p>
            <label for="surname">Nom : </label>
            <input type="text" name="surname" id="surname" />
            <label for="firstname">Prénom : </label>
            <input type="text" name="firstname" id="firstname" />
        </p>
        
        <p>
            <input type="radio" name="statut" id="etudiant" value="1"/>
            <label for="etudiant">Etudiant</label>
            
            <input type="radio" name="statut" id="personnel" value="2"/>
            <label for="personnel">Personnel</label>     
        </p>
        
        <input type="submit"/>
    </form>

</body>
</html>