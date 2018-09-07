package com.spider.demo.utils;

import java.io.*;
import java.net.URI;
import java.net.URL;

public class ImageUtils {

    public static final String DOWNLOAD_PATH = "C:/Users/zj/Desktop/spidertest";
    public static final String PIC_NAME_PRE = "/test_";

    public static void PicDownload(String picUrl, String name){
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
        PicDownload("https://img03.sogoucdn.com/app/a/100520093/013d20860a59d114-df5b4a05f7c173f3-7e866343d6ed14122f7512cd53e13aad.jpg","1.jpg");
    }

}
