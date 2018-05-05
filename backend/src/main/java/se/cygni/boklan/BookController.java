package se.cygni.boklan;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import se.cygni.boklan.entities.BookEntity;
import se.cygni.boklan.repositories.BookRepository;

@RestController
public class BookController {

    private final BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/book/{id}")
    public Mono<Book> getBook(@PathVariable("id") String id) {

        return repository.findById(id).map(it -> new Book(it));
    }

    @PutMapping("/book")
    public Mono<Void> putBook(@RequestBody Book book) {
        return repository.save(createBookEntity(book)).then();
    }

    private static BookEntity createBookEntity(Book book) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setId(book.getId());
        bookEntity.setName(book.getName());
        return bookEntity;
    }
}
