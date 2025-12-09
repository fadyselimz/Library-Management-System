import java.util.*;

public class Admin extends user {
    public Admin() {
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public void searchbyID(int id) {
        if (id == super.getId()) {
            System.out.println("User found: " + super.getUsername());
        } else {
            System.out.println("User not found");
        }
    }

    public void updatebyID(int id) {
        if (id == super.getId()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter new username:");
            String newUname = sc.nextLine();
            System.out.println("Enter new password:");
            String newPass = sc.nextLine();
            this.username=newUname;
            this.password=newPass;
        } else {
            System.out.println("User not found");
        }
    }

     public void deletebyID(int id) {
        if (id == super.getId()) {
            this.username = null;
            this.password = null;
            this.id--;
            System.out.println("User deleted successfully");
        } else {
            System.out.println("User not found");
        }
    }

    
}
