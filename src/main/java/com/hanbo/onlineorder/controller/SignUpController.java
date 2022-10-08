package com.hanbo.onlineorder.controller;

import com.hanbo.onlineorder.entity.Customer;
import com.hanbo.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {
    private CustomerService customerService;

    @Autowired
    public SignUpController (CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody Customer customer) {
        customerService.signUp(customer);
    }

}
