public class Librarian extends User{

    public Librarian() {
        super();
        this.setAccountType(AccountType.LIBRARIAN);
    }
    public Librarian(String username, String password) {
        super(username, password);
        this.setAccountType(AccountType.LIBRARIAN);
    }

    public BookStatus checkBook(Book book){
            return book.getStatus();
        }


    public BookStatus reserveBook(Book book,int patronId){
        if(book.getStatus() == BookStatus.AVAILABLE){
            book.setStatus(BookStatus.CHECKED_OUT);
             book.setPatronId(patronId);
            return BookStatus.CHECKED_OUT;
        }
        else if(book.getStatus() == BookStatus.CHECKED_OUT){
            book.setStatus(BookStatus.RESERVED);
            return BookStatus.RESERVED;
        }
            else{
            return book.getStatus();
        }
    }

      public void returnBook(Book book,int patronId){
        if(book.getStatus() == BookStatus.RESERVED){
            book.setPatronId(patronId);
            book.setStatus(BookStatus.CHECKED_OUT);
        }else if(book.getStatus() == BookStatus.CHECKED_OUT){
            book.setPatronId(-1);
            book.setStatus(BookStatus.AVAILABLE);
        }else{
            System.out.println("Book is already available in library");
        }

    }
}