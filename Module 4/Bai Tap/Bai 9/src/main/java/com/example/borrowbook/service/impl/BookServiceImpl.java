package com.example.borrowbook.service.impl;

import com.example.borrowbook.exception.BorrowBookException;
import com.example.borrowbook.model.Book;
import com.example.borrowbook.model.RentBook;
import com.example.borrowbook.repository.BookRepository;
import com.example.borrowbook.repository.RentBookRepository;
import com.example.borrowbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    BookRepository bookRepository;

    @Autowired
    RentBookRepository rentBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void removeById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Long borrowBook(Book book) throws BorrowBookException {


        RentBook rentBook = new RentBook();

        assert false;
        long idRentBook = 10000L + (long) (Math.random() * (99999L - 10000L));
        rentBook.setId(idRentBook);     // set idrent
        rentBook.setBook(book);  // set book for rent
        rentBookRepository.save(rentBook);
        decreaseAmount(book);

        return idRentBook;
    }

    @Override
    public boolean giveBookBack(RentBook rentBook) {
        Book book;
        rentBook = rentBookRepository.findById(rentBook.getId()).orElse(null);
        if (rentBook==null){
            return false;
        }else {
            book = bookRepository.findById(rentBook.getBook().getId()).orElse(null);
            assert book != null;
            System.out.println(book.getTitle());
            increaseAmount(book);
        }
        bookRepository.save(book);
        rentBookRepository.delete(rentBook);

        return true;
    }

    @Override
    public void decreaseAmount(Book book) throws BorrowBookException {
        int amount = 0;
        int remainAmount = 0;


        if (book.getAmount() < 1) {
            throw new BorrowBookException();
        } else {
            amount = book.getAmount() - 1;
            book.setAmount(amount);
            remainAmount = book.getRemainAmount() + 1;
            book.setRemainAmount(remainAmount);
        }

        bookRepository.save(book);

    }

    @Override
    public void increaseAmount(Book book) {
        int amount = book.getAmount() + 1;
        book.setAmount(amount);

        int remainAmount = book.getRemainAmount() - 1;
        book.setRemainAmount(remainAmount);

        bookRepository.save(book);

    }
}
