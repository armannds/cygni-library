package se.cygni.boklan.entities;

import org.reactivestreams.Publisher;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import se.cygni.boklan.Book;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "books")
public class BookEntity {

    @Id
    private String id;
    private String name;
    private String author;
    private int availableCopies;
    private List<String> reservedBy = new ArrayList<>();

    public List<String> getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(List<String> reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int available) {
        this.availableCopies = available;
    }
}
