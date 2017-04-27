package com.company;

import java.util.Scanner;

/**
 * Created by hackeru on 2/28/2017.
 */
public class Menu {
    Option option;

    void start() {
        printMenu();
        start();
    }

    private void printMenu() {
        System.out.println("please enter your choose :");
        System.out.println("0. exit");
        System.out.println("1. decryption file");
        System.out.println("2. encryption file");
        switch(scanChoose()){
            case '0':
                exit();
                break;
            case '1':
                option = new Encryption();
                option.start();
                break;
            case '2':
                option = new Decryption();
                option.start();
                break;
            default:
                System.out.println("your choose is not exist");
                printMenu();
                break;
        }
    }

    public char scanChoose() {
        Scanner scanner = new Scanner(System.in);
        char[] sScanner = scanner.next().toCharArray();
        if (sScanner.length == 0) {
            System.out.println("your choose is invalid, try again");
            printMenu();
        }
        //int numChoose = sScanner[0] - 48;
        return sScanner[0];
    }

    private void exit(){
        System.out.println("byby!");
    }
}
