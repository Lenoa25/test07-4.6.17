package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/20/2017.
 */
public class MultiplicationAlgorithm extends AlgorithmByKey {



    @Override
    public int encrypt(int oneByte, int key) {
        return (key * oneByte) & 0x000000FF;
    }

    @Override
    public int decrypt(int oneByte, int key){
        return (changeKey(key)*oneByte) & 0x000000FF;
    }

    private int changeKey(int key) {
        int decKey = 0;
        for (int i = 0; i < 256; i++) {
            if(((i * key)& 0x000000FF) == 1) {
                decKey = i;
                break;
            }
        }
        return decKey;
    }

    @Override
    public int insertKeyDecrypted() {
        int key=super.insertKeyDecrypted();
        if(key%2==0)
        return key+1;
        return key;
    }

    @Override
    public int insertKeyEncrypted() {
        int key=super.insertKeyEncrypted();
        if(key%2==0)
            return key+1;
        return key;
    }
}
