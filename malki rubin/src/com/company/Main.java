package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TwoDimensionalArray t=new TwoDimensionalArray(7,3);
        t.set(1,2,100);
        System.out.println(t.get(1,2));

    }
}



class TwoDimensionalArray{
    //private int[][] arr;
    private int[] arr;
    private int rows;
    public TwoDimensionalArray(int rows, int columns){
        //arr = new int[rows][columns];
        arr = new int[rows * columns];
        this.rows=columns;
    }
    public void set(int row, int column, int value){
        //if(row >= arr.length || column >= arr[row].length)
            //throw new IndexOutOfBoundsException();
        //arr[row][column] = value;
        arr[rows*row+column]=value;

    }

    public int get(int row, int column){
        //if(row >= arr.length || column >= arr[row].length)
            //throw new IndexOutOfBoundsException();
        //return arr[row][column];
        return arr[rows*row+column];
    }


    public void print(){
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " : " +arr[i] + "  ");
        }



    }


}
