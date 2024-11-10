package labs.lab_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxRadioButtonDemo extends JFrame implements ActionListener {
    // Components: Checkboxes, Radio Buttons, and a Text Field
    JCheckBox[] checkBoxes = new JCheckBox[5];  // Checkboxes numbered 1 to 5
    JRadioButton[] radioButtons = new JRadioButton[5];  // Radio buttons numbered 1 to 5
    JTextField textField = new JTextField(20);  // Text field to display selected numbers

    public CheckBoxRadioButtonDemo() {
        // Frame setup
        setTitle("Checkbox and RadioButton Demo");
        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for checkboxes
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setBorder(BorderFactory.createTitledBorder("Select Checkboxes"));
        checkBoxPanel.setLayout(new GridLayout(5, 1));

        // Create checkboxes and add to panel
        for (int i = 0; i < 5; i++) {
            checkBoxes[i] = new JCheckBox("Checkbox " + (i + 1));
            checkBoxes[i].addActionListener(this);
            checkBoxPanel.add(checkBoxes[i]);
        }

        // Panel for radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setBorder(BorderFactory.createTitledBorder("Select Radio Buttons"));
        radioPanel.setLayout(new GridLayout(5, 1));
        ButtonGroup group = new ButtonGroup();  // Grouping radio buttons

        // Create radio buttons and add to group and panel
        for (int i = 0; i < 5; i++) {
            radioButtons[i] = new JRadioButton("RadioButton " + (i + 1));
            radioButtons[i].addActionListener(this);
            group.add(radioButtons[i]);
            radioPanel.add(radioButtons[i]);
        }

        // Add components to the frame
        add(checkBoxPanel);
        add(radioPanel);
        add(new JLabel("Selected:"));
        add(textField);

        // Display the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Build a string of selected checkboxes and radio buttons
        StringBuilder selected = new StringBuilder();

        // Check which checkboxes are selected
        for (int i = 0; i < 5; i++) {
            if (checkBoxes[i].isSelected()) {
                selected.append((i + 1)).append(", ");
            }
        }

        // Check which radio button is selected
        for (int i = 0; i < 5; i++) {
            if (radioButtons[i].isSelected()) {
                selected.append((i + 1)).append(", ");
            }
        }

        // Remove trailing comma and space, if any
        if (selected.length() > 0) {
            selected.setLength(selected.length() - 2);
        }

        // Display the selected numbers in the text field
        textField.setText(selected.toString());
    }

    public static void main(String[] args) {
        // Run the GUI application
        new CheckBoxRadioButtonDemo();
    }
}
