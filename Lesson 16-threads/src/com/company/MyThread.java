package com.company;

public class MyThread extends Thread {


    @Override
    public void run() {
        System.out.println("do long running stuff");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done doing long running stuff");
    }
}
