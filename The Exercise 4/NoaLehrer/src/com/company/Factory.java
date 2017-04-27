package com.company;

/**
 * Created by hackeru on 3/22/2017.
 */


public class Factory {
    public static final String CAESAR = "1";
    public static final String XOR = "2";
    public static final String MULTIPLICATION = "3";
    public static final String REVERSE = "4";
    public static final String DoubleAlgorithm="5";

    ReverseAlgorithm reverseAlgorithm;
    boolean doubleAlgorithmFlag=false;
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
            case DoubleAlgorithm:
                return chooseAlgorithmToDouble();
        }
        return null;
    }

    private DoubleAlgorithm chooseAlgorithmToDouble() {
        DoubleAlgorithm doubleAlgorithm;
        if(doubleAlgorithmFlag==false) {
            doubleAlgorithm = new DoubleAlgorithm(chooseAlgorithm("2"), chooseAlgorithm("4"));
            return doubleAlgorithm;
        }
        else {
            doubleAlgorithm = new DoubleAlgorithm(chooseAlgorithm("1"), chooseAlgorithm("3"));
            return doubleAlgorithm;
        }
    }

    private void chooseAlgorithmToReverse() {
        doubleAlgorithmFlag=true;
        reverseAlgorithm=new ReverseAlgorithm(chooseAlgorithm("5"));
//        Menu.inputOutput.getMessage("please enter algorithm : \n1. Caesar Algorithm \n2. Xor Algorithm \n3. Multiplication Algorithm");
//        reverseAlgorithm.algorithm=chooseAlgorithm(Menu.inputOutput.setMessage());
//        if(reverseAlgorithm.algorithm==null)chooseAlgorithmToReverse();
    }

}
