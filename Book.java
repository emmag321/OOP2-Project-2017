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

    /*public static void main(String[] args) {
        Book book = new Book();
        book.setVisible(true);
    }*/

    public Book(String t, String a, String i, int n, double p){
        title = t;
        author = a;
        isbn = i;
        numPages = n;
        price = p;
    }

    public Book(String t){
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
    }

    //setters
    public void setTitle( String t)
    {
        title = t;
    }

    public void setAuthor(String a)
    {
        author = a;
    }

    public void setNumPages(int n) { numPages = n; }

    public void setPrice(double p) { price = p; }

    public void setIsbn(String i) { isbn = i; }

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
    //To String method here

    @Override
    /*public String toString() {
        return
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Number of Pages: " +numPages + "\n" +
                "Price: " +price + "\n" +
                "ISBN: " +isbn + "\n" ;
    }*/

    public String toString() {
        return
                "Title: " + title + "\n" ;
    }




}

