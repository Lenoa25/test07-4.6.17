package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }




    public static int sumOfDigit(int num)
    {
        int result=0;

           while (num!=0){
               int lastDigit=num%10;
               num/=10;
               result += lastDigit;
           }
           return result;
    }

    public static int largeOfDigit(int num)
    {
        int result=0;

        while (num!=0){
            int lastDigit=num%10;
            num/=10;
            if(lastDigit>result)
            result=lastDigit;
        }
        return result;
    }



    public static int reverseOfDigit(int num)
    {
        int result=0;

        while (num!=0){
            int lastDigit=num%10;
            num/=10;
            result*=10+lastDigit;
        }
        return result;
    }

    public static boolean is3(int num)
    {
        int c=num;
        while(c>9)
        {
            c=sumOfDigit(num);
        }
            return c==3||c==6||c==9;
    }

//    public static int reverse(int num)
//    {
//        int a=0;
//        if(num>9)
//        {
//            reverse(num/10);
//            a*=10+num%10;
//            return a;}
//        else
//            return a*10+num;
//    }
}
