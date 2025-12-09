import java.util.*;
import java.io.*;

public class Libirary_Management {
    private static final  File file = new File("Library.csv");

    public static void addBook(Book book) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
        writer.println(book.getBookName() + "," + book.getPublishingHouse() + "," + book.getAuther() + "," + book.getDateOfPublication() + "," + book.getGenre() + "," + book.getBookDiscription() + "," + book.getbookId());
        writer.close();
    }

    public static Book searchBook(String title){
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // public static String searchBook(int id){
    //     for (Book book : books) {
    //         if (book.getbookId() == id) {
    //             return book.getBookName();
    //         }
    //     }
    //     return null;
    // }
    // public static Book[] searchGenre(Genre genre){}
    // public static Book[] searchAuthor(String author){}
    // public static Book[] searchPublishHouse(String publishHouse){}
    // public static String viewBook(String title ){
    // return "";
    // }
    // public static Boolean checkBook(String title){} 
    // public static Boolean checkBook(int id ){}

    

}
