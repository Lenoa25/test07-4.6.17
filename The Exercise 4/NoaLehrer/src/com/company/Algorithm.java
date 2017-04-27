package com.company;

import java.util.Scanner;

/**
 * Created by hackeru on 2/28/2017.
 */
public interface Algorithm {

    public int encrypt(int oneByte, int key);
    public int decrypt(int oneByte, int key);
}
