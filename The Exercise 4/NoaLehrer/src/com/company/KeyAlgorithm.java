package com.company;

import java.io.*;
import java.util.Random;

/**
 * Created by hackeru on 3/22/2017.
 */
public class KeyAlgorithm implements Key,Serializable {
    int key;
    FileHandler fileHandler =new FileHandler("C:\\Users\\hackeru.HACKERU3\\Documents\\noalehrer\\key.bin");

    @Override
    public int insertKeyDecrypted() {

        InputStream inputStream = null;
        try {
            inputStream=new FileInputStream(fileHandler.file);
            setKey(inputStream.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fileHandler.closeInputStream(inputStream);
        }
        Menu.inputOutput.getMessage("the key is:"+key);
        return key;
    }

    @Override
    public int insertKeyEncrypted(){
        int keyAddition=insertKeyDecrypted();
        if(keyAddition==0) {
            Random random;
            random = new Random(System.currentTimeMillis());
            key = random.nextInt(255);
            Menu.inputOutput.getMessage("the key is:" + key);
        }
        OutputStream outputStream = null;
        try {
            outputStream=new FileOutputStream(fileHandler.file);
            if(keyAddition!=0)
            outputStream.write(keyAddition);
            outputStream.write(getKey());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fileHandler.closeOutputStream(outputStream);
        }
        return key;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
