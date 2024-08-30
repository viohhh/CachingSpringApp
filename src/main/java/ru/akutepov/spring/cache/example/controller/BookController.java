package ru.akutepov.spring.cache.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import ru.akutepov.spring.cache.example.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping(path = "/{title}")
    public ResponseEntity<Object> getBookByTitle(@PathVariable String title) throws Exception {
        return new ResponseEntity<>(bookService.getBookByTitle(title), HttpStatus.OK);
    }
}

