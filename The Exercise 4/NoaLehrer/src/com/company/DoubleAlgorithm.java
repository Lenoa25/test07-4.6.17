package com.company;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by hackeru on 3/22/2017.
 */
public class DoubleAlgorithm<T extends AlgorithmByKey> extends AlgorithmByKey {
    T firstAlgorithm;
    T secondAlgorithm;

    public DoubleAlgorithm(T firstAlgorithm, T secondAlgorithm) {
        this.firstAlgorithm = firstAlgorithm;
        this.secondAlgorithm = secondAlgorithm;
    }

    @Override
    public void start(FileHandler fileHandler, int type) {
        FileHandler file = renameFile(fileHandler, type);
        theAlgorithm(fileHandler,file,type);

    }

    @Override
    public void theAlgorithm(InputStream fileHandler, OutputStream newFile, int type) {
        first(firstAlgorithm,secondAlgorithm, fileHandler, type);
        FileHandler file = renameFile(fileHandler, type);
        first(secondAlgorithm,firstAlgorithm, file, type);

        file.file.delete();

    }


    private FileHandler renameFile(FileHandler fileHandler, int type) {
        String newName= fileHandler.file.getPath().substring(0, fileHandler.file.getPath().lastIndexOf('.'));
        if(type==1)
            newName+=".encrypted.txt";
        else newName+="_decrypted.txt";
        return new FileHandler(newName);
    }

    private void first(AlgorithmByKey firstAlgorithm, AlgorithmByKey secondAlgorithm, FileHandler fileHandler, int type) {
        if(type==1)
            firstAlgorithm.start(fileHandler, type);
        else secondAlgorithm.start(fileHandler, type);
    }


}
