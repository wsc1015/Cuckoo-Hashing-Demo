import java.util.HashMap;

public class CuckooHashing {
	public HashMap<Integer, Integer> t1 = new HashMap<Integer, Integer>();
	public HashMap<Integer, Integer> t2 = new HashMap<Integer, Integer>();

	public int hashfunction(int newvalue, HashMap<Integer, Integer> table) {
		if (table == t1)
			return newvalue % 11;
		else
			return (newvalue / 11) % 11;
	}

	public void insert(int newvalue, HashMap<Integer, Integer> tableToInsert) {
		HashMap<Integer, Integer> first, second;
		if (tableToInsert == t1) {
			first = t1;
			second = t2;
		} else {
			first = t2;
			second = t1;
		}
		if (!first.containsKey(hashfunction(newvalue, first))) {
			first.put(hashfunction(newvalue, first), newvalue);
			if (first == t1)
				System.out.print("Insert value: " + newvalue + " into t1. ");
			else
				System.out.print("Insert value: " + newvalue + " into t2. ");
		} else if (!second.containsKey(hashfunction(newvalue, second))) {
			second.put(hashfunction(newvalue, second), newvalue);
			if (first == t1)
				System.out.print("t1 is not available, so we insert value: "
						+ newvalue + " into t2");
			else
				System.out.print("t2 is not available, so we insert value: "
						+ newvalue + " into t1");
		} else {
			int kickoutvalue = first.get(hashfunction(newvalue, first));
			first.put(hashfunction(newvalue, first), newvalue);
			if (first == t1)
				System.out.println("Neither t1 and t2 is available, "
						+ "so we kick out the value: " + kickoutvalue
						+ " in t1, and insert value: " + newvalue + " into t1");
			else
				System.out.println("Neither t1 and t2 is available, "
						+ "so we kick out the value: " + kickoutvalue
						+ " in t2, and insert value: " + newvalue + " into t2");
			insert(kickoutvalue, second);
		}
	}
}
