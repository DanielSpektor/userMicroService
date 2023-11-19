package com.userMicroService.service;

import com.userMicroService.model.ModelCustomer;
import org.springframework.web.bind.annotation.GetMapping;

public interface CustomerService {

    String createCustomer(ModelCustomer modelCustomer);
    String deleteCustomerById(int userId);
    ModelCustomer getCustomerById(int userId);
    String updateCustomerNameById(int userId, String firstName, String lastName);
}
