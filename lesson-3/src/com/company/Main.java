package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    static void heapSort(int[] arr)
    {
        MyPriorityQueue myPriorityQueue=new MyPriorityQueue(arr);
        for (int i = 0; i <arr.length ; i++) {
            int max = myPriorityQueue.extractMax();
            arr[arr.length-1-i] = max;
        }
    }
}
