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
import com.octest.beans.Place;

public class EnregistrementPlace {
	
    private Connection connexion;
    
    public List<Place> recupererPlace(String event) {
    	List<Place> places = new ArrayList<Place>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT idPlace, idUser, idEvent FROM " + event);

            while (resultat.next()) {
                String idPlace = resultat.getString("idPlace");
                String idUser = resultat.getString("idUser");
                String idEvent = resultat.getString("idEvent");

                Place place = new Place();
                place.setIdPlace(idPlace);
                place.setIdUser(idUser);
                place.setIdEvent(idEvent);
                
                places.add(place);
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
        
        return places;
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
    
    public void ajouterPlace(Place place, String idEvent) {
        loadDatabase();
        
        String nomEvent = "reservation_" + idEvent;        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO " + nomEvent.replace(" ", "") + "(idUser, idEvent) VALUES(?, ?);");
            PreparedStatement preparedStatement2 = connexion.prepareStatement("INSERT INTO reservation_all (idUser, idEvent) VALUES(?, ?);");
            PreparedStatement preparedStatement3 = connexion.prepareStatement("UPDATE event SET free_seats = free_seats -1 WHERE id = " + idEvent);

            preparedStatement.setString(1, place.getIdUser());
            preparedStatement.setString(2, place.getIdEvent());
            
            preparedStatement2.setString(1, place.getIdUser());
            preparedStatement2.setString(2, place.getIdEvent());
            
            preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement3.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    // ____________________________________________________________
        
    public List<Place> recupererPlaceUser(String id) {
    	List<Place> places = new ArrayList<Place>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT idEvent FROM reservation_all WHERE idUser = " + id);

            while (resultat.next()) {
                String idEvent = resultat.getString("idEvent");

                Place place = new Place();
                place.setIdEvent(idEvent);
                
                places.add(place);
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
        
        return places;
    }
   
}
