package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyCustomerGUI extends JFrame implements ActionListener {

    public static void main(String[] args) {
        MyCustomerGUI gui = new MyCustomerGUI();
        gui.setVisible(true);
    }


    private JMenu optionsMenu;
    private JMenu bookMenu;
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

        createOptionsMenu();
        createBookMenu();

        //menu bar for customer section
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        menuBar.add(optionsMenu);
        menuBar.add(bookMenu);

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
    private void createOptionsMenu() {
        JMenuItem    item;

        optionsMenu = new JMenu("Options");

        //quit button
        item = new JMenuItem("Quit");
        item.addActionListener( this );
        optionsMenu.add( item );
    }

    //creates section of menu bar that says options
    private void createBookMenu() {
        JMenuItem    item;

        bookMenu = new JMenu("Books");

        item = new JMenuItem("Browse");
        item.addActionListener( this );
        bookMenu.add( item );
    }

    //events
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() .equals ("Quit")){
            showMessage("Shutting down the system");
            System.exit(0);
        }

    }

    private void showMessage(String s) {
        JOptionPane.showMessageDialog(null,s);
    }
}
