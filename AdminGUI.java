package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;



public class AdminGUI extends JFrame implements ActionListener {
    //Main method not needed for now
   /* public static void main(String[] args) {
        AdminGUI gui = new AdminGUI();
        gui.setVisible(true);

    }*/

    private JMenu fileMenu;
    private JMenu editMenu;
    private JButton backButton, loginButton;

    //array
    Book book1 = new Book();
    ArrayList<Book> books;

    Customer cust1 = new Customer();
    ArrayList<Customer> customers;


    //book
    String title, author,isbn;
    int numPages;
    double price;


    /*https://stackoverflow.com/questions/22506331/simple-dropdown-menu-in-java*/

    public AdminGUI() {

        Container cPane;

        //setting default values for GUI
        setTitle     ("My Book Shop ADMIN SECTION");
        setSize      (200,200);
        setResizable (true);
        setLocation  (500,100);

        //this is what the GUI does when you press the 'x' button
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());

        //creating new JButton here - says 'LOGIN'
        JButton loginButton = new JButton("LOGIN");
        //action listener
        loginButton.addActionListener(this);
        //adding the new button to the pane
        cPane.add(loginButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);
        cPane.add(backButton);
}

    //login button
    public void loginButton() {


    }




    //action listener here
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("LOGIN"))
        {
            String adminEmail = "admin";
        int password = 1234;

        cust1.setEmail(JOptionPane.showInputDialog(null,"Enter Email"));
        cust1.setPassword(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Pin")));

        if(cust1.getEmail().equals(adminEmail) && cust1.getPassword() == password)
        {
            JOptionPane.showMessageDialog(null,"Welcome to the System","Welcome!",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        else
        {
            JOptionPane.showMessageDialog(null,"Error! Your email or pin was incorrect","Warning!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

   }
}
