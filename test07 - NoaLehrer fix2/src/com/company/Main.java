package com.company;

import java.util.HashMap;
import java.util.Map;


public class Main {



    public static Map<String,Integer> map=new HashMap<>();
    public static final int SIZE = 1000;
    public static void main(String[] args) {

 //       Menu1 menu1=new Menu1(map);
  //      Menu menu =new Menu(map);

        map.put("and", 1);
        map.put("is", 1);
        map.put("this", 1);
        map.put("you", 1);
        String str = "this is an encrypted text and you should decrypt it";
        byte key = 13;
        byte[] bytes=new byte[SIZE];
        for (int i = 0; i < str.length(); i++) {
            bytes[i] = (byte) (str.getBytes()[i]+key);
        }
        DecryptionThread decryptionThread =
                new DecryptionThread(map, bytes, (byte) 0, (byte) 255, new FindIndexListener() {
                    @Override
                    public void find(byte index) {
                        System.out.println(index);
                    }
                });
        decryptionThread.start();

        try {
            decryptionThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
