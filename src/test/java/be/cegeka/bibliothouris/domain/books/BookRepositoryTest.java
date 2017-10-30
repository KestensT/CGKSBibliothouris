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
}