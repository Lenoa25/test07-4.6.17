package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Created by hackeru on 2/28/2017.
 */
 class MyFile {
    File file;

    public MyFile(String stringPath) {
        this.file = new File(stringPath);

    }

    public boolean check() {
        if (!file.canRead()) {
            System.out.println("path not exist, try again:");
            return false;
        }
        if (!file.exists()) {
            System.out.println("file not exist, try again:");
            return false;
        }
        return true;
    }
}
