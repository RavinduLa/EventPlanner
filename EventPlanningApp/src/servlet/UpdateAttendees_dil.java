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
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateAttendees_dil")
public class UpdateAttendees_dil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAttendees_dil() {
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
		attendee.setUserID(request.getParameter("useridupdate"));
		attendee.setName(request.getParameter("nameud"));
		attendee.setAddress(request.getParameter("addressud"));
		attendee.setAge(request.getParameter("ageud"));
		attendee.setPaymentMethod(request.getParameter("pmethodud"));
		attendee.setGender(request.getParameter("genderud"));
		attendee.setEmail(request.getParameter("emailud"));

		
		IuserServices ius = new UserServices();
		ius.UpdateU(attendee);
		
		request.setAttribute("attendee", attendee);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/UpdateConfirm_dil.jsp");
		
		disp.forward(request, response);
		
		
	}

}
