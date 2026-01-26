import java.util.Scanner;

public class SubstringCompare {
   
    public static String substringWithCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end && i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

 
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String subCharAt = substringWithCharAt(text, start, end);
        String subBuiltIn = "";
        if (start >= 0 && end <= text.length() && start <= end) {
            subBuiltIn = text.substring(start, end);
        } else {
            System.out.println("Invalid indices for built-in substring method.");
        }

        System.out.println("Substring using charAt(): " + subCharAt);
        System.out.println("Substring using substring(): " + subBuiltIn);

        boolean compareResult = compareStrings(subCharAt, subBuiltIn);
        System.out.println("Are both substrings equal (using charAt comparison)? " + compareResult);

        sc.close();
    }
}
