import java.util.*;

public class Admin extends User {
    public Admin() {
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public User searchbyID(int id) {
      for (int i = 0; i <= User.getCounter(); i++) {
        if (id == super.getId()) {
            System.out.println("User found: " + super.getUsername());
            return User;
        }
      }
        System.out.println("User not found");
        return null;
    }

    public void updatebyID(int id) {
        User user = new User();
        user= searchbyID(id);
        if (user != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter new username:");
            String newUname = sc.nextLine();
            System.out.println("Enter new password:");
            String newPass = sc.nextLine();
            this.setUsername(newUname);
            this.setPassword(newPass);
        } else {
            System.out.println("User not found");
        }
    }

     public void deletebyID(int id) {
        User user = new User();
        user= searchbyID(id);
        if (user != null) {
                user.setUsername(null);
                user.setPassword(null);
                user.setNumOfUsers(User.getNumOfUsers()-1);
                user.setId(-1);
            System.out.println("User deleted successfully");
        } else {
            System.out.println("User not found");
        }
    }

    
}
