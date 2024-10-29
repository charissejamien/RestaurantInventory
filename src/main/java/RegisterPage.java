import org.example.models.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage {
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JPanel rolepanel = new JPanel();
    JLabel rolelabel = new JLabel();
    JLabel managerLabel = new JLabel();
    JLabel workerLabel = new JLabel();
    JTextField userName = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton button = new JButton();
    JButton managerButton = new JButton();
    JButton workerButton = new JButton();
    String role = "worker";

    RegisterPage(JFrame frame) {
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        //Create Register Panel
        panel.setBounds(0, 0, 500, 630);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        //Create Role Panel
        rolepanel.setBounds(500, 0, 600, 630);
        rolepanel.setBackground(Color.decode("#d87436"));
        rolepanel.setLayout(null);

        //Create Register Label
        label.setBounds(100, 60, 400, 50);
        label.setText("Create Account");
        label.setForeground(Color.decode("#ff914d"));
        label.setFont(new Font("Arial", 1, 40));
        panel.add(label);

        //Create Role Label
        rolelabel.setText("select role");
        rolelabel.setBounds(220, 60, 400, 50);
        rolelabel.setFont(new Font("Arial", Font.BOLD, 25));
        rolelabel.setForeground(Color.white);
        rolepanel.add(rolelabel);

        //Create Manager label
        managerLabel.setText("Manager");
        managerLabel.setBounds(130, 350, 400, 50);
        managerLabel.setForeground(Color.white);
        managerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        rolepanel.add(managerLabel);

        //Create Worker label
        workerLabel.setText("Worker");
        workerLabel.setBounds(390, 350, 400, 50);
        workerLabel.setForeground(Color.white);
        workerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        rolepanel.add(workerLabel);

        //Create Username Field
        userName.setBounds(100, 170, 310, 50);
        userName.setBackground(Color.decode("#f6ebe1"));
        userName.setBorder(BorderFactory.createEmptyBorder());
        userName.setFont(new Font("Arial", 0, 20));
        panel.add(userName);

        //Create Password Field
        password.setBounds(100, 250, 310, 50);
        password.setBackground(Color.decode("#f6ebe1"));
        password.setBorder(BorderFactory.createEmptyBorder());
        password.setFont(new Font("Arial", 0, 20));
        panel.add(password);

        //Create Manager Button
        managerButton.setBounds(80, 150, 200, 200);
        managerButton.setBackground(Color.decode("#d87436"));
        managerButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerButton.setBackground(Color.white);
                workerButton.setBackground(Color.decode("#d87436"));
                role = "manager";
            }
        });
        rolepanel.add(managerButton);

        //Create Worker Button
        workerButton.setBounds(330, 150, 200, 200);
        workerButton.setBackground(Color.decode("#d87436"));
        workerButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        workerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workerButton.setBackground(Color.white);
                managerButton.setBackground(Color.decode("#d87436"));
                role = "worker";
            }
        });
        rolepanel.add(workerButton);

        //Create Register Button
        button.setBounds(100, 350, 150, 40);
        button.setBackground(Color.decode("#ff914d"));
        button.setText("Register");
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.white);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userName.getText();
                String pass = new String(password.getPassword());
                String type = role;
                Database.registerUser(user, pass, type);
                userName.setText("");
                password.setText("");
                managerButton.setBackground(Color.decode("#d87436"));
                managerButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
                workerButton.setBackground(Color.decode("#d87436"));
                workerButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
            }
        });
        panel.add(button);

        frame.add(panel);
        frame.add(rolepanel);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

