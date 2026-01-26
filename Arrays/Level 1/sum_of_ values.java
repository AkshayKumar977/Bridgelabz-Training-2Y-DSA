
import java.util.Scanner;

public class sum_of_values {
	public static void main(String[] args) {
		double[] arr = new double[10];
		double total = 0.0;
		int index = 0;
		Scanner sc = new Scanner(System.in);

		// Input values
		while (true) {
			if (index == 10) {
				break;
			}
			System.out.print("Enter a number (0 or negative to stop): ");
			double num = sc.nextDouble();
			if (num <= 0) {
				break;
			}
			arr[index] = num;
			index++;
		}

		// Display values and calculate sum
		System.out.print("Numbers entered: ");
		for (int i = 0; i < index; i++) {
			System.out.print(arr[i] + " ");
			total += arr[i];
		}
		System.out.println();
		System.out.println("Sum of all numbers: " + total);
		sc.close();
	}
}
