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

    RowMapper<Model> customerRowMapper = new RowMapper<Model>() {
        @Override
        public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
            Model m = new Model();
            m.setId(rs.getInt("id"));
            m.setName("name");
            m.setDes("designation");
            return m;
        }
    };


    @Autowired
    public ControllerRepo(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    public List<Model> getAllCustomer(){
        String query = "SELECT * m";
        return jdbcTemplate.query(query, customerRowMapper);
    }
}

