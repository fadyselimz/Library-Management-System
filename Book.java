package pl_project;

import java.util.*;
import javax.security.sasl.Sasl;

public class Book {
    private String bookName;
    private String publishingHouse;
    private String autherName;
    private Date dateOfPublication=new Date() ;
    private String genre;
    private String bookDiscription;
    private int bookId;

    public Book() {
        this("bookName", "publishingHouse", "autherName",new Date(), "genra", "bookDiscription", 0);
    }

    

    public Book(String bookName, String publishingHouse, String autherName, Date dateOfPublication, String genra, String bookDiscription, int bookId) {
        this.bookName = bookName;
        this.publishingHouse = publishingHouse;
        this.autherName = autherName;
        this.dateOfPublication = dateOfPublication;
        this.genra = genra;
        this.bookDiscription = bookDiscription;
        this.bookId = bookId;
    }

    public void setBookName(String bookName){
        this.bookName=bookName;

    }
    public String getBookName(){
        return bookName;
    }
    public void setPublishingHouse(String publishingHouse){
        this.publishingHouse=publishingHouse;
    }

    public String getPublishingHouse(){
        return publishingHouse;
    }
    public void setAuther(String autherName){
        this.autherName=autherName;
    }
    public String getAuther(){
       return autherName; 
    }
    public void setDateOfPublishing(Date dateOfPublication){
        this.dateOfPublication=dateOfPublication;
    }
    public Date getDateOfPublication(){
        return dateOfPublication;
    }
    public void setGenre(String genre){
        this.genre=genre;
    }
    public String getGenre(){
        return genre;
    }
    public void setBookDiscription(String bookDiscription){
        this.bookDiscription=bookDiscription;
    }
    public String getbookDiscription(){
        return bookDiscription;
    }
    public void setBookId(int bookId){
        this.bookId=bookId;
    }
    public int getbookId(){
        return bookId;
    }
}
