import java.util.*;
import java.io.*;

public class main {
    public static void main(String[] args) {
        Book book1 = new Book("The", "Scribner", "F. Scott Fitzgerald", new Date(), Genre.ROMANTIC, "A novel set in the Jazz Age");
        Book book2 = new Book("1984", "Secker & Warburg", "George Orwell", new Date(), Genre.HISTORY, "A novel about totalitarianism");
        try {
            Libirary_Management.addBook(book1);
            // Book book=new Book();
            // book=Libirary_Management.searchBook("1984");
            // System.out.println("Book Found: " + book.getBookName() + " by " + book.getAuther());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
