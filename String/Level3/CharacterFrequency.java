import java.util.Scanner;

public class CharacterFrequency {
    // Method to find the frequency of characters using charAt()
    public static Object[][] getCharFrequency(String text) {
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
        // Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }
        // Store characters and their frequencies
        Object[][] result = new Object[uniqueCount][2];
        int idx = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[idx][0] = (char) i;
                result[idx][1] = freq[i];
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        Object[][] freqArr = getCharFrequency(input);
        System.out.println("Character frequencies:");
        for (Object[] row : freqArr) {
            System.out.println(row[0] + ": " + row[1]);
        }
        sc.close();
    }
}
