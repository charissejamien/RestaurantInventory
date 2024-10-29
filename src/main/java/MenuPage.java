import org.example.models.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MenuPage {

    JButton managersButton = new JButton("Manager");
    JButton breakfastButton = new JButton("Breakfast");
    JButton lunchButton = new JButton("Lunch");
    JButton dinnerButton = new JButton("Dinner");

    MenuPage(JFrame frame) {
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        //Create Managers Button
        managersButton.setBounds(900, 30, 150, 40);
        managersButton.setBackground(Color.decode("#8c9e42"));
        managersButton.setFont(new Font("Arial", Font.BOLD, 18));
        managersButton.setForeground(Color.white);
        managersButton.setFocusable(false);
        managersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new ManagersPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(managersButton);

        //Create Breakfast Button
        breakfastButton.setForeground(Color.white);
        breakfastButton.setBorder(BorderFactory.createEmptyBorder());
        breakfastButton.setFont(new Font("Arial", Font.BOLD, 18));
        breakfastButton.setBounds(50, 30, 150, 40);
        breakfastButton.setBackground(Color.decode("#cb6a2e"));
        breakfastButton.setFocusable(false);
        breakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakfastButton.setBackground(Color.decode("#cb6a2e"));
                lunchButton.setBackground(Color.decode("#e4a781"));
                dinnerButton.setBackground(Color.decode("#e4a781"));
            }
        });
        frame.add(breakfastButton);

        //Create Lunch Button
        lunchButton.setForeground(Color.white);
        lunchButton.setBorder(BorderFactory.createEmptyBorder());
        lunchButton.setFont(new Font("Arial", Font.BOLD, 18));
        lunchButton.setBounds(230, 30, 150, 40);
        lunchButton.setBackground(Color.decode("#e4a781"));
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunchButton.setBackground(Color.decode("#cb6a2e"));
                breakfastButton.setBackground(Color.decode("#e4a781"));
                dinnerButton.setBackground(Color.decode("#e4a781"));
            }
        });
        frame.add(lunchButton);

        //Create Dinner Button
        dinnerButton.setForeground(Color.white);
        dinnerButton.setBorder(BorderFactory.createEmptyBorder());
        dinnerButton.setFont(new Font("Arial", Font.BOLD, 18));
        dinnerButton.setBounds(410, 30, 150, 40);
        dinnerButton.setBackground(Color.decode("#e4a781"));
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dinnerButton.setBackground(Color.decode("#cb6a2e"));
                breakfastButton.setBackground(Color.decode("#e4a781"));
                lunchButton.setBackground(Color.decode("#e4a781"));
            }
        });
        frame.add(dinnerButton);

        // Create a panel to hold meal panels
        JPanel mealPanelContainer = new JPanel();
        mealPanelContainer.setLayout(new GridLayout(2, 4)); // 1 row, 4 columns

        // Fetch meals from the database
        List<String[]> meals = Database.getMeals(); // Assuming this method is static

        // Loop through meals and create a panel for each
        for (String[] meal : meals) {
            JPanel mealPanel = new JPanel();
            mealPanel.setLayout(new BorderLayout());
            mealPanel.setPreferredSize(new Dimension(200, 250)); // Set preferred size for each panel
            mealPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            mealPanel.setBackground(Color.white);

            JLabel nameLabel = new JLabel(meal[0], SwingConstants.CENTER); // Meal name
            JLabel descriptionLabel = new JLabel(meal[1], SwingConstants.CENTER); // Meal description

            mealPanel.add(nameLabel, BorderLayout.NORTH);
            mealPanel.add(descriptionLabel, BorderLayout.CENTER);

            mealPanelContainer.add(mealPanel);
        }

        // Add the meal panel container to the frame
        mealPanelContainer.setBounds(50, 100, 700, 200); // Adjust size and position as needed
        frame.add(mealPanelContainer);

        frame.setLayout(null);
        frame.setSize(1100, 630);
        frame.setVisible(true);
    }
}