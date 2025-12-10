import java.util.*;
import java.io.*;

public class Libirary_Management {
    private static final  File file = new File("Library.csv");

    public Libirary_Management() {
    }

    

    public static  void addBook(Book book) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
        writer.println( book.getbookId()+","+book.getBookName() + "," + book.getPublishingHouse() + "," + book.getAuther() + "," + book.getDateOfPublication() + "," + book.getGenre() + "," + book.getBookDiscription() );
        writer.close();
        System.out.println("Book added to the library successfully.");
    }

    public static Book searchBook(String title) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        Book book = new Book();
        while(scan.hasNextLine()){
            if (scan.nextLine().contains(title)){
            
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
