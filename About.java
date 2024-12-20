package files;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(new Color(250, 250, 250)); // Light background color
        
        // Resize image to prevent blurring and make it a little smaller
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/shipuuuu.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 170, Image.SCALE_SMOOTH); // Slightly smaller image with smoother scaling
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 250, 170); // Resize image
        add(image);
        
        // Heading
        JLabel heading = new JLabel("<html><font color='#1E90FF'>University</font><br/><font color='#1E90FF'>Management System</font></html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 30)); // Modern font
        add(heading);
        
        // Developer Name
        JLabel name = new JLabel("Developed By: Shivang Rai");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("Segoe UI", Font.BOLD, 30)); // Modern font
        name.setForeground(new Color(70, 130, 180)); // Soft blue color
        add(name);
        
        // Roll number
        JLabel rollno = new JLabel("Roll number: 122039174");
        rollno.setBounds(70, 280, 550, 40);
        rollno.setFont(new Font("Segoe UI", Font.PLAIN, 30)); // Modern font
        rollno.setForeground(Color.DARK_GRAY); // Dark gray for contrast
        add(rollno);
        
        // Contact
        JLabel contact = new JLabel("Contact: shivangrai238@gmail.com    +91 9140710892 ");
        contact.setBounds(70, 340, 550, 40);
        contact.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Modern font
        contact.setForeground(Color.DARK_GRAY); // Dark gray for contrast
        add(contact);
        
        setLayout(null);
        setResizable(false); // Prevent resizing of the window
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
