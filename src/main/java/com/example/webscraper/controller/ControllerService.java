package com.example.webscraper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControllerService {
    private ControllerRepo repo;

    @Autowired
    public ControllerService(ControllerRepo repo) {
        this.repo = repo;
    }

    public List<Customer> getCustomers(){
        return repo.getAllCustomers();
    }
}




















/*import humanModel.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ControllerService {

    private ControllerService controllerService;
    @Autowired
    public ControllerService(ControllerRepo controllerRepo){
        this.controllerRepo=controllerRepo;
    }

    public List<Model> getCustomer(){
        return ControllerRepo.getAllCustomer();
    }
}*/
