import java.io.*;
import java.util.*;

public class User{
    private String username;
    private String password;
    private int id ;
    private  static int counter=getInitialCounter();
    private  static int numOfUsers=0;
    private boolean loginstatus=false;
    private static final String USER_FILE = "Users.csv";

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password; 
    }

    public String getUsername() { return username; }
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public int getId() { return id;}
    public void setId(int ID) {id= ID;}

    public static  int getCounter() {return counter;}
    public static void  setCounter(int Counter) {counter = Counter;}

    public static int getNumOfUsers() {return numOfUsers;}
    public static void setNumOfUsers(int NumOfUsers) {numOfUsers= NumOfUsers;}


private static int getInitialCounter() {
        int lines = 0;
        
        try {
            File f = new File(USER_FILE);
            if (!f.exists()) return 0;
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                sc.nextLine();
                lines++;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return lines ;
}


public void CreateAccount(String username, String password) {
        this.username = username;
        this.password = password;
        counter++;
        this.id=counter;
        numOfUsers++;
        try {
            File f = new File(USER_FILE);
              if (!f.exists()) f.createNewFile();
 
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
              String[] fields = sc.nextLine().split(",");
                if(fields.length > 0 && fields[0].equals(this.getUsername())){
                    System.out.println("Username already exists");
                    sc.close();
                    return;
                }
            }
            sc.close();
            PrintWriter users = new PrintWriter(new FileWriter(f, true));
            users.println( username +"," + password+ "," + id);
            users.close();
            System.out.println("Account created successfully.");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
}


public void login() {
        if(this.loginstatus){
            System.out.println("You are already logged in");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String uname = sc.nextLine();
        System.out.println("Enter password:");
        String pass = sc.nextLine();

             try {
             File f = new File(USER_FILE);
              if (!f.exists()) f.createNewFile();

            Scanner file = new Scanner(f);
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] F = line.split(",");

                if (F.length >= 3 && F[0].equals(uname) && F[1].equals(pass)) {
                    this.username = uname;
                    this.password = pass;
                    this.id = Integer.parseInt(F[2]);
                    this.loginstatus = true;
                    System.out.println("Login successful.");
                    file.close();
                    return;
                }
            }
            file.close();
        } catch (Exception e) {
          System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Login failed.");
}

    
public void logout() {
         if(!this.loginstatus){
            System.out.println("You are not logged in");
            return;
        }
        this.loginstatus=false;
        System.out.println("logged out successfully");
}


public void updateAccount(String newUsername, String newPassword) {
          if (!this.loginstatus) {
            System.out.println("You must log in first");
            return;
        }
         try {
            File f = new File(USER_FILE);
            if (!f.exists()) f.createNewFile();

            Scanner sc = new Scanner(f);
            List<String> lines = new ArrayList<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");

                if (F.length >= 3 && F[2].equals(String.valueOf(this.id))) {
                    line = newUsername + "," + newPassword + "," + this.id;
                    this.username = newUsername;
                    this.password = newPassword;
                }
                lines.add(line);
            }
            sc.close();

            PrintWriter pw = new PrintWriter(new FileWriter(f));
            for (String l : lines) pw.println(l);
            pw.close();

            System.out.println("Account updated successfully.");

        } catch (Exception e) {
            System.out.println("Error updating account");
        }
    }


public void deleteAccount() {
        if (!this.loginstatus) {
            System.out.println("You must log in first");
            return;
        }

        try {
            File f = new File(USER_FILE);
            Scanner sc = new Scanner(f);
            List<String> lines = new ArrayList<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] F = line.split(",");

                if (F.length >= 3 && F[2].equals(String.valueOf(this.id))) {
                    continue; 
                }
                lines.add(line);
            }
            sc.close();
            
    
            PrintWriter pw = new PrintWriter(new FileWriter(f));
            for (String l : lines) pw.println(l);
            pw.close();

            this.username = null;
            this.password = null;
            this.id = -1;
            this.loginstatus = false;
            numOfUsers--;
            
            System.out.println("Account deleted successfully.");

        } catch (Exception e) {
            System.out.println("Error deleting account");
        }
    }
}


