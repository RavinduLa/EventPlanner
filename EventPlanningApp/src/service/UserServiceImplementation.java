//IT19014128 A.M.W.W.R.L. Wataketiya

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Admin;
import model.User;
import util.CommonUtilE;

public class UserServiceImplementation implements IUserService {
	
	private static Connection con;
	private PreparedStatement ps;
	private PreparedStatement ps2;
	private static String sqlUsername = "sa";
	private static String sqlPassword = "event123";
	
	public static final Logger log = Logger.getLogger(UserServiceImplementation.class.getName());

	//Takes in a user type object and adds the details in the object into the database.
	@Override
	public void addUser(User user) {
		
		String userid = CommonUtilE.generateUserIDs(getUserIDs());
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("insert into UserDetails (Username, Name, DateOfBirth, Phone, Email) values(?,?,?,?,?)");
	        ps.setString(1, userid);
	        ps.setString(2, user.getName());
	        ps.setDate(3, user.getDateOfBirth());
	        ps.setString(4, user.getPhone());
	        ps.setString(5, user.getEmail());
	        
	        ps.execute();
			System.out.println("Executed insert statement on UserDetails");
			con.commit();
	        
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception in addUser - adding user details");
			System.out.println(ex);
			log.log(Level.SEVERE, ex.getMessage());
		}
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
			ps = con.prepareStatement("insert into Users (Username, Password) values (?,?)");
			
			ps.setString(1, userid);
			ps.setString(2, user.getPassword());
			ps.execute();
			System.out.println("Executed insert statement on Users");
			con.commit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception in addUser- adding users, passwords");
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
				System.out.println("closing connections in add user");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in add user");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		
	}
	
	
	// returns all the user ids as an arraylist
	private ArrayList<String> getUserIDs()
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select Username from UserDetails");
	        ResultSet resultset = ps.executeQuery();
	        
	        while(resultset.next())
	        {
	        	arrayList.add(resultset.getString(1));
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Exception in get user ids");
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
				System.out.println("closing connections in getting user names");
			}
			catch(Exception ex)
			{
				System.out.println("Exception in finally block in getting user names");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		
		
		
		}
		return arrayList;
		
	}



	//Returns an user type array list of a given username
	@Override
	public ArrayList<User> getUserById(String username) {
		
		ArrayList<User> userlist = new ArrayList<User>();
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select Password from Users where Username = ?");
	        ps.setString(1, username);
	        ResultSet resultset = ps.executeQuery();
	        
	        while (resultset.next())
	        {
	        	User user = new User();
	        	user.setUsername(username);
	        	user.setPassword(resultset.getString("Password"));
	        	userlist.add(user);
	        }
		}
		catch(Exception ex)
		{
			System.out.println("Exception in user service implementation getuserby id try catch block");
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
				System.out.println("Exception in finally block in user by id");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		return userlist;
	}



	//Returns an user type array list of all the users in the data base.
	@Override
	public ArrayList<User> getAllUsers() {
		
		ArrayList<User> userlist = new ArrayList<User>();
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select * from UserDetails");

	        ResultSet resultset = ps.executeQuery();
	        
	        while (resultset.next())
	        {
	        	User user = new User();
	        	user.setUsername(resultset.getString("Username"));
	        	user.setName(resultset.getString("Name"));
	        	user.setDateOfBirth(resultset.getDate("DateOfBirth"));
	        	user.setAge(resultset.getInt("Age"));
	        	user.setPhone(resultset.getString("Phone"));
	        	user.setEmail(resultset.getString("Email"));
	        	userlist.add(user);
	        }
	        
	        
		}
		catch(Exception e)
		{
			System.out.println("Exeption in try catch in get all users");
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
				System.out.println("Exception in finally block in get all users");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		return userlist;
	}


	//Returns an user type array list of a given username
	@Override
	public ArrayList<User> getUserDetailsById(String username) {
		
		ArrayList<User> userlist = new ArrayList<User>();
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select * from UserDetails where Username = ?");
	        ps.setString(1, username);

	        ResultSet resultset = ps.executeQuery();
	        
	        while (resultset.next())
	        {
	        	User user = new User();
	        	user.setUsername(resultset.getString("Username"));
	        	user.setPassword(resultset.getString("Name"));
	        	user.setDateOfBirth(resultset.getDate("DateOfBirth"));
	        	user.setAge(resultset.getInt("Age"));
	        	user.setPhone(resultset.getString("Phone"));
	        	user.setEmail(resultset.getString("Email"));
	        	userlist.add(user);
	        }
	        
		}
		catch(Exception ex)
		{
			System.out.println("Exception in try catch in getting user details by id");
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
				System.out.println("Exception in finally block in getting user details by id");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		return userlist;
	}


	//Deletes the details of user of a given username from the database
	@Override
	public void deleteUserById(String username) {
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("delete from UserDetails where Username = ?");
	        ps.setString(1, username);
	        
	        
	        
	        ps.executeQuery();
	        
		}
		catch(Exception ex)
		{
			System.out.println("Exception in try catch in delete user Userdetails table");
			System.out.println(ex);
			log.log(Level.SEVERE, ex.getMessage());
		}
		
		try
		{
			ps2 = con.prepareStatement("delete from Users where Username = ?");
	        ps2.setString(1, username);
	        
	        ps2.executeQuery();
		}
		catch(Exception ex) {
			System.out.println("Exception in try catch in delete user user table");
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
				System.out.println("Exception in finally block in  delete user");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
	}


	//Returns the nu,br of users currently in the database
	@Override
	public int getNumberOfUsers() {
		
		
		int numberOfUsers = 0;
		try
		{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select * from Users");
	        ResultSet resultset = ps.executeQuery();
	        
	        while(resultset.next())
	        {
	        	numberOfUsers++;
	        }
	        
		}
		catch(Exception ex)
		{
			System.out.println("Exception in try catch in get number of users");
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
				System.out.println("Exception in finally block in  getNumberOfUsers");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		
		return numberOfUsers;
	}
}



