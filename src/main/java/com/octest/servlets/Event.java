package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.EnregistrementEvent;

/**
 * Servlet implementation class Event
 */
public class Event extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		EnregistrementEvent tableEvent = new EnregistrementEvent();
		request.setAttribute("events", tableEvent.recupererEvent());
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/admin.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		EnregistrementEvent tableEvent = new EnregistrementEvent();
		request.setAttribute("events", tableEvent.recupererEvent());
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/statut/admin.jsp").forward(request, response);
	}

}
