package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;



public class MyBookShop extends JFrame implements ActionListener {

    MyBookShop account1 ;
    JMenu fileMenu;
    JMenuBar menuBar, customersMenu, optionsMenu;


    //array
    Book book1 = new Book();
    ArrayList<Book> book;


    //book
    String title, author,isbn;
    int numPages;
    double price;


    public static void main(String[] args) {
        MyBookShop book1 = new MyBookShop();
        book1.setVisible(true);
    }

    public MyBookShop() {
        super("Book");

        setSize(500, 500);
        setLocation(200, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //addWindowListener(new WindowEventHandler());

        Container cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(Color.pink);

        //menu
        createFileMenu();
        createCustomersMenu();
        createOptionsMenu();

        //creating menu bar here
        JMenuBar JMenuBar = new JMenuBar();
        setJMenuBar(menuBar);
        //menuBar.setBackground(Color.blue);
       // menuBar.add(fileMenu);
       // menuBar.add(customersMenu);
       // menuBar.add(optionsMenu);
    }

    //menu bar
    private void createFileMenu() {
        JMenuItem item;

        fileMenu = new JMenu("File");

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
