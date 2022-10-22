package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.bdd.EnregistrementEvent;
import com.octest.bdd.EnregistrementPlace;
import com.octest.beans.Place;

/**
 * Servlet implementation class EventBuy
 */
public class EventBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventBuy() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// RECUPERER LA LISTE DES EVENEMENTS
		EnregistrementEvent tableEvent = new EnregistrementEvent();
		request.setAttribute("events", tableEvent.recupererEvent());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/statut/etudiantEventBuy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// RECUPERER LA LISTE DES EVENEMENTS
		EnregistrementEvent tableEvent = new EnregistrementEvent();
		request.setAttribute("events", tableEvent.recupererEvent());
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/etudiantEventBuy.jsp").forward(request, response);
		
		// ACHETER UN TICKET LORSQUE L UTILISATEUR CLIQUE SUR ACHETER UN BILLET 	
		//if (request.getParameter("buyTickets") != null) {
			//String id = request.getParameter("id");
			String idEvent = request.getParameter("listEvent");

			System.out.println("_________________");
			HttpSession session = request.getSession(true);	
			String id = (String) session.getAttribute("id");

			System.out.println(id);
			System.out.println(idEvent);
			System.out.println("_________________");
			
			Place place = new Place();
			place.setIdUser(id);
			place.setIdEvent(idEvent);
	
			EnregistrementPlace placeTable = new EnregistrementPlace ();
			placeTable.ajouterPlace(place, idEvent);
		//}
		
		//doGet(request, response);
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/etudiantEventBuy.jsp").forward(request, response);

	}

}
