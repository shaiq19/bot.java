package com.example.webscraper.controller;

import humanModel.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ControllerRepo {
    private final JdbcTemplate jdbcTemplate;

    RowMapper<Customer> customerRowMapper = new  RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setCell(rs.getDouble("cell"));
            return customer;
        }
    };


    @Autowired
    public ControllerRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Customer> getAllCustomer(){
        String query = "SELECT * FROM customer";
        return jdbcTemplate.query(query, customerRowMapper);
    }
}

