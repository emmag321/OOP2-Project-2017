package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyCustomerGUI extends JFrame implements ActionListener {

    private JMenu fileMenu;
    private JMenu editMenu;
    // private JLabel response;
    //private JTextField textfield;

    MyCustomerGUI(){
        //Jpane section declared here
        Container cPane;

        //setting defaults for the GUI
        setTitle     ("Customer");
        setSize      (600,550);
        setResizable (true);
        setLocation  (500,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        //layout type
        cPane.setLayout(new FlowLayout());

        createFileMenu();
        createEditMenu();

        //menu bar for customer section
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //Jbutton here - to back
        JButton backButton = new JButton("Back");
        cPane.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    //creates section of menu bar that says options
    private void createFileMenu() {
        JMenuItem    item;

        fileMenu = new JMenu("Options");

        //quit button
        item = new JMenuItem("Quit");
        item.addActionListener( this );
        fileMenu.add( item );
    }

    //creates section of menu bar that says options
    private void createEditMenu() {
        JMenuItem    item;

        editMenu = new JMenu("Books");

        item = new JMenuItem("Browse");
        item.addActionListener( this );
        editMenu.add( item );

        item = new JMenuItem("Add Books");
        item.addActionListener( this );
        editMenu.add( item );
    }

    public void actionPerformed(ActionEvent e) {
        String fileMenu;
        fileMenu = e.getActionCommand();

        if(fileMenu.equals("Quit"))
        {
            System.exit(0);
        }
    }
}
