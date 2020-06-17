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
 * Servlet implementation class GetUser
 */
@WebServlet("/GetAttendee_dil")
public class GetAttendee_dil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAttendee_dil() {
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
		Attendee attendee = new Attendee();
		attendee.setUserID(request.getParameter("useridget"));
		

		
		IuserServices ius = new UserServices();
		attendee = ius.GetU(attendee, creatorId);
		
		if(attendee.getUserID() == null)
		{
			System.out.println("Attendee is null");
			request.setAttribute("attendee", attendee);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/invalidAttendee.jsp");
			
			disp.forward(request, response);
			
		}
		
		
		
		request.setAttribute("attendee", attendee);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/UpdateAttendee_dil.jsp");
		
		disp.forward(request, response);
	}

}
