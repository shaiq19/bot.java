package com.example.webscraper;

import humanModel.object;
import org.jsoup.Jsoup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class WebscraperApplication {

    public static void main(String[] args) throws IOException {
     /*   ArrayList<object> ary= new ArrayList<>();
        Document doc = (Document) Jsoup.connect("#region-content > div > div > div.center-wrapper > div.panel-col-first.panel-panel");
        for (int i = 1; i <= Jsoup.connect("") i++)
            doc.add(i);*/

        bot b = new bot();
        System.out.println(b.compute());

    }

}

