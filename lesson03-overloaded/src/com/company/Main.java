package com.company;

public class Main {

    public static void main(String[] args) {
	/*int x=5;
	Integer y= 6;
	int z=y;
        System.out.println(y+3);

        z = x;
        x++;
        System.out.println(z);

        Integer a=5;
        Integer b=a;
        a++;
        System.out.println(b);*/

	byte b=9;
	aMethod(b);
	aMethod(9);
	Integer i=9;
	aMethod(i);
	aMethod("9");

	//	aMethod(9); הקמפיילר מפחד לאבד מידע ולכן שגיאת קומפילציה

        //aMethod(9,10); טעות קומפילציה בגלל שהקומפיילר לא יודע איזה מהאפשרויות לבחור


    }
    //public static void aMethod(byte val){System.out.println("byte");}
    //public static void aMethod(short val){System.out.println("short");}

    public static void aMethod(int val){System.out.println("int");}
    public static void aMethod(short val){System.out.println("short");}
    public static void aMethod(Object val){System.out.println("object");}
    public static void aMethod(String val){System.out.println("String");}

    public static void aMethod(long val1,int val2){System.out.println("long,int");}
    public static void aMethod(int val1,long val2){System.out.println("int,long");}

}
