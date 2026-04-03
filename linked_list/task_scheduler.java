import java.util.*;

class TaskScheduler {

    class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        Node(int id, String name, int priority, String dueDate) {
            this.taskId = id;
            this.taskName = name;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private Node head = null;
    private Node current = null;

    // 1. Add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Node newNode = new Node(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) temp = temp.next;

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // 1. Add at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Node newNode = new Node(id, name, priority, dueDate);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    // 1. Add at position (1-based)
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Node newNode = new Node(id, name, priority, dueDate);

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 2. Remove by Task ID
    public void removeById(int id) {
        if (head == null) return;

        Node temp = head, prev = null;

        // If head is to be removed
        if (head.taskId == id) {
            if (head.next == head) {
                head = null;
                current = null;
                return;
            }

            Node last = head;
            while (last.next != head) last = last.next;

            head = head.next;
            last.next = head;
            current = head;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;

            if (temp.taskId == id) {
                prev.next = temp.next;
                if (temp == current) current = temp.next;
                return;
            }

        } while (temp != head);
    }

    // 3. View current task
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }
        printNode(current);
    }

    // 3. Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        }
    }

    // 4. Display all tasks
    public void display() {
        if (head == null) return;

        Node temp = head;
        do {
            printNode(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // 5. Search by priority
    public void searchByPriority(int priority) {
        if (head == null) return;

        Node temp = head;
        do {
            if (temp.priority == priority) {
                printNode(temp);
            }
            temp = temp.next;
        } while (temp != head);
    }

    private void printNode(Node node) {
        System.out.println("ID: " + node.taskId +
                ", Name: " + node.taskName +
                ", Priority: " + node.priority +
                ", Due: " + node.dueDate);
    }

    // Main method for testing
    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();

        ts.addAtEnd(1, "Task A", 1, "2026-04-05");
        ts.addAtEnd(2, "Task B", 2, "2026-04-06");
        ts.addAtBeginning(3, "Task C", 1, "2026-04-04");

        System.out.println("All Tasks:");
        ts.display();

        System.out.println("\nCurrent Task:");
        ts.viewCurrentTask();

        ts.moveToNextTask();
        System.out.println("\nAfter moving to next:");
        ts.viewCurrentTask();

        System.out.println("\nSearch Priority 1:");
        ts.searchByPriority(1);

        ts.removeById(2);
        System.out.println("\nAfter Deletion:");
        ts.display();
    }
}