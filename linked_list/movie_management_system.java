import java.util.*;

class MovieDLL {

    class Node {
        String title, director;
        int year;
        double rating;
        Node prev, next;

        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    private Node head;

    // 1. Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    // 1. Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    // 1. Add at position (1-based)
    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Node newNode = new Node(title, director, year, rating);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return;

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    // 2. Remove by title
    public void removeByTitle(String title) {
        if (head == null) return;

        Node temp = head;

        // If head is to be removed
        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }

        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    // 3. Search by director
    public void searchByDirector(String director) {
        Node temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printNode(temp);
            }
            temp = temp.next;
        }
    }

    // 3. Search by rating
    public void searchByRating(double rating) {
        Node temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                printNode(temp);
            }
            temp = temp.next;
        }
    }

    // 4. Display forward
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            printNode(temp);
            temp = temp.next;
        }
    }

    // 4. Display reverse
    public void displayReverse() {
        if (head == null) return;

        Node temp = head;
        while (temp.next != null) temp = temp.next;

        while (temp != null) {
            printNode(temp);
            temp = temp.prev;
        }
    }

    // 5. Update rating by title
    public void updateRating(String title, double newRating) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    private void printNode(Node node) {
        System.out.println("Title: " + node.title +
                ", Director: " + node.director +
                ", Year: " + node.year +
                ", Rating: " + node.rating);
    }

    // Main method for testing
    public static void main(String[] args) {
        MovieDLL list = new MovieDLL();

        list.addAtBeginning("Inception", "Nolan", 2010, 8.8);
        list.addAtEnd("Interstellar", "Nolan", 2014, 8.6);
        list.addAtPosition(2, "Avatar", "Cameron", 2009, 7.8);

        System.out.println("Forward:");
        list.displayForward();

        System.out.println("\nReverse:");
        list.displayReverse();

        System.out.println("\nSearch by Director (Nolan):");
        list.searchByDirector("Nolan");

        list.updateRating("Avatar", 8.0);
        System.out.println("\nAfter Update:");
        list.displayForward();

        list.removeByTitle("Inception");
        System.out.println("\nAfter Deletion:");
        list.displayForward();
    }
}