package OOP2_Project_MyShop;

import java.io.Serializable;

public class Employee extends Person implements Serializable {

    //attributes
    private String email;
    private String userName;
    private int password;

    //Constructors
    public Employee()
    {
        super();//this to bring att from person threw-- super class

        email = "unknown";
        userName = "unknown";
        password = 1234;

    }

    public Employee(String firstName, String lastName, String address, String phoneNum, String email, String userName, int password)
    {
        super(firstName, lastName, address, phoneNum);

        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    //setters
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassword(int password) { this.password = password; }

    //getters
    public String getEmail()
    {
        return email;
    }

    public String getUserName()
    {
        return userName;
    }

    public int getPassword() { return password; }

    //toString method
    @Override
    public String toString() {
        return super.toString() +
                "Email: " + email + "\n" +
                "Account Number: " + userName + "\n" +
                "Password: " + password + "\n";
    }


}