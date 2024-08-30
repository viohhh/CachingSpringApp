package ru.akutepov.spring.cache.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.akutepov.spring.cache.example.configuration.CacheConstants;
import ru.akutepov.spring.cache.example.model.Book;
import ru.akutepov.spring.cache.example.repository.BookRepository;

import javax.transaction.Transactional;

import static ru.akutepov.spring.cache.example.configuration.CacheConstants.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    @Cacheable(value = CacheConstants.DATABASE_CACHE)
    public Book getBookByTitle(String title) throws Exception {
        return bookRepository.getBookByTitle(title).orElseThrow(() -> new Exception("Book " + title + " not found."));
    }

}

