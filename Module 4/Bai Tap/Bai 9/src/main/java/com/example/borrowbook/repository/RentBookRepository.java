package com.example.borrowbook.repository;

import com.example.borrowbook.model.RentBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentBookRepository extends JpaRepository<RentBook, Long> {
}
