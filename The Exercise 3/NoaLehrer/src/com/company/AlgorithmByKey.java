package com.company;

import com.sun.javafx.property.adapter.PropertyDescriptor;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.xml.bind.Marshaller.*;
import java.io.*;
import java.util.Random;


/**
 * Created by hackeru on 3/20/2017.
 */
abstract class AlgorithmByKey implements Algorithm,Key {
    public static final int ENCRYPTION = 1;
    public static final int DECRYPTION = 2;
    InputOutput inputOutput = new onScreen();
    static TIMEListener listener;

    public void setListener(TIMEListener listener){
    AlgorithmByKey.listener=listener;
    }
    public void detectStart(){
        if(listener != null)
            listener.StartDetect();
    }
    public void detectEnd(){
        if(listener != null)
            listener.EndDetect();
    }

    public void theAlgorithm(MyFile myFile, int type) {
        detectStart();
        MyFile newFile=myFile.createFile(type);
        int key;
        if(type==ENCRYPTION)key=insertKeyEncrypted();
        else key=insertKeyDecrypted();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            inputStream = new FileInputStream(myFile.file);
            outputStream=new FileOutputStream(newFile.file);
            byte[] buffer = new byte[1];
            int actuallyRead;
            while ((actuallyRead = inputStream.read(buffer)) != -1){
                if(type==ENCRYPTION)
                    buffer[0]=(byte)encrypt(buffer[0],key);
                else buffer[0]=(byte)decrypt(buffer[0],key);
                outputStream.write(buffer[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            myFile.closeInputStream(inputStream);
            myFile.closeOutputStream(outputStream);
        }
        detectEnd();

    }




    //todo:together
    @Override
    public int encrypt(int oneByte, int key) {
        return oneByte;
    }

    @Override
    public int decrypt(int oneByte, int key) {
        return oneByte;
    }




    public int insertKeyEncrypted() {
        Random random=new Random(System.currentTimeMillis());
        int num=random.nextInt(1000);
        inputOutput.getMessage("the key is:"+num);
        return num%255;
    }

    public int insertKeyDecrypted() {
        inputOutput.getMessage("please enter key");
        String stringKey=inputOutput.setMessage();
        int num=0;
        try {
            num=Integer.parseInt(stringKey);
        }
        catch (NumberFormatException e)
        {
            inputOutput.getMessage("not number!");
            insertKeyDecrypted();
        }
        return num%255;
    }

}

