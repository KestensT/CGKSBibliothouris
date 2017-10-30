package be.cegeka.bibliothouris.domain.books;

import java.time.LocalDate;

public class Book {

    private String title;
    private String authorLastName;
    private String authorFirstName;
    private String ISBN;
    private boolean bookInLibrary;
    private LocalDate dueDate;

    public Book(String title, String authorLastName, String authorFirstName, String ISBN) {
        this.title = title;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
        this.ISBN = ISBN;
        this.bookInLibrary = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean inLibrary() {
        return bookInLibrary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (authorLastName != null ? !authorLastName.equals(book.authorLastName) : book.authorLastName != null)
            return false;
        if (authorFirstName != null ? !authorFirstName.equals(book.authorFirstName) : book.authorFirstName != null)
            return false;
        return ISBN != null ? ISBN.equals(book.ISBN) : book.ISBN == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (authorLastName != null ? authorLastName.hashCode() : 0);
        result = 31 * result + (authorFirstName != null ? authorFirstName.hashCode() : 0);
        result = 31 * result + (ISBN != null ? ISBN.hashCode() : 0);
        return result;
    }
    public void lendBook(){
        bookInLibrary = false;
        dueDate = LocalDate.now().plusWeeks(3);
    }
}
