package files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    JButton Button1, Button2, Button3;
    JTextField text1;
    JPasswordField text2;

    Splash() {
        // Set gradient background using a JPanel override
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Modern gradient colors with a smoother effect
                Color color1 = new Color(0, 204, 255); // Light cyan
                Color color2 = new Color(0, 51, 102);  // Dark blue
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(backgroundPanel);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/shivu.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT); // Adjusted dimensions
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);

        // Heading with automatic resizing and underline effect
        JLabel heading = new JLabel("WELCOME TO SHIV INSTITUTE OF EDUCATIONAL UNIVERSITY");
        heading.setBounds(300, 50, 1000, 100); // Adjust bounds as needed
        heading.setFont(new Font("Serif", Font.BOLD, 30));
        heading.setForeground(Color.black);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setVerticalAlignment(SwingConstants.CENTER);
        heading.setOpaque(false);

        // Underline effect
        heading.setText("<html><u>" + heading.getText() + "</u></html>");
        add(heading);

        // Set the position of the image
        image.setBounds(300, 150, 800, 400); // Adjusted bounds to align properly
        add(image);

        // Create modern buttons
        JButton loginButton = new JButton("Login");
        JButton closeButton = new JButton("Close");

        // Button styling
        loginButton.setBackground(new Color(0, 153, 76));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        loginButton.setFocusPainted(false);

        closeButton.setBackground(new Color(204, 0, 0));
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Arial", Font.BOLD, 18));
        closeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        closeButton.setFocusPainted(false);

        // Set button bounds at the bottom
        loginButton.setBounds(550, 600, 150, 50); // Center-aligned button
        closeButton.setBounds(750, 600, 150, 50); // Center-aligned button

        // Add action listeners
        loginButton.addActionListener(this);
        closeButton.addActionListener(e -> System.exit(0)); // Close the application on click

        // Add buttons to the frame
        add(loginButton);
        add(closeButton);

        // Set frame properties
        setSize(1400, 800); // Larger frame to fit all elements
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Login")) {
            JOptionPane.showMessageDialog(this, "Login to Open Admin portal!");
            new Login();
           
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
