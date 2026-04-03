import java.util.Scanner;

class OnlineReservationSystem {

    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private Ticket tail;

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (tail == null) {
            tail = newTicket;
            tail.next = tail;
            return;
        }
        newTicket.next = tail.next;
        tail.next = newTicket;
        tail = newTicket;
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (tail == null) {
            System.out.println("No tickets in the system");
            return;
        }
        Ticket current = tail.next;
        Ticket prev = tail;
        do {
            if (current.ticketId == ticketId) {
                if (current == tail && current.next == tail) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Ticket with ID " + ticketId + " removed");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
        System.out.println("Ticket not found");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No tickets in the system");
            return;
        }
        Ticket temp = tail.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName + ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != tail.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String customerName, String movieName) {
        if (tail == null) {
            System.out.println("No tickets in the system");
            return;
        }
        Ticket temp = tail.next;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName) || temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket Found: Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName + ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                return;
            }
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("Ticket not found");
    }

    // Calculate the total number of booked tickets
    public int countTickets() {
        if (tail == null) {
            return 0;
        }
        int count = 0;
        Ticket temp = tail.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != tail.next);
        return count;
    }

    public static void main(String[] args) {
        OnlineReservationSystem reservationSystem = new OnlineReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOnline Ticket Reservation System");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String bookingTime = scanner.nextLine();
                    reservationSystem.addTicket(ticketId, customerName, movieName, seatNumber, bookingTime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeId = scanner.nextInt();
                    reservationSystem.removeTicket(removeId);
                    break;
                case 3:
                    reservationSystem.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String searchName = scanner.nextLine();
                    reservationSystem.searchTicket(searchName, searchName);
                    break;
                case 5:
                    System.out.println("Total Tickets: " + reservationSystem.countTickets());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}