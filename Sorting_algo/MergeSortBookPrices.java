// Merge Sort - Sort an Array of Book Prices
// Problem Statement:
// A bookstore maintains a list of book prices in an array. Implement Merge Sort to sort the prices
// in ascending order.

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortBookPrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        double[] prices = new double[n];
        System.out.println("Enter the prices of books:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }
        mergeSort(prices, 0, n - 1);
        System.out.println("Sorted book prices in ascending order: " + Arrays.toString(prices));
        scanner.close();
    }

    // Merge Sort implementation
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] L = new double[n1];
        double[] R = new double[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
