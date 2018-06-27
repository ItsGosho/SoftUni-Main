package t01_book_shop_system.repositories;

import org.springframework.data.repository.CrudRepository;
import t01_book_shop_system.models.Author;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    List<Author> getAuthorsByOrderByBooksDesc();
    List<Author> getAuthorsByFirstNameAndLastName(String firstName,String lastName);
    Author findAuthorById(int id);
}
