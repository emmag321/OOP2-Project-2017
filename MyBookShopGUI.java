package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;



public class MyBookShopGUI extends JFrame implements ActionListener {

    private JMenu fileMenu;
    private JMenu editMenu;
    //private JLabel response;
   // private JTextField textfield;


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

    public MyBookShopGUI() {


        Container cPane;

        setTitle     ("My Book Shop ADMIN SECTION");
        setSize      (500,550);
        setResizable (true);
        setLocation  (500,100);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());


        createFileMenu();
        createEditMenu();



        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
}

    private void createFileMenu() {
        JMenuItem    item;

        fileMenu = new JMenu("Login");
    }

    private void createEditMenu() {
        JMenuItem    item;

        editMenu = new JMenu("Books");

        item = new JMenuItem("Browse");
        item.addActionListener( this );
        editMenu.add( item );
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Browse"))
        {
            JOptionPane.showMessageDialog(null,"Hello Test");
        }
    }
}
