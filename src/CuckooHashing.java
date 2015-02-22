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
				System.out.println("Insert value: " + newvalue + " into t1. ");
			else
				System.out.println("Insert value: " + newvalue + " into t2. ");
			String leftAlignFormat = "| %-5d | %-5d |%n";
			System.out.format("+-------+-------+%n");
			System.out.printf("|     table1    |%n");
			System.out.format("+-------+-------+%n");
			for (int i = 0; i < 11; i++) {
				System.out.format(leftAlignFormat, i, t1.get(i));
			}
			System.out.format("+-------+-------+%n");
			System.out.format("+-------+-------+%n");
			System.out.printf("|     table2    |%n");
			System.out.format("+-------+-------+%n");
			for (int i = 0; i < 11; i++) {
				System.out.format(leftAlignFormat, i, t2.get(i));
			}
			System.out.format("+-------+-------+%n");
		} else {
			int kickoutvalue = first.get(hashfunction(newvalue, first));
			first.put(hashfunction(newvalue, first), newvalue);
			if (first == t1)
				System.out.println("we kick out the value: " + kickoutvalue
						+ " from t1, and insert value: " + newvalue
						+ " into t1");
			else
				System.out.println("we kick out the value: " + kickoutvalue
						+ " from t2, and insert value: " + newvalue
						+ " into t2");
			String leftAlignFormat = "| %-5d | %-5d |%n";
			System.out.format("+-------+-------+%n");
			System.out.printf("|     table1    |%n");
			System.out.format("+-------+-------+%n");
			for (int i = 0; i < 11; i++) {
				System.out.format(leftAlignFormat, i, t1.get(i));
			}
			System.out.format("+-------+-------+%n");
			System.out.format("+-------+-------+%n");
			System.out.printf("|     table2    |%n");
			System.out.format("+-------+-------+%n");
			for (int i = 0; i < 11; i++) {
				System.out.format(leftAlignFormat, i, t2.get(i));
			}
			System.out.format("+-------+-------+%n");
			insert(kickoutvalue, second);
		}
	}
}
