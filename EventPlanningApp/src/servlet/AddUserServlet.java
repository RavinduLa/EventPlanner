//IT19014128 A.M.W.W.R.L. Wataketiya

package servlet;

import java.io.IOException;
import java.sql.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.IUserService;
import service.UserServiceImplementation;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
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

		response.setContentType("text/html");

		User user = new User();

		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));

		String bdate = request.getParameter("dateOfBirth");

		Date sqlDate = Date.valueOf(bdate);
		user.setDateOfBirth(sqlDate);

		String password = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");

		if (!password.contentEquals(confPassword)) {
			response.setContentType("text/html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/passwordMismatch.jsp");
			dispatcher.forward(request, response);
		} else if (password.contentEquals(confPassword)) {
			user.setPassword(password);
			try {
				IUserService iuserService = new UserServiceImplementation();
				iuserService.addUser(user);

				response.setContentType("text/html");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminDashboard.jsp");
				dispatcher.forward(request, response);
			} catch (Exception ex) {
				System.out.println("Exception in adding user in the servlet");
				System.out.println(ex);

				response.setContentType("text/html");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addUser.jsp");
				dispatcher.forward(request, response);
			}
		}

	}

}
