package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static List<User> linkedList;
    static User userNow;


    public static void main(String[] args) {

        linkedList=new LinkedList();
        userNow=new User();
        linkedList.add(userNow);
        printMain();

	// write your code here
    }

    private static void printMain() {
        System.out.println("1. sigh up");
        System.out.println("2. log in");
        System.out.println("3. log out");
        System.out.println("4. reverse string");
        System.out.println("0. exit");

        int userSelect=0;
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.print("enter your choice:");
        try {
            String userSelectString = bufferedReader.readLine();
            userSelect = Integer.valueOf(userSelectString);
        } catch (IOException e) {
            System.out.println("error reading...");
            printMain();
        }catch (NumberFormatException exception){
            System.out.println("must enter an integer");
            printMain();
        }
        System.out.println();

        switch (userSelect) {
            case 1:sighUp();
            break;
            case 2:logIn();
            break;
            case 3:logOut();
            break;
            case 4:reverseString();
            break;
            case 0:exitApp();
            break;
        }

//        try {
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void exitApp() {

    }

    private static void reverseString() {

        if(userNow.isLogIn==true) {
            String s = new String("");
            BufferedReader bufferedReader1 =
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter user text to reverse:");
            try {
                s = bufferedReader1.readLine();
            } catch (IOException e) {
                System.out.println("error reading...");
            }

            byte[] sBytes = s.getBytes();
            for (int i = sBytes.length-1; i >= 0; i--) {
                char c= (char) sBytes[i];
                System.out.print(c);
            }
            System.out.println();
        }
        else {
            System.out.println("please log in before");
        }
        printMain();
    }

    private static void logOut() {

        if(userNow.isLogIn==true) {
            userNow.isLogIn=false;
            System.out.println("successful logged out ");
        }
        else {
            System.out.println("you already log out");
        }
        printMain();
    }

    private static void logIn() {
        User user=new User();

        BufferedReader bufferedReader1 =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter user name:");
        try {
            user.name = bufferedReader1.readLine();
        } catch (IOException e) {
            System.out.println("error reading...");
        }

        BufferedReader bufferedReader2 =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter password:");
        try {
            user.password = bufferedReader2.readLine();
        } catch (IOException e) {
            System.out.println("error reading...");
        }
        User user1;
        int i = 0;
        for (; i <linkedList.size() ; i++) {
            user1=linkedList.get(i);
            if(user.name==user1.name&&user.password==user1.password){
             break;
           }
        }

       if (i<linkedList.size()) {

           user = linkedList.get(i);
           if (user.isLogIn == true) System.out.println("why do you want to log in again? you are log in already!");
           user.isLogIn = true;
           userNow = user;
       }
       else{
           System.out.println("name or password not exist");
           logIn();
       }
       printMain();
    }



    private static void sighUp() {
        User user1=new User();
        user1.setName(name());
        user1.setPassword(code());
        user1.isLogIn=true;
        linkedList.add(user1);
        System.out.println("welcome "+user1.name);
        userNow=user1;
        printMain();
    }

    private static String name() {
        String userSelectString="";

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter user name:");
        try {
            userSelectString = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("error reading...");
        }

        byte[] sBytes = userSelectString.getBytes();
        boolean legalName=true;
        for (int i = 0; i <sBytes.length ; i++) {
            if(sBytes[i]<97||sBytes[i]>122){
                for (int j = i; j < sBytes.length ; j++) {
                    if(sBytes[j]<48||sBytes[j]>57||j==0) {
                        legalName = false;
                        break;
                    }
                }
            }
            if(!legalName)break;
        }

        if(!legalName){
            System.out.println("error in user name");
            name();
        }
        User user1=new User();
        user1.name=userSelectString;
        if(linkedList.indexOf(user1)!=-1){
            System.out.println("user name is not available");
            name();
        }
//        try {
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return userSelectString;
    }

    private static String code() {
        String codeSelectString="";

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter your code:");
        try {
            codeSelectString = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("error reading...");
        }
        byte[] sBytes = codeSelectString.getBytes();
        boolean legalCode=true;
        int i = 0;
        for (; i <sBytes.length ; i++) {
            if(sBytes[i]<48||sBytes[i]>126) {
                legalCode = false;
                break;
            }
        }
        if(!legalCode||i<4||i>12){
            System.out.println("error in user code");
            code();
        }

//        try {
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return codeSelectString;
    }



}


