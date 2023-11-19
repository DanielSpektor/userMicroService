package com.userMicroService.repository;

import com.userMicroService.model.ModelCustomer;

public interface CustomerRepository {

    String createCustomer(ModelCustomer modelCustomer);
    String updateCustomerNameById(int userId, String firstName, String lastName);
    String deleteCustomerById(int userId);
    ModelCustomer getCustomerById(int userId);
}
