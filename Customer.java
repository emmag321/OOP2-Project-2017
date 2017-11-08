package OOP2_Project_MyShop;

public class Customer {

    //attributes
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNum;

    //mutators
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

    //accessors
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
