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

    }

    public Customer(String firstName, String lastName, String address, int phoneNum, String email, String accNum)
    {
        super(firstName, lastName, address, phoneNum);

        this.email = email;
        this.accNum = accNum;
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
    public String toString()
    {
        return super.toString() + "\nEmail: " + email + "\nAccount Number: " + accNum;
    }

    //CONSTRUCTOR
    public void setCustomer(String name, String griffin, String causeway, int i) {

    }
}
