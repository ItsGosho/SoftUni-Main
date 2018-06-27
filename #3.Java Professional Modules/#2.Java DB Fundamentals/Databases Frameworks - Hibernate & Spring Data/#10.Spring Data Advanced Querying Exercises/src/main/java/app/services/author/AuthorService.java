package app.services.author;

import app.models.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorService {

    void registerAuthor(Author author);

    void registerAuthors(Iterable<Author> authors);

    Author getRandomAuthor();

}
