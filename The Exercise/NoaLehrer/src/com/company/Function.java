package com.company;

import java.util.Scanner;

/**
 * Created by hackeru on 2/28/2017.
 */
abstract class Option {
    MyFile myFile;
    public void start(){
        enterPath(0);
        act();

    }

    protected abstract void act();


    private void enterPath(int i) {
        System.out.println("enter path file:");
        Scanner scanner=new Scanner(System.in);
        String scannerString=scanner.next();
        myFile=new MyFile(scannerString);
        if(!myFile.check())
            enterPath(i++);
    }
}
