import java.io.*;
import java.util.*;

public class Admin extends User {
private static final String USER_FILE = "Users.csv";
private static final String BOOK_FILE = "Library.csv"; 

public Admin() { }

public Admin(String username, String password) {
        super(username, password);
}


public User searchbyID(int id) {
        try {
            File f = new File(USER_FILE);
            if (!f.exists()) {
                System.out.println("User file does not exist.");
                return null;
            }

            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");
                if (F.length >= 3 && Integer.parseInt(F[2]) == id) {
                    System.out.println("User found: " + F[0] + ", Password: " + F[1]);
                    sc.close();
                    return new User(F[0], F[1]); 
                }
            }
            sc.close();
            System.out.println("User not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
}


public void updatebyID(int id) {
        try {
            File f = new File(USER_FILE);
            if (!f.exists()) {
                System.out.println("User file does not exist.");
                return;
            }

            Scanner sc = new Scanner(f);
            List<String> lines = new ArrayList<>();
            boolean found = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");

                if (F.length >= 3 && Integer.parseInt(F[2]) == id) {
                    found = true;
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter new username:");
                    String newUname = input.nextLine();
                    System.out.println("Enter new password:");
                    String newPass = input.nextLine();
                    line = newUname + "," + newPass + "," + F[2]; 
                    System.out.println("User updated successfully.");
                }

                lines.add(line);
            }
            sc.close();

            if (!found) {
                System.out.println("User not found.");
                return;
            }

    
            PrintWriter pw = new PrintWriter(new FileWriter(f));
            for (String l : lines) pw.println(l);
            pw.close();

        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
}


public void deletebyID(int id) {
        try {
            File f = new File(USER_FILE);
            if (!f.exists()) {
                System.out.println("User file does not exist.");
                return;
            }

            Scanner sc = new Scanner(f);
            List<String> lines = new ArrayList<>();
            boolean found = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");

                if (F.length >= 3 && Integer.parseInt(F[2]) == id) {
                    found = true; // skip this line → delete
                    continue;
                }
                lines.add(line);
            }
            sc.close();

            if (!found) {
                System.out.println("User not found.");
                return;
            }

            // Overwrite the file without the deleted user
            PrintWriter pw = new PrintWriter(new FileWriter(f));
            for (String l : lines) pw.println(l);
            pw.close();

            System.out.println("User deleted successfully.");

        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

public void addBook(Book book) {
        try {
            File f = new File(BOOK_FILE);
            if (!f.exists()) f.createNewFile();

            PrintWriter pw = new PrintWriter(new FileWriter(f, true));
            pw.println(book.getBookName() + "," + book.getAuther() + "," + book.getPublishingHouse() + "," +
                       book.getDateOfPublication() + "," + book.getGenre() + "," + book.getBookDiscription() + "," +
                       book.getbookId() + "," + book.getStatus());
            pw.close();

            System.out.println("Book added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }
 
 
 public void removeBookByID(int bookId) {
        try {
            File f = new File(BOOK_FILE);
            if (!f.exists()) {
                System.out.println("Book file does not exist.");
                return;
            }

            Scanner sc = new Scanner(f);
            List<String> lines = new ArrayList<>();
            boolean found = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");

                if (F.length >= 7 && Integer.parseInt(F[0]) == bookId) {
                    found = true; 
                    continue;
                }
                lines.add(line);
            }
            sc.close();

            if (!found) {
                System.out.println("Book not found.");
                return;
            }

            PrintWriter pw = new PrintWriter(new FileWriter(f));
            for (String l : lines) pw.println(l);
            pw.close();

            System.out.println("Book removed successfully.");

        } catch (Exception e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }   

public void updateBookByID(int bookId, Book updatedBook) {
        try {
            File f = new File(BOOK_FILE);
            if (!f.exists()) {
                System.out.println("Book file does not exist.");
                return;
            }

            Scanner sc = new Scanner(f);
            List<String> lines = new ArrayList<>();
            boolean found = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");

                if (F.length >= 7 && Integer.parseInt(F[0]) == bookId) {
                    found = true;
                    line = updatedBook.getBookName() + "," + updatedBook.getAuther() + "," +
                           updatedBook.getPublishingHouse() + "," + updatedBook.getDateOfPublication() + "," +
                           updatedBook.getGenre() + "," + updatedBook.getBookDiscription() + "," +
                           updatedBook.getbookId() + "," + updatedBook.getStatus();
                }
                lines.add(line);
            }
            sc.close();

            if (!found) {
                System.out.println("Book not found.");
                return;
            }

            PrintWriter pw = new PrintWriter(new FileWriter(f));
            for (String l : lines) pw.println(l);
            pw.close();

            System.out.println("Book updated successfully.");

        } catch (Exception e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }    
}