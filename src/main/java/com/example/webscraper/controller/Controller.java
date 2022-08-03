package com.example.webscraper.controller;

import com.example.webscraper.USA_Bot;
import humanModel.object;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {
    @GetMapping("/object")
    public ArrayList<object> myApi(){
        USA_Bot bot=new USA_Bot();
        return bot.compute();

    }

}
