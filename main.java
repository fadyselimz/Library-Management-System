
public class main {
    public static void main(String[] args) {
        try {
            User user1 = new User();
            user1.CreateAccount("alice", "password123");
            User user2 = new User();
            user2.CreateAccount("bob", "securepass");
             User user3 = new User();
            user2.CreateAccount("bbob", "securepass"); 
            // Book book=new Book();
            // book=Libirary_Management.searchBook("1984");
            // System.out.println("Book Found: " + book.getBookName() + " by " + book.getAuther());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
