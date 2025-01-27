package neo4j.io.abovo.demo_neo4j.api.controller;

import neo4j.io.abovo.demo_neo4j.domain.entity.BookNode;
import neo4j.io.abovo.demo_neo4j.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookNode> create(@RequestBody BookNode book) {
        BookNode savedBook = bookService.save(book);
        return ResponseEntity.ok(savedBook);
    }
}

// create a json request for the post request

