package trainee.OOP;

import java.util.List;

// Book là module cấp cao
public abstract class Book1 {
    public void display(int idVietnameseBook , int idForeignBook){
        // VietnameseBook, ForeignBook là module cấp thấp
        VietnameseBook1 vnb = new VietnameseBook1();
        vnb.findAllById(idVietnameseBook);

        ForeignBook1 fnb = new ForeignBook1();
//        fnb.updateForeignBookById(idForeignBook);
    }




    private Long id;
    private String name;
    private double prices;
    private List<Categories> categories;
    private List<PublishingCompany> publishingCompanies;

    public Book1(Long id, String name, double prices, List<Categories> categories, List<PublishingCompany> publishingCompanies) {
        this.id = id;
        this.name = name;
        this.prices = prices;
        this.categories = categories;
        this.publishingCompanies = publishingCompanies;
    }

    public abstract String detailsBook(Long id);

    public Book1() {
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

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

    public List<Categories> getCategories() {
        return categories;
    }
    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<PublishingCompany> getPublishingCompanies() {
        return publishingCompanies;
    }
    public void setPublishingCompanies(List<PublishingCompany> publishingCompanies) {
        this.publishingCompanies = publishingCompanies;
    }

}

