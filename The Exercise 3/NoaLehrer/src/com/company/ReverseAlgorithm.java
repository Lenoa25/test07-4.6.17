package com.company;

/**
 * Created by hackeru on 3/22/2017.
 */
public class ReverseAlgorithm extends AlgorithmByKey{
    public static final int ENCRYPTION = 1;
    public static final int DECRYPTION = 2;
    AlgorithmByKey algorithm;
   @Override
   public void theAlgorithm(MyFile myFile, int type) {
       if(type==ENCRYPTION)
           algorithm.theAlgorithm(myFile,DECRYPTION);
       else
           algorithm.theAlgorithm(myFile,ENCRYPTION);
   }

}
