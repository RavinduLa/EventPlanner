package service;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.MarkAttendee;

public class AttendeeServiceImplementation {
	private static Connection con;
	private PreparedStatement ps;
	private static String sqlUsername = "sa";
	private static String sqlPassword = "event123";
	
	public AttendeeServiceImplementation() {
		
	}
	
	
	public ArrayList<MarkAttendee> getAttendance() throws SQLException{
	
			ArrayList<MarkAttendee> AttandeeList = new ArrayList<MarkAttendee> ();
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        String sql = "Select * from presenceList";
	        PreparedStatement prepare = con.prepareStatement(sql);
	        ResultSet resultset = prepare.executeQuery();
	        
	 
	        while (resultset.next())
	        {
	        	MarkAttendee Attendee = new MarkAttendee();
	        	Attendee.setUSERID(resultset.getString("userID"));	        			
	        	Attendee.setSEATNO(resultset.getString("seatNo")); 
	        	Attendee.setATTENDANCE(resultset.getString("Attendance"));
	          	System.out.println(resultset.getString("userID"));
	        	
	        	
	        	//event.setDate(resultset.getDate("Date"));
	        	
	        	
	        	
	        	AttandeeList.add(Attendee);
	        	System.out.println(Attendee.getUSERID()+Attendee.getUSERID()+Attendee.getATTENDANCE());
	        }
	        
		}
		catch(Exception ex)
		{
			System.out.println("Exeption hjkol");
			System.out.println(ex.getMessage());
		}
		
		con.close();
		return AttandeeList;
	}
	
	
	public void addAttandee (MarkAttendee Attendee)
	{
		
		try
		{ 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
			System.out.println("Executed b4 con");

	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
			System.out.println("Executed after cont");

			System.out.println(Attendee.getUSERID()+Attendee.getUSERID()+Attendee.getATTENDANCE());
			ps = con.prepareStatement("insert into presenceList (userID,seatNo,Attendance) values (?,?,?)");
			con.setAutoCommit(false);
			System.out.println("Ex 3t");

			
			
			
			ps.setString(1, Attendee.getUSERID());
			ps.setString(2, Attendee.getSEATNO());
			ps.setString(3, Attendee.getATTENDANCE());
			
			
			
			
			ps.execute();
			System.out.println("Executed insert statement");
			con.commit();
		}
		catch(Exception ex)
		{
			System.out.println("Error at add event");
			System.out.println(ex);
		}
	}

	public MarkAttendee viewMarkAttendee(String USERID)
	{
		MarkAttendee mattendee = new MarkAttendee();

		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select userID from presenceList");
	        ResultSet resultset = ps.executeQuery();
	        
	        while(resultset.next())
	        {
	        	mattendee.setUSERID(resultset.getString("userID"));
	        	mattendee.setSEATNO(resultset.getString("seatNo"));
	        	mattendee.setATTENDANCE(resultset.getString("Attendance"));
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
				System.out.println("closing connections in getting user ids");
			}
			catch(Exception ex)
			{
				System.out.println("Exception lloedfp getting event ids");
				System.out.println(ex);
			}
		
		
		
		}
		return mattendee;
		
	
	}
	
	public void deleteAttandee (MarkAttendee Attendee)
	{
		
		try
		{ 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
			System.out.println("Executed b4 con");

	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
			System.out.println("Executed after cont");

			System.out.println(Attendee.getUSERID());
			ps = con.prepareStatement("delete from presenceList where userID = ?");
			con.setAutoCommit(false);
			System.out.println("Ex 3t");
			ps.setString(1, Attendee.getUSERID());		
			ps.execute();
			System.out.println("Delete Success..!");
			con.commit();
		}
		catch(Exception ex)
		{
			System.out.println("Error at delete event");
			System.out.println(ex);
		}
	}
	
	
	public void updateAttandee (MarkAttendee Attendee)
	{
		
		try
		{ 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
			System.out.println("Executed b4 con");

	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
			System.out.println("Executed after cont");

			System.out.println(Attendee.getUSERID());
			ps = con.prepareStatement("update presenceList set Attendance = ? where userID = ?");
			con.setAutoCommit(false);
			ps.setString(1, Attendee.getATTENDANCE());
			ps.setString(2, Attendee.getUSERID());
			ps.execute();
			System.out.println("Update Success..!");
			con.commit();
		}
		catch(Exception ex)
		{
			System.out.println("Error at delete event");
			System.out.println(ex);
		}
	}
	
}
