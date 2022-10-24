package com.octest.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Enregistrement;
import com.octest.bdd.EnregistrementEvent;
import com.octest.bdd.EnregistrementSalle;
import com.octest.beans.ConferenceRoom;
import com.octest.beans.Utilisateur;
import com.octest.beans.Event;

/**
 * Servlet implementation class Admin
 */
public class AdminEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEvent() {
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
		EnregistrementSalle tableRoom = new EnregistrementSalle();
		request.setAttribute("rooms", tableRoom.recupererConferenceRoom());
		
		// ENREGISTRER UN NOUVEL EVENEMENT + AFFICHAGE 
		Event event = new Event();
		event.setName(request.getParameter("nameEvent"));
		event.setConferenceRoom(request.getParameter("conferenceRoom"));
		event.setDate(request.getParameter("date"));
		event.setTime(request.getParameter("time"));
		event.setCovidMode(request.getParameter("covidMode"));
		event.setDescription(request.getParameter("description"));
		
		EnregistrementEvent tableEvent = new EnregistrementEvent();
		tableEvent.ajouterEvent(event);
		request.setAttribute("events", tableEvent.recupererEvent());

        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/admin.jsp").forward(request, response);

	}

}
