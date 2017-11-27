/*****************************************************
 *    Title: BicycleFrame4.java
 *    Author: John Walsh
 *    Site owner/sponsor: https://mydocs.ittralee.ie
 *    Date: 2017
 *    Code version: edited Jan 10 '13 at 17:42
 *    Availability: https://mydocs.ittralee.ie/xythoswfs/webview/fileManager.action?x=y&XY_performTicketSessionBypass=true&cookieConsentSet=on&shareLogin=false&stk=00938CC0736D2E9 (Accessed 22/11/2017)
 *    Modified:  chnaged value to do with bike to book for my project
 *****************************************************/


package OOP2_Project_MyShop;

//import books.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*; // ADDED
/** manages a collection of bikes, holding the info in a LinkedList */

//use of annotation to supress compiler warning

@SuppressWarnings({"unchecked", "deprecation"})

public class AddBookGUI extends JFrame implements ActionListener{

    JMenu fileMenu, bookMenu;
    ArrayList <Book> books; // set of bikes : CHANGED
    // int count; NOT NEEDED

    JButton backButton;

    // driver
    public static void main( String[] args ) {
        AddBookGUI frame = new AddBookGUI();
        frame.setVisible(true);
    }

    // constructor
    public AddBookGUI( ) {
        newSystem();
        Container cPane;
        //set the frame default properties
        setTitle     ( "Book Shop System" );
        setSize(600, 550);
        setResizable(true);
        setLocation(500, 100);
        Container pane = getContentPane();
        //  pane.setBackground(Color.blue);
        pane.setBackground(new Color(240,210,240));
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        cPane = getContentPane();
        cPane.setLayout(new FlowLayout());

        createOptionsMenu();
        createBookMenu();
        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(bookMenu);

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

    // CHANGED
    public void newSystem() {
        books = new ArrayList<Book>();
    }

    /** writes the array of books to the file "books.dat"
     */   // UNCHANGED
    public void save() throws IOException {
        ObjectOutputStream os;
        os = new ObjectOutputStream(new FileOutputStream ("books.dat"));
        os.writeObject(books);
        os.close();
    }

    /** loads an array of books from the file "books.dat"
     */  // CHANGED
    public void open() {
        try{
            ObjectInputStream is;
            is = new ObjectInputStream(new FileInputStream ("books.dat"));
            books  = (ArrayList<Book>) is.readObject(); // CHANGED
            is.close();
        }

        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"FileNotFound: didn't work");
            e.printStackTrace();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"IOException: didn't work");
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"open didn't work");
            e.printStackTrace();
            // counting valid bikes not needed

        }
    } // end open()

    // MINOR CHANGES
    public void addBook(){
      Book temp = new Book();
      //title
      temp.setTitle(JOptionPane.showInputDialog("What is the title of this Book??"));
      //author
      temp.setAuthor(JOptionPane.showInputDialog("What is the author of this Book??"));
      //number of pages
      temp.setNumPages(Integer.parseInt(JOptionPane.showInputDialog("How many pages in this book??")));
      //price
      temp.setPrice(Integer.parseInt(JOptionPane.showInputDialog("What is the price??")));
      //ISBN
      temp.setIsbn(JOptionPane.showInputDialog("What is the ISBN of this Book??"));
      books.add(temp); // CHANGED
    }

    // MINOR CHANGES: NOTE USE OF GET
    public void display(){
        JTextArea area = new JTextArea();
        int numBooks = books.size();
        if (numBooks>0) {
            area.setText("Book List: needs better output formatting\n\n");
            for (int i = 0; i<numBooks; i++)
                area.append("Book no: " + i + " " + books.get(i).toString()+"\n");
            showMessage(area);
        }
        else            showMessage("No books in the system");
    } // end display


    // Version of display which uses an iterator
    public void display2(){
        int numBooks = books.size();
        if (numBooks <1)
            showMessage("No book in the system");
        else {
            JTextArea area = new JTextArea();
            Iterator <Book> iterator = books.iterator( );
            while ( iterator.hasNext( ) )
                // uses polymorphic 'toString()' to avoid the type cast
                // typecast still needed if using the 'get' methods
                area.append(iterator.next( ) + "\n");
            showMessage(area);
        }
    } // end display2

    //Events
    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand() .equals ("Quit")){
            showMessage("Shutting down the system");
            System.exit(0);
        }
        else if (e.getActionCommand() .equals ("Add Book")){
            addBook(); // branch to a separate method
        }
        else if (e.getActionCommand() .equals ("Display")){
            display();
        }
        else if (e.getActionCommand() .equals ("New File")){
            newSystem();
        }
        else if (e.getActionCommand() .equals ("Save")){
            try{
                save();
                showMessage("Data saved successfully");
            } // try
            catch (IOException f){
                showMessage("Not able to save the file:\n"+
                        "Check the console printout for clues to why ");
                f.printStackTrace();
            }// catch
        }// else if

        else if (e.getActionCommand() .equals ("Open")){
            open();
            display();
        }
        else
            showMessage("I have no idea what you clicked");
    } // actionPerformed

    private void createOptionsMenu(){
        // create the menu
        fileMenu = new JMenu("File");
        // declare a menu item (re-usable)
        JMenuItem item;
        // create the 'quit' option
        fileMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        fileMenu.add(item);
    }

    private void createBookMenu(){
        // create the menu
        bookMenu = new JMenu("Books");
        // declare a menu item (re-usable)
        JMenuItem item;

        item = new JMenuItem("Add Book");
        item.addActionListener(this);
        bookMenu.add(item);

        item = new JMenuItem("Display");
        item.addActionListener(this);
        bookMenu.add(item);
    }
    /** utility methods to make the code simpler */
    public void showMessage (String s){
        JOptionPane.showMessageDialog(null,s);
    }

    public void showMessage (JTextArea s){
        JOptionPane.showMessageDialog(null,s);
    }
}