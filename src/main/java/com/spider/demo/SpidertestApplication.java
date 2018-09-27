package com.spider.demo;


import com.spider.demo.crawler.ImageCrawler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpidertestApplication {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(SpidertestApplication.class, args);
        ImageCrawler imageCrawler = ac.getBean(ImageCrawler.class);
        imageCrawler.start();
    }
}
