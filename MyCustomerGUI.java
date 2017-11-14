package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MyCustomerGUI extends JFrame {

    private JMenu fileMenu;
    private JMenu editMenu;

    public MyCustomerGUI(){
        Container cPane;
        setTitle     ("Customer");
        setSize      (600,550);
        setResizable (true);
        setLocation  (500,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());


    }

    public static void main(String[] args) {

    }


    public void actionPerformed(ActionEvent e) {

        {
            JOptionPane.showMessageDialog(null,"Hello Customer");
        }
    }
}
