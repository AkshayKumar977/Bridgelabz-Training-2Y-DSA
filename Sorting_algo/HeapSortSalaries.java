// Heap Sort - Sort Job Applicants by Salary
// Problem Statement:
// A company receives job applications with different expected salary demands. Implement Heap
// Sort to sort these salary demands in ascending order.

import java.util.Arrays;
import java.util.Scanner;

public class HeapSortSalaries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of applicants: ");
        int n = scanner.nextInt();
        double[] salaries = new double[n];
        System.out.println("Enter the expected salary demands:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextDouble();
        }
        heapSort(salaries);
        System.out.println("Sorted salary demands in ascending order: " + Arrays.toString(salaries));
        scanner.close();
    }

    // Heap Sort implementation
    public static void heapSort(double[] arr) {
        int n = arr.length;
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            double temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[], n is size of heap
    public static void heapify(double[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;
        // If largest is not root
        if (largest != i) {
            double swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
