package t01_book_shop_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import t01_book_shop_system.services.AuthorSerImpl;
import t01_book_shop_system.services.BookSerImpl;
import t01_book_shop_system.services.CategorySerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

    private AuthorSerImpl authorSer;
    private BookSerImpl bookSer;
    private CategorySerImpl categorySer;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("d/M/yyyy");

    @Autowired
    public ConsoleRunner(AuthorSerImpl authorSer, BookSerImpl bookSer, CategorySerImpl categorySer) {
        this.authorSer = authorSer;
        this.bookSer = bookSer;
        this.categorySer = categorySer;
    }

    @Override
    public void run(String... strings) throws Exception {
        Scanner skener = new Scanner(System.in);

/*        Book book=bookSer.getBookById(1);
        Author author=authorSer.findAuthorById(1);
        book.setAuthor(author);
        //author.getBooks().add(book);
        bookSer.saveBook(book);
        authorSer.saveAuthor(author);*/


        this.bookSer.getBooksByAuthorOrderByRealeseDateDescTitleAsc(this.authorSer.getAuthorsByFirstNameAndLastName("George","Powell").get(0))
                .forEach(x->{
                    System.out.println(x.getTitle()+" "+x.getRealeseDate()+" "+x.getCopies());
                });
    }

    public void printBooksAfter2000(){
        try {
            this.bookSer.getBooksByRealeseDateAfter(DATE_FORMAT.parse("01/01/2000"))
                    .forEach(x->{
                        System.out.println(x.getTitle());
                    });
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void printAuthorWithAtLeastOneBookAfter1900(){
        this.authorSer.atleastOneBookAfter1990()
                .forEach(x->{
                    System.out.println(x.getFirstName()+" "+x.getLastName());
                });
    }
    public void printAuthorWithOrderedBooks(){
        this.authorSer.getAuthorsByOrderByBooksDesc()
                .forEach(x->{
                    System.out.println(x.getFirstName()+" "+x.getLastName()+" "+x.getBooks().size());
                });
    }
}
