package dao;

import models.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookDao {

    Book create(Book book);
    Book update(Book book);
    Book delete(Integer id);
    Optional<Book> read(Integer id);
    Collection<Book> all();


}
