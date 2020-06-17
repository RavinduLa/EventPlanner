//IT19000268

//LIYANAGE S.M.H.


package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Budget;

/**
 * Servlet implementation class CreateBudget
 */
@WebServlet("/CreateBudget")
public class CreateBudget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBudget() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
response.setContentType("text/html");

//INSERT NAME OF THE PARTICULAR EVENT
		
		//Budget budget = new Budget();
		//budget.setEventName(request.getParameter("eventName"));

//INSERT EVENT ID OF THE EVENT
		
		Budget budget1 = new Budget();
		budget1.setEventId(request.getParameter("EventId"));
		
		
		//INSERT BUDGET ACCORDING TO EVENT ID
		
		Budget budget2 = new Budget();
		budget2.setBudget(request.getParameter("budget"));
		
		//INSERT VENUE OF THE EVENT
		
		//Budget budget3 = new Budget();
		//budget3.setVenue(request.getParameter("venue"));
		
		
		
		
		
		
		
		System.out.println("BUDGET:");
		
	}

}
