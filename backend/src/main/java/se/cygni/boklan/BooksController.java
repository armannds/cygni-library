package se.cygni.boklan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import se.cygni.boklan.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    private final BookRepository repository;

    @Autowired
    public BooksController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    @CrossOrigin(origins = "http://localhost:8080")
    public Flux<Book> getBook() {
        return repository.findAll().map(Book::new);
    }
}
