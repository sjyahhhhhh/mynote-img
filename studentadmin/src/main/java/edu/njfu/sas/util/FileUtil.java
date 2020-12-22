package edu.njfu.sas.util;

import java.util.UUID;

public class FileUtil {
    public static String getStringFromInputStream(){
        return null;
    }
    public static String getRandomFileName(String fileName){
        /**
         * test.jpg
         * test-1234.jpg
         * uedit,百度出品
         */
        int index = fileName.lastIndexOf(".");
        String sffix = fileName.substring(index + 1);
        return fileName.substring(0,index)+"-"+UUID.randomUUID()+"."+sffix;
    }
}
