
import java.util.Scanner;

public class mean_height {
	public static void main(String[] args) {
		double[] heights = new double[11];
		double sum = 0.0;
		Scanner sc = new Scanner(System.in);

		// Input heights
		for (int i = 0; i < heights.length; i++) {
			System.out.print("Enter height of player " + (i + 1) + ": ");
			heights[i] = sc.nextDouble();
			sum += heights[i];
		}

		double mean = sum / heights.length;
		System.out.println("Mean height of the football team: " + mean);
		sc.close();
	}
}
