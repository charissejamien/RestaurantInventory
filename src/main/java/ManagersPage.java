import org.example.models.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagersPage {

    JButton menuPageButton = new JButton();
    JLabel welcomeLabel = new JLabel();
    JLabel addMealLabel = new JLabel();
    JLabel mealNameLabel = new JLabel();
    JTextField mealNameTf = new JTextField("");
    JLabel descLabel = new JLabel();
    JTextField descriptionTf = new JTextField();
    JLabel categLabel = new JLabel();
    JButton breakfastButton = new JButton("breakfast");
    JButton lunchButton = new JButton("lunch");
    JButton dinnerButton = new JButton("dinner");
    JLabel dtLabel = new JLabel();
    JButton vegButton = new JButton();
    JButton nonvegButton = new JButton();
    JLabel spiceLevel = new JLabel();
    JButton spicyButton = new JButton();
    JButton nonspicyButton = new JButton();
    JLabel calsLabel = new JLabel();
    JTextField calsTf = new JTextField();
    JButton addButton = new JButton();
    private String category = "breakfast";
    private String dietType = "Non-Vegetarian";
    private String spice = "Not-Spicy";


    ManagersPage(JFrame frame) {


        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        menuPageButton.setBounds(900, 20, 150, 40);
        menuPageButton.setBackground(Color.decode("#8c9e42"));
        menuPageButton.setText("Back to Menu");
        menuPageButton.setFont(new Font("Arial", Font.BOLD, 16));
        menuPageButton.setForeground(Color.white);
        menuPageButton.setFocusable(false);
        menuPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuPage(frame);
            }
        });
        frame.add(menuPageButton);

        //Hello, Manager Label
        welcomeLabel.setText("Hello, Manager");
        welcomeLabel.setForeground(Color.decode("#545454"));
        welcomeLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 36));
        welcomeLabel.setBounds(50, 30, 500, 50);
        frame.add(welcomeLabel);

        //Add meal Label
        addMealLabel.setText("Add a Meal");
        addMealLabel.setForeground(Color.decode("#d87436"));
        addMealLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 28));
        addMealLabel.setBounds(50, 90, 500, 50);
        frame.add(addMealLabel);

        //Add Meal Name Label
        mealNameLabel.setText("Meal Name");
        mealNameLabel.setBounds(50, 170, 250, 30);
        mealNameLabel.setForeground(Color.decode("#d87436"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        //Add Meal Name TextField
        mealNameTf.setBounds(50, 200, 250, 40);
        mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        //Add description Label
        descLabel.setText("Description");
        descLabel.setBounds(50, 270, 250, 30);
        descLabel.setForeground(Color.decode("#d87436"));
        descLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(descLabel);

        //Add description TextField
        descriptionTf.setBounds(50, 300, 250, 40);
        descriptionTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        descriptionTf.setBackground(Color.white);
        frame.add(descriptionTf);

        //Add Category Label
        categLabel.setText("Category");
        categLabel.setBounds(50, 370, 250, 30);
        categLabel.setForeground(Color.decode("#d87436"));
        categLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(categLabel);

        //Add breakfast Button
        breakfastButton.setBounds(50, 400, 70, 40);
        breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        breakfastButton.setBackground(Color.white);
        breakfastButton.setFocusable(false);
        breakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                breakfastButton.setBackground(Color.decode("#d87436"));
                breakfastButton.setForeground(Color.white);
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                category = "breakfast";
            }
        });
        frame.add(breakfastButton);

        //Add Lunch Button
        lunchButton.setBounds(140, 400, 70, 40);
        lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        lunchButton.setBackground(Color.white);
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                lunchButton.setBackground(Color.decode("#d87436"));
                lunchButton.setForeground(Color.white);
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                category = "lunch";
            }
        });
        frame.add(lunchButton);

        //Add Dinner Button
        dinnerButton.setBounds(230, 400, 70, 40);
        dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        dinnerButton.setBackground(Color.white);
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                dinnerButton.setBackground(Color.decode("#d87436"));
                dinnerButton.setForeground(Color.white);
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                category = "dinner";
            }
        });
        frame.add(dinnerButton);

        //Add Diet Type label
        dtLabel.setText("Diet Type");
        dtLabel.setBounds(50, 470, 250, 30);
        dtLabel.setForeground(Color.decode("#d87436"));
        dtLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(dtLabel);

        //Add Vegetarian Button
        vegButton.setText("Vegetarian");
        vegButton.setBounds(50, 500, 120, 40);
        vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        vegButton.setBackground(Color.white);
        vegButton.setFocusable(false);
        vegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                vegButton.setBackground(Color.decode("#d87436"));
                vegButton.setForeground(Color.white);
                dietType = "Vegetarian";
                nonvegButton.setBackground(Color.white);
                nonvegButton.setForeground(Color.black);
            }
        });
        frame.add(vegButton);

        //Add Non-Vegetarian Button
        nonvegButton.setText("Non-Vegetarian");
        nonvegButton.setBounds(180, 500, 120, 40);
        nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        nonvegButton.setBackground(Color.white);
        nonvegButton.setFocusable(false);
        nonvegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                nonvegButton.setBackground(Color.decode("#d87436"));
                nonvegButton.setForeground(Color.white);
                dietType = "Non-Vegetarian";
                vegButton.setBackground(Color.white);
                vegButton.setForeground(Color.black);
            }
        });
        frame.add(nonvegButton);

        //Add a Spice Label
        spiceLevel.setText("Spice");
        spiceLevel.setBounds(450, 170, 250, 30);
        spiceLevel.setForeground(Color.decode("#d87436"));
        spiceLevel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(spiceLevel);

        //Add Spicy button
        spicyButton.setText("Spicy");
        spicyButton.setBounds(450, 200, 120, 40);
        spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        spicyButton.setBackground(Color.white);
        spicyButton.setFocusable(false);
        spicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                spicyButton.setBackground(Color.decode("#d87436"));
                spicyButton.setForeground(Color.white);
                spice = "Spicy";
                nonspicyButton.setBackground(Color.white);
                nonspicyButton.setForeground(Color.black);
            }
        });
        frame.add(spicyButton);

        //Add Non-Spicy Button
        nonspicyButton.setText("Not-Spicy");
        nonspicyButton.setBounds(580, 200, 120, 40);
        nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        nonspicyButton.setBackground(Color.white);
        nonspicyButton.setFocusable(false);
        nonspicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
                nonspicyButton.setBackground(Color.decode("#d87436"));
                nonspicyButton.setForeground(Color.white);
                spice = "Not-Spicy";
                spicyButton.setBackground(Color.white);
                spicyButton.setForeground(Color.black);
            }
        });
        frame.add(nonspicyButton);

        //Add Calories Label
        calsLabel.setText("Calories");
        calsLabel.setBounds(450, 270, 250, 30);
        calsLabel.setForeground(Color.decode("#d87436"));
        calsLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(calsLabel);

        //Add Calories TextField
        calsTf.setBounds(450, 300, 250, 40);
        calsTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        calsTf.setBackground(Color.white);
        frame.add(calsTf);

        //Add Add Meal button
        addButton.setText("Add Meal");
        addButton.setBounds(450, 370, 250, 40);
        addButton.setBackground(Color.decode("#d87436"));
        addButton.setFont(new Font("Arial", 1, 18));
        addButton.setForeground(Color.white);
        addButton.setFocusable(false);
        addButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = mealNameTf.getText();
                String description = descriptionTf.getText();
                String category = ManagersPage.this.category;
                String dietType = ManagersPage.this.dietType;
                String spice = ManagersPage.this.spice;
                int calories = Integer.parseInt(calsTf.getText());
                Database.addMeals(name, description, category, dietType, spice, calories);
                mealNameTf.setText("");
                descriptionTf.setText("");
                breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                vegButton.setBackground(Color.white);
                vegButton.setForeground(Color.black);
                nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                nonvegButton.setBackground(Color.white);
                nonvegButton.setForeground(Color.black);
                spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                spicyButton.setBackground(Color.white);
                spicyButton.setForeground(Color.black);
                nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                nonspicyButton.setBackground(Color.white);
                nonspicyButton.setForeground(Color.black);
                calsTf.setText("");
            }
        });
        frame.add(addButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
