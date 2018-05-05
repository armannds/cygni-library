package se.cygni.boklan.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import se.cygni.boklan.entities.BookEntity;

@Repository
public interface BookRepository extends ReactiveCrudRepository<BookEntity, String> {
}
