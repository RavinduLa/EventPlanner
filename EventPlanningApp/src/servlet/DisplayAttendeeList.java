package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MarkAttendee;
import service.AttendeeServiceImplementation;


@WebServlet("/DisplayList")
public class DisplayAttendeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAttendeeList() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		MarkAttendee attendee = new MarkAttendee();
		AttendeeServiceImplementation att = new AttendeeServiceImplementation();
		
		attendee.setUSERID(request.getParameter("UId"));
		attendee.setSEATNO(request.getParameter("seatNo"));
		if((request.getParameter("seat")).equals("Yes") && (request.getParameter("pay")).equals("Yes"))
		{
			attendee.setATTENDANCE("Presence");
		}
		else
		{
			attendee.setATTENDANCE("Absence");
		}
		
		
		att.addAttandee(attendee);
		
		System.out.println("After Adding");
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/presenceList.jsp");
		dispatcher.forward(request, response);
	}

}
