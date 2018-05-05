package se.cygni.boklan;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public List<Book> getBook() {
        return BookController.books;
    }
}
