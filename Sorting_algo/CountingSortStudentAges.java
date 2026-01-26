// Counting Sort - Sort Student Ages
// Problem Statement:
// A school collects students’ ages (ranging from 10 to 18) and wants them sorted. Implement
// Counting Sort for this task.

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortStudentAges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter the ages of students (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        countingSort(ages, 10, 18);
        System.out.println("Sorted ages in ascending order: " + Arrays.toString(ages));
        scanner.close();
    }

    // Counting Sort implementation for ages in range [min, max]
    public static void countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        // Store the count of each age
        for (int age : arr) {
            count[age - min]++;
        }
        // Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        // Copy the output array to arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
