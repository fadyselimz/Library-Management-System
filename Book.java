import java.util.*;

public class Book {
    private String bookName;
    private String publishingHouse;
    private String autherName;
    private String dateOfPublication ;
    private String genre;
    private String bookDiscription;
    private int bookId;
    private static int counter = getInitialCounter();
    private BookStatus status;

    public Book() {
    }

    

    public Book(String bookName, String publishingHouse, String autherName, Date dateOfPublication, Genre genre, String bookDiscription) {
        this.bookName = bookName;
        this.publishingHouse = publishingHouse;
        this.autherName = autherName;
        this.dateOfPublication = dateOfPublication.toString();
        this.genre = genre.toString();
        this.bookDiscription = bookDiscription;
        this.bookId = counter+1;
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
    public void setDateOfPublication(String dateOfPublication){
        this.dateOfPublication=dateOfPublication;
    }
    public String getDateOfPublication(){
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
    
    private static int getInitialCounter() {
        int lines = 0;
        try {
            Scanner scan = new Scanner(new java.io.File("Library.csv"));
            while (scan.hasNextLine()) {
                scan.nextLine();
                lines++;
            }
            scan.close();
        } catch (Exception e) {

        }
        return lines ;
    }
}
