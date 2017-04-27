package com.company;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Created by hackeru on 2/28/2017.
 */
 class MyFile {
    File file;

    public MyFile(String stringPath) {
        this.file = new File(stringPath);

    }

    public boolean check() {
        if (!file.canRead()) {
            System.out.println("path not exist, try again:");
            return false;
        }

        if (!file.exists()) {
            System.out.println("file not exist, try again:");
            return false;
        }
        return true;
    }

    public void closeOutputStream(OutputStream outputStream){
        if(outputStream != null)
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void closeInputStream(InputStream inputStream) {
        if (inputStream != null)
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
     public MyFile createFile(int type){
            File file = this.file;
            String newName;
            if(type==1)
                newName=file.getPath().substring(0,file.getPath().lastIndexOf('.'))+".encrypted.txt";
            else newName=file.getPath().substring(0,file.getPath().lastIndexOf('.'))+"_decrypted.txt";
            MyFile newFile=new MyFile(newName);
            return newFile;
        }


}
