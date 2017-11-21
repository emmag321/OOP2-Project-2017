//Emma_Griffin_OOP2_Project
package OOP2_Project_MyShop;

import javax.swing.*;
import java.awt.*;

public class Book extends JFrame {


    public static void main(String[] args) {
        Book book = new Book();
        book.setVisible(true);
    }

    //attributes
    private String title;
    private String author;
    private int numPages;
    private double price;
    private String isbn;

    //setters
    public void setTitle( String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setNumPages(int numPages) { this.numPages = numPages; }

    public void setPrice(double price) { this.price = price; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

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
    public String toString() {
        return
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Number of Pages: " +numPages + "\n" +
                "Price: " +price + "\n" +
                "ISBN: " +isbn + "\n" ;
    }




}

