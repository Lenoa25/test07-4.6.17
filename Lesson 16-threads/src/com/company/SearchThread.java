package com.company;

public class SearchThread extends Thread {

    private int[] arr;
    private int from, to;
    private FoundListener listener;
    private boolean go = true;

    public SearchThread(int[] arr, int from, int to, FoundListener listener) {
        this.arr = arr;
        this.from = from;
        this.to = to;
        this.listener = listener;
    }

    @Override
    public void run() {
        int num=Integer.MIN_VALUE;
        for (int i = from; i <= to; i++) {
            if(!go) {
                System.out.println("stopped");
                return;
            }
            if(arr[i] > num){
                num=arr[i];
            }
        }
        if(listener != null)
            listener.found(num, this);
    }

    public interface FoundListener{
        void found(int index, SearchThread searchThread);
    }

    public void stopSearching(){
        go = false;
    }
}
