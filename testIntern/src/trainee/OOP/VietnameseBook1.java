package trainee.OOP;

import java.util.List;

public class VietnameseBook1 extends Book1 implements VietnameseBookService{
    private String translator;
    private String size;
    private int numberPage;

    public VietnameseBook1() {
    }

    @Override
    public String detailsBook(Long id) {
        return "Name :" + super.getName() +
                "Categories : " + super.getCategories().get(Math.toIntExact(id)).getName() +
                "Publishing : " + super.getPublishingCompanies().get(Math.toIntExact(id)).getName() +
                "Translator : " + this.getTranslator() +
                "Size : " + this.getSize() +
                "Number Page :" + this.getNumberPage();
    }


    public VietnameseBook1(Long id, String name, double prices,
                           List<Categories> categories, List<PublishingCompany> publishingCompanies,
                           String translator, String size, int numberPage) {
        super(id, name, prices, categories, publishingCompanies);
        this.translator = translator;
        this.size = size;
        this.numberPage = numberPage;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    @Override
    public void orderVietnameseBook() {

    }

    @Override
    public void findAllById(int idVietnameseBook) {

    }
}
