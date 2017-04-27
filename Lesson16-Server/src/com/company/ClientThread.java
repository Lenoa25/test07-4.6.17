package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ClientThread extends Thread {

    Socket clientSocket;
    InputStream inputStream;
    OutputStream outputStream;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            int actuallyRead=0,a=0,b=0;
            char operator='+';
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            byte[] buffer = new byte[4],buffer2 = new byte[4],Abytes = new byte[4];

            if ((actuallyRead = inputStream.read(buffer))!=-1){
                a = ByteBuffer.wrap(buffer).getInt();
            }
            if ((actuallyRead = inputStream.read(buffer))!=-1) {
                b = ByteBuffer.wrap(buffer).getInt();
            }
            if ((actuallyRead = inputStream.read(buffer2))!=-1) {
                switch (buffer2[0]) {
                    case '*':
                        a *= b;
                        break;
                    case '/':
                        if((b==0))outputStream.close();
                        a /= b;
                        break;
                    case '+':
                        a += b;
                        break;
                    case '-':
                        a -= b;
                        break;
                    case '%':
                        if((b==0))outputStream.close();
                        a %= b;
                        break;
                }
            }
            ByteBuffer.wrap(Abytes).putInt(a);

            outputStream.write(Abytes);

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
            if(clientSocket != null)
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
