package be.cegeka.bibliothouris.application;


import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.users.User;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Inject
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestParam(value = "title", required = true) String title, @RequestParam(value = "authorLastName", required = true) String authorLastName,
                        @RequestParam(value = "authorFirstName", required = true) String authorFirstName, @RequestParam(value = "ISBN", required = true) String ISBN) {
        bookService.addBook(title, authorLastName, authorFirstName, ISBN);
    }

}