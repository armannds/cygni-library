package se.cygni.boklan.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import se.cygni.boklan.entities.BookEntity;


public interface BookRepository extends ReactiveCrudRepository<BookEntity, String> {
}
