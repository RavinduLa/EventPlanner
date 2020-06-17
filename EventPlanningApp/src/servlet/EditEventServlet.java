//IT19014128 A.M.W.W.R.L. Wataketiya

package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import service.EventServiceImplementation;
import service.IEventService;

/**
 * Servlet implementation class EditEventServlet
 */
@WebServlet("/EditEventServlet")
public class EditEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEventServlet() {
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
		
		
		String eventId = request.getParameter("eventId");
		Event event = new Event();
		
		event.setEventId(eventId);
		event.setEventName(request.getParameter("eventName"));
		
		//starting date
		String startingDateTime= request.getParameter("startingDateTime");
		System.out.println(startingDateTime);
		DateFormat dfStart = new SimpleDateFormat("yyyy-mm-dd hh:mm a"); //this a is required for am pm
		Date parsedStart = null;
		try {
			parsedStart = dfStart.parse(startingDateTime);
			System.out.println("Successfully parsed date time");
		} catch (ParseException e) {
			
			System.out.println("Parse exception in starting date time");
			System.out.println(e);
			e.printStackTrace();
		}
		Timestamp timestampStart = null;
		try
		{
			 timestampStart = new java.sql.Timestamp(parsedStart.getTime());
			 System.out.println("executing timestamp");
		}
		catch(Exception ex)
		{
			System.out.println("Exception in timestamp");
			System.out.println(ex);
		}
		event.setStartingDateTime(timestampStart);
		
		
		
		//ending date time
		String end = request.getParameter("endingDateTime");
		DateFormat dfEnd = new SimpleDateFormat("yyyy-mm-dd hh:mm a");
		Date parsedEnd = null;
		try {
			parsedEnd = dfEnd.parse(end);
		} catch (ParseException e) {
			
			System.out.println("Parse exception in ending date time");
			System.out.println(e);
			e.printStackTrace();
		}
		Timestamp timestampEnd = new java.sql.Timestamp(parsedEnd.getTime());
		
		event.setEndingDateTime(timestampEnd);
		
		long diff = timestampEnd.getTime() - timestampStart.getTime();
		
		event.setVenue(request.getParameter("venue"));
		
		int atLimit = 0;
		try
		{
			atLimit = Integer.parseInt(request.getParameter("atendeeLimit"));
		}
		catch(NumberFormatException numex)
		{
			System.out.println("Atendee limit num format exception");
			System.out.println(numex);
			
			response.setContentType("text/html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/wrongFormat.jsp");
			dispatcher.forward(request, response);
			
		}
		
		event.setAtendeeLimit(atLimit);
		
		event.setCreatorId(request.getParameter("creatorID"));
		
		if(diff > 0)
		{
			IEventService iEventService = new EventServiceImplementation();
			iEventService.updateEventById(eventId, event);
			
			response.setContentType("text/html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listEvents.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dateError.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
