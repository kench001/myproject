import javax.swing.*;
import java.awt.*;

public class SimpleStore {

    // Item descriptions and prices
    static final String[] itemCodes = {"A", "B", "C", "D", "E"};
    static final String[] itemDescriptions = {
        "3-in-1 coffee",
        "Cup noodles",
        "Laundry soap",
        "Bottled Water - 1 liter",
        "Bottled water - 500 ml"
    };
    static final double[] itemPrices = {10.00, 20.00, 25.00, 20.00, 12.00};

    static StringBuilder cart = new StringBuilder();
    static double totalBill = 0;
    static int totalItems = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Small Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("Item code\tItem Description\tPrice\n" +
                "A\t3-in-1 coffee\t10.00\n" +
                "B\tCup noodles\t20.00\n" +
                "C\tLaundry soap\t25.00\n" +
                "D\tBottled Water - 1 liter\t20.00\n" +
                "E\tBottled water - 500 ml\t12.00");

        frame.add(textArea);
        frame.setVisible(true);

        while (true) {
            String[] options = {"Buy", "Payment", "Inventory", "Exit"};
            int choice = JOptionPane.showOptionDialog(frame, "Choose an option:", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) { // Buy
                handleBuy();
            } else if (choice == 1) { // Payment
                handlePayment();
            } else if (choice == 2) { // Inventory
                JOptionPane.showMessageDialog(frame, textArea.getText());
            } else if (choice == 3) { // Exit
                System.exit(0);
            }
        }
    }

    private static void handleBuy() {
        String itemCode = JOptionPane.showInputDialog("Enter item code:");
        if (itemCode == null) return;

        boolean validCode = false;
        double itemPrice = 0;
        String itemDescription = "";

        for (int i = 0; i < itemCodes.length; i++) {
            if (itemCodes[i].equalsIgnoreCase(itemCode)) {
                validCode = true;
                itemPrice = itemPrices[i];
                itemDescription = itemDescriptions[i];
                break;
            }
        }

        if (!validCode) {
            JOptionPane.showMessageDialog(null, "Invalid item code");
            return;
        }

        String quantityStr = JOptionPane.showInputDialog("Enter quantity:");
        if (quantityStr == null) return;

        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "Quantity must be greater than 0");
            } else {
                double totalItemPrice = itemPrice * quantity;
                cart.append(itemDescription).append(" - ").append(quantity).append(" x ").append(itemPrice).append(" = ").append(totalItemPrice).append("\n");
                totalBill += totalItemPrice;
                totalItems += quantity;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid quantity");
        }
    }

    private static void handlePayment() {
        JOptionPane.showMessageDialog(null, "Items purchased:\n" + cart.toString() + "\nTotal items: " + totalItems + "\nTotal bill: " + totalBill);
        cart.setLength(0); // Clear the cart
        totalBill = 0;
        totalItems = 0;
    }
}
