public class main {
    public static void main(String[] args) {
        try {
            Admin admin = new Admin("admin", "adminpass");
            admin.removeBookByID(2);

            // Book book=new Book();
            // book=Libirary_Management.searchBook("1984");
            // System.out.println("Book Found: " + book.getBookName() + " by " + book.getAuther());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
