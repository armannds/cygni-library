package se.cygni.boklan;

import se.cygni.boklan.entities.BookEntity;

import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private String id;

    public Book() {

    }

    public Book(String name, String author, String id) {
        this.name = name;
        this.author = author;
        this.id = id;
    }

    public Book(BookEntity entity) {
        this(entity.getName(), entity.getAuthor(), entity.getId());
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getName(), book.getName()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAuthor(), getId());
    }
}
