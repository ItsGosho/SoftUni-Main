package t01_book_shop_system.services.interfaces;

import t01_book_shop_system.models.Author;

import java.util.List;

public interface AuthorServices {

    void saveAuthor(Author author);
    List<Author> getAuthorsByOrderByBooksDesc();
    List<Author> getAuthorsByFirstNameAndLastName(String firstName,String lastName);
    Author findAuthorById(int id);
}
