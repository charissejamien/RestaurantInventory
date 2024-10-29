import org.example.models.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage {


    public static void main(String[] args) {
        JLabel errorLabel = new JLabel();

            //Create Frame
            JFrame frame = new JFrame();
            frame.setSize(1100, 630);
            frame.getContentPane().setBackground(Color.decode("#d87436"));
            frame.setLayout(null);
            frame.setLocationRelativeTo((Component) null);
            frame.setResizable(false);

            //Create Login Panel
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.white);
            panel.setBounds(500, 0, 600, 630);
            frame.add(panel);

            //Create Login Label
            JLabel label = new JLabel();
            label.setText("Welcome!");
            label.setFont(new Font("Arial", 1, 50));
            label.setForeground(Color.decode("#d87436"));
            label.setBounds(150, 60, 500, 70);
            panel.add(label);

            //Create extra label
            JLabel extraLabel = new JLabel();
            extraLabel.setText("Log in to your account");
            extraLabel.setBounds(160, 130, 500, 30);
            extraLabel.setFont(new Font("Bitstream Vera Sans Mono", 0, 18));
            extraLabel.setForeground(Color.decode("#545454"));
            panel.add(extraLabel);

            //Create Username Field
            JTextField userName = new JTextField();
            userName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#7c8a92")));
            userName.setBounds(160, 200, 270, 40);
            userName.setFont(new Font("Abadi MT Condensed Extra Bold", 1, 15));
            userName.setCaretColor(Color.darkGray);
            userName.setForeground(Color.decode("#545454"));
            userName.setText("Username");
            userName.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    userName.setText("");
                }
            });
            userName.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    if(userName.getText() == null)
                        userName.setText("Username");
                }
            });
            panel.add(userName);

            //Create Password placeholder
            JLabel passPlaceholder = new JLabel();
            passPlaceholder.setText("Password");
            passPlaceholder.setBounds(161, 260, 270, 40);
            passPlaceholder.setFont(new Font("Abadi MT Condensed Extra Bold", 1, 15));
            passPlaceholder.setForeground(Color.decode("#545454"));
            passPlaceholder.setVisible(true);
            panel.add(passPlaceholder);

            //Create Password Field
            JPasswordField password = new JPasswordField();
            password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#7c8a92")));
            password.setBounds(160, 260, 270, 40);
            password.setForeground(Color.darkGray);
            password.setCaretColor(Color.darkGray);
            password.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    passPlaceholder.setText("");
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if(userName.getText() == null)
                        passPlaceholder.setText("Password");
                }
            });
            panel.add(password);

            //Create Login Button
            JButton loginButton = new JButton();
            loginButton.setBounds(160, 330, 100, 35);
            loginButton.setBorder(BorderFactory.createEmptyBorder());
            loginButton.setBackground(Color.decode("#d87436"));
            loginButton.setText("Login");
            loginButton.setForeground(Color.white);
            loginButton.setFont(new Font("Arial", 1, 18));
            loginButton.setFocusable(false);
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String usernameInput = userName.getText();
                    String passwordInput = new String(password.getPassword());

                    if (Database.authenticateUser(usernameInput, passwordInput)) {
                        new MenuPage(frame);
                    } else {
                        //Create Error Login Label
                        errorLabel.setText("Invalid username and password. Please try again");
                        errorLabel.setBounds(160, 300, 500, 20);
                        errorLabel.setForeground(Color.red);
                        errorLabel.setFont(new Font("Bitstream Vera Sans Mono", Font.PLAIN, 12));
                        userName.setText("");
                        password.setText("");
                    }

                }
            });
            panel.add(errorLabel);
            panel.add(loginButton);

            //Create Register Label
            JLabel label2 = new JLabel();
            label2.setText("Don't have an account yet? ");
            label2.setBounds(170, 370, 500, 50);
            label2.setFont(new Font("Bitstream Vera Sans Mono", 1, 12 ));
            panel.add(label2);

            //Create Register button
            JButton registerButton = new JButton();
            registerButton.setText("Register");
            registerButton.setFont(new Font("Bitstream Vera Sans Mono", 1, 12 ));
            registerButton.setForeground(Color.BLUE);
            registerButton.setBorderPainted(false);
            registerButton.setContentAreaFilled(false);
            registerButton.setFocusPainted(false);
            registerButton.setBounds(305, 375, 100, 40);
            registerButton.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    frame.getContentPane().removeAll();
                    new RegisterPage(frame);
                    frame.revalidate();
                    frame.repaint();
                }

                public void mouseEntered(MouseEvent e) {
                    registerButton.setForeground(Color.RED);
                }

                public void mouseExited(MouseEvent e) {
                    registerButton.setForeground(Color.BLUE);
                }
            });
            panel.add(registerButton);

            frame.add(panel);
            frame.setVisible(true);
        }
    }

