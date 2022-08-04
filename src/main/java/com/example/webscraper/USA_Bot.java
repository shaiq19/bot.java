package com.example.webscraper;

import humanModel.Model;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class USA_Bot {
    ArrayList<Model> obj = new ArrayList();
    public ArrayList<Model> compute()  {
        try {
            if(obj.isEmpty()){
                return crawl();
            }
            else {
                return obj;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    public ArrayList<Model> crawl() throws IOException {
        int i=0;
        Document doc = Jsoup.connect("https://cha.house.gov/subcommittees/joint-committee-congress-library-116th-congress").get();
       Elements firstCol = doc.select("#region-content > div > div > div.center-wrapper > div.panel-col-last.panel-panel > div");
        for (Element headline : firstCol) {
            Elements img = headline.select(".each-member");
            for (Element inner: img) {
                i=i+1;
                Elements exmaple= inner.select("img");
                String source = exmaple.attr("src");
                String title = exmaple.attr("title");
                /*System.out.println(source);
                System.out.println(title);*/
               String desi = inner.select(".each-member-ss-dd").text();
               String[] SPLIT_STATE = desi.split("~");
                String state = SPLIT_STATE[1];
                /*System.out.println(state);*/

               /* System.out.println(new object(source, title, state));*/
               // System.out.println(obj.add(new object(source, title, state)));
                obj.add(new Model(i,source, title, state));

            }

        }
      /*  obj.clear();*/

        return obj;
    }

    public Model addrecords(Model m){
        obj.add(m);
        return  m;
    }

    public ArrayList<Model>  deleterecord(int m){
        obj.remove(m);
        return obj;

    }

    public void update(Model m, int id){
        obj= (ArrayList<Model>) obj.stream().map(e->{
            if(e.getId()==id){
                e.setName(m.getName());
                e.setImg(m.getImg());
                e.setDes(m.getDes());
            }
           return e;
        }).collect(Collectors.toList());
       // return  m;
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