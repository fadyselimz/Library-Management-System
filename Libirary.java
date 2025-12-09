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

    public static String searchBook(int id){}
    public static Book[] searchGenre(Genre genre){}
    public static Book[] searchAuthor(String author){}
    public static Book[] searchPublishHouse(String publishHouse){}
    public static String viewBook(String title ){}
    public static Boolean checkBook(String title){} 
    public static Boolean checkBook(int id ){}

    

}
