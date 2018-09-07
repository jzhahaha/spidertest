package com.spider.demo.pageprocess;

import com.spider.demo.utils.ImageUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Date;
import java.util.List;

public class ImagePage implements PageProcessor {

    private final static int RETRY_TIMES = 3;
    private final static int SLEEP_TIME = 1000;

    private Site site = Site.me().setRetryTimes(RETRY_TIMES).setSleepTime(SLEEP_TIME);

    public static int i = 0;

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().xpath("//ul[@class='clearfix']/li/a").links().all();
        page.addTargetRequests(links);
        if(page.getUrl().regex("http://www\\.win4000\\.com/zt/gaoqing_\\w+.html").match()) {
            List<String> detailUrl = page.getHtml().xpath("//ul[@class='clearfix']/li/a").links().all();
            for(String temp : detailUrl){
                System.out.println("============"+temp);
            }


            page.addTargetRequests(detailUrl);
        }else {
            String picUrl = page.getHtml().xpath("//div[@class='pic-meinv']/a").css("img","src").toString();
            System.out.println("============"+picUrl);

            ImageUtils.PicDownload(picUrl, String.valueOf(i)+".jpg");
            i++;
        }

    }

    public static void main(String[] args) {
//        System.setProperties();
        Date beginTime = new Date();
        Spider.create(new ImagePage())
                .addUrl("http://www.win4000.com/zt/gaoqing_1.html")
                .thread(5)
                .start();
        Date endTime = new Date();
        System.out.println("====================="+ (endTime.getTime() - beginTime.getTime()));
    }


}
