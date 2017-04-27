package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String,String> users=new HashMap<>();
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(3000);
            List<String> messages=new ArrayList<>();
            while(true){
                System.out.println("waiting for incoming communication");
                Socket socket = serverSocket.accept();
                System.out.println("client connected");
                ClientThread clientThread = new ClientThread(socket,messages,users);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
