package com.company;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class Main {
    public static final int SEND_MESSAGE = 100;
    public static final int GET_MESSAGE = 101;
    public static final int OKAY = 90;

    public static final String SERVER = "10.0.11.4";
    public static final int PORT = 3000;
    public static final String EXIT = "exit";
    public static User user;

    public static void main(String[] args) {
       // login();

        System.out.println("choose \n1.sigh up \n2. login \n'exit' to exit the program");;

        NaggerThread naggerThread=new NaggerThread();
        naggerThread.start();






        String input;
        while (!(input=getInputFromUser()).equals(EXIT)) {
            switch (input) {
                case "1":login();
                sendToServerLogin(1);
                    break;
                case "2":
                    login();
                    sendToServerLogin(2);
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        }
        System.out.println("bye bye, see you later.");

    }
    private static void sendToServerEvery(){


    }

    private static void sendToServer(String massage) {
//        byte[] nameBytes = user.name.getBytes();
//        byte[] passwordBytes = user.name.getBytes();
//        byte[] messegeBytes = messege.getBytes();
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream=null;
        try{
            socket = new Socket(SERVER, PORT);

            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            outputStream.write(SEND_MESSAGE);
            byte[] inputBytes = massage.getBytes();
            outputStream.write(inputBytes.length);
            outputStream.write(inputBytes);
            int result = inputStream.read();
            if(result != OKAY)
                System.out.println("error sending message");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }



    private static String getInputFromUser(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static void login(){
        user = new User();
        System.out.println("name: ");
        user.name=getInputFromUser();
        System.out.println("password: ");
        user.password=getInputFromUser();
        System.out.println("login succeed");
    }
    private static void sendToServerLogin(int logOrSigh) {
        byte[] nameBytes = user.name.getBytes();
        byte[] passwordBytes = user.name.getBytes();

        Socket socket = null;
        InputStream inputStream =null;
        OutputStream outputStream = null;
        try{
            socket = new Socket(SERVER, PORT);
            inputStream=socket.getInputStream();
            outputStream = socket.getOutputStream();

            outputStream.write(logOrSigh);
            outputStream.write(nameBytes);
            outputStream.write(passwordBytes);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}