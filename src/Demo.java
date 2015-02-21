import java.util.Scanner;

public class Demo {
	public void testCuckooHashing() {
		Scanner scanner = new Scanner(System.in);
		CuckooHashing test = new CuckooHashing();
		while (true) {
			System.out.println("\nPlease enter a new value: ");
			int newone = scanner.nextInt();
			if(newone == 0) {
				System.out.println("Test end!");
				break;
			}
			test.insert(newone, test.t1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo().testCuckooHashing();
	}
}
