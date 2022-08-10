package com.example.webscraper.controller;

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
        String query = "SELECT * FROM customer order by id asc";
        return jdbcTemplate.query(query, customerRowMapper);
    }

    public int insertData(Customer customer ){
        String query = "INSERT INTO customer(id, name, cell) values(?,?,?)";
        return this.jdbcTemplate.update(query, customer.getId(),customer.getName(),customer.getCell());
    }

    public int deleteData(int id){
        String query = "DELETE FROM customer WHERE id = ?";
        return this.jdbcTemplate.update(query,id);
    }

    public int updateData(Customer customer, int customerId){
        String query = "UPDATE customer SET name =?, cell=? WHERE id=?";
        return this.jdbcTemplate.update(query, customer.getName(),customer.getCell(),customerId);
    }
}

