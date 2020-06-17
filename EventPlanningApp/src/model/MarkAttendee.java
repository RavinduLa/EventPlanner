package model;

public class MarkAttendee {
	
	@Override
	public String toString() {
		
		return "Attendee [USERID=" + USERID + ", NAME=" + NAME + ", ADDRESS=" + ADDRESS + ", AGE=" + AGE+", PAYMENT_METHOD="+ PAYMENT_METHOD+ ", GENDER=" +GENDER+ ",EMAIL=" +EMAIL+ ",SEATNO=" 
				+SEATNO+", ATTENDANCE =" +ATTENDANCE + "]";
	}
	
	private String USERID;
	private String NAME;
	private String ADDRESS;
	private String AGE;
	private String PAYMENT_METHOD;
	private String GENDER;
	private String EMAIL;
	private String SEATNO;
	private String ATTENDANCE;
	
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	public String getPAYMENT_METHOD() {
		return PAYMENT_METHOD;
	}
	public void setPAYMENT_METHOD(String pAYMENT_METHOD) {
		PAYMENT_METHOD = pAYMENT_METHOD;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getSEATNO() {
		return SEATNO;
	}
	public void setSEATNO(String sEATNO) {
		SEATNO = sEATNO;
	}
	public String getATTENDANCE() {
		return ATTENDANCE;
	}
	public void setATTENDANCE(String aTTENDANCE) {
		ATTENDANCE = aTTENDANCE;
	}
	
	

	

}
