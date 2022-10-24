package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Utilisateur;

public class Noms {
    private Connection connexion;
    
    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT id, surname, firstname, statut FROM user;");

            // Récupération des données
            while (resultat.next()) {
                String id = resultat.getString("id");
                String surname = resultat.getString("surname");
                String firstname = resultat.getString("firstname");
                String statut = resultat.getString("statut");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(id);
                utilisateur.setSurname(surname);
                utilisateur.setFirstname(firstname);
                utilisateur.setStatut(statut);

                utilisateurs.add(utilisateur);
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
        
        return utilisateurs;
    }
    
    
    //____________________________________
    
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
    
    //____________________________________
    
    public List<Utilisateur> recupererUtilisateursStatut(String statut) {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT id, surname, firstname FROM user WHERE statut = " + statut);

            // Récupération des données
            while (resultat.next()) {
                String id = resultat.getString("id");
                String surname = resultat.getString("surname");
                String firstname = resultat.getString("firstname");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(id);
                utilisateur.setSurname(surname);
                utilisateur.setFirstname(firstname);

                utilisateurs.add(utilisateur);
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
        
        return utilisateurs;
    }

}