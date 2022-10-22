package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.EnregistrementEvent;
import com.octest.bdd.EnregistrementPlace;
import com.octest.bdd.EnregistrementSalle;
import com.octest.beans.ConferenceRoom;
import com.octest.beans.Place;

/**
 * Servlet implementation class EventEtudiant
 */
public class EventList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// RECUPERER LA LISTE DES EVENEMENTS
		EnregistrementEvent tableEvent = new EnregistrementEvent();
		request.setAttribute("events", tableEvent.recupererEvent());
		
		// INFORMATION PEROSNNELLES
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/etudiantEvent.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnregistrementEvent tableEvent = new EnregistrementEvent();
		request.setAttribute("events", tableEvent.recupererEvent());
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/etudiantEvent.jsp").forward(request, response);
	}

}
