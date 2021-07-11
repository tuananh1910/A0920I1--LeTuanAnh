package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(
            value = "SELECT  * FROM customer as c join customer_type as t where c.customer_type_id = t.id and t.id like %:id% and c.name like %:key_search%",
            nativeQuery = true)
    Page<Customer> findAllCustomerByTypeCustomerId(@Param("id") String id, @Param("key_search") String key_search, Pageable pageable);
}
