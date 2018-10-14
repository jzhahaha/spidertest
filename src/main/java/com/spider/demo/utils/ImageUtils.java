package com.spider.demo.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.parameters.P;

import java.io.*;
import java.net.URI;
import java.net.URL;

public class ImageUtils {

//    public static final String DOWNLOAD_PATH = "C:\\Users\\junzou214916\\Desktop\\spidertest";
    public static final String DOWNLOAD_PATH = "C:\\Users\\zj\\Desktop\\spidertest";

    public static final String PIC_NAME_PRE = "/test_";

    public static void PicDownload(String picUrl, String name){
        if(StringUtils.isEmpty(picUrl)){
            return;
        }
        try {
            URL url = new URL(picUrl);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String picName = PIC_NAME_PRE+name;

            File file = new File(DOWNLOAD_PATH+picName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int length;
            while ( (length = dataInputStream.read(buffer)) > 0 ){
                outputStream.write(buffer, 0 ,length);
            }
            fileOutputStream.write(outputStream.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PicDownload("http://video.icoolxue.com/97853770?e=1539524858&token=66qv3jBbt6n2ODZRTS5YTnuhc3t18SyuClnpmz4C:kaiFpXhGzs0gINZpfT3etPjdF20=","1.mp3");
    }

}
