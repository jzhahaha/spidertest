package com.spider.demo.crawler;

import com.spider.demo.pageprocess.ImagePage;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.Date;

@Component
public class ImageCrawler {

    public void start(){
        Date beginTime = new Date();
        Spider.create(new ImagePage())
                .addUrl("http://www.win4000.com/zt/meinv.html")
                .thread(4)
                .start();
        Date endTime = new Date();
        System.out.println("====================="+ (endTime.getTime() - beginTime.getTime()));

    }
}
