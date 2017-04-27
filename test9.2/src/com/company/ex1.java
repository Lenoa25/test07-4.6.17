package com.company;

import java.util.Random;

/**
 * Created by hackeru on 2/9/2017.
 */
public class ex1 {


    static int t1(int[] arr,int m) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int[] binmap = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            binmap[arr[i]-min]++;
        }
        int sum = 0;
        int[] arr2 = new int[m];
        boolean flag = false;
        for (int i = 0, j = 0; i < binmap.length; i++) {
            if (binmap[i] > 0) {

                    if (j == m) {
                        j = 0;
                        flag = true;
                    }
                    if (flag) {
                        if (arr[j] - arr[j + 1] < sum) {
                            continue;
                        } else {
                            sum += i - arr2[j - 1];
                        }

                    }
                    arr2[j++] = i;
                }
            }

        return sum;


    }












    static int randomizedPartition(int[] arr, int low, int high){
        if(high == low)
            return low;
        Random random = new Random(System.currentTimeMillis());
        int pos = random.nextInt(high-low) + low;
        int temp = arr[high];
        arr[high] = arr[pos];
        arr[pos] = temp;
        return partition(arr, low, high);
    }

    static int quickSelect(int[] arr, int l, int r, int k){
        if(k>0 && k <= r-l+1){
            int pos = randomizedPartition(arr, l, r);
            if(pos-l == k-1)
                return arr[pos];
            if(pos-l > k-1)
                return quickSelect(arr, l, pos-1, k);
            return quickSelect(arr, pos+1, r, k-pos+l-1);
        }
        return Integer.MAX_VALUE;
    }













    static boolean containsPairWithSumX2(int[] arr, int sum){
        if(arr.length < 100)
            return containsPairWithSumX(arr, sum);
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }
        if(max-min > 10000)
            return containsPairWithSumX(arr, sum);
        boolean[] binmap = new boolean[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if(temp>=min && binmap[temp-min]){
                return true;
            }
            binmap[arr[i]-min] = true;
        }
        return false;
    }




    //O(nlgn)
    static boolean containsPairWithSumX(int[] arr, int sum){
        quickSort(arr, 0, arr.length-1);
        int l = 0,r = arr.length - 1;
        while (l < r){
            int temp = arr[l] + arr[r];
            if(temp == sum)
                return true;
            else if(temp < sum)
                l++;
            else
                r--;
        }
        return false;
    }


    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

}
