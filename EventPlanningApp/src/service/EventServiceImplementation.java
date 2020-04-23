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
import java.util.Date;

import model.Event;
import util.CommonUtilE;

public class EventServiceImplementation implements IEventService{
	
	private static Connection con;
	private PreparedStatement ps;
	private static String sqlUsername = "sa";
	private static String sqlPassword = "event123";
	
	public ArrayList<Event> getEvents()
	{
		return actionOnEvent(null);
	}
	
	public ArrayList<Event> getEventById(String eventId)
	{
		return actionOnEvent(eventId);
	}

	public ArrayList<Event> actionOnEvent(String  eventId) {
		// TODO Auto-generated method stub
		
		ArrayList<Event> eventList = new ArrayList<Event>();
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        if(eventId != null && !eventId.isEmpty())  //Querying for employee of given id
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
	        	//event.setDate(resultset.getDate("Date"));
	        	event.setStartingDateTime(resultset.getTimestamp("StartingDateTime"));
	        	event.setEndingDateTime(resultset.getTimestamp("EndingDateTime"));
	        	event.setDuration(resultset.getString("Duration"));
	        	event.setVenue(resultset.getString("Venue"));
	        	event.setStatus(resultset.getBoolean("Status"));
	        	event.setCreatorId(resultset.getString("CreatorID"));
	        	event.setAtendeeLimit(resultset.getInt("AtendeeLimit"));
	        	eventList.add(event);
	        }
	        
		}
		catch(Exception ex)
		{
			System.out.println("Exeption hjkol");
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
				System.out.println("Exception lloedfp");
				System.out.println(ex);
			}
		}
		
		return eventList;
	}
	
	public void addEvent (Event event)
	{
		String eventID = CommonUtilE.generateIDs(getEventIDs());
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
			//ps.setBoolean(4, event.isStatus());
			ps.setString(6, event.getCreatorId());
			
			ps.setInt(7, event.getAtendeeLimit());
			
			ps.execute();
			System.out.println("Executed insert statement");
			con.commit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception at add event");
			System.out.println(ex);
		}
	}
	
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
				System.out.println("Exception in deleting events");
				System.out.println(ex);
			}
		
		
		
		}
	}
	
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
				System.out.println("Exception lloedfp getting event ids");
				System.out.println(ex);
			}
		
		
		
		}
		return arrayList;
		
	}

	@Override
	public void updateEventById(String eventId, Event event) {
		// TODO Auto-generated method stub
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
				System.out.println("closing connections in editing events");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in editing events");
				System.out.println(ex);
			}
		
		
		
		}
	}

}
