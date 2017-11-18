package OOP2_Project_MyShop;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class AdminGUI extends JFrame implements ActionListener{

    private JMenu fileMenu;
    private JMenu editMenu;
    private JButton backButton, loginButton;

    /*//array
    Book book1 = new Book();
    ArrayList<Book> books;*/

    //need this it brings threw customer!!!!!
    Customer cust1 = new Customer();
    ArrayList<Customer> customers;


    /*//book
    String title, author,isbn;
    int numPages;
    double price;*/


    /*https://stackoverflow.com/questions/22506331/simple-dropdown-menu-in-java*/

    public AdminGUI() {

        Container cPane;

        //setting default values for GUI
        setTitle     ("My Book Shop ADMIN SECTION");
        setSize      (600,550);
        setResizable (true);
        setLocation  (500,100);

        //this is what the GUI does when you press the 'x' button
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());

        createFileMenu();
        createEditMenu();

        //menu bar for customer section
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //creating new JButton here - says 'LOGIN'
        loginButton = new JButton("LOGIN");
        cPane.add(loginButton);
        //the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getActionCommand().equals("LOGIN"))
                {
                    String adminEmail = "emmag321@gmail.com";
                    int password = 150514;

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
        });

        backButton = new JButton("BACK");
        cPane.add(backButton);

        //the back button - bring u to MainGUI
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

       /* editMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String menuName;
                menuName = e.getActionCommand();

                if(menuName.equals("Quit"))
                {
                    System.exit(0);
                }
            }
        });*/
    }
    //method
    private void createFileMenu() {
        JMenuItem    item;

        fileMenu = new JMenu("Options");

        item = new JMenuItem("Quit");
        item.addActionListener( this );
        fileMenu.add( item );
    }

    //method
    private void createEditMenu() {
        JMenuItem    item;

        editMenu = new JMenu("Books");

        item = new JMenuItem("Browse");
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Add Books");
        item.addActionListener( this );
        editMenu.add( item );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileMenu;
        fileMenu = e.getActionCommand();

        if(fileMenu.equals("Quit"))
        {
            System.exit(0);
        }
    }
}



