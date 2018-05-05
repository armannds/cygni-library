package se.cygni.boklan;

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
