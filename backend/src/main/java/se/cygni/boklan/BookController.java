package se.cygni.boklan;

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

        Mono<BookEntity> book = repository.findById(id);
         return book.map(it -> new Book(it));
    }

    @PutMapping("/book")
    @CrossOrigin(origins = "http://localhost:8080")
    public Mono<Void> putBook(@RequestBody Book book) {
        return repository.save(createBookEntity(book)).then();
    }

    @DeleteMapping("/book/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public Mono<Void> deleteBook(@PathVariable("id") String id) {
        return repository.deleteById(id);
    }

    private static BookEntity createBookEntity(Book book) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setId(book.getId());
        bookEntity.setName(book.getName());
        bookEntity.setAvailableCopies(book.getAvailableCopies());
        return bookEntity;
    }

    @PutMapping("/book/reserve")
    @CrossOrigin(origins = "*")
    public Mono<BookEntity> reserveBook(@RequestBody Reservation reservation) {
        System.out.println("id: " + reservation.getId());
        BookEntity book = repository.findById(reservation.getId()).block();


        if (book != null && !book.getReservedBy().contains(reservation.name)) {
            book.getReservedBy().add(reservation.name);
            return repository.save(book);
        }
        return Mono.empty();

    }
}
