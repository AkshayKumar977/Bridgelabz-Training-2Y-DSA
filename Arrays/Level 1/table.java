
import java.util.Scanner;

public class table {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to print its multiplication table: ");
		int number = sc.nextInt();
		int[] table = new int[10];

		// Calculate multiplication table
		for (int i = 0; i < 10; i++) {
			table[i] = number * (i + 1);
		}

		// Display the table
		for (int i = 0; i < 10; i++) {
			System.out.println(number + " * " + (i + 1) + " = " + table[i]);
		}
		sc.close();
	}
}
