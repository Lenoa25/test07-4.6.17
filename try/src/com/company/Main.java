package com.company;

public class Main {

    public static void main(String[] args) {
	int[] arr={1,2,3,4};
        System.out.println(tryfun(arr));
    }
    public static int tryfun(int[] arr){
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i]*(i+1)*(arr.length-i);
        }
//        if(arr.length%2==0)
//            return sum*(arr.length+1);
//        return sum*arr.length+sum-arr[0]-arr[arr.length];
        return sum;
    }

}
