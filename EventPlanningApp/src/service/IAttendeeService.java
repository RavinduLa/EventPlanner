package service;

import java.util.ArrayList;

import model.MarkAttendee;

public interface IAttendeeService {
	public ArrayList<MarkAttendee> getAttendee();
	public ArrayList<MarkAttendee> actionOnAttendee(String  userID);
	public void addAttandee(MarkAttendee Attandee);
	public ArrayList<MarkAttendee> getEventById(String userID);
}
