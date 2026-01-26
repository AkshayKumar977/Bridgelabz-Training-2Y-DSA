import java.util.Scanner;

// Class to find the first non-repeating character in a string
public class FirstNonRepeatingCharacter {
    // Method to find the first non-repeating character using charAt()
    public static Character firstNonRepeatingChar(String text) {
        int[] freq = new int[256]; // For ASCII
        int n = 0;
        try {
            while (true) {
                char c = text.charAt(n);
                freq[c]++;
                n++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string
        }
        // Find first non-repeating character
        for (int i = 0; i < n; i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return null; // No non-repeating character
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        Character result = firstNonRepeatingChar(input);
        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
        sc.close();
    }
}
