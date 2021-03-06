package be.cegeka.bibliothouris.application;


import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
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

    @RequestMapping(path = {"/librarian"})
    @PostMapping
    public void addBook(@RequestParam(value = "title", required = true) String title, @RequestParam(value = "authorLastName", required = true) String authorLastName,
                        @RequestParam(value = "authorFirstName", required = true) String authorFirstName, @RequestParam(value = "ISBN", required = true) String ISBN) {
        bookService.addBook(title, authorLastName, authorFirstName, ISBN);
    }

    @RequestMapping(path = "/getonebookbasedonisbn")
    @GetMapping
    public List<Book> getOneBookBasedOnISBN(@RequestParam(value="isbn",required = true)String isbn){
        return bookService.getOneBookBasedOnISBN(isbn);
    }

    @RequestMapping(path = "/searchbyisbn")
    @GetMapping
    public List<Book> getAllBooksByPartlyIsbn(@RequestParam(value = "isbnPart",required = true)String isbnPart){
        return bookService.getAllBooksByPartlyIsbn(isbnPart);
    }

    @RequestMapping(path = "/searchbytitle")
    @GetMapping
    public List<Book> getAllBooksByPartlyTitle(@RequestParam(value = "titlePart",required = true)String titlePart){
        return bookService.getAllBooksByPartlyTitle(titlePart);
    }

    @RequestMapping(path = "/searchbyauthor")
    @GetMapping
    public List<Book> getAllBooksByPartlyAuthor(@RequestParam(value = "authorPart",required = true)String authorPart){
        return bookService.getAllBooksByPartlyAuthor(authorPart);
    }



}
