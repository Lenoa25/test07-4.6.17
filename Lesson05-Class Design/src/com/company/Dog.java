package com.company;

/**
 * Created by hackeru on 2/9/2017.
 */
public class Dog {
   private static int counter =0;
    public Dog() {
       counter++;
    }
    public static void mfunc() {
        System.out.println(counter);
    }
}
