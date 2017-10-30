package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;

    private final AtomicLong counter = new AtomicLong();

    public void addBook(String bookTitle, String authorLastName, String authorFirstName, String iSBN) {
        bookRepository.addBook(new Book(bookTitle, authorLastName, authorFirstName, iSBN));
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public List<Book> getOneBookBasedOnISBN(String isbn) {
        return bookRepository.getOnebOokBasedOnISBN(isbn);
    }
}
