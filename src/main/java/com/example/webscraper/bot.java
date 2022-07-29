package com.example.webscraper;

import humanModel.object;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class bot {
    public Elements compute()  {
        try {
            return crawl();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    public Elements crawl() throws IOException {
        Document doc = Jsoup.connect("https://cha.house.gov/subcommittees/joint-committee-congress-library-116th-congress").get();
       Elements firstCol = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-last.panel-panel > div");
        for (Element headline : firstCol) {
            Elements img = headline.select(".each-member");
            for (Element inner: img) {
                Elements exmaple= inner.select("img");
                String source = exmaple.attr("src");
                String title = exmaple.attr("title");
                /*System.out.println(source);
                System.out.println(title);*/
               String desi = inner.select(".each-member-ss-dd").text();
               String[] SPLIT_STATE = desi.split("~");
                String state = SPLIT_STATE[1];
                /*System.out.println(state);*/
                System.out.println(new object(source,title,state));
            }

        }

       return null;
    }

}


/*
#region-content > div > div > div.center-wrapper > div.panel-col-last.panel-panel > div > div:nth-child(1) > div > div > div > div > div > div > div > span.each-member-ss-dd
#region-content > div > div > div.center-wrapper > div.panel-col-first.panel-panel > div > div:nth-child(1) > div > div > div > div > div > div > div > span.each-member-ss-dd
*/


/*   String element=doc.select(".page-title").text();*/
        /*Elements element = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-first.panel-panel > div > div:nth-child(1) > div > div > div > div > div > div > div > span.each-member-name");
        Elements des = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-first.panel-panel > div > div:nth-child(1) > div > div > div > div > div > div > div > span.each-member-ss-dd");
        System.out.println(des);
        Elements img = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-first.panel-panel > div > div:nth-child(1) > div > div > div > div > div > div > div > a > img");
        System.out.println(img);*/
       /* Elements img = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-last.panel-panel > div > div:nth-child(1) > div > div > div > div > div > div > div > a > img");

        String title = img.attr("title");
        System.out.println(title);
        Elements desi = doc.select( "#region-content > div > div > div.center-wrapper > div.panel-col-last.panel-panel > div > div:nth-child(1) > div > div > div > div > div > div > div > span.each-member-ss-dd");
        System.out.println(desi);
        return img;*/





         /* Elements secomdCol = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-last.panel-panel");
        String img1 = secomdCol.select("img").attr("src");
        for (Element headline : secomdCol) {
            System.out.println(headline);
        }*/