package BookStore.service;

import trainee.BookStore.model.dto.BuyBookRequest;

public interface ISellBookService {
    void sellBook(BuyBookRequest buyBookRequest);
}
