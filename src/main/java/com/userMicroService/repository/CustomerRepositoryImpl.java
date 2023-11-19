package com.userMicroService.repository;

import com.userMicroService.model.ModelCustomer;
import com.userMicroService.mapper.CustomerMapper;
import com.userMicroService.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String createCustomer (ModelCustomer modelCustomer) {
        String sql = "INSERT INTO " + Constants.USER_TABLE_NAME + " (first_name, last_name, email, address, join_date) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, modelCustomer.getFirstName(), modelCustomer.getLastName(), modelCustomer.getEmail(), modelCustomer.getAddress(), modelCustomer.getJoinDate());
        return "User was successfully created and added to the system !";
    }

    @Override
    public String updateCustomerNameById(int userId, String firstName, String lastName) {
        String sql = "UPDATE " + Constants.USER_TABLE_NAME + " SET first_name = ?, last_name = ? WHERE id = ?";
        if(jdbcTemplate.update(sql, userId, firstName, lastName) == 1) {
            return "User's first name with id " + userId + " was updated to first name " + firstName + " and last name " + lastName;
        } else {
            return "User with id " + userId + " wasn't found";
        }

    }

    @Override
    public String deleteCustomerById(int userId) {
        String sql = "DELETE FROM " + Constants.USER_TABLE_NAME + " WHERE id = ?";
        if (jdbcTemplate.update(sql, userId) == 1) {
            return "User with id " + userId + " was deleted";
        }else{
            return "User with id " + userId + " wasn't found";
        }
    }

    @Override
    public ModelCustomer getCustomerById(int userId) {
        String sql = "SELECT * FROM " + Constants.USER_TABLE_NAME + " WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new CustomerMapper(), userId);
    }
}
