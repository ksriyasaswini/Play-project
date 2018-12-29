package dao;

import models.Author;

import java.util.Collection;
import java.util.Optional;

public interface AuthorDao {
    Author create(Author author);
    Optional<Author> read(Integer id);
    Author update(Author author);
    Author delete(Integer id);
    Collection<Author> all();

}
