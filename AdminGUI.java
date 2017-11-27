package OOP2_Project_MyShop;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class AdminGUI extends JFrame implements ActionListener {

    JMenu optionsMenu;
    JMenu adminMenu;
    JButton backButton, loginButton, addCustButton, cancelButton, registerButton, bookButton;
    JTextArea display, customerList;

    ArrayList<Person> employees;
    ArrayList<Book> books;

    public static void main(String[] args) {
        AdminGUI gui = new AdminGUI();
        gui.setVisible(true);
    }

    //customer
    String email, firstName, lastName, address, accNum;
    int password;
    float phoneNum;

    public AdminGUI() {
        newSystem();

        DefaultListModel listCust = new DefaultListModel();
        JList list = new JList(listCust);

        Container cPane;

        //setting default values for GUI
        setTitle("My Book Shop ADMIN SECTION");
        setSize(600, 550);
        setResizable(true);
        setLocation(500, 100);

        //this is what the GUI does when you press the 'x' button
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());

        createOptionsMenu();
        createAdminMenu();
        //createCustomerMenu();

        //menu bar for customer section
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        menuBar.add(optionsMenu);
        menuBar.add(adminMenu);

        //display added employees
        display = new JTextArea();
        cPane.add(display);

        bookButton = new JButton("Book");
        cPane.add(bookButton);

        backButton = new JButton("BACK");
        cPane.add(backButton);

        //the back button - bring u to MainGUI
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //makes cutomer GUI come up when button is clicked
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookGUI customerShop = new AddBookGUI();
                customerShop.setVisible(true);
            }
        });
    }



    public void newSystem() {
        //person & book arrays
        employees = new ArrayList<Person>();
        books = new ArrayList<Book>();
    }

    public void save() throws IOException {
        ObjectOutputStream os;
        os = new ObjectOutputStream(new FileOutputStream("employees.dat"));
        os.writeObject(employees);
        os.close();
    }

    public void open() {
        try {
            ObjectInputStream is;
            is = new ObjectInputStream(new FileInputStream("employees.dat"));
            employees = (ArrayList<Person>) is.readObject();
            is.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "open didn't work");
            e.printStackTrace();
        }

    }//here

    //adds employees to system
    public void addCust(){
        String firstName = JOptionPane.showInputDialog("Enter first name: ");
        String lastName = JOptionPane.showInputDialog("Enter surname: ");
        String address = JOptionPane.showInputDialog("Enter address: ");
        int phoneNum = (Integer.parseInt(JOptionPane.showInputDialog("Enter phone number: ")));
        Person customer = new Person(firstName,lastName,address,phoneNum);
        employees.add(customer);

        JOptionPane.showMessageDialog(null,firstName + "s account has successfully created");
    }

    //displays employees that have been put into system
    public void display(){
        JTextArea area = new JTextArea();
        int numCustomers = employees.size();
        if (numCustomers>0) {
            area.setText("Employees: \n\n");
            for (int i = 0; i<numCustomers; i++)
                area.append("User no: " + i + " " + employees.get(i).toString()+"\n");
            showMessage(area);
        }
        else
            showMessage("No Users in the system");
    }

    //adds books that have been put into system
    public void addBook(){
        String title = JOptionPane.showInputDialog("Enter the title: ");
        String author = JOptionPane.showInputDialog("Enter the author: ");
        int numPages = (Integer.parseInt(JOptionPane.showInputDialog("Enter the number of pages: ")));
        float price = (Float.parseFloat(JOptionPane.showInputDialog("Enter the price: ")));
        String isbn = JOptionPane.showInputDialog("Enter the ISBN: ");
        Book book = new Book(title,author,numPages,price,isbn);
        books.add(book);

        JOptionPane.showMessageDialog(null,title + " has been added to the system");
    }

    //displays books that have been put into system
    public void displayBook(){
        JTextArea area = new JTextArea();
        int numBooks = books.size();
        if (numBooks>0) {
            area.setText("Book List: \n\n");
            for (int i = 0; i<numBooks; i++)
                area.append("Book no: " + i + " " + books.get(i).toString()+"\n");
            showMessage(area);
        }
        else
            showMessage("No books in the system");
    } // end display

    //menu bar with - options & quit
    private void createOptionsMenu() {
        JMenuItem item;

        optionsMenu = new JMenu("Options");

        item = new JMenuItem("Quit");
        item.addActionListener(this);
        optionsMenu.add(item);

        item = new JMenuItem("Save");
        item.addActionListener(this);
        optionsMenu.add(item);
    }

    //method
    private void createAdminMenu() {
        JMenuItem item;

        adminMenu = new JMenu("Admin");

        //add employee button
        item = new JMenuItem("Add Employee");
        item.addActionListener(this);
        adminMenu.add(item);

        //lists employee button
        item = new JMenuItem("Display Employee");
        item.addActionListener(this);
        adminMenu.add(item);

        //lists employee button
        item = new JMenuItem("Book");
        item.addActionListener(this);
        adminMenu.add(item);

        //lists employee button
        item = new JMenuItem("Display Book");
        item.addActionListener(this);
        adminMenu.add(item);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quit")) {
            showMessage("Shutting down the system");
            System.exit(0);
        }
        else if (e.getActionCommand().equals ("Add Employee")){
            addCust();
        }
        else if (e.getActionCommand().equals ("Display Employee")){
            display();
        }
        else if (e.getActionCommand().equals ("Book")){
            addBook();
        }
        else if (e.getActionCommand().equals ("Display Book")){
            displayBook();
        }
        else if (e.getActionCommand().equals ("New File")){
            newSystem();
        }
        else if (e.getActionCommand().equals ("Save")){
            try{
                save();
                showMessage("Data saved successfully");
            }
            catch (IOException f){
                showMessage("Not able to save the file:\n"+
                        "Check the console printout to see why ");
                f.printStackTrace();
            }
        }

        else if (e.getActionCommand() .equals ("Open")){
            open();
            display();
        }
        else
            showMessage("Did not work");
    }

    public void showMessage (String s){ JOptionPane.showMessageDialog(null,s); }

    public void showMessage (JTextArea s){
        JOptionPane.showMessageDialog(null,s);
    }
}




