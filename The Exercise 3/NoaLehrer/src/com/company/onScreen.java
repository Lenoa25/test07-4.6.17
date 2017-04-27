package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hackeru on 3/16/2017.
 */
public class onScreen implements InputOutput {
    @Override
    public void getMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String setMessage() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
