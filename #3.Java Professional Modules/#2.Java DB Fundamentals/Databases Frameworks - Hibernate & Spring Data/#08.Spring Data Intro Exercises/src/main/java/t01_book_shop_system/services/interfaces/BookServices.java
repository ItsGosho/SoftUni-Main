package t01_book_shop_system.services.interfaces;

import t01_book_shop_system.models.Author;
import t01_book_shop_system.models.Book;

import java.util.Date;
import java.util.List;

public interface BookServices {
    void saveBook(Book book);
    Book getBookById(int id);
    List<Book> getBooksByRealeseDateAfter(Date date);
    List<Book> getBooksByRealeseDateBefore(Date date);
    List<Book> getBooksByAuthorOrderByRealeseDateDescTitleAsc(Author author);

}
