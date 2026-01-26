import java.util.Scanner;

public class CalendarDisplay {
    // Array of month names
    static final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    // Array of days in each month
    static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Method to get month name
    public static String getMonthName(int month) {
        return months[month - 1];
    }

    // Method to check leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    // Method to get the first day of the month (0=Sun, 1=Mon, ..., 6=Sat)
    public static int getFirstDayOfMonth(int month, int year) {
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int days = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);
        System.out.printf("    %s %d\n", monthName, year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        // Indentation for the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        // Print days
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if (((day + firstDay) % 7 == 0) || (day == days)) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        System.out.println();
        displayCalendar(month, year);
        sc.close();
    }
}
