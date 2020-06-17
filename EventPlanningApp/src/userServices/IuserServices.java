package userServices;
/*Reg No - IT19075204 , Name - G.G.D.D Weerasinghe */
import java.util.ArrayList;


import model.Attendee;

public interface IuserServices {

	public void RegisterU(Attendee attendee);
	
	public void UpdateU(Attendee attendee);
	
	public int DeleteU(Attendee attendee, String creatorId);
	
	public ArrayList<Attendee> ListU(String creatorId);
	
	public Attendee GetU(Attendee attendee, String creatorId);
	
	public ArrayList<Attendee> ShowEvent();
	
	public void CreateTable(Attendee attendee);
	
	public void DeleteA(Attendee attendee);
	
	public ArrayList<Attendee> eventdetails(Attendee attendee);
}
