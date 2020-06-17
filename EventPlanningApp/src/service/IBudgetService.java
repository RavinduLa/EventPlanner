//IT19000268

//LIYANAGE S.M.H.

//WEEKEND BATCH Y2S1 1.1


package service;

import java.util.ArrayList;

import model.Budget;

public interface IBudgetService {
	

	public ArrayList<Budget> budgetSelection(String eventId);
	
	public String addBudget(Budget budget);
	
	public ArrayList<Budget> getBudgetById(String eventId);
	
	public String deleteBudgetById(String eventId);
	
	//public ArrayList<Budget> updateBudgetById(String eventId);
	public void updateBudgetById(String eventId);
	
	public String getEventName(String eventId);
	
	
	
}
