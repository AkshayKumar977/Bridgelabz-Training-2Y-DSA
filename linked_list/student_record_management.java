class StudentLinkedList {

    class Node {
        int rollNo;
        String name;
        int age;
        String grade;
        Node next;

        Node(int rollNo, String name, int age, String grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    private Node head;

    // 1. Add at beginning
    public void addAtBeginning(int rollNo, String name, int age, String grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // 1. Add at end
    public void addAtEnd(int rollNo, String name, int age, String grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // 1. Add at specific position (1-based index)
    public void addAtPosition(int pos, int rollNo, String name, int age, String grade) {
        Node newNode = new Node(rollNo, name, age, grade);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 2. Delete by Roll Number
    public void deleteByRoll(int rollNo) {
        if (head == null) return;

        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // 3. Search by Roll Number
    public Node search(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // 4. Display all records
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo +
                               ", Name: " + temp.name +
                               ", Age: " + temp.age +
                               ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // 5. Update grade by Roll Number
    public void updateGrade(int rollNo, String newGrade) {
        Node student = search(rollNo);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(1, "Akshay", 20, "A");
        list.addAtEnd(2, "Rahul", 21, "B");
        list.addAtPosition(2, 3, "Neha", 19, "A+");

        list.display();

        list.updateGrade(2, "A");
        System.out.println("\nAfter update:");
        list.display();

        list.deleteByRoll(1);
        System.out.println("\nAfter deletion:");
        list.display();
    }
}