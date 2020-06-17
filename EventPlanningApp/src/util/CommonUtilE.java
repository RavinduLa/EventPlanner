//IT19014128 A.M.W.W.R.L. Wataketiya

package util;

import java.util.ArrayList;

public class CommonUtilE {

	public static String generateEventIDs(ArrayList<String> arraylist) {
		String id;
		int next = arraylist.size();
		next++;
		id = "ev" + next;

		while (arraylist.contains(id)) {
			next++;
			id = "ev" + next;
		}

		return id;
	}

	public static String generateUserIDs(ArrayList<String> arraylist) {
		String id;
		int next = arraylist.size();
		next++;
		id = "cr" + next;

		while (arraylist.contains(id)) {
			next++;
			id = "cr" + next;
		}

		return id;
	}

}
