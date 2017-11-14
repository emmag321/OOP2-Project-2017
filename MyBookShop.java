package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;



public class MyBookShop extends JFrame implements ActionListener {

    private JMenu fileMenu;
    private JMenu editMenu;
    private JLabel response;
    private JTextField textfield;


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

    /*https://stackoverflow.com/questions/22506331/simple-dropdown-menu-in-java*/

    public MyBookShop() {
        Container cPane;

        setSize(500, 500);
        setLocation(200, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());


        createFileMenu();
        createEditMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        //menuBar.add(fileMenu);
        //menuBar.add(editMenu);


}

    private void createFileMenu() {
    }

    private void createEditMenu() {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
