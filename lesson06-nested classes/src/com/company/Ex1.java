package com.company;

import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/13/2017.
 */
public class Ex1 {
    static int[] num;
    static int[] k=new int[5];

    public Ex1(int[] num) {
        this.num = num;
        tryFunc();
    }

    public static void tryFunc() {

        int i = 0;
        for (; i < k.length; i++) {
            k[i] = num[i];
        }
        MyPriorityQueue myPriorityQueueK = new MyPriorityQueue(k);
//        while (num[i]>Integer.MIN_VALUE)
        while (i < num.length) {
            if (num[i] < myPriorityQueueK.getMax()) {
                myPriorityQueueK.extractMax();
                myPriorityQueueK.insert(num[i]);
            }
            i++;
        }
        print();
    }

    private static void print() {
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i] + " ");
        }
    }


}

