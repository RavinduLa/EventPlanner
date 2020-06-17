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

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class DeleteMarkAttendee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMarkAttendee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		MarkAttendee attendee = new MarkAttendee();
		AttendeeServiceImplementation att = new AttendeeServiceImplementation();
		
		attendee.setUSERID(request.getParameter("UId"));
		att.deleteAttandee(attendee);
		
		System.out.println("After Deleting");
		
		response.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/presenceList.jsp");
		dispatcher.forward(request, response);
		doGet(request, response);
	}

}
