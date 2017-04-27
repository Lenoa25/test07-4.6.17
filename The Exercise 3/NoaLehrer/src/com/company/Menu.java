package com.company;

/**
 * Created by hackeru on 2/28/2017.
 */
public class Menu{
    public static final String EXIT = "0";
    public static final String ENCRYPTION = "1";
    public static final String DECRYPTION = "2";

    MyFile myFile;
    AlgorithmByKey option;
    static InputOutput inputOutput = new onScreen();

    boolean type;

    void start() {
        boolean exist=true;
        while (exist) {
            inputOutput.getMessage("please enter your choose : \n0. exit \n1. encryption file \n2. decryption file");
            exist = printMenu(scanChoose());
        }

    }

    boolean printMenu(String choose) {
        switch (choose) {
            case EXIT:
                exit();
                return false;
            case ENCRYPTION:
                type=false;
                encryptionDecryption();
                break;
            case DECRYPTION:
                type=true;
                encryptionDecryption();
                break;
            default:
                inputOutput.getMessage("your choose is not exist");
                break;
        }
        return true;
    }

    public void encryptionDecryption(){
        enterPath(0);
        chooseAlgorithm();
        if(!type) {
            option.theAlgorithm(myFile,1);
            inputOutput.getMessage("encryption succeed");
        }
        else {
            option.theAlgorithm(myFile,2);
            inputOutput.getMessage("decryption succeed");
        }

    }

    private void chooseAlgorithm() {
        inputOutput.getMessage("please enter algorithm : \n1. Caesar Algorithm \n2. Xor Algorithm \n3. Multiplication Algorithm \n4. Reverse Algorithm");
        Factory factory=new Factory();
        option=factory.chooseAlgorithm(inputOutput.setMessage());
        if (option==null){
            inputOutput.getMessage("your choose is not exist");
            chooseAlgorithm();
        }
    }

    public String scanChoose() {
        String sScanner = inputOutput.setMessage();
        if (sScanner.length() == 0) {
            inputOutput.getMessage("your choose is invalid, try again");
            start();
        }
        return sScanner;
    }

    void exit() {
        inputOutput.getMessage("byebye!");
    }

    void enterPath(int i) {
        inputOutput.getMessage("enter path file:");
        String scannerString = inputOutput.setMessage();
        myFile = new MyFile(scannerString);
        if (!myFile.check())
            enterPath(i++);
    }

    TIMEListener timeListener=new TIMEListener() {
        @Override
        public void StartDetect() {
            inputOutput.getMessage("the algorithm is start \nthe time now is" + System.nanoTime());
        }

        @Override
        public void EndDetect() {
            inputOutput.getMessage("the algorithm is end \nthe time now is" + System.nanoTime());
        }
    };

}
