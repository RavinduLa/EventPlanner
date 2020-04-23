package util;

import java.util.ArrayList;

public class CommonUtilE {
	
	public static String generateIDs(ArrayList <String> arraylist)
	{
		String id;
		int next = arraylist.size();
		next++;
		id = "ev" + next;
		
		if (arraylist.contains(id))
		{
			next++;
			id = "ev" + next;
		}
		
		return id;
	}

}
