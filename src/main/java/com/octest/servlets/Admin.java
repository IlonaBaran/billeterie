package com.octest.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Enregistrement;
import com.octest.bdd.EnregistrementEvent;
import com.octest.bdd.EnregistrementSalle;
import com.octest.bdd.Noms;
import com.octest.beans.ConferenceRoom;
import com.octest.beans.Utilisateur;
import com.octest.beans.Event;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		EnregistrementEvent tableEvent = new EnregistrementEvent();
		request.setAttribute("events", tableEvent.recupererEvent());
		
		EnregistrementSalle tableRoom = new EnregistrementSalle();
		request.setAttribute("rooms", tableRoom.recupererConferenceRoom());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/admin.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ENREGISTRER UNE NOUVELLE SALLE DE CONFERENCE + AFFICHAGE 
		ConferenceRoom conferenceRoom = new ConferenceRoom();
		conferenceRoom.setName(request.getParameter("name"));
		conferenceRoom.setSeats(request.getParameter("seats"));

		EnregistrementSalle conferenceRoomTable = new EnregistrementSalle ();
		conferenceRoomTable.ajouterSalle(conferenceRoom);
		request.setAttribute("rooms", conferenceRoomTable.recupererConferenceRoom());

		
		// ENREGISTRER UN NOUVEL EVENEMENT + AFFICHAGE 
		Event event = new Event();
		event.setName(request.getParameter("nameEvent"));
		event.setConferenceRoom(request.getParameter("conferenceRoom"));
		event.setDate(request.getParameter("date"));
		event.setTime(request.getParameter("time"));
		event.setCovidMode(request.getParameter("covidMode"));
		//event.setCovidMode(request.getParameter("description"));
		
        System.out.println("___________");
        System.out.println(request.getParameter("nameEvent"));
        System.out.println(request.getParameter("date") + "___" + request.getParameter("time"));
        System.out.println("___________");

		EnregistrementEvent tableEvent = new EnregistrementEvent();
		tableEvent.ajouterEvent(event);
		request.setAttribute("events", tableEvent.recupererEvent());
		
		
		// ENREGISTRER UN NOUVEL ADMIN + AFFICHAGE 
		Utilisateur utilisateur = new Utilisateur();
        utilisateur.setSurname(request.getParameter("surname"));
        utilisateur.setFirstname(request.getParameter("firstname"));
        utilisateur.setStatut(request.getParameter("statut"));

        Enregistrement userTable = new Enregistrement ();
        userTable.ajouterUtilisateur(utilisateur);

		if (request.getParameter("Etudiants") != null) {
			Noms tableNoms = new Noms();
			request.setAttribute("noms", tableNoms.recupererUtilisateursStatut("1"));
			System.out.println("Etudiants");
		}
		if (request.getParameter("Personnel") != null) {
			Noms tableNoms = new Noms();
			request.setAttribute("noms", tableNoms.recupererUtilisateursStatut("2"));
			System.out.println("Personnel");
		}
		if (request.getParameter("Administrateur") != null) {
			Noms tableNoms = new Noms();
			request.setAttribute("noms", tableNoms.recupererUtilisateursStatut("3"));
			System.out.println("Administrateur");
		}
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/admin.jsp").forward(request, response);

	}

}
