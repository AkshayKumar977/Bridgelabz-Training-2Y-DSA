// Insertion Sort - Sort Employee IDs
// Problem Statement:
// A company stores employee IDs in an unsorted array. Implement Insertion Sort to sort the
// employee IDs in ascending order.

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        int[] empIds = new int[n];
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            empIds[i] = scanner.nextInt();
        }
        insertionSort(empIds);
        System.out.println("Sorted employee IDs in ascending order: " + Arrays.toString(empIds));
        scanner.close();
    }

    // Insertion Sort implementation
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Move elements of arr[0..i-1], that are greater than key, to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
