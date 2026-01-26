import java.util.Scanner;

public class UniqueCharFrequency {
    // Method to find unique characters using charAt() and nested loops
    public static char[] uniqueCharacters(String text) {
        int n = 0;
        try {
            while (true) {
                text.charAt(n);
                n++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string
        }
        char[] unique = new char[n];
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[uniqueCount++] = c;
            }
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    // Method to find frequency of unique characters
    public static String[][] uniqueCharFrequencies(String text) {
        int[] freq = new int[256];
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
        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] freqArr = uniqueCharFrequencies(input);
        System.out.println("Unique character frequencies:");
        for (String[] row : freqArr) {
            System.out.println(row[0] + ": " + row[1]);
        }
        sc.close();
    }
}
