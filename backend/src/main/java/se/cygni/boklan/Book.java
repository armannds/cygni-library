package se.cygni.boklan;

import se.cygni.boklan.entities.BookEntity;

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
}
