package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("power:" + power2(2,3));
        System.out.println("sqrt :" +sqrt(15) );
        System.out.println("product :" + product(8,6) );
        drawRectangle(4,5,3,3);
    }
    //מרחק -חיסור
    static int distance(int x,int y)
    {
        int result =0;
        int large=y;
        int small = x;
        if(x>y) {
            large = x;
            small= y;
        }
        for (; small < large; small++,result ++)
        {}
        return result;
    }
    //כפל
    static int product(int x,int y)
    {
        int result =0;

        while(x>0) {
            if (x % 2 == 0) {
                x = x >> 1;
                y = y << 1;
            } else {
                x--;
                result += y;
            }
        }


        return result;


        /*
        int a=0;
        int large=y;
        int small = x;
        if(x>y) {
            large = x;
            small= y;
        }
        for (int i = 0; i <small ; i++) {
            a+=large;
        }
        return a;
        */
    }
    //מנה בחלוקה
    static int quotient(int x,int y)
    {
        if (y==0)
            return -1;
        int a=0;
        int i=y;
        for (; i <x ; i+=y) {
            a++;
        }
        return a;

    }
    // שארית החלוקה
    static int remainder(int x,int y)
    {
        if (y==0)
            return -1;
        return distance(x,product(quotient(x,y),y));

    }
    //חזקה בלולאה
    static int power1(int x,int y)
    {
      /*  if(x==0&&y==0)
            return -1
        if(y==0)
            return 0;
        if(x==0)
            return 1;
*/
        if(x==0) {
            if (y == 0)
                return -1;
            return 0;
        }
        if(y==0||x==1)
            return 1;
        int result=x;
        for (int i = 1; i <y ; i++) {
            result *=x;
        }
        return result;
    }
    //חזקה ברקורסיה
    static int power2(int x,int y)
    {
        if(x==0){
            if (y == 0)
                return -1;
            return 0;
        }
        if(y==0||x==1)
            return 1;
        return power2(x,y-1)*x;
    }
    //חזקה ביעילות גדולה יותר
    static int power3(int x,int y)
    {
        if(x==0){
            if (y == 0)
                return -1;
            return 0;
        }
        if(y==0||x==1)
            return 1;

        if(y%2==0)
        {
            int temp = power3(x,y/2);
            return temp*temp ;
        }
        else
        {
            int temp = power3(x,(y-1)/2);
            return temp*temp*x ;
        }
    }
    //שורש
    static int sqrt(int x)
    {
        int result=0;
        while(result*result <x)
            result ++;
        return result;
    }

    //n^2 סדרת פיבונצ'י
    static int fib1(int n)
    {
        if (n==1||n==2)
            return 1;
        return fib1(n-1)+fib1(n-2);
    }
    //סדרת פיבונצ'י n
    static int fib2(int n)
    {
        if (n==1||n==2)
            return 1;
       int a=0;
       int b=1;
       int c;
        for (int i = 2; i < n; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return b;
    }

    static void drawRectangle(int x,int y, int weight,int height)
    {
        for (int i = 0; i <y ; i++) {
            System.out.println("");
        }

            for (int z = 0; z < weight; z++)
            {
                for (int i = 0; i <x ; i++)
                {
                    System.out.print(" ");
                System.out.print("*");
                if(z==weight-1)
                {
                    System.out.println("");
                }
                for (int j = 0; j < height; j++) {
                    if (j == x || i == y)
                        System.out.print("*");
                }
            }

        }
    }
}
