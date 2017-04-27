package com.company;

/**
 * Created by hackeru on 3/22/2017.
 */


public class Factory {
    public static final String CAESAR = "1";
    public static final String XOR = "2";
    public static final String MULTIPLICATION = "3";
    public static final String REVERSE = "4";

    ReverseAlgorithm reverseAlgorithm;

    public AlgorithmByKey chooseAlgorithm(String select){
        switch (select){
            case CAESAR:
                return new CaesarAlgorithm();
            case XOR:
                return new XorAlgorithm();
            case MULTIPLICATION:
                return new  MultiplicationAlgorithm();
            case REVERSE:
                chooseAlgorithmToReverse();
                return reverseAlgorithm;
        }
        return null;
    }

    private void chooseAlgorithmToReverse() {
        reverseAlgorithm=new ReverseAlgorithm();
        Menu.inputOutput.getMessage("please enter algorithm : \n1. Caesar Algorithm \n2. Xor Algorithm \n3. Multiplication Algorithm");
        reverseAlgorithm.algorithm=chooseAlgorithm(Menu.inputOutput.setMessage());
        if(reverseAlgorithm.algorithm==null)chooseAlgorithmToReverse();
    }
}
