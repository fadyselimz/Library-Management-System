public class Patron extends User {

    public Patron(String name, String password) {
        super(name, password);
    }
    
    public BookStatus requestReservation(Book book) {
        if (book.getStatus() == BookStatus.AVAILABLE) {
            book.setStatus(BookStatus.RESERVED);
            return BookStatus.RESERVED;
        }else{
        return book.getStatus();
        }
    }
}
