package se.cygni.boklan;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.cygni.boklan.entities.BookEntity;
import se.cygni.boklan.repositories.BookRepository;

import java.time.Month;
import java.util.ArrayList;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebFluxTest
public class BookTest {

    @MockBean
    BookRepository repository;

    @Autowired
    private WebTestClient webClient;

    @Before
    public void before() {

    }

    @Test
    public void get() throws Exception {
        BookEntity entity = new BookEntity();
        entity.setName("Boknamn");
        entity.setId("3");
        entity.setAuthor("Apa");
        entity.setAvailableCopies(5);

        given(repository.findById(entity.getId()))
                .willReturn(Mono.just(entity));

        webClient.get().uri("/book/{id}", entity.getId()).accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Book.class)
                .isEqualTo(createBook(entity));
    }

    @Ignore
    @Test
    public void getNonExisting() {
        String id = "5";
        given(repository.findById(id)).willReturn(Mono.empty());

        webClient.get().uri("/book/{id}", id).accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is4xxClientError();
    }


    private static Book createBook(BookEntity entity) {
        return new Book(entity.getName(), entity.getAuthor(), entity.getId(), entity.getAvailableCopies());
    }
}
