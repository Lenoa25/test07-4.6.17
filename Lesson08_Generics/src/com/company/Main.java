package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int ASCII_0 = 48;
    public static final int ASCII_9 = 57;
    public static final int ASCII_ = 45;


    public static void main(String[] args) {

         /*
        LinkedList<Dog> linkedList = new LinkedList<Dog>();
        linkedList.add(new Dog());
        LinkedList<Cat> cats = new LinkedList<>();
        //linkedList.add(new Cat());
        //Cat c = (Cat)linkedList.get(0);
        Pair<Dog, Cat> pair = new Pair<>(new Dog(), new Cat());
        Pair<Dog, Dog> pair2 = new Pair<>(new Dog(), new Dog());
        //raw types
        List list = new LinkedList<Object>();
        list.add("First");
        list.add("Second");
        list.add(123);
        List<String> strings = list;
        List<Integer> ints = list;
        //String s = strings.get(2);
        //System.out.println(s);
        //Integer i = ints.get(1);
        //System.out.println(i);
        Animal a = new Dog();
        Dog d = (Dog)a;
        LinkedList<Animal> animals = new LinkedList<Animal>();
        LinkedList animals2 = animals;
        LinkedList<Animal> animals3 = animals2;
        //animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Dog());
        LinkedList<Dog> dogs = new LinkedList<>();
        for (int j = 0; j < animals.size(); j++) {
            dogs.add((Dog)animals.get(j));
        }
        List<?> list2 = animals;
        System.out.println(list2.get(0));
        Pair<?, ?> pair1 = new Pair<Integer, Integer>();
        Integer integer = (Integer) pair1.getObject1();
//        pair1.setObject1(integer);
        */


        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please enter your name:");
        try {
            //String name = bufferedReader.readLine();
            //System.out.println("your name is: " + name);
            String ageAsString = bufferedReader.readLine();
            int age = Integer.valueOf(ageAsString);
            System.out.println("your age is: " + age);
        } catch (IOException e) {
            System.out.println("error reading...");
        }catch (NumberFormatException exception){
            System.out.println("must enter an integer");
        }


        String s = "hello";
        byte[] sBytes = s.getBytes();
        char c = (char)sBytes[0];
        System.out.println(sBytes[0]);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }





        isInt("555");
        System.out.println(toInt("-999"));
    }


    public static boolean isInt (String num){
        if(num==null||num.length()==0)
            return false;
        byte[] numBytes=num.getBytes();
        for (int i = 0; i <numBytes.length ; i++) {
            if(numBytes[0]== ASCII_) {
                i++;
            }
            if(numBytes[i]> ASCII_9 ||numBytes[i]< ASCII_0)
            return false;
        }
        return true;
    }


    public  static int toInt(String num){
        byte[] numBytes=num.getBytes();
        int number=0,length= numBytes.length;
        boolean isNegetive=false;
        for (int i=0; i <length ; i++) {
            if(numBytes[i]== ASCII_) {
                i++;
                isNegetive=true;
            }
            number=(number*10)+(numBytes[i]-ASCII_0);
        }
        if(isNegetive)return number*-1;
        return number;
    }


    public static <T> void fill(List<T> list, int quantity, T obj){
        for (int i = 0; i < quantity; i++) {
            list.add(obj);
        }
    }

}



class Animal{

}

class Dog extends Animal{

}
class Cat extends Animal{

}

