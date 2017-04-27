package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by hackeru on 3/21/2017.
 */
public class NaggerThread extends Thread {

    int lastMessageReceive=-1;

    boolean alive;
    @Override
    public void run() {
        alive=true;
        while (alive){

            Socket socket = null;
            InputStream inputStream = null;
            OutputStream outputStream=null;
            try {
//                byte[] nameBytes = Main.user.name.getBytes();
//                byte[] passwordBytes = Main.user.name.getBytes();
                socket = new Socket(Main.SERVER, Main.PORT);
//                outputStream = socket.getOutputStream();
//                outputStream.write(nameBytes);
//                outputStream.write(null);
//                outputStream.write(passwordBytes);
//                outputStream.write(null);
                inputStream = socket.getInputStream();
                outputStream=socket.getOutputStream();
                byte[] lastMessageReceivedBytes = new byte[4];
                ByteBuffer.wrap(lastMessageReceivedBytes).putInt(lastMessageReceive+1);
                outputStream.write(lastMessageReceivedBytes);
                int messageLength;
                while ((messageLength=inputStream.read())!=-1){
                    byte[] messageBytes=new byte[messageLength];
                    inputStream.read(messageBytes);
                    String message=new String(messageBytes);
                    System.out.println(message);
                    lastMessageReceive++;
                }
//                byte[] meesegeBytes = new byte[40];
//                int actuallyRead = inputStream.read(resultBytes);
//                if (actuallyRead != -1) {
//                    inputStream.read(meesegeBytes);
//                    String messege = meesegeBytes.toString();
//                    System.out.println(messege);
//                }
                try {
                    this.sleep(500);
                } catch (InterruptedException e) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
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

    public void stopMessage(){
        alive=false;
        this.interrupt();

    }
}
