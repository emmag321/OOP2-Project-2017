//Emma_Griffin_OOP2_Project
package OOP2_Project_MyShop;

public class Customer {

    //attributes
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNum;

    //no args constructor
    public Customer()
    {
        this("unknown", "unknown", "unknown", 0);
    }

    //contructor with args
    public Customer(String firstName, String lastName, String address, int phoneNum)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    //mutators -- they set
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhoneNum(int phoneNum)
    {
        this.phoneNum = phoneNum;
    }

    //accessors -- they get
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public int getPhoneNum()
    {
        return phoneNum;
    }
}
