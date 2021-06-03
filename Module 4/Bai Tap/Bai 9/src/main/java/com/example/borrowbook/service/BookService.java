package com.example.borrowbook.service;

import com.example.borrowbook.exception.BorrowBookException;
import com.example.borrowbook.model.Book;
import com.example.borrowbook.model.RentBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable) ;
    Book findById(Long id) ;

    void save (Book book);

    void removeById (Long id);

    Long borrowBook(Book book) throws BorrowBookException;

    boolean giveBookBack(RentBook rentBook);

    void decreaseAmount(Book book) throws BorrowBookException;  // giam so luong sach khi co nguoi muon sach

    void increaseAmount(Book book) throws BorrowBookException; // tang so luong sach khi co nguoi tra
}
