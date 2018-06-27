package t01_book_shop_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import t01_book_shop_system.models.Author;
import t01_book_shop_system.models.Book;
import t01_book_shop_system.repositories.AuthorRepository;
import t01_book_shop_system.repositories.BookRepository;
import t01_book_shop_system.services.interfaces.BookServices;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class BookSerImpl implements BookServices {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookSerImpl(BookRepository bookRepository,AuthorRepository authorRepository){
        this.bookRepository=bookRepository;
        this.authorRepository=authorRepository;
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public List<Book> getBooksByRealeseDateAfter(Date date) {
        return this.bookRepository.getBooksByRealeseDateAfter(date);
    }

    @Override
    public List<Book> getBooksByRealeseDateBefore(Date date) {
        return this.bookRepository.getBooksByRealeseDateAfter(date);
    }

    @Override
    public List<Book> getBooksByAuthorOrderByRealeseDateDescTitleAsc(Author author) {
        return this.bookRepository.getBooksByAuthorOrderByRealeseDateDescTitleAsc(author);
    }
}
