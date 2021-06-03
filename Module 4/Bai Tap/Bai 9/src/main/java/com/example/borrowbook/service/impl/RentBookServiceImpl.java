package com.example.borrowbook.service.impl;

import com.example.borrowbook.model.RentBook;
import com.example.borrowbook.repository.RentBookRepository;
import com.example.borrowbook.service.RentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentBookServiceImpl implements RentBookService {
    @Autowired
    RentBookRepository rentBookRepository;

    @Override
    public Page<RentBook> findAll(Pageable pageable) {
        return rentBookRepository.findAll(pageable);
    }

    @Override
    public RentBook findById(Long id) {
        return rentBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentBook rentBook) {
        rentBookRepository.save(rentBook);
    }

    @Override
    public void removeById(Long id) {
        rentBookRepository.deleteById(id);
    }
}
