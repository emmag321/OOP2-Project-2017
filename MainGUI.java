package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    //main method
    public static void main(String[] args) {
        MainGUI gui = new MainGUI();
        gui.setVisible(true);
    }

    public MainGUI(){
        setTitle     ("Main GUI");
        setSize      (600,550);
        setResizable (true);
        setLocation  (500,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton adminButton = new JButton("Admin");
        JButton customerButton = new JButton("Customer");

        Container cpane = getContentPane();

        cpane.setLayout(new FlowLayout());

        cpane.add(adminButton);
        cpane.add(customerButton);

        //makes button do something here
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyBookShopGUI bookShop = new MyBookShopGUI();
                bookShop.setVisible(true);
            }
        });

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCustomerGUI customerShop = new MyCustomerGUI();
                customerShop.setVisible(true);
            }
        });

    }
}