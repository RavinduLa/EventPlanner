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
import model.User;
import service.AdminServiceImplementation;
import service.IAdminService;
import service.IUserService;
import service.UserServiceImplementation;

/**
 * Servlet implementation class NormalLoginServlet
 */
@WebServlet("/NormalLoginServlet")
public class NormalLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NormalLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String normalUsername = request.getParameter("normalUsername");
		String password = request.getParameter("password");

		IUserService iuser = new UserServiceImplementation();
		ArrayList<User> arraylist = iuser.getUserById(normalUsername);

		String qPassword = null;
		for (User user : arraylist) {
			qPassword = user.getPassword();
		}

		if (password.equals(qPassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("normalUsername", normalUsername);

			response.setContentType("text/html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userDashboard.jsp");
			dispatcher.forward(request, response);
		} else {

			response.setContentType("text/html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/invalidUserLogin.jsp");
			dispatcher.forward(request, response);
		}
	}

}
