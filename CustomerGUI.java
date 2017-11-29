package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerGUI extends JFrame {

    JMenu optionsMenu;
    JMenu adminMenu;

    ArrayList<Book> books = AdminGUI.books;

    public CustomerGUI()
    {
        Container cPane;

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

        // add all the names into it
        for(Book bb: books)
            comboBooks.addItem( bb.getTitle() );

        cPane.add(comboBooks);
    }
}