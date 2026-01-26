// Bubble Sort - Sort Student Marks
// Problem Statement:
// A school maintains student marks in an array. Implement Bubble Sort to sort the student marks
// in ascending order.

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortStudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }
        bubbleSort(marks);
        System.out.println("Sorted marks in ascending order: " + Arrays.toString(marks));
        scanner.close();
    }

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }
}
