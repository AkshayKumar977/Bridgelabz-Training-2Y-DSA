import java.util.Scanner;

public class DeckOfCards {
    static final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    // Initialize the deck
    public static String[] initializeDeck() {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int idx = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[idx++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle the deck
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Distribute n cards to x players
    public static String[][] distributeCards(String[] deck, int n, int x) {
        if (n * x > deck.length) {
            return null; // Not enough cards
        }
        String[][] players = new String[x][n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < x; j++) {
                players[j][i] = deck[idx++];
            }
        }
        return players;
    }

    // Print players and their cards
    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);
        System.out.print("Enter number of cards per player: ");
        int n = sc.nextInt();
        System.out.print("Enter number of players: ");
        int x = sc.nextInt();
        String[][] players = distributeCards(deck, n, x);
        if (players == null) {
            System.out.println("Not enough cards to distribute.");
        } else {
            printPlayers(players);
        }
        sc.close();
    }
}
