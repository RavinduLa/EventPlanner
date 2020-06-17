package servlet;
/*Reg No - IT19075204 , Name - G.G.D.D Weerasinghe */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Attendee;
import userServices.IuserServices;
import userServices.UserServices;

/**
 * Servlet implementation class AssignAttendees
 */
@WebServlet("/AssignAttendees_dil")
public class AssignAttendees_dil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignAttendees_dil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Attendee attendee = new Attendee();
		
		attendee.setEventID(request.getParameter("Eventid"));
		attendee.setUserID(request.getParameter("userid"));
		
		IuserServices aa =  new UserServices();
		aa.CreateTable(attendee);
		
		//added by rlw
		/*
		String eventId = request.getParameter("Eventid");
		String creatorId = request.getParameter("creatorId");
		
		request.setAttribute("eventId", eventId);
		request.setAttribute("username", creatorId);*/
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/listEvents.jsp");
		
		/*
		request.setAttribute("attendee", attendee);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/ShowEvent_dil.jsp");*/
		
		disp.forward(request, response);
		
		
	}

}
