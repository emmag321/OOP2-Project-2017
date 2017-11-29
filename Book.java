/*****************************************************
 *    Title: Bicycle.java
 *    Author: John Walsh
 *    Site owner/sponsor: https://mydocs.ittralee.ie
 *    Date: 2017
 *    Code version: edited Nov 13 2017 10.04AM
 *    Availability: https://mydocs.ittralee.ie/xythoswfs/webview/fileManager.action?x=y&XY_performTicketSessionBypass=true&cookieConsentSet=on&shareLogin=false&stk=00938CC0736D2E9 (Accessed 22/11/2017)
 *    Modified:  chnaged value to do with bike to book for my project
 *****************************************************/


//Emma_Griffin_OOP2_Project
package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Book implements Serializable {

    //attributes
    private String title;
    private String author;
    private int numPages;
    private double price;
    private String isbn;
    private int numInStock;


    //no args constructor
    public Book()
    {
        this("unknown", "unknown",0, 0, "unknown", 0);
    }

    //contructor with args
    public Book(String title, String author, int numPages, float price, String isbn, int numInStock)
    {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.price = price;
        this.isbn = isbn;
        this.numInStock = numInStock;
    }
    //contructor with args - just one args
    public Book(String title)
    {
        this.title = title;
    }



   /* public Book(String t){
        title = t;
        author = "unknown";
    }

    public Book(String t, String a){
        title = t;
        author = a;
    }

    public Book(){
        title = "unknown";
        author = "unknown";
    }*/

    //setters
    // public void setFirstName(String firstName){this.firstName = firstName;}
    public void setTitle(String Title)
    {
        this.title = title;
    }

    public void setAuthor(String Author)
    {
        this.author = author;
    }

    public void setNumPages(int numPages)
    {
        this.numPages = numPages;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }


    //getters
    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getNumPages()
    {
        return numPages;
    }

    public double getPrice()
    {
        return price;
    }

    public String getIsbn() { return isbn; }

    public int getNumInStock() {
        return numInStock;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }

    //To String method here

    @Override
    public String toString() {
        return
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Number of Pages: " +numPages + "\n" +
                "Price: " +price + "\n" +
                "ISBN: " +isbn + "\n" ;
    }
}

