//Emma_Griffin_OOP2_Project --  this is just a test to display customer details here
package OOP2_Project_MyShop;

import javax.swing.*;

public class TestMyBookShop {
    public static void main(String[] args)
    {
        Customer cust1 = new Customer();

        cust1.setFirstName("Emma");
        cust1.setLastName("Griffin");
        cust1.setAddress("Causeway");
        cust1.setPhoneNum(07544334);
        cust1.setAccNum("12334F");
        cust1.setEmail("emmag321@gmail.com");

        JOptionPane.showMessageDialog(null, cust1.toString(), "Shop Test", JOptionPane.PLAIN_MESSAGE);
    }

}
