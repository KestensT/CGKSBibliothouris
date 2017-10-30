package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks(){
        return books;
    }
    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getOnebOokBasedOnISBN(String isbn) {
        List<Book> singleBookList=new ArrayList<>();
        for (int i = 0; i <books.size() ; i++) {
            if (books.get(i).getISBN().equals(isbn)){
                singleBookList.add(books.get(i));
            }
        }
        return singleBookList;
    }
}
