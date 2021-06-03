package com.example.borrowbook.service;

import com.example.borrowbook.model.RentBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentBookService {
    Page<RentBook> findAll(Pageable pageable) ;
    RentBook findById(Long id) ;

    void save (RentBook rentBook);

    void removeById (Long id);
}
