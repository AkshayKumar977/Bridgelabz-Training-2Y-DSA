import java.util.Scanner;

class InventoryManagement {

    static class Item {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Item next;

        Item(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    private Item head;

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add an item at a specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove an item based on Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found");
            return;
        }
        temp.next = temp.next.next;
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityById(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search for an item based on Item ID or Item Name
    public void searchItem(String itemName, int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Sort the inventory based on Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            while (current.next != null) {
                boolean condition;
                if (criteria.equalsIgnoreCase("name")) {
                    condition = ascending ? current.itemName.compareToIgnoreCase(current.next.itemName) > 0 : current.itemName.compareToIgnoreCase(current.next.itemName) < 0;
                } else if (criteria.equalsIgnoreCase("price")) {
                    condition = ascending ? current.price > current.next.price : current.price < current.next.price;
                } else {
                    System.out.println("Invalid criteria");
                    return;
                }
                if (condition) {
                    // Swap items
                    String tempName = current.itemName;
                    int tempId = current.itemId;
                    int tempQuantity = current.quantity;
                    double tempPrice = current.price;

                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;

                    current.next.itemName = tempName;
                    current.next.itemId = tempId;
                    current.next.quantity = tempQuantity;
                    current.next.price = tempPrice;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Calculate Total Value");
            System.out.println("6. Sort Inventory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Item ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Position (0 for beginning, -1 for end): ");
                    int position = scanner.nextInt();
                    if (position == 0) {
                        inventory.addItemAtBeginning(name, id, quantity, price);
                    } else if (position == -1) {
                        inventory.addItemAtEnd(name, id, quantity, price);
                    } else {
                        inventory.addItemAtPosition(name, id, quantity, price, position);
                    }
                    break;
                case 2:
                    System.out.print("Enter Item ID to remove: ");
                    int removeId = scanner.nextInt();
                    inventory.removeItemById(removeId);
                    break;
                case 3:
                    System.out.print("Enter Item ID to update quantity: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateQuantityById(updateId, newQuantity);
                    break;
                case 4:
                    System.out.print("Enter Item Name or ID to search: ");
                    String searchName = scanner.next();
                    int searchId = scanner.nextInt();
                    inventory.searchItem(searchName, searchId);
                    break;
                case 5:
                    inventory.calculateTotalValue();
                    break;
                case 6:
                    System.out.print("Enter criteria (name/price): ");
                    String criteria = scanner.next();
                    System.out.print("Sort in ascending order? (true/false): ");
                    boolean ascending = scanner.nextBoolean();
                    inventory.sortInventory(criteria, ascending);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}