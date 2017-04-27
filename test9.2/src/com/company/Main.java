package com.company;

public class Main {

    public static void main(String[] args) {
	int[] arr={7,2,3,2,4,9,12,56};
 //       System.out.println(ex1.t1(arr,3));
        MyPriorityQueue m= new MyPriorityQueue(arr);
        System.out.println(m.getMax() );
    }
}
