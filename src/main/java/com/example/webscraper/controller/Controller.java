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
private ControllerService controllerService;
   @Autowired
            public Controller(ControllerService controllerService)
    { this.controllerService= controllerService;}
    USA_Bot bot=new USA_Bot();
   /* @GetMapping("/object")
    public ArrayList<Model> myApi(){

        return bot.compute();

    }*/

    @GetMapping("/object")
    public ResponseEntity<List<Customer>> getAllCustomers() {
//        ArrayList<ModelClass> list = obj.usBotApi();

        return ResponseEntity.status(200).body(controllerService.getCustomers());
    }

    @PostMapping("/object/post")
    public Model addRecord(@RequestBody Model m)
    {
        bot.addrecords(m);
        return m;
    }

    @DeleteMapping("object/{id}")
    public ArrayList<Model> deleteRecord(@PathVariable int id) {
       return bot.deleterecord(id);
    }

    @PutMapping("/object/{id}")
    public Model update(@RequestBody Model m, @PathVariable int id)
    {
        this.bot.update(m,id);
        return m;
    }
}
