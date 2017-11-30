package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CustomerGUI {

    private static JFrame mainframe=new JFrame("Customer");
    ArrayList<Book> books = AdminGUI.books;
    ArrayList<JButton> buttons;
    ArrayList<Person> employees = AdminGUI.employees;
    private static Book actualBook=null;

    //declaring JLabel here
    JLabel text;

    //this is where my process is taking place - the purchasing of a book
    public CustomerGUI(){
        //the frame will close when 'x' is pressed
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //default settings of the frame
        mainframe.setBounds(200,200,500,500);
        //creating new JPanel here
        JPanel flowLayout=new JPanel(new FlowLayout());
        GridLayout grid=null;

        //this is my process here
        if(books.size()==0||books.size()==1){
            grid=new GridLayout(1,1);
        }else if (books.size()==2){
            grid=new GridLayout(2,1);
        }else{
            for(int i=2;i<books.size();i++){
                grid=new GridLayout(i,1);
            }
        }
        JPanel contentPanel=new JPanel(grid);

        buttons = new ArrayList<JButton>();

        for (int i=0;i<books.size();i++){

            actualBook=books.get(i);
            JButton btn=new JButton(actualBook.getTitle());
            buttons.add(btn);
            //System.out.println(buttons.get(i));

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for(int i=0;i<buttons.size();i++)
                    {
                        if(buttons.get(i).getText().equals(btn.getText()))
                                actualBook = books.get(i);
                    }


                    actualBook.setNumMinusOne();
                    System.out.println(actualBook);
                    JOptionPane.showMessageDialog(null,"Thank you for purchasing the book:"+actualBook.getTitle());



                    if (books.size() > 0) {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("books.dat");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(books);
                            out.close();
                            fileOut.close();
                            System.out.printf("Serialized data to books.dat file");
                        } catch (IOException i) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Failed to save books",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE
                            );
                            i.printStackTrace();
                        }
                    }
                }
            });
            contentPanel.add(btn);
        }
        contentPanel.setVisible(true);
        flowLayout.add(contentPanel);


        JLabel text = new JLabel("By Clicking on the buttons you'll purchase the item");
        text.setVisible(true);
        flowLayout.add(text);
        mainframe.add(flowLayout);
        mainframe.setVisible(true);
    }
}
