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
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteAttendeeS_dil")
public class DeleteAttendeeS_dil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAttendeeS_dil() {
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
		
		response.setContentType("text/html");
		
		String creatorId = request.getParameter("creatorId");
		int success;
		Attendee attendee = new Attendee();
		
		attendee.setUserID(request.getParameter("useriddelete"));
		
		IuserServices ius = new UserServices();
		success = ius.DeleteU(attendee, creatorId);
		
		if (success == 0)
		{
			request.setAttribute("attendee", attendee);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/invalidAttendee.jsp");
			
			disp.forward(request, response);
		}
		
		System.out.println(success);
		request.setAttribute("attendee", attendee);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/DeleteAttendee_dil.jsp");
		
		disp.forward(request, response);
		
		
	}

}
