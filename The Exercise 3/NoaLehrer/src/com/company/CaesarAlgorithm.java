package com.company;

import java.io.*;
import java.util.Random;

/**
 * Created by hackeru on 3/16/2017.
 */
public class CaesarAlgorithm extends AlgorithmByKey {



    @Override
    public int encrypt(int oneByte, int key) {
        return oneByte+key;
    }

    @Override
    public int decrypt(int oneByte, int key){
        return oneByte-key;
    }


}
