package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Utilisateur;

public class Enregistrement {
	
    private Connection connexion;
    
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
    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO user(surname, firstname, statut) VALUES(?, ?, ?);");
            preparedStatement.setString(1, utilisateur.getSurname());
            preparedStatement.setString(2, utilisateur.getFirstname());
            preparedStatement.setString(3, utilisateur.getStatut());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
