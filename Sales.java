//Emma_Griffin_OOP2_Project
package OOP2_Project_MyShop;

import java.util.Date; //imported this for the date attribute

public class Sales {

    private int saleId;
    private double amount;
    private Date date; //cant get date working
    private String totalSales;//not sure what type this should be

    //no args constructor
    public Sales()
    {
        this(0, 0.0,  "unknown");
    }

    //constructor with args
    public Sales(int saleId, double amount, String totalSales)
    {
        this.saleId = saleId;
        this.amount = amount;
        this.date = date;
        this.totalSales = totalSales;
    }

    //mutators
    public void setSaleId(int saleId)
    {
        this.saleId = saleId;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setTotalSales(String totalSales)
    {
        this.totalSales = totalSales;
    }

}
