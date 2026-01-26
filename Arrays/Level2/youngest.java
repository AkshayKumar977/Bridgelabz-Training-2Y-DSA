import java.util.Scanner;

public class youngest {
    public static void main(String[] args) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter age of " + names[i] + ": ");
                if (sc.hasNextInt()) {
                    ages[i] = sc.nextInt();
                    if (ages[i] > 0) break;
                } else {
                    sc.next();
                }
                System.out.println("Invalid age. Please enter a positive integer.");
            }
            while (true) {
                System.out.print("Enter height (in cm) of " + names[i] + ": ");
                if (sc.hasNextDouble()) {
                    heights[i] = sc.nextDouble();
                    if (heights[i] > 0) break;
                } else {
                    sc.next();
                }
                System.out.println("Invalid height. Please enter a positive number.");
            }
        }

        int youngestIdx = 0;
        int tallestIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIdx]) youngestIdx = i;
            if (heights[i] > heights[tallestIdx]) tallestIdx = i;
        }

        System.out.println("\nYoungest friend: " + names[youngestIdx] + " (Age: " + ages[youngestIdx] + ")");
        System.out.println("Tallest friend: " + names[tallestIdx] + " (Height: " + heights[tallestIdx] + " cm)");
    }
}
