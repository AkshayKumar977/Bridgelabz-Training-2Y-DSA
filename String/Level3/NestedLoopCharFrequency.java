import java.util.Scanner;

public class NestedLoopCharFrequency {
    // Method to find the frequency of characters using nested loops
    public static String[] charFrequencies(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            freq[i] = 1;
            if (chars[i] == '0') continue;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark as counted
                }
            }
        }
        // Count non-'0' characters
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') count++;
        }
        String[] result = new String[count];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[idx++] = chars[i] + ": " + freq[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[] freqArr = charFrequencies(input);
        System.out.println("Character frequencies:");
        for (String s : freqArr) {
            System.out.println(s);
        }
        sc.close();
    }
}
