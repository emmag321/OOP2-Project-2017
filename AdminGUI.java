package OOP2_Project_MyShop;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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



        //new stuff starts here
        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"Id","Title","Author","Pages","Price","ISBN"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        //http://1bestcsharp.blogspot.ie/2015/05/java-jtable-add-delete-update-row.html
        // create JFrame and JTable
        JTable table = new JTable();

        // create JTextFields
        //JTextField textId = new JTextField();
        JTextField textTitle = new JTextField();
        JTextField textAuthor = new JTextField();
        JTextField textPages = new JTextField();
        JTextField textPrice = new JTextField();
        JTextField textIsbn = new JTextField();

        // set the model to the table
        table.setModel(model);

        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");

        textAuthor.setBounds(20, 220, 100, 25);
        textTitle.setBounds(20, 250, 100, 25);
        textAuthor.setBounds(20, 280, 100, 25);
        textPages.setBounds(20, 310, 100, 25);

        btnAdd.setBounds(150, 220, 100, 25);
        btnUpdate.setBounds(150, 265, 100, 25);
        btnDelete.setBounds(150, 310, 100, 25);

        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);

        cPane.setLayout(null);

        cPane.add(pane);

        // add JTextFields to the jframe
        //cPane.add(textId);
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
            Object[] row = new Object[4];
            @Override
            public void actionPerformed(ActionEvent e) {

                row[0] = textTitle.getText();
                row[1] = textAuthor.getText();
                row[2] = textPages.getText();
                row[3] = textPrice.getText();
                row[4] = textIsbn.getText();

                // add row to the model
                model.addRow(row);
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

                //textId.setText(model.getValueAt(i, 0).toString());
                textTitle.setText(model.getValueAt(i, 1).toString());
                textAuthor.setText(model.getValueAt(i, 2).toString());
                textPages.setText(model.getValueAt(i, 3).toString());
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
                   // model.setValueAt(textId.getText(), i, 0);
                    model.setValueAt(textTitle.getText(), i, 1);
                    model.setValueAt(textAuthor.getText(), i, 2);
                    model.setValueAt(textPages.getText(), i, 3);
                }
                else{
                    System.out.println("Update Error");
                }
            }
        });
        // new stuff ends here
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
    public void addEmployee(){
        String firstName = JOptionPane.showInputDialog("Enter first name: ");
        String lastName = JOptionPane.showInputDialog("Enter surname: ");
        String address = JOptionPane.showInputDialog("Enter address: ");
        String phoneNum = JOptionPane.showInputDialog("Enter phone number: ");
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

        //lists employee button
        item = new JMenuItem("Add Book");
        item.addActionListener(this);
        adminMenu.add(item);

        //lists employee button
        item = new JMenuItem("Display Book");
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
        else if (e.getActionCommand().equals (" Add Book")){
            addBook();//adds new book to system
        }
        else if (e.getActionCommand().equals ("Display Book")){
            displayBook();//displays new books
        }
        else if (e.getActionCommand().equals ("Back")){
            backButton();//back button
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




