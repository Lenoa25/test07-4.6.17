package com.company;

import java.io.File;

/**
 * Created by hackeru on 3/29/2017.
 */
public class FileInformation {
    File file;
    int version;

    public FileInformation(String s) {
        version=-1;
        this.file=new File(s);
    }
}
