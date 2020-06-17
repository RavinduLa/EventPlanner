package servlet;
/*Reg No - IT19075204 , Name - G.G.D.D Weerasinghe */
import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class eventdetails
 */
@WebServlet("/eventdetails_dil")
public class eventdetails_dil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventdetails_dil() {
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
		
		Attendee attendee = new Attendee();
		attendee.setEventID(request.getParameter("eventdetails"));
		
		IuserServices iu = new UserServices();
		ArrayList<Attendee> UserAr = iu.eventdetails(attendee);		
		
		request.setAttribute("UserAr", UserAr);
		RequestDispatcher ds=getServletContext().getRequestDispatcher("/showeventdetails_dil.jsp");
		ds.forward(request, response);
			
	}

}
