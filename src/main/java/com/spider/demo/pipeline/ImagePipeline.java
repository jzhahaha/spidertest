package com.spider.demo.pipeline;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class ImagePipeline implements Pipeline {


    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("resultItems, : url: " + resultItems.getRequest().getUrl());
        System.out.println("resultItems, : method: " + resultItems.getRequest().getMethod());
        System.out.println("resultItems, : extras: " + resultItems.getRequest().getExtras().toString());
        System.out.println("resultItems, : fields: " + resultItems.getAll().toString());
        System.out.println("task, : UUID: " + task.getUUID());
    }
}
