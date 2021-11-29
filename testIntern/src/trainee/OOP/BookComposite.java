package trainee.OOP;

import java.util.List;

public class BookComposite implements IVietnameseBookService{
    private List<VietnameseBook> vietnameseBooks;

    public BookComposite(List<VietnameseBook> vietnameseBooks) {
        this.vietnameseBooks = vietnameseBooks;
    }

    @Override
    public void detailsVietnameseBook() {
        for (VietnameseBook value: vietnameseBooks){
            value.detailsVietnameseBook();
        }
    }
}
