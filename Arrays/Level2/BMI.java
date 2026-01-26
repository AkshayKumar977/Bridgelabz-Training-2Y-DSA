import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] heights = new double[n]; // in meters
        double[] weights = new double[n]; // in kg
        double[] bmis = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (in meters) for person " + (i+1) + ": ");
            heights[i] = sc.nextDouble();
            System.out.print("Enter weight (in kg) for person " + (i+1) + ": ");
            weights[i] = sc.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            if (bmis[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmis[i] < 25) {
                status[i] = "Normal weight";
            } else if (bmis[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        System.out.println("\nPerson\tHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n", (i+1), heights[i], weights[i], bmis[i], status[i]);
        }
    }
}
