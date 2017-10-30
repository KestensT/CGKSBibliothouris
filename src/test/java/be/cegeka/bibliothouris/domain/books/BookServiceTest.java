package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(bookService, "counter", new AtomicLong(4l));
    }

    @Test
    public void addBook_shouldCallBookRepository() throws Exception {
        bookService.addBook("A", "Romeo", "Mattia", "123");

        verify(bookRepository).addBook(new Book("A", "Romeo", "Mattia", "123"));
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("A", "Romeo", "Mattia", "123");
        Book book2 = new Book("B", "Karpisek", "Len", "456");
        Book book3 = new Book("C", "Vancampenhoudt", "Ralph", "789");
        Book book4 = new Book("D", "Jacobs", "Erwin", "1011");

        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2, book3, book4));

        Assertions.assertThat(bookService.getAllBooks()).containsOnly(book1, book2, book3, book4);
    }
}
