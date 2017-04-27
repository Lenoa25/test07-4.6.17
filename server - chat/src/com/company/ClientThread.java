
package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;


public class ClientThread extends Thread {


    public static final int SEND_MESSAGE = 100;
    public static final int GET_MESSAGE = 101;
    public static final int SIGH_UP=102;
    public static final int LOGIN=103;
    public static final int OKAY = 90;
    public static final int FAILURE= 91;
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private List<String> messages;
    private Map<String,String> users;

    public ClientThread(Socket clientSocket,List<String> messages,Map<String,String> users) {
        this.clientSocket = clientSocket;
        this.messages=messages;
        this.users=users;
        inputStream = null;
        outputStream = null;
    }

    @Override
    public void run() {
        try{
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            int action = inputStream.read();

            switch (action){
                case SEND_MESSAGE:
                    sendMassage();
                    break;
                case GET_MESSAGE:
                    getMassage();
                    break;
                case SIGH_UP:
                    sighUp();
                    break;
                case LOGIN:
                    logIn();
                    break;
            }



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

    private void logIn() throws IOException {
        User user=readUserFromString();
        outputStream.write(validUser(user)?OKAY:FAILURE);
    }

    private boolean validUser(User user){
        if(user==null)return false;
        String existingPassword=users.get(user.getUserName());
        return existingPassword!=null&&
                existingPassword.equals(user.getPassword());
    }

    private void sighUp() throws IOException {
        User user=readUserFromString();
        if(user==null)return;
        boolean success=false;
        synchronized (users){
            if(users.containsKey(user.getUserName())){
                users.put(user.getUserName(),user.getPassword());
                success=true;
            }
        }
        outputStream.write(success?OKAY:FAILURE);

    }

    private void getMassage() throws IOException {
        User user=readUserFromString();
        if(!validUser(user))return;

        int messageLength=inputStream.read();
        if(messageLength==-1)
            return;
        byte[] messageBytes = new byte[messageLength];
        int actuallyRead=inputStream.read(messageBytes);
        if(actuallyRead!=messageLength)
            return;
        String message=new String(messageBytes);
        messages.add(message);
        outputStream.write(OKAY);

    }

    private void sendMassage() throws IOException {
        User user=readUserFromString();
        if(!validUser(user))return;

        byte[] messageFromBytes=new byte[4];
        int actuallyRead=inputStream.read(messageFromBytes);
        if(actuallyRead!=4)
            return;
        int messageFrom=ByteBuffer.wrap(messageFromBytes).getInt();
        for (int i = messageFrom; i < messages.size(); i++) {
            String massage=messages.get(i);
            byte[] messageBytes=massage.getBytes();
            outputStream.write(messageBytes.length);
            outputStream.write(messageBytes);
        }

    }
    private User readUserFromString() throws IOException {
        User user=new User();
        int userNameLength=inputStream.read();
        if(userNameLength==-1)
            return null;
        byte[] userNameBytes=new byte[userNameLength];
        int actuallyRead=inputStream.read(userNameBytes);
        if(actuallyRead!=userNameLength)
            return null;
        user.setUserName(new String(userNameBytes));

        int userPasswordLength=inputStream.read();
        if(userPasswordLength==-1)
            return null;
        byte[] userPasswordBytes=new byte[userPasswordLength];
        actuallyRead=inputStream.read(userPasswordBytes);
        if(actuallyRead!=userPasswordLength)
            return null;
        user.setPassword(new String(userPasswordBytes));

        return user;
    }

}
