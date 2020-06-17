package userServices;
/*Reg No - IT19075204 , Name - G.G.D.D Weerasinghe */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Attendee;

public class UserServices implements IuserServices {
	public static Connection con;
	public static PreparedStatement ps;    
		
	@Override
	public void RegisterU(Attendee attendee) {
		con = dbUtil.ConnectionUtil.getConn();
		
		
		try {
			ps = con.prepareStatement("insert into attendee values(?,?,?,?,?,?,?,?) ");
			
			con.setAutoCommit(false);
		
			ps.setString(1, attendee.getUserID());
			ps.setString(2, attendee.getName());
			ps.setString(3, attendee.getAddress());
			ps.setString(4, attendee.getAge());
			ps.setString(5, attendee.getPaymentMethod());
			ps.setString(6, attendee.getGender());
			ps.setString(7, attendee.getEmail());
			ps.setString(8, attendee.getCreatorId());


			ps.execute();
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	@Override
	public void UpdateU(Attendee attendee) {
		con=dbUtil.ConnectionUtil.getConn();
		
		try {
			ps = con.prepareStatement("UPDATE attendee set Name=?, Address=?, Age=?, PaymentMethod=?, Gender=?, Email=?  WHERE UserID = ?");
			
			ps.setString(1, attendee.getName());
			ps.setString(2, attendee.getAddress());
			ps.setString(3, attendee.getAge());
			ps.setString(4, attendee.getPaymentMethod());
			ps.setString(5, attendee.getGender());
			ps.setString(6, attendee.getEmail());
			ps.setString(7, attendee.getUserID());
			 
			ps.executeUpdate();
			con.commit();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

	@Override
	public int DeleteU(Attendee attendee, String creatorId) {
		// TODO Auto-generated method stub
		
		con = dbUtil.ConnectionUtil.getConn();
		int success = 1;
		try {
			ps = con.prepareStatement("DELETE FROM attendee WHERE (UserID = ?) and (CreatorID = ?)");
			
			con.setAutoCommit(false);
			ps.setString(1,attendee.getUserID());
			ps.setString(2, creatorId);
			
			ps.execute();
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = 0;
		}
		
		return success;
	}

	@Override
	public ArrayList<Attendee> ListU(String creatorId) {
		// TODO Auto-generated method stub
		ArrayList<Attendee> attendee = new ArrayList<Attendee>();
		
		con = dbUtil.ConnectionUtil.getConn();
		
		ResultSet resultSet = null;
		try {
			ps = con.prepareStatement("SELECT * FROM attendee where CreatorID = ?"); //edited by RLW
			ps.setString(1, creatorId);
			
			resultSet = ps.executeQuery();
	
				while(resultSet.next())
				{
					Attendee u = new Attendee();
					u.setUserID(resultSet.getString("UserID"));
					u.setName(resultSet.getString("Name"));
					u.setAddress(resultSet.getString("Address"));
					u.setAge(resultSet.getString("Age"));
					u.setPaymentMethod(resultSet.getString("PaymentMethod"));
					u.setGender(resultSet.getString("Gender"));
					u.setEmail(resultSet.getString("Email"));
					u.setCreatorId(resultSet.getString("CreatorID"));
					
					attendee.add(u);
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return attendee;
		
		
	}

	@Override
	public Attendee GetU(Attendee attendee, String creatorId) {
		// TODO Auto-generated method stub
		con=dbUtil.ConnectionUtil.getConn();
		Attendee u =  new Attendee();
		
		try {
			ps = con.prepareStatement("SELECT * FROM attendee WHERE (UserID = ?) and (CreatorID = ?)  ");
			
			ps.setString(1, attendee.getUserID());
			ps.setString(2, creatorId);
			 
			ResultSet result = ps.executeQuery();
			
			while(result.next())
			{
				u.setUserID(result.getString(1));
				u.setName(result.getString(2));
				u.setAddress(result.getString(3));
				u.setAge(result.getString(4));
				u.setPaymentMethod(result.getString(5));
				u.setGender(result.getString(6));
				u.setEmail(result.getString(7));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return u;
	}

	@Override
	public ArrayList<Attendee> ShowEvent() {
		// TODO Auto-generated method stub
		
		ArrayList<Attendee> attendee = new ArrayList<Attendee>();
		
		con = dbUtil.ConnectionUtil.getConn();
		
		ResultSet resultSet = null;
		
		try {
			ps = con.prepareStatement("select * from EVENTS");
			
			resultSet = ps.executeQuery();
			
			while(resultSet.next())
			{
				Attendee u = new Attendee();
				u.setAtendeeLimit(resultSet.getInt("AtendeeLimit"));
				u.setEventID(resultSet.getString("EventID"));
				
				attendee.add(u);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return attendee;
	}

	@Override
	public void CreateTable(Attendee attendee) {
		// TODO Auto-generated method stub
		con = dbUtil.ConnectionUtil.getConn();
		
		try {
			ps = con.prepareStatement("insert into eventAttendees (EventID,AttendeeID) values (?,?) ");
			
			con.setAutoCommit(false);
			
			ps.setString(1,attendee.getEventID());
			ps.setString(2,attendee.getUserID());
			
			ps.execute();
			con.commit();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void DeleteA(Attendee attendee) {
		// TODO Auto-generated method stub
		con = dbUtil.ConnectionUtil.getConn();
		
		try {
			ps = con.prepareStatement("delete from eventAttendees where AttendeeID = ? and EventID = ?");
			con.setAutoCommit(false);
			ps.setString(1,attendee.getUserID());
			ps.setString(2,attendee.getEventID());
			
			ps.execute();
			con.commit();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public ArrayList<Attendee> eventdetails(Attendee attendee) {
		// TODO Auto-generated method stub
		ArrayList<Attendee> user1 = new ArrayList<>();
		
		con = dbUtil.ConnectionUtil.getConn();
		
		
		ResultSet resultSet= null;
		
		try {
			ps = con.prepareStatement("select AttendeeID from eventAttendees where EventID = ?");
			
			con.setAutoCommit(false);
			
		
			ps.setString(1,attendee.getEventID());
			
			resultSet = ps.executeQuery();
			
			
			
			while(resultSet.next())
			{
				Attendee u = new Attendee();
				u.setUserID(resultSet.getString("AttendeeID"));
				
				user1.add(u);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		return user1;
	}

	
	
	

	
	
}
