//IT19014128 A.M.W.W.R.L. Wataketiya

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import service.AdminServiceImplementation;
import service.IAdminService;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		
		String adminUsername = request.getParameter("adminUsername");
		String password = request.getParameter("password");
		
		
		IAdminService iadmin= new AdminServiceImplementation();
		ArrayList<Admin> arraylist  = iadmin.getAdminById(adminUsername);
		
		String qPassword = null;
		for (Admin admin : arraylist)
		{
			qPassword = admin.getAdminPassword();
		}
		
		if(password.equals(qPassword))
		{
			HttpSession session=request.getSession();  
	        session.setAttribute("adminUsername",adminUsername); 
	        
	        response.setContentType("text/html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminDashboard.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{
		
			response.setContentType("text/html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/invalidAdminLogin.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
