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

    public static String searchBook(String title) throws FileNotFoundException {
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
                return book.toString();
            }
        }
        scan.close();
        return null;
    }

    public static String searchBook(int id) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] fields = line.split(",");
            if(fields.length > 0 && (Integer.parseInt( fields[0]))== id){
                Book book = new Book();
                book.setBookId(Integer.parseInt(fields[0]));
                book.setBookName(fields[1]);
                book.setPublishingHouse(fields[2]);
                book.setAuther(fields[3]);
                book.setDateOfPublication(fields[4]);
                book.setGenre(fields[5]);
                book.setBookDiscription(fields[6]);
                scan.close();
                return book.toString();
            }
        }
        scan.close();
        return null;
    }
    public static List<String> searchGenre(Genre genre){
        List<String> foundBooks = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] fields = line.split(",");
                if(fields.length > 5 && fields[5].equalsIgnoreCase(genre.toString())){
                    foundBooks.add(line);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return foundBooks;
    }
    public static List<String> searchAuthor(String author){
        List<String> foundBooks = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] fields = line.split(",");
                if(fields.length > 3 && fields[3].equalsIgnoreCase(author)){
                    foundBooks.add(line);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return foundBooks;
    }
    public static List<String> searchPublishHouse(String publishHouse){
        List<String> foundBooks = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] fields = line.split(",");
                if(fields.length > 2 && fields[2].equalsIgnoreCase(publishHouse)){
                    foundBooks.add(line);
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return foundBooks;
    }
    public static String viewBook(Book book ){
    return book.toString();
    }
    // public static Boolean checkBook(String title){} 
    // public static Boolean checkBook(int id ){}

    

}
