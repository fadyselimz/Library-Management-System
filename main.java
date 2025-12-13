public class main {
    public static void main(String[] args) {
        try {
   
        Admin admin1 = new Admin();
        admin1.CreateAccount("first", "adminPass");
        admin1.CreateAccount("second", "fady");
        Patron patron1 = new Patron();
        patron1.CreateAccount("third", "patronPass2");
        Librarian librarian1 = new Librarian();
        librarian1.CreateAccount("fourth", "librarianPass");
         
 patron1.CreateAccount("fifth", "patronPass2");

        librarian1.CreateAccount("sixth", "librarianPass");
        
     patron1.CreateAccount("seventh", "patronPass2");


           

            // Book book=new Book();
            // book=Libirary_Management.searchBook("1984");
            // System.out.println("Book Found: " + book.getBookName() + " by " + book.getAuther());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
