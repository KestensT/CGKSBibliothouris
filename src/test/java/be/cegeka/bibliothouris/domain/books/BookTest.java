package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class BookTest {

    private Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book("Lord of the Flies", "Golding", "William", "0123654789");
    }

    @Test
    public void equals_SameBook_isTrue() throws Exception {
        Assertions.assertThat(book).isEqualTo(book);
    }

    @Test
    public void equals_BookWithSameTitleAuthorAndISBN_isTrue() throws Exception {
        assertThat(book).isEqualTo(new Book("Lord of the Flies", "Golding", "William", "0123654789"));
    }

    @Test
    public void equals_NullObject_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(null);
    }


}