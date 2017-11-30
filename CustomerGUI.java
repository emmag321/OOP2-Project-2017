package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerGUI extends JFrame implements ActionListener {

    JMenu optionsMenu;


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
        cPane.setBackground(new Color(240,210,240));

        JComboBox comboBooks = new JComboBox();

        createOptionsMenu();

        //menu bar for customer section
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        menuBar.add(optionsMenu);
        //menuBar.add(adminMenu);

        // add all the names into it
        for(Book bb: books)
            comboBooks.addItem( bb.getTitle() );

        cPane.add(comboBooks);
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



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}