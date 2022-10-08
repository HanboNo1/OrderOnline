package com.hanbo.onlineorder.service;

import com.hanbo.onlineorder.dao.CustomerDao;
import com.hanbo.onlineorder.entity.Cart;
import com.hanbo.onlineorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerDao customerDao;

    // password encoder
    // private PasswordEncoder passwordEncoder;
    @Autowired
    public CustomerService (CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setEnabled(true);

        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
