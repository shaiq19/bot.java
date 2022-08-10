package com.example.webscraper.controller;

import com.example.webscraper.USA_Bot;
import humanModel.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    ControllerService controllerService;
    ControllerRepo   controllerRepo;

    @Autowired
            public Controller(ControllerService controllerService){ this.controllerService= controllerService;}
    USA_Bot bot=new USA_Bot();
   /* @GetMapping("/object")
    public ArrayList<Model> myApi(){

        return bot.compute();

    }*/

    @GetMapping("/object")
    public ResponseEntity<List<Customer>> getAllCustomers() {

        return ResponseEntity.status(200).body(controllerService.getCustomers());
    }

   /* @PostMapping("/object/post")
    public Model addRecord(@RequestBody Model m)
    {
        bot.addrecords(m);
        return m;
    }*/

/////
    @PostMapping("/object/post")
    public int addRecord(@RequestBody Customer customer )
    {
        return controllerService.add(customer);
    }

/*
    @DeleteMapping("object/{id}")
    public ArrayList<Model> deleteRecord(@PathVariable int id) {
       return bot.deleterecord(id);
    }*/


    ///
    @DeleteMapping("/object/{customerId}")
    public void deleteRecord(@PathVariable ("customerId") int customerId)
    {
        this.controllerService.delete(customerId);
    }
/*

    @PutMapping("/object/{id}")
    public Model update(@RequestBody Model m, @PathVariable int id)
    {
        this.bot.update(m,id);
        return m;
    }
*/

    @PutMapping("/object/{id}")
    public int  update(@RequestBody Customer customer, @PathVariable int id)
    {
       return this.controllerService.update(customer, id);
    }


}
