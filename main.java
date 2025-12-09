import java.util.Date;

public class main {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "Scribner", "F. Scott Fitzgerald", new Date(), "Fiction", "A novel set in the Jazz Age", 1);
        Book book2 = new Book("1984", "Secker & Warburg", "George Orwell", new Date(), "Dystopian", "A novel about totalitarianism", 2);
        try {
            Libirary_Management.addBook(book2);
            Libirary_Management.addBook(book1);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
