public class Librarian extends User{

    public Librarian() {
        super();
        this.setAccountType(AccountType.LIBRARIAN);
    }
    public Librarian(String userName,String password) {
        super(userName,password);
        this.setAccountType(AccountType.LIBRARIAN);
    }

    public BookStatus checkBook(Book book){
            return book.getStatus();
        }


    public BookStatus reserveBook(Book book,int patronId){
        if(book.getStatus() == BookStatus.AVAILABLE){
            book.setStatus(BookStatus.RESERVED);
             book.setPatronId(patronId);
            return BookStatus.RESERVED;
        }
        else if(book.getStatus() == BookStatus.RESERVED){
            book.setStatus(BookStatus.CHECKED_OUT);
            return BookStatus.CHECKED_OUT;
        }
            else{
            return book.getStatus();
        }
    }

      public void returnBook(Book book) {
        if(book.getStatus() == BookStatus.RESERVED){
            book.setPatronId(-1);
        }
            book.setStatus(BookStatus.AVAILABLE);

    }
}