package com.company;

import graphicshape.Shape;
import graphicshape.Square;
import javafx.scene.shape.Circle;

public class Main {

    public static void main(String[] args) {

        Circle circle1 =new Circle();
       // System.out.println(circle1.x);
        System.out.println(circle1.toString());

        HappyBirthday.wish();


        Number[] nums={5,7,4.3f,new Double((3)),new RationalNumber(5,2)};
        System.out.println(sum(nums));


        Shape s=new Square(6);
        //s.setSide(7);
        System.out.println(s.area());



    }
    // סכמתי איברים שאיני יודע איזה סוג הם
    public static double sum(Number[] nums)
    {
        double sum=0.0;
//        for (int i = 0; i < nums.length; i++) {
//            Number num =nums[i];
//            sum+=num.doubleValue();
//        }
        for(Number num:nums){
            sum+=num.doubleValue();
        }
        return sum;
    }




}
