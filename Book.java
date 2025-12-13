import java.util.*;
public class Book {
    private String bookName;
    private String publishingHouse;
    private String autherName;
    private String dateOfPublication ;
    private String genre;
    private String bookDiscription;
    private int bookId;
    private int PatronId;
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
        this.bookId = getInitialCounter();
        counter = this.bookId;
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
    public int getBookId(){
        return bookId;
    }
    public BookStatus getStatus() {
        return status;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }
    public void setPatronId(int patronId) {
        PatronId = patronId;
    }
    public int getPatronId() {
        return PatronId;
    }
    private static int getInitialCounter() {
        int maxId = 0;
        try {
            java.io.File file = new java.io.File("Library.csv");
            if (!file.exists()) return 0;
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] fields = line.split(",");
                if (fields.length >= 1) {
                    try {
                        int idVal = Integer.parseInt(fields[0].trim());
                        if (idVal > maxId) maxId = idVal;
                    } catch (NumberFormatException ignored) { }
                }
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return maxId+1 ;
    }


}