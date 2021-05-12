package service.Impl;

import model.Customer;
import org.springframework.stereotype.Service;
import service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(Long id) {

    }
}
