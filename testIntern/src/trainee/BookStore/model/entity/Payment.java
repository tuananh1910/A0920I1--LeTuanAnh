package trainee.BookStore.model.entity;

public class Payment {
    private Long id;
    private String name;

    // OneToOne
    private SellBook sellBook;

    // constructor
    public Payment(Long id, String name, SellBook sellBook) {
        this.id = id;
        this.name = name;
        this.sellBook = sellBook;
    }

    public Payment() {
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

    public SellBook getSellBook() {
        return sellBook;
    }

    public void setSellBook(SellBook sellBook) {
        this.sellBook = sellBook;
    }
}
