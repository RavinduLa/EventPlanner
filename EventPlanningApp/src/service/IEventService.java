//IT19014128 A.M.W.W.R.L. Wataketiya

package service;

import model.Event;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface IEventService {
	
	public ArrayList<Event> getEvents();
	public ArrayList<Event> actionOnEvent(String  eventId);
	public void addEvent(Event event);
	public ArrayList<Event> getEventById(String eventId);
	public void deleteEventById (String eventID);
	public void updateEventById(String eventId, Event event);
	public ArrayList<Event> getEventForCreator(String creatorId);
	public ArrayList<Event> getTopEventForCreator(String creatorId);
	public ArrayList<Event> searchEventByUser(String creatorId, String eventId);

}
