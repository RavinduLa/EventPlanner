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
import model.Event;

public class AdminServiceImplementation implements IAdminService {

	private static Connection con;
	private PreparedStatement ps;
	private static String sqlUsername = "sa";
	private static String sqlPassword = "event123";
	public static final Logger log = Logger.getLogger(UserServiceImplementation.class.getName());
	
	
	//Returns an admin type arraylist of a given admin username
	@Override
	public ArrayList<Admin> getAdminById(String adminUsername) {
		
		
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=EventDB";
	        con = DriverManager.getConnection(url, sqlUsername, sqlPassword);
	        
	        ps = con.prepareStatement("select Password from Admin where AdminUsername = ?");
	        ps.setString(1, adminUsername);
	        
	        ResultSet resultset = ps.executeQuery();
	        
	        while (resultset.next())
	        {
	        	Admin admin = new Admin();
	        	admin.setAdminUsername(adminUsername);
	        	admin.setAdminPassword(resultset.getString("Password"));
	        	adminList.add(admin);
	        }
	        
	        
		}
		catch(Exception e)
		{
			System.out.println("Exception in admin get password");
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
				System.out.println("Exception in finally block in get Password");
				System.out.println(ex);
				log.log(Level.SEVERE, ex.getMessage());
			}
		}
		
		return adminList;
	}

}
