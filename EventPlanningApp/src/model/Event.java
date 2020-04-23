package model;

import java.sql.Timestamp;
import java.util.Date;

public class Event {
	
	private String eventId;
	private String eventName;
	private Date date = new Date();
	private Timestamp startingDateTime ;
	private Timestamp endingDateTime ;
	private String duration ;
	private String venue;
	private boolean status;
	private int atendeeLimit;
	
	public int getAtendeeLimit() {
		return atendeeLimit;
	}
	public void setAtendeeLimit(int atendeeLimit) {
		this.atendeeLimit = atendeeLimit;
	}
	private String creatorId;
	
	
	
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getStartingDateTime() {
		return startingDateTime;
	}
	public void setStartingDateTime(Timestamp startingDateTime) {
		this.startingDateTime = startingDateTime;
	}
	public Date getEndingDateTime() {
		return endingDateTime;
	}
	public void setEndingDateTime(Timestamp endingDateTime) {
		this.endingDateTime = endingDateTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	
	
	
	
	

}
