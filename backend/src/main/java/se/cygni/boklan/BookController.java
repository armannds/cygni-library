package se.cygni.boklan;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    public static List<Book> books = new ArrayList<>();

    @GetMapping("/book")
    public Book getBook() {
        if (books.isEmpty()) {
            return new Book("Harry potter", "Rowling", "1");
        } else {
            return books.get(0);
        }
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") String id) {
        Optional<Book> matchingBook = books.stream().
                filter(book -> book.getId().equals(id)).
                findFirst();

        return matchingBook.get();
    }

    @PutMapping("/book")
    public void putBook(@RequestBody Book book) {
        books.add(book);
    }
}
