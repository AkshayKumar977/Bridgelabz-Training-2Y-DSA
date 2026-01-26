import java.util.Scanner;

public class PalindromeCheck {
    // Logic 1: Compare characters from start and end
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Using character arrays and reverse
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    // Helper: Reverse a string using charAt()
    public static char[] reverseString(String text) {
        int n = text.length();
        char[] rev = new char[n];
        for (int i = 0; i < n; i++) {
            rev[i] = text.charAt(n - 1 - i);
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        System.out.println("\nPalindrome check using three logics:");
        System.out.println("Iterative: " + (isPalindromeIterative(input) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (isPalindromeRecursive(input, 0, input.length() - 1) ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array/Reverse: " + (isPalindromeArray(input) ? "Palindrome" : "Not Palindrome"));
        sc.close();
    }
}
