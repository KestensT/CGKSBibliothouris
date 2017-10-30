package be.cegeka.bibliothouris.domain.books;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class BookRepositoryTest {
    BookRepository bib;
    Book testbook1;
    Book testbook2;
    Book testbook3;

    @Before
    public void setUp() throws Exception {
        bib= new BookRepository();
        testbook1=new Book("The world of Thibault ","mattia","romeo","123");
        testbook2=new Book("A wonderfull world","mattia","vancampenhoudt","abc123abc");
        testbook3=new Book("WipeOut: Erwins Angles","ralph","vancampenhoudt","abc");
        bib.addBook(testbook1);
        bib.addBook(testbook2);
        bib.addBook(testbook3);
    }

    @Test
    public void givenISBNabc123returnslistofsinglebook() throws Exception {
        assertThat(bib.getOnebOokBasedOnISBN("abc123abc")).contains(testbook2);
    }

    @Test
    public void getAllBooksByPartlyIsbn_givenPartOfAnIsbn_shouldReturnListOfPossibleMatchingBooks() throws Exception {
        String string = "abc.*abc";
        assertThat(bib.getAllBooksByPartlyIsbn(string)).containsOnly(testbook2);
    }
    @Test
    public void getAllBooksByPartlyTitle_givenPartOfATitle_shouldReturnListOfPossibleMatchingBooks() throws Exception {
        String string = "world";
        assertThat(bib.getAllBooksByPartlyTitle(string)).containsOnly(testbook1,testbook2);
    }
    @Test
    public void getAllBooksByPartlyAuthor_givenPartOfAFirstName_shouldReturnListOfPossibleMatchingBooks() throws Exception {
        String string = "mattia";
        assertThat(bib.getAllBooksByPartlyAuthor(string)).containsOnly(testbook1,testbook2);
    }
    @Test
    public void getAllBooksByPartlyAthor_givenPartOfALastName_shouldReturnListOfPossibleMatchingBooks() throws Exception {
        String string = "vancampenhoudt";
        assertThat(bib.getAllBooksByPartlyAuthor(string)).containsOnly(testbook2, testbook3);
    }

    @Test
    public void checkIfBookIsInLibrary() throws Exception {
        Book book = new Book("Wild Adventures of Thibault", "Thibault", "Jones", "6969");

        Assertions.assertThat(book.inLibrary()).isTrue();
    }

    @Test
    public void checkIfTwoAddedBooksAreInLibrary() throws Exception {
        Book book = new Book("Wild Adventures of Thibault", "Thibault", "Jones", "6969");
        BookRepository library = new BookRepository();
        library.addBook(book);
        library.addBook(book);

        assertThat(library.amountofBooksISBN("6969")).isEqualTo(2);
    }

    @Test
    public void checkIfThreeAddedBooksWithDifferentISBNAreNotCounted_OneBookShouldBeReturned() throws Exception {
        Book book = new Book("Wild Adventures of Thibault", "Thibault", "Jones", "6969");
        Book book2 = new Book("Wild Adventures of Thibault", "Thibault", "Jones", "8000");
        Book book3 = new Book("Wild Adventures of Thibault", "Thibault", "Jones", "9000");
        BookRepository library = new BookRepository();
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);

        assertThat(library.amountofBooksISBN("6969")).isEqualTo(1);
    }

    @Test
    public void lendBookToUserWillDecreaseAmountOfSameISBNBooksByOne() throws Exception {
        Book book = new Book("Wild Adventures of Thibault", "Thibault", "Jones", "6969");
        Book book2 = new Book("Wild Adventures of Thibault", "Thibault", "Jones", "6969");
        bib.addBook(book);
        bib.addBook(book2);
        bib.lendBook("6969");

        assertThat(bib.amountofBooksISBN("6969")).isEqualTo(1);
    }
}