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


public User searchById(int id) {
    if (!USER_FILE.exists()) {
        System.out.println("User file does not exist.");
        return null;
    }
    try (Scanner sc = new Scanner(USER_FILE)) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] fields = line.split(",");
            if (fields.length >= 3) {
                int userId = Integer.parseInt(fields[2]);
                if (userId == id) {
                    String accountType = fields.length >= 4 ? fields[3] : "PATRON";
                    System.out.println("User found: " + fields[0] + ", Password: " + fields[1] + " ID: " + fields[2] + ", AccountType: " + accountType);
                    User u;
                    if("ADMIN".equals(accountType)){
                        u = new Admin(fields[0], fields[1]);
                    } else if("LIBRARIAN".equals(accountType)){
                        u = new Librarian(fields[0], fields[1]);
                    } else {
                        u = new Patron(fields[0], fields[1]);
                    }
                    u.setId(userId);
                    return u;
                }
            }
        }
        System.out.println("User not found.");
    } catch (IOException e) {
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
                String[] fields = line.split(",");

                if (fields.length >= 3 && Integer.parseInt(fields[2]) == id) {
                    found = true;
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter new username:");
                    String newUname = input.nextLine();
                    System.out.println("Enter new password:");
                    String newPass = input.nextLine();
                    String type = fields.length >= 4 ? fields[3] : "PATRON";
                    line = newUname + "," + newPass + "," + fields[2] + "," + type; 
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
                String[] fields = line.split(",");

                if (fields.length >= 3 && Integer.parseInt(fields[2]) == id) {
                    found = true; 
                    continue;
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

            System.out.println("User deleted successfully.");

        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

public void addBook(Book book) {
    if (!this.getLoginStatus()) {
        System.out.println("You must log in first");
        return;
    }
    Library_Management.addBook(book);
}
 
 
 public void removeBookByID(int bookId) {
        if(this.getLoginStatus()){
            Library_Management.removeBookByID(bookId);
            return;
        }else{
            System.out.println("You must log in first");
        }
       
    }   

public void updateBookByID(int bookId, Book updatedBook) {
        if(this.getLoginStatus()){
            Library_Management.updateBookByID(bookId, updatedBook);
            return;
        }else{
            System.out.println("You must log in first");
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
