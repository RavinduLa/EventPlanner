//IT19014128 A.M.W.W.R.L. Wataketiya

package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Timestamp;
import model.Event;
import util.CommonUtilE;

public class EventServiceImplementation implements IEventService{
	
	private static Connection con;
	private PreparedStatement ps;
	private static String sqlUsername = "sa";
	private static String sqlPassword = "event123";
	
	public static final Logger log = Logger.getLogger(EventServiceImplementation.class.getName()); //setting logger
	
	public ArrayList<Event> getEvents() //returns all the events as an arraylist of type events
	{
		return actionOnEvent(null);
	}
	
	public ArrayList<Event> getEventById(String eventId) //returns an event as an arraylist of type events of given event id
	{
		return actionOnEvent(eventId);
	}

	//returns one or more events as an event type array list
	public ArrayList<Event> actionOnEvent(String  eventId) {
		
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        if(eventId != null && !eventId.isEmpty())  //Querying for event of given id
	        {
	        	ps = con.prepareStatement("select * from Events where EventID = ?");
	        	System.out.println("In only one event");
	        	ps.setString(1, eventId);
	        }
	        else
	        {
	        	ps = con.prepareStatement("select * from Events order by EventID ASC");
	        }
	        
	        ResultSet resultset = ps.executeQuery();
	        while (resultset.next())
	        {
	        	Event event = new Event();
	        	event.setEventId(resultset.getString("EventID"));
	        	event.setEventName(resultset.getString("EventName"));
	        	event.setStartingDateTime(resultset.getTimestamp("StartingDateTime"));
	        	event.setEndingDateTime(resultset.getTimestamp("EndingDateTime"));
	        	event.setDuration(resultset.getString("Duration"));
	        	event.setVenue(resultset.getString("Venue"));
	        	event.setCreatorId(resultset.getString("CreatorID"));
	        	event.setAtendeeLimit(resultset.getInt("AtendeeLimit"));
	        	eventList.add(event);
	        }
	        
		}
		catch(Exception ex)
		{
			System.out.println("Exeption in try catch in action on event");
			log.log(Level.SEVERE, ex.getMessage());
			System.out.println(ex);
		}
		
		finally
		{
			try
			{
				if(ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
				System.out.println("closing connections");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in action on event");
				log.log(Level.SEVERE, ex.getMessage());
				System.out.println(ex);
			}
		}
		
		return eventList;
	}
	
	//adds and event to the database taking an event type object as the parameter
	public void addEvent (Event event)
	{
		String eventID = CommonUtilE.generateEventIDs(getEventIDs());
		try
		{ 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
			ps = con.prepareStatement("insert into Events (EventID, EventName, StartingDateTime, EndingDateTime, Venue, CreatorID, AtendeeLimit) values (?,?,?,?,?,?,?)");
			con.setAutoCommit(false);
			
			event.setEventId(eventID);
			ps.setString(1, event.getEventId());
			ps.setString(2, event.getEventName());
			
			
			
			Timestamp startingDateTime = (Timestamp) event.getStartingDateTime();
			ps.setTimestamp(3, startingDateTime);
			
			Timestamp endingDateTime = (Timestamp) event.getEndingDateTime();
			ps.setTimestamp(4, endingDateTime);
			
			ps.setString(5, event.getVenue());
			ps.setString(6, event.getCreatorId());
			
			ps.setInt(7, event.getAtendeeLimit());
			
			ps.execute();
			System.out.println("Executed insert statement");
			con.commit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception in try catch at add event");
			System.out.println(ex);
		}
		
		finally
		{
			try
			{
				if(ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
				System.out.println("closing connections");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in add event");
				log.log(Level.SEVERE, ex.getMessage());
				System.out.println(ex);
			}
		}

	}
	
	//takes in an event id as a string and deletes the related event details form the database
	public void deleteEventById (String eventID)
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("delete from Events where EventID =?");
	        ps.setString(1, eventID);
	        ps.execute();
	        System.out.println("Executed delete statement");
	        con.commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("Exception in try catch in deleteEventById.");
			log.log(Level.SEVERE, ex.getMessage());
		}
		
		finally
		{
			try
			{
				if(ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
				System.out.println("closing connections in deleting events");
			}
			catch(Exception ex)
			{
				System.out.println("Exception finally block in deleting events");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		
		
		
		}
	}
	
	//returns event ids as a string type array list
	private ArrayList<String> getEventIDs()
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select EventID from Events");
	        ResultSet resultset = ps.executeQuery();
	        
	        while(resultset.next())
	        {
	        	arrayList.add(resultset.getString(1));
	        }
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("Exception in try catch in getEventIDs");
			log.log(Level.SEVERE, ex.getMessage());
		}
		finally
		{
			try
			{
				if(ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
				System.out.println("closing connections in getting event ids");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in getting event ids");
				log.log(Level.SEVERE, ex.getMessage());
				System.out.println(ex);
			}
		
		
		
		}
		return arrayList;
		
	}

	//takes in event id as a string and an event type object and updates the database with the relative details of the event object
	@Override
	public void updateEventById(String eventId, Event event) {
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("update Events set EventName=?, StartingDateTime=?, EndingDateTime=?, Venue=?, CreatorID=?, AtendeeLimit=? where EventID =?");
	        ps.setString(1, event.getEventName());
	        
	        
	        Timestamp startingDateTime = (Timestamp) event.getStartingDateTime();
			ps.setTimestamp(2, startingDateTime);
			
			Timestamp endingDateTime = (Timestamp) event.getEndingDateTime();
			ps.setTimestamp(3, endingDateTime);
			
			ps.setString(4, event.getVenue());
			ps.setString(5, event.getCreatorId());
			ps.setInt(6, event.getAtendeeLimit());
			ps.setString(7, event.getEventId());
	        
	        ps.execute();
	        System.out.println("Executed update statement");
	        con.commit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception in try catch in updateEventById");
			System.out.println(ex);
			log.log(Level.SEVERE, ex.getMessage());
		}
		
		finally
		{
			try
			{
				if(ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
				System.out.println("closing connections in editing events");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in editing events");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		
		
		
		}
	}
	
	//Returns an event type arraylist for a given creator id
	@Override
	public ArrayList<Event> getEventForCreator(String creatorId) {
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        
	        
	        ps = con.prepareStatement("select * from Events where CreatorID = ?");
	        ps.setString(1, creatorId);
	        
	        ResultSet resultset = ps.executeQuery();
	        while (resultset.next())
	        {
	        	Event event = new Event();
	        	event.setEventId(resultset.getString("EventID"));
	        	event.setEventName(resultset.getString("EventName"));
	        	event.setStartingDateTime(resultset.getTimestamp("StartingDateTime"));
	        	event.setEndingDateTime(resultset.getTimestamp("EndingDateTime"));
	        	event.setDuration(resultset.getString("Duration"));
	        	event.setVenue(resultset.getString("Venue"));
	        	event.setCreatorId(resultset.getString("CreatorID"));
	        	event.setAtendeeLimit(resultset.getInt("AtendeeLimit"));
	        	eventList.add(event);
	        }
	        
	        
		}
		catch(Exception ex)
		{
			System.out.println("Exception in try catch in getting event for creator");
			System.out.println(ex);
			log.log(Level.SEVERE, ex.getMessage());
		}
		finally
		{
			try
			{
				if(ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
				System.out.println("closing connections");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in get event for creator id");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		
		return eventList;
	}

	//Returns an event type array list for a given creator id
	@Override
	public ArrayList<Event> getTopEventForCreator(String creatorId) {
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select top 2 * from Events where CreatorID = ?");
	        ps.setString(1, creatorId);
	        
	        ResultSet resultset = ps.executeQuery();
	        while (resultset.next())
	        {
	        	Event event = new Event();
	        	event.setEventId(resultset.getString("EventID"));
	        	event.setEventName(resultset.getString("EventName"));
	        	event.setStartingDateTime(resultset.getTimestamp("StartingDateTime"));
	        	event.setEndingDateTime(resultset.getTimestamp("EndingDateTime"));
	        	event.setDuration(resultset.getString("Duration"));
	        	event.setVenue(resultset.getString("Venue"));
	        	event.setCreatorId(resultset.getString("CreatorID"));
	        	event.setAtendeeLimit(resultset.getInt("AtendeeLimit"));
	        	eventList.add(event);
	        }
		}
		catch(Exception e)
		{
			System.out.println("Exception in getting top records");
			System.out.println(e);
			log.log(Level.SEVERE, e.getMessage());
		}
		finally
		{
			try
			{
				if(ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
				System.out.println("closing connections");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in get top events");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		
		return eventList;
	}

	//Returns an event type array list for a given creator id and event id
	@Override
	public ArrayList<Event> searchEventByUser(String creatorId, String eventId) {
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		System.out.println("Event id: " + eventId);
		System.out.println("creatorId : " + creatorId);
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select * from Events where (EventID = ?) and (CreatorID = ?)");
	        ps.setString(1, eventId);
	        ps.setString(2, creatorId);
	        
	        ResultSet resultset = ps.executeQuery();
	        while (resultset.next())
	        {
	        	Event event = new Event();
	        	event.setEventId(resultset.getString("EventID"));
	        	event.setEventName(resultset.getString("EventName"));
	        	event.setStartingDateTime(resultset.getTimestamp("StartingDateTime"));
	        	event.setEndingDateTime(resultset.getTimestamp("EndingDateTime"));
	        	event.setDuration(resultset.getString("Duration"));
	        	event.setVenue(resultset.getString("Venue"));
	        	event.setCreatorId(resultset.getString("CreatorID"));
	        	event.setAtendeeLimit(resultset.getInt("AtendeeLimit"));
	        	eventList.add(event);
	        }
	        
	        
		}
		catch (Exception ex)
		{
			System.out.println("Exception in search event try catch");
			System.out.println(ex);
			log.log(Level.SEVERE, ex.getMessage());
		}
		
		finally
		{
			try
			{
				if(ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
				System.out.println("closing connections");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in search events");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		return eventList;
	}

	

}
