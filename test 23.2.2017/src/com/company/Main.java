package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,7,6,5,4};
        System.out.println(ifExist(arr));
        System.out.println(findLocation(arr, 0, arr.length - 1));
        System.out.println(findLocation2(arr, 0, arr.length - 1));

        int[] arr2 = {3, 4, 5, 6, 7, 9, 10, 4, 3, 2, 1};

        arr2 = sortMode2(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }
        System.out.println();




        Station[] stations = {
                new Station(1, 1),
                new Station(3, 1),
                new Station(1, 2),
                new Station(3, 4),
                new Station(4, 4),
                new Station(2, 3),
                new Station(4, 2),
                new Station(2, 3),
                new Station(1, 1),
                new Station(2, 2),
                new Station(3, 2),
                new Station(3, 1),
                new Station(2, 2),
                new Station(2, 2),
                new Station(4, 6)
        };
        System.out.println(Station.findStartingStation2(stations));
        System.out.println(Station.findStartingStation(stations));
//        int[] arr3;
//        Random random = new Random(System.currentTimeMillis());
//        for (int i = 0; i < 1000; i++) {
//            arr3 = new int[1 + random.nextInt(100)];
//            for (int j = 0; j < arr3.length; j++) {
//                arr3[j] = random.nextInt(1000)-500;
//            }
//           arr3= sortMode2(arr3);
//            if(!isEvenFirst(arr3)){
//                System.out.println("your code is wrong");
//                for (int k = 0; k < arr3.length; k++) {
//                    System.out.print(arr3[k] + ", ");
//                }
//                break;
//            }
//        }


        char[] chars={72,73,74,75,76,77,78,79,80};
        char[] chars1={76,77,78,79};
        char c=75;
        MyString myString=new MyString(chars);
        MyString myString1=new MyString(chars1);
        System.out.println(myString.indexOf(myString1));
        MyString[] myStrings=myString.split(c);
        System.out.println(myStrings[0].getChars());
       // System.out.println(myStrings[1].getChars());

    }


    static boolean isEvenFirst(int[] arr){
        boolean found = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] % 2 == 0){
                if(found)
                    return false;
            }else{
                found = true;
            }
        }
        return true;
    }





    public static boolean ifExist(int[] arr){
        if(arr.length==1)
            return true;
        int j = arr.length-1;
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i]>arr[i+1]){
                for (; j >i ; j--) {
                    if(arr[j]>arr[j-1])
                        return false;
                }
                if (j==i)
                    return true;
            }

        }
        return true;
    }

//אפשרות ב יותר טובה - אין צורך לבדוק:
    static int findLocation(int[] arr,int r,int l) {
        if(arr.length==1)
            return 0;

        if (r == l/2 || (l - r)/2== l)
            return check(arr,r,l);
        if (arr[r] > arr[l])
            return findLocation(arr, r, l / 2);
        else
            return findLocation(arr, (l - r) / 2, l);

    }

    private static int check(int[] arr, int r, int l) {
        for (int i = r; i < l; i++) {
            if(arr[i]>arr[i+1]) {
                return i;
            }
        }
        return l;
    }

    //בדוק אותי  :)

    static int findLocation2(int[] arr,int r,int l) {
        if(arr.length==1)
            return 0;

        if (r +1==l)
            if(arr[r]>arr[l])
                return r;
            else return l;
        if (arr[r] > arr[l])
            return findLocation2(arr, r, l-((l-r) / 2));
        else
            return findLocation2(arr, r+((l - r) / 2), l);

    }

    static int[] sortMode2(int[] arr){
        int numMode2=0;

        for (int i = 0,j=arr.length-1; i <arr.length ; i++) {
            if(arr[i]%2==1) {
                for (int k = j; k >= i; k--) {
                    if(k==i)
                        return arr;
                    if(arr[k]%2==0){
                        numMode2=arr[k];
                        arr[k]=arr[i];
                        arr[i]=numMode2;
                        j=k;
                        break;
                    }
                }
            }
        }
        return arr;
    }

}
