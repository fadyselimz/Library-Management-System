import java.io.*;
import java.util.*;

public class Admin extends User {
private static final File USER_FILE = new File("Users.csv");
private static final File BOOK_FILE = new File("Library.csv"); 

public Admin() { 
        super();
        this.setAccountType(AccountType.ADMIN);
}

public Admin(String username, String password) {
        super(username, password);
        this.setAccountType(AccountType.ADMIN);
}


public User searchbyID(int id) {
        try {    
            if (!USER_FILE.exists()) {
                System.out.println("User file does not exist.");
                return null;
            }

            Scanner sc = new Scanner(USER_FILE);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");
                if (F.length >= 3 && Integer.parseInt(F[2]) == id) {
                    String type = F.length >= 4 ? F[3] : "PATRON";
                    System.out.println("User found: " + F[0] + ", Password: " + F[1] + " ID: " + F[2] + ", AccountType: " + type);
                    User u;
                    if("ADMIN".equals(type)){
                        u = new Admin(F[0], F[1]);
                    } else if("LIBRARIAN".equals(type)){
                        u = new Librarian(F[0], F[1]);
                    } else {
                        u = new Patron(F[0], F[1]);
                    }
                    u.setId(Integer.parseInt(F[2]));
                    sc.close();
                    return u;
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
            File file = USER_FILE;
            if (!file.exists()) {
                System.out.println("User file does not exist.");
                return;
            }

            Scanner sc = new Scanner(file);
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
                    String type = F.length >= 4 ? F[3] : "PATRON";
                    line = newUname + "," + newPass + "," + F[2] + "," + type; 
                    System.out.println("User updated successfully.");
                }

                lines.add(line);
            }
            sc.close();

            if (!found) {
                System.out.println("User not found.");
                return;
            }

    
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (String l : lines) pw.println(l);
            pw.close();

        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
}


public void deletebyID(int id) {
        try {
            File file = USER_FILE;
            if (!file.exists()) {
                System.out.println("User file does not exist.");
                return;
            }

            Scanner sc = new Scanner(file);
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
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (String l : lines) pw.println(l);
            pw.close();

            System.out.println("User deleted successfully.");

        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

public void addBook(Book book) {
        try {
            File file = BOOK_FILE;
            if (!file.exists()) file.createNewFile();

            int nextId = getNextBookId();
            book.setBookId(nextId);
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.println(nextId + "," + book.getBookName() + "," + book.getPublishingHouse() + "," +
                       book.getAuther() + "," + book.getDateOfPublication() + "," + book.getGenre() + "," +
                       book.getBookDiscription());
            pw.close();

            System.out.println("Book added successfully.");

        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }
 
 
 public void removeBookByID(int bookId) {
        try {
            File file = BOOK_FILE;
            if (!file.exists()) {
                System.out.println("Book file does not exist.");
                return;
            }

            Scanner sc = new Scanner(file);
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

            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (String l : lines) pw.println(l);
            pw.close();

            System.out.println("Book removed successfully.");

        } catch (Exception e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }   

public void updateBookByID(int bookId, Book updatedBook) {
        try {
            File file = BOOK_FILE;
            if (!file.exists()) {
                System.out.println("Book file does not exist.");
                return;
            }

            Scanner sc = new Scanner(file);
            List<String> lines = new ArrayList<>();
            boolean found = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");

                if (F.length >= 7 && Integer.parseInt(F[0]) == bookId) {
                    found = true;
                    line = bookId + "," + updatedBook.getBookName() + "," +
                           updatedBook.getPublishingHouse() + "," + updatedBook.getAuther() + "," +
                           updatedBook.getDateOfPublication() + "," + updatedBook.getGenre() + "," +
                           updatedBook.getBookDiscription();
                }
                lines.add(line);
            }
            sc.close();

            if (!found) {
                System.out.println("Book not found.");
                return;
            }

            PrintWriter pw = new PrintWriter(new FileWriter(file));
            for (String l : lines) pw.println(l);
            pw.close();

            System.out.println("Book updated successfully.");

        } catch (Exception e) {
            System.out.println("Error updating book: " + e.getMessage());
        }
    }    

private int getNextBookId() {
        int maxId = 0;
        try {
            if (!BOOK_FILE.exists()) return 1;
            Scanner sc = new Scanner(BOOK_FILE);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] fields = line.split(",");
                if (fields.length >= 1) {
                    try {
                        int idVal = Integer.parseInt(fields[0].trim());
                        if (idVal > maxId) maxId = idVal;
                    } catch (NumberFormatException ignored) { }
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return maxId + 1;
}

public BookStatus trackBook(Book book) {
        return book.getStatus();
}

}
