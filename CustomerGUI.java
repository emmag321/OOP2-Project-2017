package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerGUI extends JFrame implements ActionListener {

    JMenu optionsMenu;
    JLabel purchase;
    JComboBox comboBooks;
    JButton purchaseButton;


    ArrayList<Book> books = AdminGUI.books;
    ArrayList<Person> employees = AdminGUI.employees;

    //was trying to make this a parent class but i failed
    //making this class the parent class
    // private JFrame parent;

    //was trying to make this a parent class but i failed
    // public static ArrayList<Person> employees = MainGUI.employees;
    // public static ArrayList<Book> books = MainGUI.books;


    public CustomerGUI(/*JFrame parent*/)
    {
        Container cPane;

        //was trying to make this a parent class but i failed
        //this.parent = parent;

        //setting default values for GUI
        setTitle("Book Shop");
        setSize(900, 550);
        setResizable(true);
        setLocation(200, 100);

        //this is what the GUI does when you press the 'x' button
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.setBackground(new Color(240,215,240));

        //creating JCombo here
         comboBooks = new JComboBox();

        createOptionsMenu();

        //menu bar for customer section
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        menuBar.add(optionsMenu);
        //menuBar.add(adminMenu);

        //creates new button JButton here
        JButton backButton = new JButton("BACK");

        //creating JLabels here
        purchase = new JLabel("Purchase :");

        //creates JButton
        purchaseButton = new JButton("Purchase");

        //set bounds for JButton
        comboBooks.setBounds(180, 120, 100, 25);
        //set bounds for JButton
        purchaseButton.setBounds(180, 160, 100, 25);
        //set bounds for JButton
        purchase.setBounds(110, 120, 100, 25);

        //add labels to GUI here to make visable
        cPane.add(purchase);
        //adds JButton to window
        cPane.add(purchaseButton);
        //adds to window here
        cPane.add(backButton);

        cPane.setBounds(0, 0, 880, 200);

        cPane.setLayout(null);

        //the back button - bring u to MainGUI
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        // add all the names into it
        for(Book bb: books)
            comboBooks.addItem( bb.getTitle() );

        cPane.add(comboBooks);
    }

    //makes make button go back to MainGUI
    /*public void backButton(){
        MainGUI main = new MainGUI();
        main.setVisible(true);
    }*/

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



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Quit")) {
            showMessage("Shutting down the system");
            System.exit(0);
        }
        else if (e.getActionCommand().equals ("Add Employee")){
            //addEmployee();//adds employee here to system
        }
        else if (e.getActionCommand().equals ("Display Employee")){
            //display();//displays employye
            //open();
        }
        else if (e.getActionCommand().equals ("Back")){
            //backButton();//back button
        }
        else
            showMessage("Did not work");
    }

    public void showMessage (String s){ JOptionPane.showMessageDialog(null,s); }

}