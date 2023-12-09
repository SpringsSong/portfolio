import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

// Main class for the program
public class Broadhead_SearchAndSort {

    private UniqueList<Integer> numbersList; // List to store unique numbers
    private JTextArea resultTextArea; // Text area to display numbers

    // Constructor to initialize the GUI
    public Broadhead_SearchAndSort() {
        numbersList = new UniqueList<>();

        // Create the main frame
        JFrame frame = new JFrame("Number List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the text area for displaying numbers
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        // Create buttons with corresponding actions
        JButton sortButton = new JButton("Sort");
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortNumbers();
            }
        });

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shuffleNumbers();
            }
        });

        JButton reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reverseNumbers();
            }
        });

        JButton addButton = new JButton("Add Number");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNumber();
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sortButton);
        buttonPanel.add(shuffleButton);
        buttonPanel.add(reverseButton);
        buttonPanel.add(addButton);

        // Set the layout of the frame
        frame.setLayout(new BorderLayout());
        frame.add(resultTextArea, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to add a number to the list
    private void addNumber() {
        String input = JOptionPane.showInputDialog("Enter a number:");
        try {
            int number = Integer.parseInt(input);
            numbersList.add(number);
            updateResultTextArea();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }

    // Method to sort the numbers in ascending order
    private void sortNumbers() {
        Collections.sort(numbersList);
        updateResultTextArea();
    }

    // Method to shuffle the order of the numbers
    private void shuffleNumbers() {
        Collections.shuffle(numbersList);
        updateResultTextArea();
    }

    // Method to reverse the order of the numbers
    private void reverseNumbers() {
        Collections.reverse(numbersList);
        updateResultTextArea();
    }

    // Method to update the text area with the current list of numbers
    private void updateResultTextArea() {
        resultTextArea.setText("");

        if (!numbersList.isEmpty()) {
            StringBuilder result = new StringBuilder(String.valueOf(numbersList.get(0)));

            for (int i = 1; i < numbersList.size(); i++) {
                result.append(", ").append(numbersList.get(i));
            }

            resultTextArea.setText(result.toString());
        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        new Broadhead_SearchAndSort();
    }
}

// UniqueList class that extends LinkedList to store unique elements
class UniqueList<T extends Comparable<T>> extends LinkedList<T> {
    @Override
    public boolean add(T e) {
        if (!contains(e)) {
            super.add(e);
            return true;
        }
        return false;
    }
}
