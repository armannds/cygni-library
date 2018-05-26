package se.cygni.boklan;

import se.cygni.boklan.entities.BookEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private String id;
    private int availableCopies;
    private List<String> reservedBy = new ArrayList<>();

    public Book() {

    }

    public Book(String name, String author, String id, int availableCopies, List<String> reservedBy) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.availableCopies = availableCopies;
        this.reservedBy.addAll(reservedBy);
    }

    public Book(BookEntity entity) {
        this(entity.getName(), entity.getAuthor(), entity.getId(), entity.getAvailableCopies(), entity.getReservedBy());
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

    public List<String> getReservedBy() {
        return reservedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getAvailableCopies() == book.getAvailableCopies() &&
                Objects.equals(getName(), book.getName()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getId(), book.getId()) &&
                Objects.equals(getReservedBy(), book.getReservedBy());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAuthor(), getId(), getAvailableCopies(), getReservedBy());
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
