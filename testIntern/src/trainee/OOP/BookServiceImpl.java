package trainee.OOP;

import java.util.List;

public class BookServiceImpl {
    public void sale(List<Book1> book1s, String namePublishing){
        // tìm nhũng cuốn sách được công ty phát hành X thì giảm 50%
        for (int i = 0; i< book1s.size(); i++) {
            if (book1s.get(i).getPublishingCompanies().get(i).getName().equals(namePublishing) ) {
                book1s.get(i).setPrices(book1s.get(i).getPrices()*0.5);
            }
        }
        // nếu như phát triển chức năng giảm giá theo cách khác thì nên extend BookServiceImpl
        // không nên sửa trực tiếp trong code vì có thể sẽ ảnh hưởng đến code cũ.
    }
}
