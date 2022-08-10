package com.example.webscraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ControllerService {

    @Autowired
    private ControllerRepo controllerRepo;

    @Autowired
    public ControllerService(ControllerRepo controllerRepo){
        this.controllerRepo=controllerRepo;
    }

    public List<Customer> getCustomers(){
        return controllerRepo.getAllCustomer();
    }

    public int add(Customer customer){
        return controllerRepo.insertData(customer);
    }
///ERROR
    public int delete(int eid){
        return controllerRepo.deleteData(eid);
    }

    public int update(Customer customer,int customerId){
       return controllerRepo.updateData(customer,customerId);
    }
}
