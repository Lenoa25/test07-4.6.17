package com.company;


import java.io.*;

import java.net.URL;

public class Download {

    public static void start() throws Exception {

        try{
            File file1,file2;
            System.out.println("give image to download :");
            String fileName = Main.getInputFromUser();
            file1=new File(fileName);
            System.out.println("give path to write there :");
            String fileToWrite = Main.getInputFromUser();
            file2=new File(fileToWrite+'\\'+fileName.substring(fileName.lastIndexOf('\\'),fileName.length()));




            System.out.println("Downloading File From: " + file1.getName());




            InputStream inputStream = new FileInputStream(file1);
            OutputStream outputStream = new FileOutputStream(file2);
            byte[] buffer = new byte[2048];

            int length = 0;

            while ((length = inputStream.read(buffer)) != -1) {
                System.out.println("Buffer Write of length: " + length);
                outputStream.write(buffer, 0, length);

            }


            while ((length = inputStream.read(buffer)) != -1) {
                System.out.println("Buffer Read of length: " + length);


            }



            inputStream.close();
            outputStream.close();

        }catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}