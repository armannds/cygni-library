package se.cygni.boklan;

import se.cygni.boklan.entities.BookEntity;

import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private String id;
    private Boolean available;

    public Book() {

    }

    public Book(String name, String author, String id, Boolean available) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.available = available;
    }

    public Book(BookEntity entity) {
        this(entity.getName(), entity.getAuthor(), entity.getId(), entity.getAvailable());
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
