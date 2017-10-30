package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Named
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getOnebOokBasedOnISBN(String isbn) {
        List<Book> singleBookList = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                singleBookList.add(book);
            }
        }
        return singleBookList;
    }

    public void lendBook(String iSBN) {

    }

    public List<Book> getAllBooksByPartlyIsbn(String isbnPart) {

        List<Book> possibleMatches = new ArrayList<>();
        Pattern pattern = Pattern.compile(isbnPart.toLowerCase());
        for (Book book : books) {
            Matcher matcher = pattern.matcher(book.getISBN().toLowerCase());
            if (matcher.find()) {
                possibleMatches.add(book);
            }
        }
        return possibleMatches;
    }

    public List<Book> getAllBooksByPartlyTitle(String titlePart) {

        List<Book> possibleMatches = new ArrayList<>();
        Pattern pattern = Pattern.compile(titlePart.toLowerCase());
        for (Book book : books) {
            Matcher matcher = pattern.matcher(book.getTitle().toLowerCase());
            if (matcher.find()) {
                possibleMatches.add(book);
            }
        }
        return possibleMatches;
    }

    public List<Book> getAllBooksByPartlyAuthor(String authorPart) {

        List<Book> possibleMatches = new ArrayList<>();
        Pattern pattern = Pattern.compile(authorPart.toLowerCase());
        for (Book book : books) {
            Matcher matcher = pattern.matcher(book.getAuthorFirstName().toLowerCase());
            if (matcher.find()) {
                possibleMatches.add(book);
            }
        }
        for (Book book : books) {
            Matcher matcher = pattern.matcher(book.getAuthorLastName().toLowerCase());
            if (matcher.find()) {
                possibleMatches.add(book);
            }
        }
        return possibleMatches;
    }
}
