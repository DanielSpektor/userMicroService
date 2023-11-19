package com.userMicroService.controller;

import com.userMicroService.model.ModelCustomer;
import com.userMicroService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public String createCustomer(@RequestBody ModelCustomer modelCustomer) {
        return customerService.createCustomer(modelCustomer);
    }

    @DeleteMapping
    public String deleteCustomerById(@RequestParam int userId) {
        return customerService.deleteCustomerById(userId);
    }

    @PutMapping(value = "/update/name")
    public String updateCustomerNameById(@RequestBody ModelCustomer modelCustomer) {
        if (modelCustomer.getUserId() == 0 || modelCustomer.getFirstName() == null || modelCustomer.getLastName() == null) {
            return "Can't change this user's name";
        } else {
            return customerService.updateCustomerNameById(modelCustomer.getUserId(), modelCustomer.getFirstName(), modelCustomer.getLastName());
        }
    }

    @GetMapping
    public ModelCustomer getCustomerById(@RequestParam int userId) {
        return customerService.getCustomerById(userId);
    }



}
