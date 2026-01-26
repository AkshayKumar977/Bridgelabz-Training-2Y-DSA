import java.util.Scanner;

public class largest_and_second_largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        long temp = Math.abs(number); // Handle negative numbers

        while (temp != 0) {
            if (index == maxDigit) break;
            digits[index] = (int)(temp % 10);
            temp /= 10;
            index++;
        }

        if (index == 0) {
            System.out.println("No digits to process.");
            return;
        }

        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        if (secondLargest == -1) {
            System.out.println("Second largest digit: Not found");
        } else {
            System.out.println("Second largest digit: " + secondLargest);
        }
    }
}
