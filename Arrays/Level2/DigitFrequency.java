import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = sc.nextLong();

        // Count digits
        long tempNum = num;
        int count = 0;
        if (tempNum == 0) {
            count = 1;
        } else {
            while (tempNum > 0) {
                count++;
                tempNum /= 10;
            }
        }

        // Store digits in array
        int[] digits = new int[count];
        tempNum = num;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = (int)(tempNum % 10);
            tempNum /= 10;
        }

        // Frequency array
        int[] freq = new int[10];
        for (int i = 0; i < count; i++) {
            freq[digits[i]]++;
        }

        // Display frequency
        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + ": " + freq[i]);
            }
        }
    }
}
