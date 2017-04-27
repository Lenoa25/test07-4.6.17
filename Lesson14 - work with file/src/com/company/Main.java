package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class Main {
    static File file;
    public static void main(String[] args) {

        file = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\noalehrer\\MyFile.txt");
        OutputStream outputStream = null;
        int num;
        try {
            outputStream = new FileOutputStream(file);
//            outputStream.write("good".getBytes());
//            outputStream.write(" ".getBytes());
//            outputStream.write("lack!".getBytes());
            Random random=new Random(System.currentTimeMillis());
            int numRandom=random.nextInt(100000)+100000;
            for (int i = 0; i < numRandom; i++) {
                num=random.nextInt(1000000);
                byte[] aBytes = new byte[4];
                ByteBuffer.wrap(aBytes).putInt(num);
                for (int j = 0; j <4 ; j++) {
                    outputStream.write(aBytes[j]);
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);

            byte[] buffer = new byte[4];
            /*int actuallyRead = inputStream.read(buffer);
            if(actuallyRead != -1){
                String s = new String(buffer, 0, actuallyRead);
                System.out.println(s);
            }*/
            int actuallyRead;
            int bigNum=0,b;
            //StringBuilder stringBuilder = new StringBuilder();
            String s;
            while ((actuallyRead = inputStream.read(buffer)) != -1) {
                b = ByteBuffer.wrap(buffer).getInt();
                if(b>bigNum)
                    bigNum=b;
            }


           System.out.println(bigNum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


        File file1=new File("C:\\Users\\hackeru.HACKERU3\\Documents");

  //      System.out.println(isFile(file1,"MyFile"));

    }
    public void add(String s){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(s.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
//
//    public static boolean isFile(File directory,String file ){
//        if(!directory.isDirectory())
//            return false;
//
//
//        File[] files=directory.listFiles();
//        int i=0;
//        for (; i <files.length-1 ; i++) {
//            if(files[i].toString()==file)
//            return true;
//
//        }
//
//        return isFile(files[i],file);
//    }




}






