import java.util.*;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public int getValue() {
        if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
            return 0;
        } else if (rank.equals("Ace")) {
            return 1;
        } else {
            return Integer.parseInt(rank);
        }
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }
}

class Player {
    private String name;
    private int bet;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getBet() {
        return bet;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public int calculateHandValue() {
        int value = 0;
        for (Card card : hand) {
            value += card.getValue();
        }
        return value % 10;
    }
}

public class LoyolaLuckyNineReplica {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Player> players = new ArrayList<>();
    private static Deck deck = new Deck();

    public static void main(String[] args) {
        System.out.println("Welcome to Lucky 9 game!");

        boolean running = true;
        while (running) {
            System.out.println("[1] Start game");
            System.out.println("[2] View leaderboard");
            System.out.println("[3] Exit");
            System.out.print("Select your action: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    viewLeaderboard();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void startGame() {
        System.out.print("Enter your dealer's name:");
        String dealerName = scanner.nextLine();
        System.out.print("Enter cash fund:");
        int cashFund = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter number of players (max 20):");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (numPlayers < 1 || numPlayers > 20) {
            System.out.println("Invalid number of players.");
            return;
        }

        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String playerName = scanner.nextLine();
            System.out.print("Enter bet for " + playerName + ": ");
            int bet = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            players.add(new Player(playerName));
            players.get(i - 1).setBet(bet);
        }

        System.out.println("[1] Play");
        System.out.println("[2] Quit");
        System.out.print("Select your action: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            playGame(dealerName, cashFund);
        }
    }

    private static void playGame(String dealerName, int cashFund) {
        deck.shuffle();

        for (Player player : players) {
            for (int i = 1; i <= 2; i++) {
                Card card = deck.drawCard();
                player.addToHand(card);
                System.out.println(player.getName() + "'s " + i + " card: " + card);
            }
        }

        for (Player player : players) {
            System.out.println(player.getName() + "'s cards:");
            for (Card card : player.getHand()) {
                System.out.println(card);
            }

            System.out.println("Do you want to draw a third card? (Y/N)");
            String drawChoice = scanner.nextLine();

            if (drawChoice.equalsIgnoreCase("Y")) {
                Card card = deck.drawCard();
                player.addToHand(card);
                System.out.println(player.getName() + "'s 3rd card: " + card);
            }

            System.out.println(player.getName() + "'s total value: " + player.calculateHandValue());
        }

        // Dealer fights the cards and bets
        Player dealer = new Player(dealerName);
        int dealerTotal = 0;
        for (Player player : players) {
            if (player.calculateHandValue() > dealerTotal && player.calculateHandValue() <= 9) {
                dealerTotal = player.calculateHandValue();
            }
        }
        System.out.println("Dealer's total value: " + dealerTotal);

        for (Player player : players) {
            if (player.calculateHandValue() == dealerTotal) {
                System.out.println(player.getName() + " wins with " + dealerTotal);
                cashFund -= player.getBet();
            } else {
                System.out.println(player.getName() + " loses with " + player.calculateHandValue());
                cashFund += player.getBet();
            }
        }

        System.out.println("Updated cash fund: " + cashFund);
    }

    private static void viewLeaderboard() {
        // Not implemented in this basic version
        System.out.println("Leaderboard:");
        for (Player player : players) {
            System.out.println(player.getName() + " - Bet: " + player.getBet());
        }
    }
}
