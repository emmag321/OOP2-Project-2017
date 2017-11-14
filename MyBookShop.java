package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;



public class MyBookShop extends JFrame implements ActionListener {

    MyBookShop shop;
    JLabel logoLabel;
    JButton registerButton, loginButton, saveCustButton, cancelButton;
    JMenu fileMenu, customersMenu, optionsMenu;
    JLabel buttonLabel, response, welcomeMsg;
    JTextArea display, calcList, custList;


    //array
    Book book1 = new Book();
    ArrayList<Book> books;

    Customer cust1 = new Customer();
    ArrayList<Customer> customers;


    //book
    String title, author,isbn;
    int numPages;
    double price;


    public static void main(String[] args) {
       MyBookShop shop = new MyBookShop();
        shop.setVisible(true);
    }

    public MyBookShop() {
        super("Book Shop");

        setSize(500, 500);
        setLocation(200, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

       JPanel panel = new JPanel();

       super.add(panel);

       JLabel lbl = new JLabel("hello");
       lbl.setVisible(true);

       panel.add(lbl);
}

    //menu bar
    private void createFileMenu() {
        JMenuItem item;

        fileMenu = new JMenu("Main Menu");

        item = new JMenuItem("Login");
        item.addActionListener(this);

        fileMenu.add(item);

        item = new JMenuItem("Open");
        item.addActionListener(this);

        fileMenu.add(item);

        item = new JMenuItem("Save");
        item.addActionListener(this);

        fileMenu.add(item);

        item = new JMenuItem("Quit");
        item.addActionListener(this);

        fileMenu.add(item);


    }

    private void createCustomersMenu() {
    }

    private void createOptionsMenu() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
