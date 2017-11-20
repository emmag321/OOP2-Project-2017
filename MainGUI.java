package OOP2_Project_MyShop;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

//this main GUI calls AdminGUI and MyCustomerGUI

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

        //creates buttons
        JButton adminButton = new JButton("Admin");
        JButton customerButton = new JButton("Customer");
        JButton quitButton = new JButton("Quit");

        Container cpane = getContentPane();

        cpane.setLayout(new FlowLayout());

        cpane.add(adminButton);
        cpane.add(customerButton);
        cpane.add(quitButton);

        //makes button do something here
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginGUI login = new loginGUI();
                login.setVisible(true);
                //MainGUI.setVisable(false);

            }
        });

        //makes cutomer GUI come up when button is clicked
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCustomerGUI customerShop = new MyCustomerGUI();
                customerShop.setVisible(true);
            }
        });

        //quit button - when clicked system closes
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    String quitButton;
                    quitButton = e.getActionCommand();

                    if (quitButton.equals("Quit")) {
                        System.exit(0);
                    }
                }
                /*
                //buttons
                 if(e.getSource() == registerButton)
                {
                    addCust();

                    registerButton.setVisible(false);
                    loginButton.setVisible(false);
                    buttonLabel.setVisible(false);
                }*/

            }
        });
    }
}
