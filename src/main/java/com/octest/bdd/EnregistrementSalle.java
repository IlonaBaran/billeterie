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

public class EnregistrementSalle {
	
    private Connection connexion;
    
    public List<ConferenceRoom> recupererConferenceRoom() {
    	List<ConferenceRoom> conferenceRooms = new ArrayList<ConferenceRoom>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT name_room, seats_room FROM conference_room;");

            // Récupération des données
            while (resultat.next()) {
                String name_room = resultat.getString("name_room");
                String seats_room = resultat.getString("seats_room");

                ConferenceRoom conferenceRoom = new ConferenceRoom();
                conferenceRoom.setName(name_room);
                conferenceRoom.setSeats(seats_room);
                
                conferenceRooms.add(conferenceRoom);
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
        
        return conferenceRooms;
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

    
    public void ajouterSalle(ConferenceRoom conferenceRoom) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO conference_room(name_room, seats_room) VALUES(?, ?);");
            preparedStatement.setString(1, conferenceRoom.getName());
            preparedStatement.setString(2, conferenceRoom.getSeats());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
