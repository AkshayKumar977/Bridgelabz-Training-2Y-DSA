
import java.util.Scanner;

public class bonus {
	public static void main(String[] args) {
		final int EMP_COUNT = 10;
		double[] salary = new double[EMP_COUNT];
		double[] years = new double[EMP_COUNT];
		double[] bonus = new double[EMP_COUNT];
		double[] newSalary = new double[EMP_COUNT];
		double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter salary and years of service for 10 employees:");
		for (int i = 0; i < EMP_COUNT; i++) {
			while (true) {
				System.out.print("Employee " + (i+1) + " salary: ");
				if (sc.hasNextDouble()) {
					salary[i] = sc.nextDouble();
					if (salary[i] > 0) break;
				} else {
					sc.next();
				}
				System.out.println("Invalid salary. Please enter a positive number.");
			}
			while (true) {
				System.out.print("Employee " + (i+1) + " years of service: ");
				if (sc.hasNextDouble()) {
					years[i] = sc.nextDouble();
					if (years[i] >= 0) break;
				} else {
					sc.next();
				}
				System.out.println("Invalid years of service. Please enter a non-negative number.");
			}
		}

		for (int i = 0; i < EMP_COUNT; i++) {
			if (years[i] > 5) {
				bonus[i] = salary[i] * 0.05;
			} else {
				bonus[i] = salary[i] * 0.02;
			}
			newSalary[i] = salary[i] + bonus[i];
			totalBonus += bonus[i];
			totalOldSalary += salary[i];
			totalNewSalary += newSalary[i];
		}

		System.out.println("\nSummary for all employees:");
		System.out.printf("%-10s %-12s %-12s %-12s\n", "Employee", "Old Salary", "Bonus", "New Salary");
		for (int i = 0; i < EMP_COUNT; i++) {
			System.out.printf("%-10d %-12.2f %-12.2f %-12.2f\n", (i+1), salary[i], bonus[i], newSalary[i]);
		}
		System.out.println("\nTotal bonus payout: " + String.format("%.2f", totalBonus));
		System.out.println("Total old salary: " + String.format("%.2f", totalOldSalary));
		System.out.println("Total new salary: " + String.format("%.2f", totalNewSalary));
	}
}
