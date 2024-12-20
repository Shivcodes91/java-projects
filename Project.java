package files;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setSize(1540, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        // Create Menu Bar
        JMenuBar mb = new JMenuBar();
        
        // New Information Menu
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(new Color(70, 130, 180));  // Change color
        newInformation.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Font styling
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        facultyInfo.addActionListener(this);
        setHoverEffect(facultyInfo);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        studentInfo.addActionListener(this);
        setHoverEffect(studentInfo);
        newInformation.add(studentInfo);
        
        // Other menus
        createMenu(mb, "View Details", Color.RED, new String[]{"View Faculty Details", "View Student Details"});
        createMenu(mb, "Apply Leave", new Color(0, 128, 255), new String[]{"Faculty Leave", "Student Leave"});
        createMenu(mb, "Leave Details", Color.RED, new String[]{"Faculty Leave Details", "Student Leave Details"});
        createMenu(mb, "Examination", new Color(70, 130, 180), new String[]{"Examination Results", "Enter Marks"});
        createMenu(mb, "Update Details", Color.RED, new String[]{"Update Faculty Details", "Update Student Details"});
        createMenu(mb, "Fee Details", new Color(0, 128, 255), new String[]{"Fee Structure", "Student Fee Form"});
        createMenu(mb, "Utility", Color.RED, new String[]{"Notepad", "Calculator"});
        
        // About & Exit Menu
        createMenu(mb, "About", new Color(70, 130, 180), new String[]{"About"});
        createMenu(mb, "Exit", Color.RED, new String[]{"Exit"});
        
        setJMenuBar(mb);
        setVisible(true);
    }

    // Helper method to create menus dynamically
    private void createMenu(JMenuBar mb, String menuName, Color color, String[] itemNames) {
        JMenu menu = new JMenu(menuName);
        menu.setForeground(color);
        menu.setFont(new Font("Segoe UI", Font.BOLD, 14));
        mb.add(menu);

        for (String itemName : itemNames) {
            JMenuItem menuItem = new JMenuItem(itemName);
            menuItem.setBackground(Color.WHITE);
            menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            menuItem.addActionListener(this);
            setHoverEffect(menuItem);
            menu.add(menuItem);
        }
    }

    // Method to add hover effect on menu items
    private void setHoverEffect(JMenuItem item) {
        item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                item.setBackground(new Color(240, 240, 240)); // Light gray on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                item.setBackground(Color.WHITE); // Default background
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (msg.equals("View Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (msg.equals("Student Leave")) {
            new StudentLeave();
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("About")) {
            new About();
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
