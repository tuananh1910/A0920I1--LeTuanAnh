package BookStore.model.entity;

import java.util.List;

public class Categories {
    private Long id;
    private String name;

    // OneToMany
    private List<Book> books;

    // constructor

    public Categories() {
    }

    public Categories(Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    //getter setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
