package com.company;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import static com.company.GetMessagesThread.GET_MESSAGES;

/**
 * Created by hackeru on 3/29/2017.
 */
public class UploadImage extends Thread {

    public static final int PORT = 3000;
    public static final String SERVER_IP = "127.0.0.1";
    public static final int UPLOAD = 50;
    public static final int DOWNLOAD = 51;
    private boolean go = true;
    private int lastMessageReceived;
    File file;

    public UploadImage(File file) {
        this.file=file;
        lastMessageReceived=-1;
    }

    @Override
    public void run() {
        if(go) {
            go = false;
            Socket clientSocket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                clientSocket = new Socket(SERVER_IP, PORT);
                inputStream = new FileInputStream(file);
                outputStream = clientSocket.getOutputStream();
                outputStream.write(UPLOAD);
                outputStream.write(lastMessageReceived);
                byte[] buffer = new byte[2048];

                int length = 0;
 //               outputStream.write((int)(file.length()/2048));
                while ((length = inputStream.read(buffer)) != -1) {
                 //   System.out.println("Buffer Write of length: " + length);
                    outputStream.write(buffer, 0, length);
                }
                lastMessageReceived++;
                go = true;
            }
            catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null)
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (outputStream != null)
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (clientSocket != null)
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

        }
        else {
            System.out.println("try upload later");
        }
    }
}
