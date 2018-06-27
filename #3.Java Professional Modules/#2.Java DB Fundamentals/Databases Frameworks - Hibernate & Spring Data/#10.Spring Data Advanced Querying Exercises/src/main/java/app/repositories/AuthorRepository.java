package app.repositories;

import app.models.Author;
import app.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getAuthorsById(long id);

    @Query("select a from Author as a")
    List<Author> vzemiAvtorite();

    //T06
    List<Author> getAuthorsByFirstNameEndingWith(String endWith);

}
