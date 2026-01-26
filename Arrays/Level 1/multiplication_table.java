
import java.util.Scanner;

public class multiplication_table {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to print its multiplication table from 6 to 9: ");
		int number = sc.nextInt();
		int[] multiplicationResult = new int[4];

		// Calculate multiplication table from 6 to 9
		for (int i = 0; i < 4; i++) {
			multiplicationResult[i] = number * (i + 6);
		}

		// Display the table
		for (int i = 0; i < 4; i++) {
			System.out.println(number + " * " + (i + 6) + " = " + multiplicationResult[i]);
		}
		sc.close();
	}
}
