package app.services.book;

import app.models.AgeRestriction;
import app.models.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void newBook(Book book);

    void newBooks(Iterable<Book> books);

    long getBooksCount();
}
