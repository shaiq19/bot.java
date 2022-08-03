package com.example.webscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebscraperApplication {

    public static void main(String[] args) throws IOException {

     /*   ArrayList<object> ary= new ArrayList<>();
        Document doc = (Document) Jsoup.connect("#region-content > div > div > div.center-wrapper > div.panel-col-first.panel-panel");
        for (int i = 1; i <= Jsoup.connect("") i++)
            doc.add(i);*/
        SpringApplication.run(WebscraperApplication.class, args);
        USA_Bot b = new USA_Bot();
        System.out.println(b.compute());

    }

}

