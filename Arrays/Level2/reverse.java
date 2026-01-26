import java.util.Scanner;

public class reverse {
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

        // Create reverse array
        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        // Display reversed array
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversed[i]);
        }
        System.out.println();
    }
}
