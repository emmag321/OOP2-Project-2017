//Emma_Griffin_OOP2_Project --  this is just a test to display customer details here
package OOP2_Project_MyShop;

import javax.swing.*;

public class TestMyBookShop {
    public static void main(String[] args)
    {
        //creating employee object
        Employee employee1 = new Employee();

        employee1.setFirstName("Emma");
        employee1.setLastName("Griffin");
        employee1.setAddress("Causeway");
        employee1.setPassword(150514);
        employee1.setPhoneNum("99798809");
        employee1.setUserName("12334F");
        employee1.setEmail("emma@gmail.com");

        //creating book object
        Book book1 = new Book();

        book1.setTitle("harry potter");
        book1.setAuthor("jk rolling");
        book1.setNumPages(299);
        book1.setPrice(7.99);
        book1.setIsbn("12345IE");

        //displays the emplyee object here - if i change it to book1.toString() - it will then display the book object
        JOptionPane.showMessageDialog(null, employee1.toString(), "Shop Test", JOptionPane.PLAIN_MESSAGE);
    }

}