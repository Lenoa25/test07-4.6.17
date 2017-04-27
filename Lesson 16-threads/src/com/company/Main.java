package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 6, 8, 4, 2, 4, 6, 9, 45, 87, 9, 0, 7, 5, 4};
        search(arr);
    }

    public static void search(int[] arr) {


        class SearchFoundListener implements SearchThread.FoundListener {
            boolean f = false;
            int maxNum;
            SearchThread thread1, thread2;

            public void setThread1(SearchThread thread1) {
                this.thread1 = thread1;
            }

            public void setThread2(SearchThread thread2) {
                this.thread2 = thread2;
            }

            @Override
            public void found(int num, SearchThread searchThread) {
                if (!f) {
                    f = true;
                    maxNum=num;
                } else {
                    if (num>maxNum) {
                        System.out.println("the max number is "+num);
                    } else {
                        System.out.println("the max number is "+maxNum);
                    }
                }
            }
        }


        SearchFoundListener listener = new SearchFoundListener();
        int n = arr.length - 1;
        SearchThread searchThread1 =
                new SearchThread(arr, 0, n / 2, listener);
        SearchThread searchThread2 =
                new SearchThread(arr, n / 2 + 1, n, listener);
        listener.setThread1(searchThread1);
        listener.setThread2(searchThread2);
        searchThread1.start();
        searchThread2.start();
    }
}



