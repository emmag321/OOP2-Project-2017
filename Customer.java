package OOP2_Project_MyShop;

import java.io.Serializable;
import javax.swing.*;
import java.io.*;

public class Customer extends Person implements Serializable {

    //attributes
    private String email;
    private String accNum;
    private int password;

    //Constructors
    public Customer()
    {
        super();//this to bring att from person threw-- super class

        email = "unknown";
        accNum = "unknown";
        password = 1234;

    }

    public Customer(String firstName, String lastName, String address, int phoneNum, String email, String accNum)
    {
        super(firstName, lastName, address, phoneNum);

        this.email = email;
        this.accNum = accNum;
        this.password = getPassword();
    }

    //setters
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setAccNum(String accNum)
    {
        this.accNum = accNum;
    }

    public void setPassword(int password) { this.password = password; }

    //getters
    public String getEmail()
    {
        return email;
    }

    public String getAccNum()
    {
        return accNum;
    }

    public int getPassword() { return password; }

    //toString method
    @Override
    public String toString() {
         return super.toString() +
                 "Email: " + email + "\n" +
                 "Account Number: " +  accNum + "\n" +
                 "Password: " + password + "\n";
    }


}
