package com.company;

import java.io.*;

/**
 * Created by hackeru on 2/28/2017.
 */
 class FileHandler {
    File file;

    public FileHandler(String stringPath) {
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

    public InputStream openFileInputStream(){
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public OutputStream openFileOutputStream(){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return outputStream;
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
     public FileHandler createFile(String end){
            String newName;
                newName=this.file.getPath().substring(0,this.file.getPath().lastIndexOf('.'))+end;
            FileHandler newFile=new FileHandler(newName);
            return newFile;
        }


}
