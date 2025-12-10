import java.util.*;
import java.io.*;

public class Libirary_Management {
    private static final  File file = new File("Library.csv");

    public Libirary_Management() {
    }

    public static  void addBook(Book book) throws IOException {
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] fields = line.split(",");
            if(fields.length > 1 && fields[1].equalsIgnoreCase( book.getBookName())){
                System.out.println("Book already exists in the library.");
                scan.close();
                return;
            }
        }
        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
        writer.println( book.getbookId()+","+book.getBookName() + "," + book.getPublishingHouse() + "," + book.getAuther() + "," + book.getDateOfPublication() + "," + book.getGenre() + "," + book.getBookDiscription() );
        writer.close();
        System.out.println("Book added to the library successfully.");
    }

    public static Book searchBook(String title) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] fields = line.split(",");
            if(fields.length > 1 && fields[1].equalsIgnoreCase(title)){
                Book book = new Book();
                book.setBookId(Integer.parseInt(fields[0]));
                book.setBookName(fields[1]);
                book.setPublishingHouse(fields[2]);
                book.setAuther(fields[3]);
                book.setDateOfPublication(fields[4]);
                book.setGenre(fields[5]);
                book.setBookDiscription(fields[6]);
                scan.close();
                return book;
            }
        }
        scan.close();
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
