package com.company;
import java.io.*;


/**
 * Created by hackeru on 3/20/2017.
 */
abstract class AlgorithmByKey implements Algorithm {
    public static final int ENCRYPTION = 1;
    public static final int DECRYPTION = 2;
    InputOutput inputOutput = new onScreen();
    static TIMEListener listener;
    KeyAlgorithm keyAlgorithm=new KeyAlgorithm();
    boolean flag=false;

    public static void setListener(TIMEListener listener){
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

    public void start(FileHandler fileHandler, int type){
       
        FileHandler newFile= createFile(fileHandler,type);
        if(type==ENCRYPTION)keyAlgorithm.insertKeyEncrypted();
        else keyAlgorithm.insertKeyDecrypted();
        theAlgorithm(fileHandler.openFileInputStream(),newFile.openFileOutputStream(),type);

    }


    public void theAlgorithm(InputStream inputStream, OutputStream outputStream, int type) {
        detectStart();
        try{

            byte[] buffer = new byte[1];
            int actuallyRead;
            while ((actuallyRead = inputStream.read(buffer)) != -1){
                if(type==ENCRYPTION)
                    buffer[0]=(byte)encrypt(buffer[0],keyAlgorithm.key);
                else buffer[0]=(byte)decrypt(buffer[0],keyAlgorithm.key);
                outputStream.write(buffer[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        detectEnd();

    }


    @Override
    public int encrypt(int oneByte, int key) {
        return oneByte;
    }

    @Override
    public int decrypt(int oneByte, int key) {
        return oneByte;
    }



    public int insertKeyEncrypted() {
        keyAlgorithm.insertKeyEncrypted();

        return keyAlgorithm.getKey();
    }

    public int insertKeyDecrypted() {
        keyAlgorithm.insertKeyDecrypted();

        return keyAlgorithm.getKey();
    }

    protected FileHandler createFile(FileHandler fileHandler, int type) {
        if (type == 1)
            return fileHandler.createFile(".encrypted.txt");
        return fileHandler.createFile("_decrypted.txt");
    }
}

