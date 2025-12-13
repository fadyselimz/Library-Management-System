public class Patron extends User {
    
    public Patron() {
        super();
        this.setAccountType(AccountType.PATRON);
    }
    public Patron(String name, String password) {
        super(name, password);
        this.setAccountType(AccountType.PATRON);
    }
    
    public BookStatus requestReservation(Book book) {
       Librarian librarian = new Librarian();
       return librarian.reserveBook(book,this.getId());
    }
   public void returnBook(Book book) {
       Librarian librarian = new Librarian();
       librarian.returnBook(book);
    }

}