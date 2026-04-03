import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SocialMedia {

    static class User {
        int userId;
        String name;
        int age;
        List<Integer> friendIds;
        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendIds = new ArrayList<>();
            this.next = null;
        }
    }

    private User head;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
            return;
        }
        User temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newUser;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }
        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }
        List<Integer> mutualFriends = new ArrayList<>(user1.friendIds);
        mutualFriends.retainAll(user2.friendIds);
        System.out.println("Mutual Friends: " + mutualFriends);
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        System.out.println("Friends of User ID " + userId + ": " + user.friendIds);
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: " + temp.name + ", ID: " + temp.userId + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found");
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Number of Friends: " + temp.friendIds.size());
            temp = temp.next;
        }
    }

    // Helper method to find a user by ID
    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSocial Media Friend Management");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    socialMedia.addUser(userId, name, age);
                    break;
                case 2:
                    System.out.print("Enter User ID 1: ");
                    int userId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userId2 = scanner.nextInt();
                    socialMedia.addFriendConnection(userId1, userId2);
                    break;
                case 3:
                    System.out.print("Enter User ID 1: ");
                    int removeId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int removeId2 = scanner.nextInt();
                    socialMedia.removeFriendConnection(removeId1, removeId2);
                    break;
                case 4:
                    System.out.print("Enter User ID 1: ");
                    int mutualId1 = scanner.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int mutualId2 = scanner.nextInt();
                    socialMedia.findMutualFriends(mutualId1, mutualId2);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    int displayId = scanner.nextInt();
                    socialMedia.displayFriends(displayId);
                    break;
                case 6:
                    System.out.print("Enter Name or User ID to search: ");
                    String searchName = scanner.next();
                    int searchId = scanner.nextInt();
                    socialMedia.searchUser(searchName, searchId);
                    break;
                case 7:
                    socialMedia.countFriends();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}