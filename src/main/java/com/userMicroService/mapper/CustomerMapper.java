package com.userMicroService.mapper;

import com.userMicroService.model.ModelCustomer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<ModelCustomer> {
    @Override
    public ModelCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ModelCustomer(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getInt("age"),
                rs.getString("address"),
                rs.getDate("join_date").toLocalDate()
        );
    }
}
