package com.userMicroService.service;

import com.userMicroService.model.ModelCustomer;
import com.userMicroService.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    @Override
    public String createCustomer(ModelCustomer modelCustomer) {
        return customerRepository.createCustomer(modelCustomer);
    }

    @Override
    public String updateCustomerNameById(int userId, String firstName, String lastName) {
        return customerRepository.updateCustomerNameById(userId, firstName, lastName);
    }

    @Override
    public String deleteCustomerById(int userId) {
        return customerRepository.deleteCustomerById(userId);
        // need to delete also the user's answers
    }

    @Override
    public ModelCustomer getCustomerById(int userId) {
        return customerRepository.getCustomerById(userId);
    }


}
