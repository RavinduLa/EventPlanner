package model;
/*Reg No - IT19075204 , Name - G.G.D.D Weerasinghe */
public class Attendee {
	private String UserID;
	private String Name;
	private String Address;
	private String Age;
	private String paymentMethod;
	private String Gender;
	private String Email;
	
	private String EventID;
	private int AtendeeLimit;
	
	private String creatorId;
	
	
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getEventID() {
		return EventID;
	}
	public void setEventID(String eventID) {
		EventID = eventID;
	}
	public int getAtendeeLimit() {
		return AtendeeLimit;
	}
	public void setAtendeeLimit(int atendeeLimit) {
		AtendeeLimit = atendeeLimit;
	}
	public String getUserID() {
		return UserID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	
	 

}
