package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/20/2017.
 */
public class XorAlgorithm extends AlgorithmByKey {


    @Override
    public int encrypt(int oneByte, int key) {
        return oneByte^key;
    }

    @Override
    public int decrypt(int oneByte, int key){
        return oneByte^key;
    }
}
