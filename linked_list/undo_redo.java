import java.util.Scanner;

class UndoRedoEditor {

    static class TextState {
        String content;
        TextState next;
        TextState prev;

        TextState(String content) {
            this.content = content;
            this.next = null;
            this.prev = null;
        }
    }

    private TextState head;
    private TextState current;
    private int size;
    private final int MAX_SIZE = 10;

    // Add a new text state at the end of the list
    public void addTextState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = current = newState;
            size = 1;
            return;
        }
        // Remove all redo states
        current.next = null;
        newState.prev = current;
        current.next = newState;
        current = newState;
        size++;

        // Limit the history size
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo functionality
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("No more undo steps available");
            return;
        }
        current = current.prev;
    }

    // Redo functionality
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("No more redo steps available");
            return;
        }
        current = current.next;
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text available");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    public static void main(String[] args) {
        UndoRedoEditor editor = new UndoRedoEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nUndo/Redo Text Editor");
            System.out.println("1. Add Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text state: ");
                    String content = scanner.nextLine();
                    editor.addTextState(content);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}