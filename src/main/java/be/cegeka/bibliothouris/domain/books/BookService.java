package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;

    public void addBook(String bookTitle, String authorLastName, String authorFirstName, String iSBN) {
        bookRepository.addBook(new Book(bookTitle, authorLastName, authorFirstName, iSBN));
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}
