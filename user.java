import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class User{
    private String username;
    private String password;
    private int id ;
    private  static int counter=getInitialCounter();
    private  static int numOfUsers=0;
    private boolean loginstatus=false;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password; 
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
         id= ID;
    }

    public static  int getCounter() {
        return counter;
    }
    public static void  setCounter(int Counter) {
        counter = Counter;
    }


    public static int getNumOfUsers() {
        return numOfUsers;
    }

      public static void setNumOfUsers(int NumOfUsers) {
         numOfUsers= NumOfUsers;
    }
     private static int getInitialCounter() {
        int lines = 0;
        try {
            Scanner scan = new Scanner(new java.io.File("Library.csv"));
            while (scan.hasNextLine()) {
                scan.nextLine();
                lines++;
            }
            scan.close();
        } catch (Exception e) {

        }
        return lines ;
    }

    public void CreateAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.id=counter+1;
        numOfUsers++;
        try {
            Scanner scan = new Scanner(new java.io.File("Users.csv"));
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] fields = line.split(",");
                if(fields.length > 0 && fields[0].equals(this.getUsername())){
                    System.out.println("Username already exists");
                    scan.close();
                    return;
                }
            }
            PrintWriter users = new PrintWriter(new FileWriter(new java.io.File("Users.csv"), true));
            users.println( this.getUsername()+","+this.getPassword()+","+this.getId());
            users.close();
            System.out.println("Account created successfully.");
        } catch (java.io.IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void login() {
        if(this.loginstatus){
            System.out.println("You are already logged in");
            return;
        }
        User user1 = new User(this.username, this.password);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String uname = sc.nextLine();
        System.out.println("Enter password:");
        String pass = sc.nextLine();
        if (uname.equals(user1.username) && pass.equals(user1.password)) {
            System.out.println("Login successful");
            this.loginstatus=true;
        } else {
            System.out.println("Login failed");
        }
    }

    public void logout() {
         if(!this.loginstatus){
            System.out.println("You are not logged in");
            return;
        }
        this.loginstatus=false;
        System.out.println("User logged out successfully");
    }

    public void updateAccount(String newUsername, String newPassword) {
        User user1 = new User(this.username, this.password);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String uname = sc.nextLine();
        System.out.println("Enter password:");
        String pass = sc.nextLine();
        if (uname.equals(user1.username) && pass.equals(user1.password) && this.loginstatus==true ) {
            this.username = newUsername;
            this.password = newPassword;
            System.out.println("Your Account updated successfully");
        } else {
            System.out.println("Account update failed");
        }
    }

    public void deleteAccount() {
        User user1 = new User(this.username, this.password);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String uname = sc.nextLine();
        System.out.println("Enter password:");
        String pass = sc.nextLine();
        if (uname.equals(user1.username) && pass.equals(user1.password) && this.loginstatus==true) {
            this.username = null;
            this.password = null;
            User.numOfUsers--;
            this.id=-1;
            this.loginstatus=false;
            System.out.println("Your Account deleted successfully");
        } else {
            System.out.println("Account deletion failed");
        }
    }
}