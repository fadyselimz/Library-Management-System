import java.util.*;

public class Book {
    private String bookName;
    private String publishingHouse;
    private String autherName;
    private Date dateOfPublication=new Date() ;
    private Genre  genre;
    private String bookDiscription;
    private int bookId;
    private static int counter=1;
    private BookStatus status;

    public Book() {
    }

    

    public Book(String bookName, String publishingHouse, String autherName, Date dateOfPublication, Genre genre, String bookDiscription) {
        this.bookName = bookName;
        this.publishingHouse = publishingHouse;
        this.autherName = autherName;
        this.dateOfPublication = dateOfPublication;
        this.genre = genre;
        this.bookDiscription = bookDiscription;
        this.bookId = counter;
        counter++;
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
    public void setGenre(Genre genre){
        this.genre=genre;
    }
    public Genre getGenre(){
        return genre;
    }
    public void setBookDiscription(String bookDiscription){
        this.bookDiscription=bookDiscription;
    }
    public String getBookDiscription(){
        return bookDiscription;
    }
    public void setBookId(int bookId){
        this.bookId=bookId;
    }
    public int getbookId(){
        return bookId;
    }
    public BookStatus getStatus() {
        return status;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
