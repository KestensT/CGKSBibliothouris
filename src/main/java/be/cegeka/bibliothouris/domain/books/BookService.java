package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class BookService {

    private final AtomicLong counter = new AtomicLong();
    @Inject
    private BookRepository bookRepository;

    public void addBook(String bookTitle, String authorLastName, String authorFirstName, String iSBN) {
        bookRepository.addBook(new Book(bookTitle, authorLastName, authorFirstName, iSBN));
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public List<Book> getOneBookBasedOnISBN(String isbn) {
        return bookRepository.getOnebOokBasedOnISBN(isbn);
    }

    public List<Book> getAllBooksByPartlyIsbn(String isbnPart) {
        return bookRepository.getAllBooksByPartlyIsbn(isbnPart);
    }
    public List<Book> getAllBooksByPartlyTitle(String titlePart) {
        return bookRepository.getAllBooksByPartlyTitle(titlePart);
    }
    public List<Book> getAllBooksByPartlyAuthor(String authorPart) {
        return bookRepository.getAllBooksByPartlyAuthor(authorPart);
    }
}
