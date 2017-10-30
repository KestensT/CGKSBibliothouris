package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.users.User;
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

    @Test
    public void equals_ifOtherClass_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Object());
    }

    @Test
    public void equals_BookWithOtherTitle_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("Lord of the cries", "Golding", "William", "0123654789"));
    }

    @Test
    public void equals_BookWithOtherAuthorFirstName_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("Lord of the Flies", "Golding", "Willem", "0123654789"));
    }

    @Test
    public void equals_BookWithOtherAuthorLastName_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("Lord of the Flies", "Goldeng", "William", "0123654789"));
    }

    @Test
    public void equals_BookWithOtherISBN_isFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("Lord of the Flies", "Golding", "William", "0123654788"));
    }

    @Test
    public void equals_ObjectWithNullTitle_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book(null, "Golding", "William", "0123654789"));
    }

    @Test
    public void equals_ObjectWithNullAuthorLastName_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("Lord of the Flies", null, "William", "0123654789"));
    }

    @Test
    public void equals_ObjectWithNullAuthorFirsttName_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("Lord of the Flies", "Golding", null, "0123654789"));
    }

    @Test
    public void equals_ObjectWithNullISBN_IsFalse() throws Exception {
        assertThat(book).isNotEqualTo(new Book("Lord of the Flies", "Golding", "William", null));
    }

    @Test
    public void equals_ObjectWithBothNullTitle_IsTrue() throws Exception {
        assertThat(new Book(null, "Golding", "William", "0123654789")).isEqualTo(new Book(null, "Golding", "William", "0123654789"));
    }

    @Test
    public void equals_ObjectWithBothNullAuthorLastName_IsTrue() throws Exception {
        assertThat(new Book("Lord of the Flies", null, "William", "0123654789")).isEqualTo(new Book("Lord of the Flies", null, "William", "0123654789"));
    }

    @Test
    public void equals_ObjectWithBothNullAuthorFirstName_IsTrue() throws Exception {
        assertThat(new Book("Lord of the Flies", "Golding", null, "0123654789")).isEqualTo(new Book("Lord of the Flies", "Golding", null, "0123654789"));
    }

    @Test
    public void equals_ObjectWithBothNullISBN_IsTrue() throws Exception {
        assertThat(new Book("Lord of the Flies", "Golding", "William", null)).isEqualTo(new Book("Lord of the Flies", "Golding", "William", null));
    }

    @Test
    public void equals_ObjectWithNoNullTitle_IsFalse() throws Exception {
        assertThat(new Book(null, "Golding", "William", "0123654789")).isNotEqualTo(new Book("Lord of the Flies", "Golding", "William", "0123654789"));
    }

    @Test
    public void equals_ObjectWithNoNullAuthorLastName_IsFalse() throws Exception {
        assertThat(new Book("Lord of the Flies", null, "William", "0123654789")).isNotEqualTo(new Book("Lord of the Flies", "Golding", "William", "0123654789"));
    }

    @Test
    public void equals_ObjectWithNoNullAuthorFirstName_IsFalse() throws Exception {
        assertThat(new Book("Lord of the Flies", "Golding", null, "0123654789")).isNotEqualTo(new Book("Lord of the Flies", "Golding", "William", "0123654789"));
    }

    @Test
    public void equals_ObjectWithNoNullISBN_IsFalse() throws Exception {
        assertThat(new Book("Lord of the Flies", "Golding", "William", null)).isNotEqualTo(new Book("Lord of the Flies", "Golding", "William", "0123654789"));
    }

    @Test
    public void assertThatANewCreatedBookIsInTheLibrary_True() throws Exception {
        User lendingUser = new User(1l, "Thibault");
        Book lendingbook = new Book("Wild Adventures of Thibault", "Thibault", "Jones", "6969");

        assertThat(lendingbook.inLibrary()).isTrue();
    }

}