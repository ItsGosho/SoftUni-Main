package app.repositories;

import app.models.AgeRestriction;
import app.models.Author;
import app.models.EditionType;
import app.models.Book;
import app.stored_procedure.ReducedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //T01
    List<Book> getBooksByAgeRestrictionEquals(AgeRestriction ageRestriction);

    //T02
    List<Book> getBooksByEditionTypeEqualsAndCopiesLessThan(EditionType editionType, int countCopies);

    //T03
    List<Book> getBooksByPriceLessThanOrPriceGreaterThan(BigDecimal price1, BigDecimal price2);

    //T04
    List<Book> getBooksByReleaseDateIsNot(Date date);

    //T05
    List<Book> getBooksByReleaseDateBefore(Date date);

    //T07
    List<Book> getBooksByTitleIsContaining(String word);

    //T08
    List<Book> getBooksByAuthorLastNameStartingWith(String word);

    //T09
    @Query("select count(b.id) from Book as b where length(b.title) >= :inputNum")
    int broiKnigiBratko(@Param("inputNum") int howLong);

    //T10
    @Query("select sum(b.copies) from Book as b where b.author=:inputAuthor")
    int sumKnigiOtAvtor(@Param("inputAuthor") Author author);


    //T11
    @Query("select new app.stored_procedure.ReducedBook(b.title,b.editionType,b.ageRestriction,b.price) from Book as b where b.title = :vT")
    ReducedBook getINReducedBookByTitle(@Param("vT") String title);

    //T13
    @Modifying
    @Transactional
    void removeBooksByCopiesIsLessThan(int num);
    int countBooksByCopiesLessThan(int num);
}