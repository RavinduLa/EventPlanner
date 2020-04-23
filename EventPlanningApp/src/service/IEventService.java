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

}
