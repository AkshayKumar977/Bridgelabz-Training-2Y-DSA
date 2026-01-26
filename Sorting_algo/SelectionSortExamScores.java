// Selection Sort - Sort Exam Scores
// Problem Statement:
// A university needs to sort students’ exam scores in ascending order. Implement Selection Sort
// to achieve this.

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortExamScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] scores = new int[n];
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        selectionSort(scores);
        System.out.println("Sorted exam scores in ascending order: " + Arrays.toString(scores));
        scanner.close();
    }

    // Selection Sort implementation
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
