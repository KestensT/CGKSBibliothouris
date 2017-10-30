package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookRepositoryTest {

    @Test
    public void givenISBNabc123returnslistofsinglebook() throws Exception {
        Book testbook1=new Book("a","mattia","romeo","123");
        Book testbook2=new Book("a","ralph","vancampenhoudt","abc123");
        BookRepository bib= new BookRepository();
        bib.addBook(testbook1);
        bib.addBook(testbook2);

        Assertions.assertThat(bib.getOnebOokBasedOnISBN("abc123").get(0)).isEqualTo(testbook2);
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
        library.lendBook("6969");

        assertThat();

    }


}