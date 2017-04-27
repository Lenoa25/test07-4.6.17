package com.company;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Comparator;

/**
 * Created by hackeru on 2/27/2017.
 */
public class MyString implements Comparable<MyString> {

    final char[] chars;

    public MyString(char[] chars) {
        this.chars = chars;
    }


    int indexOf(MyString myString){
        int j = 0;
         for (int i = 0; i < chars.length-myString.chars.length; i++) {
             if(myString.chars[0]==chars[i]){
                 for ( j = 0; j <myString.chars.length ; j++) {
                     if(myString.chars[j]!=chars[i+j])break;
                 }
                 if(j==myString.chars.length)return i;
             }
         }
         return -1;
     }
     //איפה המילה במשפט, אם לא קיים -1
    // קוד שלא נופל, int מיקום ההתחלה

    MyString[] split(char c){
        int sum=1,index=0;
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]==c)sum++;
        }
        MyString[] myStrings=new MyString[sum];
        char[] ezer=new char[15];
        for (int i = 0,j=0; i <chars.length ; i++) {
            if(chars[i]==c)
            {
                myStrings[index++]=new MyString(ezer);
                j=0;
                continue;
            }
            ezer[j++]=chars[i];
        }
        myStrings[index]=new MyString(ezer);
        return myStrings;
    }

    // פירוק משפט לפי מילים כשנשלח רווח
    // אם התו בהתחלה או בסוף יוחזר אחד ריק


    private void toUpper() {
        for (int i = 0; i < this.chars.length; i++) {
            if (chars[i] > 90)
                chars[i] -= 32;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)return false;
        if(obj instanceof MyString) {
            MyString myString = (MyString) obj;
            return (indexOf(myString) == 0) && (myString.chars.length == this.chars.length);
        }
        return false;
    }



    @Override
    public int hashCode() {
        return chars.length*13^chars[0]*17^chars[chars.length]*23^chars[chars.length/2]*23;
    }

    public char[] getChars() {
        return chars;
    }


    @Override
    public int compareTo(MyString myString) {

        for (int i = 0; i < chars.length && i < myString.chars.length; i++) {
            if (chars[i] > myString.chars[i])
                return -1;
            if (chars[i] < myString.chars[i])
                return 1;
        }
        if (chars.length == myString.chars.length) return 0;
        if (chars.length < myString.chars.length) return 1;
        return -1;

    }
}
