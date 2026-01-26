import java.util.Scanner;

public class YetAnotherStringSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int customLength = findLengthWithoutLengthMethod(input);
        int builtInLength = input.length();

        System.out.println("Length (without using length()): " + customLength);
        System.out.println("Length (using length()): " + builtInLength);

        String[] customWords = splitWithoutSplit(input);
        String[] builtInWords = input.split(" ");

        System.out.println("Words (custom split):");
        for (String word : customWords) {
            System.out.println(word);
        }
        System.out.println("Words (built-in split):");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        boolean areEqual = compareStringArrays(customWords, builtInWords);
        System.out.println("Are both splits equal? " + areEqual);
    }

    public static int findLengthWithoutLengthMethod(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    public static String[] splitWithoutSplit(String str) {
        int len = findLengthWithoutLengthMethod(str);
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (str.charAt(i) == ' ') {
                inWord = false;
            }
        }
        int[] starts = new int[wordCount];
        int[] ends = new int[wordCount];
        int idx = 0;
        inWord = false;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != ' ' && !inWord) {
                starts[idx] = i;
                inWord = true;
            }
            if ((str.charAt(i) == ' ' || i == len - 1) && inWord) {
                ends[idx] = (str.charAt(i) == ' ') ? i - 1 : i;
                idx++;
                inWord = false;
            }
        }
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = starts[i]; j <= ends[i]; j++) {
                sb.append(str.charAt(j));
            }
            words[i] = sb.toString();
        }
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
}
