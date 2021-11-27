package trainee.OOP;

import java.util.List;

public class ForeignBook1 extends Book1 {
    private String issuingCompany;
    private String codeISBN;

    public ForeignBook1(Long id, String name, double prices,
                        List<Categories> categories, List<PublishingCompany> publishingCompanies,
                        String issuingCompany, String codeISBN) {
        super(id, name, prices, categories, publishingCompanies);
        this.issuingCompany = issuingCompany;
        this.codeISBN = codeISBN;
    }

    public ForeignBook1(Long id, String name, double prices, List<Categories> categories, List<PublishingCompany> publishingCompanies) {
        super(id, name, prices, categories, publishingCompanies);
    }

    public ForeignBook1() {

    }



    @Override
    public String detailsBook(Long id) {
        return "Name :"+super.getName() +
                "Categories : " + super.getCategories().get(Math.toIntExact(id)).getName()+
                "Publishing : " + super.getPublishingCompanies().get(Math.toIntExact(id)).getName()+
                "Issuing :" + this.getIssuingCompany()+
                "ISN : " + this.getCodeISBN();
    }


    public String getIssuingCompany() {
        return issuingCompany;
    }

    public void setIssuingCompany(String issuingCompany) {
        this.issuingCompany = issuingCompany;
    }

    public String getCodeISBN() {
        return codeISBN;
    }

    public void setCodeISBN(String codeISBN) {
        this.codeISBN = codeISBN;
    }


}
