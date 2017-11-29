/*****************************************************
 *    Title: Bicycle.java
 *    Author: John Walsh
 *    Site owner/sponsor: https://mydocs.ittralee.ie
 *    Date: 2017
 *    Code version: edited Nov 13 2017 10.04AM
 *    Availability: https://mydocs.ittralee.ie/xythoswfs/webview/fileManager.action?x=y&XY_performTicketSessionBypass=true&cookieConsentSet=on&shareLogin=false&stk=00938CC0736D2E9 (Accessed 22/11/2017)
 *    Modified: changed value to do with bike to book for my project
 *****************************************************/

/*****************************************************
 *    Title:  JTableRow.java
 *    Author: unknown- doesn't say
 *    Site owner/sponsor: 1bestcsharp.blogspot.ie
 *    Date: unknown- doesn't say
 *    Code version: unknown- doesn't say
 *    Availability: http://1bestcsharp.blogspot.ie/2015/05/java-jtable-add-delete-update-row.html(Accessed 27/11/2017)
 *    Modified: changed to suit my project and to be displayed with in this GUI
 *****************************************************/

package OOP2_Project_MyShop;


import sun.applet.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class AdminGUI extends JFrame implements ActionListener {


    JTextField textTitle;
    JTextField textAuthor;
    JTextField textPages;
    JTextField textPrice;
    JTextField textIsbn;
    JMenu optionsMenu;
    JMenu adminMenu;
    JButton backButton, loginButton, addCustButton, cancelButton, registerButton, bookButton;
    JTextArea display, customerList;


    public static ArrayList<Person> employees = MainGUI.employees;
    public static ArrayList<Book> books = MainGUI.books;

    /*
    public static void main(String[] args) {
        AdminGUI gui = new AdminGUI();
        gui.setVisible(true);
    }
    */


    //customer
    String email, firstName, lastName, address, accNum;
    int password;
    float phoneNum;

    public AdminGUI() {
        //newSystem();

        DefaultListModel listCust = new DefaultListModel();
        JList list = new JList(listCust);

        Container cPane;

        //setting default values for GUI
        setTitle("My Book Shop ADMIN SECTION");
        setSize(900, 550);
        setResizable(true);
        setLocation(200, 100);

        //this is what the GUI does when you press the 'x' button
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(new Color(240,210,240));

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

        //referenced code starts here
        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"Title","Author","Pages","Price","ISBN"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        //http://1bestcsharp.blogspot.ie/2015/05/java-jtable-add-delete-update-row.html
        // create JFrame and JTable
        JTable table = new JTable();

        // create JTextFields
        //JTextField textId = new JTextField();
        textTitle = new JTextField();
        textAuthor = new JTextField();
        textPages = new JTextField();
        textPrice = new JTextField();
        textIsbn = new JTextField();

        //creating JLabels here
        JLabel titleLabel = new JLabel("Title :");
        JLabel authorLabel = new JLabel("Author :");
        JLabel pagesLabel = new JLabel("Pages :");
        JLabel priceLabel = new JLabel("Price :");
        JLabel isbnLabel = new JLabel("ISBN :");

        // set the model to the table
        table.setModel(model);

        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");

        textTitle.setBounds(70, 220, 100, 25);
        textAuthor.setBounds(70, 250, 100, 25);
        textPages.setBounds(70, 280, 100, 25);
        textPrice.setBounds(70, 310, 100, 25);
        textIsbn.setBounds(70, 340, 100, 25);

        titleLabel.setBounds(20, 220, 100, 25);
        authorLabel.setBounds(20, 250, 100, 25);
        pagesLabel.setBounds(20, 280, 100, 25);
        priceLabel.setBounds(20, 310, 100, 25);
        isbnLabel.setBounds(20, 340, 100, 25);

        cPane.add(titleLabel);
        cPane.add(authorLabel);
        cPane.add(pagesLabel);
        cPane.add(priceLabel);
        cPane.add(isbnLabel);


        btnAdd.setBounds(180, 220, 100, 25);
        btnUpdate.setBounds(180, 265, 100, 25);
        btnDelete.setBounds(180, 310, 100, 25);

        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);

        cPane.setLayout(null);

        cPane.add(pane);

        // add JTextFields to the jframe
        cPane.add(textTitle);
        cPane.add(textAuthor);
        cPane.add(textPages);
        cPane.add(textPrice);
        cPane.add(textIsbn);

        // add JButtons to the jframe
        cPane.add(btnAdd);
        cPane.add(btnDelete);
        cPane.add(btnUpdate);

        cPane.setSize(900,400);
        // frame.setLocationRelativeTo(null);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setVisible(true);

        // button add row
        btnAdd.addActionListener(new ActionListener(){

            // create an array of objects to set the row data
            Object[] row = new Object[5];
            @Override
            public void actionPerformed(ActionEvent e) {

                row[0] = textTitle.getText();
                row[1] = textAuthor.getText();
                row[2] = textPages.getText();
                row[3] = textPrice.getText();
                row[4] = textIsbn.getText();

                // add row to the model
                model.addRow(row);

                addBook();


            }
        });

        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });

        // get selected row data From table to textfields
        table.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){

                // i = the index of the selected row
                int i = table.getSelectedRow();

                textTitle.setText(model.getValueAt(i, 0).toString());
                textAuthor.setText(model.getValueAt(i, 1).toString());
                textPages.setText(model.getValueAt(i, 2).toString());
                textPrice.setText(model.getValueAt(i, 3).toString());
                textIsbn.setText(model.getValueAt(i, 4).toString());
            }
        });

        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                if(i >= 0)
                {
                    model.setValueAt(textTitle.getText(), i, 0);
                    model.setValueAt(textAuthor.getText(), i, 1);
                    model.setValueAt(textPages.getText(), i, 2);
                    model.setValueAt(textPrice.getText(), i, 3);
                    model.setValueAt(textIsbn.getText(), i, 4);

                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        //referenced code ends here
    }

    private void addBook() {
        String title;
        String author;
        int numPages;
        float price;
        String isbn;

        title = textTitle.getText();
        author = textAuthor.getText();
        numPages = (Integer.parseInt(textPages.getText()));
        price = (Float.parseFloat(textPrice.getText()));
        isbn = textIsbn.getText();

        Book book = new Book(title, author, numPages, price, isbn);

        books.add(book);
    }

    /*
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
    */

    //adds employees to system
    public void addEmployee(){
        String firstName = JOptionPane.showInputDialog("Enter first name: ");
        String lastName = JOptionPane.showInputDialog("Enter surname: ");
        String address = JOptionPane.showInputDialog("Enter address: ");
        String phoneNum = JOptionPane.showInputDialog("Enter phone number: ");
        String email = JOptionPane.showInputDialog("enter email:");
        String userName = JOptionPane.showInputDialog("enter user name:");
        int password = (Integer.parseInt(JOptionPane.showInputDialog("enter password(must be digits):")));
        Employee employee = new Employee(firstName,lastName,address,phoneNum, email, userName, password);
        employees.add(employee);

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

    //makes make button go back to MainGUI
    public void backButton(){
        MainGUI main = new MainGUI();
        main.setVisible(true);
    }

    //menu bar with - back,quit,save
    private void createOptionsMenu() {
        JMenuItem item;

        optionsMenu = new JMenu("Options");

        item = new JMenuItem("Back");
        item.addActionListener(this);
        optionsMenu.add(item);

        item = new JMenuItem("Quit");
        item.addActionListener(this);
        optionsMenu.add(item);

        item = new JMenuItem("Save");
        item.addActionListener(this);
        optionsMenu.add(item);
    }

    //menubar with Add Employee,Display Employee,Add Book,Display Book
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
    }

    //events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quit")) {
            showMessage("Shutting down the system");
            System.exit(0);
        }
        else if (e.getActionCommand().equals ("Add Employee")){
            addEmployee();//adds employee here to system
        }
        else if (e.getActionCommand().equals ("Display Employee")){
            display();//displays employye
        }
        else if (e.getActionCommand().equals ("Back")){
            backButton();//back button
        }
        else if (e.getActionCommand().equals ("New File")){
            //newSystem();
        }
        else if (e.getActionCommand().equals ("Save")){
            /*
            try{
                //save();
                showMessage("Data saved successfully");
            }
            catch (IOException f){
                showMessage("Not able to save the file:\n"+
                        "Check the console printout to see why ");
                f.printStackTrace();
            }
            */
        }

        else if (e.getActionCommand() .equals ("Open")){
            //open();
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