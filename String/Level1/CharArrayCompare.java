import java.util.Scanner;

public class CharArrayCompare {
    
    public static char[] getChars(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        return arr;
    }

   
    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.next();

        char[] userChars = getChars(text);
        char[] builtInChars = text.toCharArray();

        boolean areEqual = compareCharArrays(userChars, builtInChars);

        System.out.print("User-defined char array: ");
        for (char c : userChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("Built-in toCharArray: ");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Are both arrays equal? " + areEqual);
        sc.close();
    }
}
