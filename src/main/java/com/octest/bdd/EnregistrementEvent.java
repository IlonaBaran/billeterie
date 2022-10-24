package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.ConferenceRoom;
import com.octest.beans.Event;

public class EnregistrementEvent {
	
    private Connection connexion;
    
    public List<Event> recupererEvent() {
    	List<Event> events = new ArrayList<Event>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT id, name_event, conference_room, date, time, covid_mode, description FROM event;");

            // Récupération des données
            while (resultat.next()) {
                String id = resultat.getString("id");
                String name = resultat.getString("name_event");
                String conferenceRoom = resultat.getString("conference_room");
                String date = resultat.getString("date");
                String time = resultat.getString("time");
                String covidMode = resultat.getString("covid_mode");
                String description = resultat.getString("description");

                Event event = new Event();
                event.setId(id);
                event.setName(name);
                event.setConferenceRoom(conferenceRoom);
                event.setDate(date);
                event.setTime(time);
                event.setCovidMode(covidMode);
                event.setDescription(description);

                events.add(event);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return events;
    }
    
    // ____________________________________________________________
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
        	connexion = DriverManager.getConnection("jdbc:mysql://mysql-challensge.alwaysdata.net/challensge_censg", "284673", "bcz!P6T%up");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    // ____________________________________________________________
    
    public String recupererLastEvent() {
    	Event event = new Event();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT id FROM event ORDER BY id DESC LIMIT 1;");

            // Récupération des données
            while (resultat.next()) {
                String id = resultat.getString("id");
                event.setId(id);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return event.getId();
    }
 
    // ____________________________________________________________
    
    public void ajouterEvent(Event event) {
        loadDatabase();
        try {
        	// INSERTION DE L EVENEMENT DANS LA TABLE DES EVENEMENTS
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO event(name_event, conference_room, date, time, covid_mode, description, free_seats) VALUES(?, ?, ?, ?, ?, ?, ?);");

            preparedStatement.setString(1, event.getName());
            preparedStatement.setString(2, event.getConferenceRoom());
            preparedStatement.setString(3, event.getDate());
            preparedStatement.setString(4, event.getTime());
            preparedStatement.setString(5, event.getCovidMode());
            preparedStatement.setString(6, event.getDescription());
            
            EnregistrementSalle salle = new EnregistrementSalle();
            preparedStatement.setString(7, salle.recupererNbPlace(event.getConferenceRoom()));
           
            preparedStatement.executeUpdate();
            
        	// CREATION DE LA TABLE DE RESERVATION DES PLACES DE L EVENEMENT
            Statement stmt = connexion.createStatement();
            EnregistrementEvent enregistrementEvent = new EnregistrementEvent();
            String nomTable = "reservation_" + enregistrementEvent.recupererLastEvent();
            
            String sql = "CREATE TABLE " + nomTable.replace(" ", "") +
                         "(idPlace SERIAL NOT NULL, " +
                         " idUser VARCHAR(255), " + 
                         " idEvent VARCHAR(255)," +
                          "PRIMARY KEY (idPlace))  "; 
            stmt.executeUpdate(sql);

            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    

    

    

}
