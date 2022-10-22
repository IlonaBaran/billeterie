package com.octest.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.ConferenceRoom;
import com.octest.beans.Utilisateur;
import com.octest.bdd.EnregistrementEvent;
import com.octest.bdd.EnregistrementSalle;
import com.octest.bdd.Noms;


/**
 * Servlet implementation class Valider
 */
public class Valider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valider() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TABLE DES UTILISATEURS
		Noms userTable = new Noms();
        boolean trouve = false ;
        
        // PARAMETRES DE L UTILISATEUR QUI VEUT SE CONNECTER
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setSurname(request.getParameter("surname"));
        utilisateur.setFirstname(request.getParameter("firstname"));
        utilisateur.setStatut(request.getParameter("statut"));
        
        // BOUCLE POUR SAVOIR SI LA PERSONNE EST DANS LA BDD
        for (Utilisateur i : userTable.recupererUtilisateurs()) {
            if (i.equals(utilisateur)) {
                // ON OUVRE UNE SESSION
                HttpSession session = request.getSession();
            	trouve = true;
            	
                session.setAttribute("id", i.getId());
                session.setAttribute("surname", i.getSurname());
                session.setAttribute("firstname", i.getFirstname());        		
                        		
            	if (utilisateur.getStatut().equals("1")){
                    this.getServletContext().getRequestDispatcher("/WEB-INF/statut/etudiant.jsp").forward(request, response);
            	} else if (utilisateur.getStatut().equals("2")){
                    this.getServletContext().getRequestDispatcher("/WEB-INF/statut/personnel.jsp").forward(request, response);
            	} else if (utilisateur.getStatut().equals("3")){
                    this.getServletContext().getRequestDispatcher("/WEB-INF/redirection.jsp").forward(request, response);
            	}
            	break;
            }       
        }
        
        if (!trouve){
            this.getServletContext().getRequestDispatcher("/").forward(request, response);        
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String surname = request.getParameter("surname");
		request.setAttribute("surname", surname);
		
		doGet(request, response);
	}
}
