package trainee.OOP;

public class VietnameseBook implements IVietnameseBookService {
    private String name;

    public VietnameseBook(String name) {
        this.name = name;
    }

    @Override
    public void detailsVietnameseBook() {
        System.out.println("Vietnamese Name Book: " + name);
    }
}
