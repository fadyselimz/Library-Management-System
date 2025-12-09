import java.util.*;

public class Libirary {
    private static List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public static Book searchBook(String title){
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public static Book[] searchGenre(genre:Genre){}
    public static Book[] searchAuthor(String author){}
    public static Book[] searchPublishHouse(publishHouse : String){}
    public static String viewBook(title : String ){}
    public static String viewBook(Id : int){}
    public static Boolean checkBook(title : String){} 
    public static Boolean checkBook(Id : int ){}

}
