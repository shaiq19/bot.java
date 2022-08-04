package com.example.webscraper.controller;

import com.example.webscraper.USA_Bot;
import humanModel.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {
    USA_Bot bot=new USA_Bot();
    @GetMapping("/object")
    public ArrayList<Model> myApi(){

        return bot.compute();

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
