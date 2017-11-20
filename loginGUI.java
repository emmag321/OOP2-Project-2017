package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class loginGUI extends JFrame {

    JButton loginAdminButton, backButton;

    //need this it brings threw customer!!!!!
    Customer cust1 = new Customer();
    ArrayList<Customer> customers;

    //customer
    String email, firstName, lastName, address, accNum;
    int password;
    float phoneNum;

    public loginGUI(){

        Container cPane;

        //setting default values for GUI
        setTitle     ("Login For Admin");
        setSize      (600,550);
        setResizable (true);
        setLocation  (500,100);

        //this is what the GUI does when you press the 'x' button
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());

        //creating new JButton here - says 'LOGIN'
        loginAdminButton = new JButton("LOGIN");
        cPane.add(loginAdminButton);

        backButton = new JButton("BACk");
        cPane.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //the login button
        loginAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getActionCommand().equals("LOGIN"))
                {
                    String adminEmail = "emmag321@gmail.com";
                    int password = 150514;
                    String message;

                    cust1.setEmail(JOptionPane.showInputDialog(null,"Enter Email"));
                    cust1.setPassword(Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Pin")));

                    if(cust1.getEmail().equals(adminEmail) && cust1.getPassword() == password)
                    {
                        JOptionPane.showMessageDialog(null,"Welcome to the System","Welcome!",
                                JOptionPane.INFORMATION_MESSAGE);


                        {
                            AdminGUI admin = new AdminGUI();
                            admin.setVisible(true);
                        }
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null,"Error! Your email or pin was incorrect","Warning!",
                                JOptionPane.ERROR_MESSAGE);
                    }




                }
            }
        });
    }
}


