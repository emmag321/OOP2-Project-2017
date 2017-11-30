package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerGUI {

    private static JFrame mainframe=new JFrame("Customer");
    ArrayList<Book> books = AdminGUI.books;
    ArrayList<Person> employees = AdminGUI.employees;
    private static Book actualBook=null;

    public CustomerGUI(){
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.setBounds(200,200,500,500);
        JPanel flowy=new JPanel(new FlowLayout());
        GridLayout grid=null;
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

        for (int i=0;i<books.size();i++){
            actualBook=null;
            actualBook=books.get(i);
            JButton btn=new JButton(actualBook.getTitle());
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actualBook.setNumMinusOne();
                    JOptionPane.showMessageDialog(null,"Thank you for purchasing the book:"+actualBook.getTitle());
                }
            });
            contentPanel.add(btn);
        }
        contentPanel.setVisible(true);
        flowy.add(contentPanel);



        JTextField text=new JTextField("By Clicking on the buttons you'll purchase the item");
        text.setVisible(true);
        flowy.add(text);
        mainframe.add(flowy);
        mainframe.setVisible(true);
    }
}
