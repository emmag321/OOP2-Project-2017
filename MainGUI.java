package OOP2_Project_MyShop;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    JLabel logoLabel;

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

        Container cpane = getContentPane();
        cpane.setLayout(new FlowLayout());

        //image
        logoLabel = new JLabel(new ImageIcon("book.png"));//https://www.google.es/search?biw=1366&bih=656&tbm=isch&sa=1&ei=qsgWWouPMsTAgAbz5Z2IBg&q=book+shop+logo&oq=book+shop+logo&gs_l=psy-ab.3..0l2.24526.24763.0.25467.3.3.0.0.0.0.111.323.0j3.3.0....0...1c.1.64.psy-ab..0.2.217....0.lgX832TuvBY#imgrc=BrF0Ryz5D9pQ1M:
        cpane.add(logoLabel);

        //creates buttons
        JButton adminButton = new JButton("Admin");
        JButton quitButton = new JButton("Quit");

        cpane.add(adminButton);
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

       /* //makes cutomer GUI come up when button is clicked
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookGUI customerShop = new AddBookGUI();
                customerShop.setVisible(true);
            }
        });*/

       //closes system when quit is clicked.. shows warning message before hand
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmMessage = JOptionPane.showConfirmDialog(null,"Are you sure you want to Quit?",
                        "Closing", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);

                if(confirmMessage == 0)
                {
                    System.exit(0);
                }
            }
        });

    }
}
