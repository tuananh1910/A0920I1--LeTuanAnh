package com.example.customer_m.repository;

import com.example.customer_m.model.Customer;
import com.example.customer_m.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByNameContains(String name, Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);
}
