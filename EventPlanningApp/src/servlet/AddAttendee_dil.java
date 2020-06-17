package servlet;
/*Reg No - IT19075204 , Name - G.G.D.D Weerasinghe */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import model.Attendee;
import userServices.IuserServices;
import userServices.UserServices;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddAttendee_dil")
public class AddAttendee_dil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttendee_dil() {
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
		attendee.setUserID(request.getParameter("userid"));
		attendee.setName(request.getParameter("name"));
		attendee.setAddress(request.getParameter("address"));
		attendee.setAge(request.getParameter("age"));
		attendee.setPaymentMethod(request.getParameter("pmethod"));
		attendee.setGender(request.getParameter("gender"));
		attendee.setEmail(request.getParameter("email"));
		attendee.setCreatorId(request.getParameter("creatorId"));

		System.out.println("before services");
		IuserServices ius = new UserServices();
		ius.RegisterU(attendee);
		
		System.out.println("after services");
		
		request.setAttribute("attendee", attendee);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/RegisterAttendeesConfirmation_dil.jsp");
		
		disp.forward(request, response);
		
		
	}

}
