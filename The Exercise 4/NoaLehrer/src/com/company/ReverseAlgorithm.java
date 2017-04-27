package com.company;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by hackeru on 3/22/2017.
 */
public class ReverseAlgorithm<T extends AlgorithmByKey> extends AlgorithmByKey{
    public static final int ENCRYPTION = 1;
    public static final int DECRYPTION = 2;

    T algorithm;

    public ReverseAlgorithm(T algorithm) {
        this.algorithm = algorithm;
    }

   @Override
   public void start(FileHandler fileHandler, int type) {
       FileHandler newFile= createFile(fileHandler,type);
       if(type==ENCRYPTION) {
           keyAlgorithm.insertKeyDecrypted();
           type = DECRYPTION;
       }
       else {
           keyAlgorithm.insertKeyEncrypted();
           type = ENCRYPTION;
       }
       algorithm.theAlgorithm(fileHandler,newFile,type);

   }

    @Override
    public void theAlgorithm(InputStream fileHandler, OutputStream newFile, int type) {
        if(type==ENCRYPTION)keyAlgorithm.insertKeyDecrypted();
        else keyAlgorithm.insertKeyEncrypted();
        if(type==ENCRYPTION)
            algorithm.theAlgorithm(fileHandler,newFile,DECRYPTION);
        else
            algorithm.theAlgorithm(fileHandler,newFile,ENCRYPTION);
    }

    @Override
    public int insertKeyDecrypted() {
        return super.insertKeyEncrypted();
    }

    @Override
    public int insertKeyEncrypted(){
        return super.insertKeyDecrypted();
    }



}
