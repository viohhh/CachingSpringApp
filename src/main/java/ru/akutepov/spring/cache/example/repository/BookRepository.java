package ru.akutepov.spring.cache.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.akutepov.spring.cache.example.model.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> getBookByTitle(String title);

}

