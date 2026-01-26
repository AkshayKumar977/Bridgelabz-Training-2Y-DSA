import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[][] marks = new double[n][3]; // [physics, chemistry, maths]
        double[] percentages = new double[n];
        String[] grades = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for student " + (i+1) + ":");
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                while (true) {
                    System.out.print(subject + ": ");
                    marks[i][j] = sc.nextDouble();
                    if (marks[i][j] >= 0 && marks[i][j] <= 100) break;
                    System.out.println("Enter valid marks (0-100)");
                }
            }
        }

        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j < 3; j++) {
                total += marks[i][j];
            }
            percentages[i] = total / 3.0;
            double p = percentages[i];
            if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else if (p >= 40) grades[i] = "E";
            else grades[i] = "R";
        }

        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\t%\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.1f\t\t%.1f\t\t%.1f\t%.2f\t%s\n", (i+1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}
