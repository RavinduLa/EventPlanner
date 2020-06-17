//IT19014128 A.M.W.W.R.L. Wataketiya

package service;

import java.util.ArrayList;

import model.Admin;
import model.Event;

public interface IAdminService {
	
	public ArrayList<Admin> getAdminById (String adminUsername);

}
