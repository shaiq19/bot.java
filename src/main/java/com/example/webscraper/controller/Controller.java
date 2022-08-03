package com.example.webscraper.controller;

import com.example.webscraper.USA_Bot;
import humanModel.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
