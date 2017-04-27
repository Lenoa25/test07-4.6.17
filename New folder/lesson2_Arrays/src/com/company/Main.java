package com.company;


public class Main {

    public static void main(String[] args) {

        int[] arr = {3, 6, 2, 5};


        int x = 5;
        int y = x;
        x = 6;

        int[] arr2 = arr;
        arr[0] = 4;
        bubbleSort(arr);

        printArray(arr);

        System.out.println(binarySearch(arr, 0, arr.length - 1, 2));

        drowrectangel(3,3,3,3);

    }

    static int binarySearch(int[] arr, int left, int right, int x) {
        if (right >= left) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == x)
                return middle;
            if (arr[middle] < x)
                return binarySearch(arr, middle + 1, right, x);
            return binarySearch(arr, left, middle - 1, x);
        }
        return -1;
    }


    static void bubbleSort(int[] arr) {
        int upTo = arr.length - 1;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < upTo; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
            upTo--;
        }
    }

    static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    //7
    //2 7 3 8 2 5 3 9 34
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
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

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int quickSelect(int[] arr, int low, int high, int k) {
        if (low < high) {
            int p = partition(arr, low, high);
            if (p - l == k - 1)
                return arr[p];
            if (p - l > k - 1)
                return quickSelect(arr, low, p - 1, k);
            else
                return quickSelect(arr, p + 1, high, k - p + l - 1);
        }
        return -1;
    }


    static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(",");
        }
        System.out.println("}");
    }



    static void drowrectangel(int x,int y, int weight,int height)
    {
        for (int i = 0; i <y ; i++) {
            System.out.println("");
        }
        for (int i = 0; i <x ; i++)
        {
            System.out.print(" ");
        for (int z = x; z < weight; z++)
        {
            System.out.print("*");
                if(z==weight)
                {
                    System.out.println("");
                }
            for (int j = y; j < height; j--) {
                if (j == x || i == y)
                    System.out.print("*");
            }
        }

        }
    }
}



