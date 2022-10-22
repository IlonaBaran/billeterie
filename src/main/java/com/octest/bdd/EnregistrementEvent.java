package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            resultat = statement.executeQuery("SELECT id, nameEvent, conferenceRoom, date, time, covidMode FROM event;");

            // Récupération des données
            while (resultat.next()) {
                String id = resultat.getString("id");
                String name = resultat.getString("nameEvent");
                String conferenceRoom = resultat.getString("conferenceRoom");
                String date = resultat.getString("date");
                String time = resultat.getString("time");
                String covidMode = resultat.getString("covidMode");

                Event event = new Event();
                event.setId(id);
                event.setName(name);
                event.setConferenceRoom(conferenceRoom);
                event.setDate(date);
                event.setDate(time);
                event.setCovidMode(covidMode);
                
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
    
    public void ajouterEvent(Event event) {
        loadDatabase();
        try {
        	// INSERTION DE L EVENEMENT DANS LA TABLE DES EVENEMENTS
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO event(nameEvent, conferenceRoom, date, time, covidMode) VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setString(1, event.getName());
            preparedStatement.setString(2, event.getConferenceRoom());
            preparedStatement.setString(3, event.getDate());
            preparedStatement.setString(4, event.getTime());
            preparedStatement.setString(5, event.getCovidMode());
            
            preparedStatement.executeUpdate();
            
        	// CREATION DE LA TABLE DE RESERVATION DES PLACES DE L EVENEMENT
            Statement stmt = connexion.createStatement();
            String nomTable = "reservation_" + event.getName();
            
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
