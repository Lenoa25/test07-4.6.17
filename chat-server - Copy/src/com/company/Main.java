package com.company;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final int PORT = 3000;
    public static final String PATHTOUPLOADINGFILE = "C:\\Users\\hackeru.HACKERU3\\Downloads\\abc.img";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            List< Message> messages = new ArrayList<>();
            Map<String, String> users = new HashMap<>();
            FileInformation file=new FileInformation(PATHTOUPLOADINGFILE);
            while(true){
                System.out.println("waiting for incoming communication...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected");
                ClientThread clientThread = new ClientThread(clientSocket, messages, users,file);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
