//Emma_Griffin_OOP2_Project
package OOP2_Project_MyShop;

public class Book {

    //attributes
    private String title;
    private String author;
    private int numPages;
    private double price;

    //setters
    public void setTitle( String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setNumPages(int numPages)
    {
        this.numPages = numPages;
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

    //To String method here

}

