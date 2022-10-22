package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.EnregistrementSalle;
import com.octest.beans.ConferenceRoom;

/**
 * Servlet implementation class AjouterSalleAdmin
 */
public class AjouterSalleAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterSalleAdmin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConferenceRoom conferenceRoom = new ConferenceRoom();
		conferenceRoom.setName(request.getParameter("nameRoom"));
		conferenceRoom.setSeats(request.getParameter("seatsRoom"));

		EnregistrementSalle conferenceRoomTable = new EnregistrementSalle ();
		conferenceRoomTable.ajouterSalle(conferenceRoom);
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/admin.jsp").forward(request, response);
	}

}
