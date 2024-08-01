import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaMiniStoreDownTownQ {

    public static void main(String[] args) {
        new JavaMiniStoreDownTownQ().createAndShowGUI();
    }

    private void createAndShowGUI() {
        String[][] items = {
                {"A", "3-in-1 coffee", "10.00"},
                {"B", "Cup noodles", "20.00"},
                {"C", "Laundry soap", "25.00"},
                {"D", "Bottled water - 1 liter", "20.00"},
                {"E", "Bottled water - 500ml", "12.00"},
        };
        String[] header = {"Item code", "Item Description", "Price"};

        JFrame frame = new JFrame("Items Table with Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(items.length + 1, header.length));

        for (String column : header) {
            tablePanel.add(new JLabel(column, SwingConstants.CENTER));
        }

        for (String[] row : items) {
            for (String cell : row) {
                tablePanel.add(new JLabel(cell, SwingConstants.CENTER));
            }
        }

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton buyButton = new JButton("Buy");
        JButton paymentButton = new JButton("Payment");
        JButton inventoryButton = new JButton("Inventory");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(buyButton);
        buttonPanel.add(paymentButton);
        buttonPanel.add(inventoryButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JTextArea paymentArea = new JTextArea();
        paymentArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(paymentArea);
        mainPanel.add(scrollPane, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.setVisible(true);

        InventoryManager inventoryManager = new InventoryManager(items);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryManager.handleBuyAction();
            }
        });

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryManager.handlePaymentAction();
            }
        });

        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryManager.displayInventory();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

class InventoryManager {
    private String[][] items;
    private int[] inventory;
    private int[] cart;

    public InventoryManager(String[][] items) {
        this.items = items;
        this.inventory = new int[items.length];
        this.cart = new int[items.length];
        // Initialize inventory quantities
        inventory[0] = 100; // Product A
        inventory[1] = 36;  // Product B
        inventory[2] = 15;  // Product C
        inventory[3] = 8;   // Product D
        inventory[4] = 24;  // Product E
    }

    public void handleBuyAction() {
        String itemCode = JOptionPane.showInputDialog("Enter item code:");
        String quantityStr = JOptionPane.showInputDialog("Enter quantity:");
        if (itemCode == null || quantityStr == null) return;

        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) throw new NumberFormatException();
            boolean found = false;
            for (int i = 0; i < items.length; i++) {
                if (items[i][0].equalsIgnoreCase(itemCode)) {
                    int availableQuantity = inventory[i];
                    if (availableQuantity >= quantity) {
                        inventory[i] -= quantity;
                        cart[i] += quantity;
                        found = true;
                        JOptionPane.showMessageDialog(null, "Your item is added to your cart.");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Product " + items[i][0] + " is out of stock.");
                        return;
                    }
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(null, "Invalid item code.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Quantity should be a valid number greater than 0.");
        }
    }

    public void handlePaymentAction() {
        double totalBill = 0.0;
        boolean itemsBought = false;

        StringBuilder receipt = new StringBuilder("Items Bought\n\n");
        int totalItems = 0;

        for (int i = 0; i < items.length; i++) {
            if (cart[i] > 0) {
                itemsBought = true;
                receipt.append(String.format("%-20s %5d %10.2f\n", items[i][1], cart[i], cart[i] * Double.parseDouble(items[i][2])));
                totalItems += cart[i];
                totalBill += cart[i] * Double.parseDouble(items[i][2]);
            }
        }

        if (itemsBought) {
            receipt.append(String.format("\nNo. of items purchased: %d\nTotal Bill: %.2f\n\nThank you for shopping!", totalItems, totalBill));
            JOptionPane.showMessageDialog(null, receipt.toString(), "Payment Receipt", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No items have been added to your cart.", "Payment Receipt", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void displayInventory() {
        StringBuilder inventoryList = new StringBuilder("Product Code  Total No. of Items in Store\n");
        for (int i = 0; i < items.length; i++) {
            inventoryList.append(String.format("%-30s%d\n", items[i][0], inventory[i]));
        }
        JOptionPane.showMessageDialog(null, inventoryList.toString(), "Inventory", JOptionPane.INFORMATION_MESSAGE);
    }
}
