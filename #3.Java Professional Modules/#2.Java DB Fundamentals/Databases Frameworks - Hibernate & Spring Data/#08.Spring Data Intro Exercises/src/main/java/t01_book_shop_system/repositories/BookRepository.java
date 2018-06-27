package t01_book_shop_system.repositories;

import org.springframework.data.repository.CrudRepository;
import t01_book_shop_system.models.Author;
import t01_book_shop_system.models.Book;

import java.util.Date;
import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer> {
    List<Book> getBooksByRealeseDateAfter(Date date);
    List<Book> getBooksByRealeseDateBefore(Date date);
    List<Book> getBooksByAuthorOrderByRealeseDateDescTitleAsc(Author author);
    Book getBookById(int id);
}
