//IT19014128 A.M.W.W.R.L. Wataketiya

package service;

import java.util.ArrayList;

import model.User;

public interface IUserService {
	
	public void addUser(User user);
	public ArrayList<User> getUserById(String username);
	public ArrayList<User> getAllUsers();
	public ArrayList<User> getUserDetailsById(String username);
	public void deleteUserById (String username);
	public int getNumberOfUsers();

}
