package trainee.OOP;

import java.util.List;

public class SaleBook extends BookServiceImpl{
    public void sale(List<Book1> book1s, String namePublishing){
        // tìm nhũng cuốn sách được công ty phát hành X thì giảm 10%
        for (int i = 0; i< book1s.size(); i++) {
            if (book1s.get(i).getPublishingCompanies().get(i).getName().equals(namePublishing) ) {
                book1s.get(i).setPrices(book1s.get(i).getPrices()*0.1);
            }
        }
    }
}
