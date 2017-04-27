package com.company;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Main {

    public static final int PORT = 3000;

    //Socket Client
    public static void main(String[] args) {
       go();

    }

    private static void go() {
        int a=readInput();
        int b=readInput();
        char operator=getOperator();
        if((b==0)&&(operator=='/'||operator=='%')){
            System.out.println("you write 0- not illegal");
            go();
        }

        byte[] Abytes=new byte[4],Bbytes=new byte[4];
        ByteBuffer.wrap(Abytes).putInt(a);
        ByteBuffer.wrap(Bbytes).putInt(b);


        try {
            Socket socket = new Socket("127.0.0.1", PORT);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(Abytes);
            outputStream.write(Bbytes);
            outputStream.write(operator);
            byte[] buffer = new byte[1024];
            int actuallyRead = inputStream.read(buffer);
            int result = ByteBuffer.wrap(buffer).getInt();
            System.out.println(result);
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        again();
    }

    private static void again() {
        System.out.println("do you want again? press 1");
        if(readInput()==1){go();}

    }


    private static char getOperator() {
        System.out.println("enter an operator:");
        char input='+' ;
        String s;
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in));
            if((s=bufferedReader.readLine())!=null) {
               input=s.toCharArray()[0];
                    if(input!='*'&&input!='/'&&input!='-'&&input!='+'&&input!='%'){
                        System.out.println("dont operator!");
                        readInput();
                    }
            }
            else {
                System.out.println("you dont write anything");
                readInput();}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static int readInput() {
        System.out.println("enter a number:");
        int input = 0;
        byte[] bytes=new byte[4];
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in));
            if((bytes=bufferedReader.readLine().getBytes())!=null) {
                for (int i = 0; i <bytes.length ; i++) {
                    if(bytes[i]<48||bytes[i]>57){
                        System.out.println("dont number!");
                        readInput();
                    }
                 input=input*10+(bytes[i]-48);
                }
            }
            else {
                System.out.println("you dont write anything");
                readInput();}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }


}

//הרצה מחוץ לאינטילג'יי
//jar