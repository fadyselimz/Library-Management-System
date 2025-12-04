import java.util.*;

public class user {
    protected String username;
    protected String password;
    protected int id = 100;

    public user() {
    }

    public user(String username, String password) {
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

    public void CreateAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.id++;
    }

    public void login() {
        user user1 = new user(this.username, this.password);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String uname = sc.nextLine();
        System.out.println("Enter password:");
        String pass = sc.nextLine();
        if (uname.equals(user1.getUsername()) && pass.equals(user1.getPassword())) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

    public void logout() {
        System.out.println("User logged out successfully");
    }

    public void updateAccount(String newUsername, String newPassword) {
        user user1 = new user(this.username, this.password);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String uname = sc.nextLine();
        System.out.println("Enter password:");
        String pass = sc.nextLine();
        if (uname.equals(user1.getUsername()) && pass.equals(user1.getPassword())) {
            this.username = newUsername;
            this.password = newPassword;
            System.out.println("Your Account updated successfully");
        } else {
            System.out.println("Account update failed");
        }
    }

    public void deleteAccount() {
        user user1 = new user(this.username, this.password);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String uname = sc.nextLine();
        System.out.println("Enter password:");
        String pass = sc.nextLine();
        if (uname.equals(user1.getUsername()) && pass.equals(user1.getPassword())) {
            this.username = null;
            this.password = null;
            this.id--;
            System.out.println("Your Account deleted successfully");
        } else {
            System.out.println("Account deletion failed");
        }
    }
}