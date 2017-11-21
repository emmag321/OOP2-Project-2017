package OOP2_Project_MyShop;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class AdminGUI extends JFrame implements ActionListener{

    public static void main(String[] args) {
        AdminGUI gui = new AdminGUI();
        gui.setVisible(true);
    }

    JMenu optionsMenu;
    JMenu adminMenu;
    JButton backButton, loginButton, addCustButton, cancelButton, registerButton;
    JTextArea display, customerList;

    /*//array
    Book book1 = new Book();
    ArrayList<Book> books;*/

    //need this it brings threw customer!!!!!
    Customer cust1 = new Customer();
    ArrayList<Customer> customers;

    //customer
     String email, firstName, lastName, address, accNum;
     int password;
     float phoneNum;


    /*//book
    String title, author,isbn;
    int numPages;
    double price;*/


    /*https://stackoverflow.com/questions/22506331/simple-dropdown-menu-in-java*/

    public AdminGUI() {

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        list.setForeground(Color.RED);
        list.setBackground(Color.WHITE);
        list.setSelectionForeground(Color.GREEN);
        list.setSelectionBackground(Color.LIGHT_GRAY);
        list.setFixedCellWidth(150);
        list.setFixedCellHeight(50);
        list.setFont(new Font("Serif",Font.BOLD,16));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(list);
        add(panel,BorderLayout.WEST);

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

        createOptionsMenu();
        createAdminMenu();
        //createCustomerMenu();

        //menu bar for customer section
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        menuBar.add(optionsMenu);
        menuBar.add(adminMenu);

        //display added customers
        display = new JTextArea();
        cPane.add(display);

        //register
        registerButton = new JButton("Register New Employee");
        registerButton.addActionListener(this);
        cPane.add(registerButton);

        addCustButton = new JButton("Add Customer");
        addCustButton.addActionListener(this);
        cPane.add(addCustButton);

        backButton = new JButton("BACK");
        cPane.add(backButton);

        //the back button - bring u to MainGUI
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    //method
    private void createOptionsMenu() {
        JMenuItem    item;

        optionsMenu = new JMenu("Options");

        item = new JMenuItem("Quit");
        item.addActionListener( this );
        optionsMenu.add( item );
    }

    //method
    private void createAdminMenu() {
        JMenuItem    item;

       adminMenu = new JMenu("Admin");

        //add employee button
        item = new JMenuItem("Register New Employee");
        item.addActionListener( this );
        adminMenu.add( item );

        //remove employee button
        item = new JMenuItem("Remove Employee");
        item.addActionListener( this );
        adminMenu.add( item );

        //list employee button
        item = new JMenuItem("List Employees");
        item.addActionListener( this );
        adminMenu.add( item );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() .equals ("Quit")){
            showMessage("Shutting down the system");
            System.exit(0);
        }

        if(e.getSource() == registerButton)
        {
            addCust();

            registerButton.setVisible(false);
            loginButton.setVisible(false);
        }

        //customerMenu
        else if(adminMenu.equals("Add New Employee"))
        {
            //calcList.setVisible(false);
            display.setVisible(true);
            customerList.setVisible(false);
            addCustButton.setVisible(true);
            cancelButton.setVisible(true);

            addCust();
        }

        else if(adminMenu.equals("Remove Employee"))
        {
           // calcList.setVisible(false);
            customerList.setVisible(true);

            int cust = Integer.parseInt(JOptionPane.showInputDialog(null, "Which customer would "
                    + "you like to remove?"));

            customers.remove(cust);
        }

        else if(adminMenu.equals("List Customers"))
        {
            //calcList.setVisible(false);
            addCustButton.setVisible(false);
            cancelButton.setVisible(false);
            //welcomeMsg.setVisible(false);
            display.setVisible(false);

            for(int x=0; x<customers.size(); x++)
            {
                customerList.append(customers.get(x).toString());
            }

            customerList.setVisible(true);
        }

    }

    private void showMessage(String s) {
        JOptionPane.showMessageDialog(null,s);
    }

    public void addCust()
    {
        int numCusts = Integer.parseInt(JOptionPane.showInputDialog(null,"How many customers would you like to add?"));

        for(int i=0; i<numCusts; i++)
        {
            //first name
            cust1.setFirstName(JOptionPane.showInputDialog(null,"Enter Name:"));
            firstName = cust1.getFirstName();

            //last name
            cust1.setLastName(JOptionPane.showInputDialog(null,"Enter Last Name:"));
            lastName = cust1.getLastName();

            //address
            cust1.setAddress(JOptionPane.showInputDialog(null,"Enter Address"));
            address = cust1.getAddress();

            //account number
            cust1.setAccNum(JOptionPane.showInputDialog(null,"Enter Age"));
            accNum = cust1.getAccNum();

            //password
            cust1.setPassword(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Gender")));
            password = cust1.getPassword();

            //phone number
            cust1.setPhoneNum(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Account Number")));
            phoneNum = cust1.getPhoneNum();

            //email
            cust1.setEmail(JOptionPane.showInputDialog(null,"Enter Email"));
            email = cust1.getEmail();

            /*****************************************************
             *    Title: Way to get number of digits in an int
             *    Author: John Saunders
             *    Site owner/sponsor: stackoverflow.com
             *    Date: 20/08/2009
             *    Code version: edited Aug 21 '09 at 08:01
             *    Availability: http://stackoverflow.com/questions/1306727/way-to-get-number-of-digits-in-an-int (Accessed on 03/12/2016)
             *    Modified:  Names of variables and used specific length to compare and validate
             *****************************************************/

            if(String.valueOf(phoneNum).length()!=4)//referenced code
            {
                JOptionPane.showMessageDialog(null,"Error! Pin must be 4 digits only", "Error", JOptionPane.WARNING_MESSAGE);
                cust1.setPassword(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Pin")));
                password = cust1.getPassword();
            }

        }
        for(int i=0; i<numCusts; i++)
        {
            display.append("Customer Info: " + cust1.toString());

            customers = new ArrayList<Customer>();
            customers.add(cust1);
        }

        display.setVisible(true);
        Container cPane = getContentPane();
        cPane.add(addCustButton);
        cPane.add(cancelButton);
    }

    JList list = new JList(
            new String[]{"Add Book","Delete Book","Display Details"}
    );
}




