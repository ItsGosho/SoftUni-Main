package t01_book_shop_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import t01_book_shop_system.models.Author;
import t01_book_shop_system.repositories.AuthorRepository;
import t01_book_shop_system.repositories.BookRepository;
import t01_book_shop_system.services.interfaces.AuthorServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
@Primary
public class AuthorSerImpl implements AuthorServices {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("d/M/yyyy");

    @Autowired
    public AuthorSerImpl(AuthorRepository authorRepository,BookRepository bookRepository){
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
    }


    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthorsByOrderByBooksDesc() {
        return this.authorRepository.getAuthorsByOrderByBooksDesc();
    }

    @Override
    public List<Author> getAuthorsByFirstNameAndLastName(String firstName,String lastName) {
        return this.authorRepository.getAuthorsByFirstNameAndLastName(firstName,lastName);

    }

    @Override
    public Author findAuthorById(int id) {
        return authorRepository.findAuthorById(id);
    }

    public List<Author> atleastOneBookAfter1990(){
        List<Author> returnAuthorList=new LinkedList<>();
        try {
            this.bookRepository.getBooksByRealeseDateBefore(DATE_FORMAT.parse("01/01/1990"))
                    .stream()
                    .forEach(x->{
                        Author author=x.getAuthor();
                        if(author!=null && author.getBooks().size() >=1){
                            returnAuthorList.add(x.getAuthor());
                        }
                    });
        } catch (ParseException e) {

        }
        return  returnAuthorList;
    }
}
