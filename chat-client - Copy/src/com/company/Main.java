package com.company;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import static com.company.GetMessagesThread.*;

public class Main {

    public static final int UPLOAD = 50;
    public static final int DOWNLOAD = 51;

    public static void main(String[] args) {
      /*  String input;
        User user = null;
        while(true) {
            if ((user = menu()) == null)
                return;
            else {
                if (checkUser(user))
                    break;
                else
                    System.out.println(
                            user.getAction()==SIGN_UP ?
                                    "username taken" :
                                    "username or password are incorrect");
            }
        }

        System.out.println("welcome.");
        GetMessagesThread getMessagesThread = new GetMessagesThread(user);
	    getMessagesThread.start();


	    while(!(input = getInputFromUser()).equals("exit")){
            Socket clientSocket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try{
                clientSocket = new Socket(SERVER_IP, PORT);
                inputStream = clientSocket.getInputStream();
                outputStream = clientSocket.getOutputStream();
                outputStream.write(SEND_MESSAGE);
                user.stream(outputStream);
                byte[] inputBytes = input.getBytes();
                outputStream.write(inputBytes.length);
                outputStream.write(inputBytes);
                int result = inputStream.read();
                if(result != OKAY)
                    System.out.println("error sending message");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	    getMessagesThread.stopGettingMessages();
	    */
//      Download download=new Download();
//        try {
//            download.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        menuDownload();
    }

    private static boolean checkUser(User user) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket(SERVER_IP, PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            outputStream.write(user.getAction());
            user.stream(outputStream);
            int result = inputStream.read();
            return result == OKAY;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        return false;
    }

    private static User menu() {
        String input;
        System.out.println("please choose:");
        System.out.println("1. sign up");
        System.out.println("2. login");
        System.out.println("at any point, type 'exit' to exit this program");
        input = getInputFromUser();
        int action = 0;
        while(action == 0){
            switch (input){
                case "1":
                    action = SIGN_UP;
                    break;
                case "2":
                    action = LOGIN;
                    break;
                case "exit":
                    System.out.println("c u later!");
                    return null;
                default:
                    System.out.println("invalid choice. try again");

            }
        }
        System.out.println("please enter user name:");
        String userName = getInputFromUser();
        if(userName.equals("exit"))
            return null;
        //TODO: loop until valid user name
        System.out.println("please enter password:");
        String password = getInputFromUser();
        if(password.equals("exit"))
            return null;
        return new User(userName, password, action);
    }

    private static void menuDownload() {
        String input;
        System.out.println("please choose:");
        System.out.println("1. upload");
        System.out.println("2. download");
        System.out.println("at any point, type 'exit' to exit this program");
        input = getInputFromUser();
        int action = 0;
        while (action == 0) {
            switch (input) {
                case "1":
                    read(UPLOAD);
                    break;
                case "2":
                    write(DOWNLOAD);
                    break;
                case "exit":
                    System.out.println("c u later!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice. try again");
                    break;
            }
            menuDownload();
        }

    }

    private static void write(int download) {
        File file;
        System.out.println("give path to download :");
        String fileName = Main.getInputFromUser();
        file=new File(fileName);
        if (!file.exists()){
            System.out.println("not exist");
            write(download);
        }
        DownloadImage downloadImage =new DownloadImage(file,new User("noa","1234",0));
        downloadImage.start();
        System.out.println("success to download");
    }

    private static void read(int upload) {
        File file;
        System.out.println("give image to download :");
        String fileName = Main.getInputFromUser();
        file=new File(fileName);
        if (!file.exists()&&(!file.isFile())){
            System.out.println("invalid input");
            read(upload);
        }
        UploadImage uploadImage = new UploadImage(file);
        uploadImage.start();
        System.out.println("success to upload");
    }

    static String getInputFromUser(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
