package com.company;

import java.security.InvalidParameterException;

public class MyPriorityQueue {
    private int[] arr;
    private int size;

    public MyPriorityQueue(){
        arr = new int[10];
        size = 0;
    }

    public MyPriorityQueue(int[] arr){
//        this.arr = arr;
//        size = arr.length;
        for (int i = size/2; i >= 0; i--) {
            heapify(ex1.quickSelect(arr,arr.length,0,arr.length/2));
        }
    }

    private void heapify(int i){
        int smallest = i;
        int l = leftChild(i);
        int r = rightChild(i);
        if(l<size && arr[l] < arr[smallest])
            smallest = l;
        if(r<size && arr[r] < arr[smallest])
            smallest = r;
        if(smallest != i){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(smallest);
        }
    }

    private void bubbleUp(int i){
        int p;
        while(i != 0 && arr[(p=parent(i))] > arr[i]){
            int temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
            i = p;
        }
    }


    private int leftChild(int i){
        return 2*i + 1;
    }

    private int rightChild(int i){
        return 2*i + 2;
    }

    private int parent(int i){
        return (i-1)/2;
    }








    public void increase(int i, int addition){
        if(addition < 0 || i >= size || i < 0)
            throw new InvalidParameterException();
        arr[i] += addition;
        bubbleUp(i);
    }


    public void delete(int i){
        increase(i, Integer.MAX_VALUE - arr[i]);
        extractMax();
    }

    public void insert(int x){
        if(size == arr.length){
            int[] temp = new int[size * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
           int i = size;
        size++;
        arr[i] = x;
        bubbleUp(i);
    }












    public int getMax(){
        if(size == 0)
            throw new IndexOutOfBoundsException();

        int result = arr[0];
        for (int i = 1; i < size; i++) {
            if(arr[i] > result)
                result = arr[i];
        }
        return result;
    }

    //size--
    //34 123 5 23 5  6 45 34 5 2 2
    public int extractMax(){
        if(size == 0)
            throw new IndexOutOfBoundsException();

        if(size == 1){
            size--;
            return arr[0];
        }
        int max = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapify(0);
        return max;
    }

    public int getSize(){
        return size;
    }

}
