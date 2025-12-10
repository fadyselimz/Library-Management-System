public class Librarian extends User{

    public Librarian(String userName,String password) {
        super(userName,password);
    }

    public BookStatus checkBook(Book book){
            return book.getStatus();
        }

        

}