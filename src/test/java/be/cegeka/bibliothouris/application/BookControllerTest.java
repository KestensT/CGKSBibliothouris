package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addBook_ShouldCallBookService() throws Exception {
        bookController.addBook("A", "Romeo", "Mattia", "1256286");

        verify(bookService).addBook("A", "Romeo", "Mattia", "1256286");
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("A", "Romeo", "Mattia", "123");
        Book book2 = new Book("B", "Karpisek", "Len", "456");
        Book book3 = new Book("C", "Jacobs", "Erwin", "789");

        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2, book3));

        Assertions.assertThat(bookController.getAllBooks()).containsOnly(book1, book2, book3);
    }

    @Test
    public void addingSameBookTwice_shouldWork() throws Exception {
        Book book1 = new Book("A", "Romeo", "Mattia", "123");
        Book book2 = new Book("A", "Romeo", "Mattia", "123");

        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        Assertions.assertThat(bookController.getAllBooks()).containsOnly(book1, book2);
    }

    @Test
    public void addingMultipleBooks_shouldStillWork() throws Exception {
        Book book1 = new Book("A", "Romeo", "Mattia", "123");
        Book book2 = new Book("B", "Karpisek", "Len", "456");
        Book book3 = new Book("C", "Jacobs", "Erwin", "789");
        Book book4 = new Book("D", "Vancampenhoudt", "Ralph", "101112");
        Book book5 = new Book("E", "Gielen", "Seppe", "789456");

        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1, book2, book3, book4, book5));

        Assertions.assertThat(bookController.getAllBooks()).containsOnly(book1, book2, book3, book4, book5);
    }
}
