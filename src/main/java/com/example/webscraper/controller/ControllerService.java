package com.example.webscraper.controller;

import humanModel.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControllerService {

    private ControllerRepo controllerRepo;
    @Autowired
    public ControllerService(ControllerRepo controllerRepo){
        this.controllerRepo=controllerRepo;
    }

    public List<Model> getCustomer(){
        return ControllerRepo.getAllCustomer();
    }
}
