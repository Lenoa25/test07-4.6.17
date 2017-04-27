package com.company;

import java.util.Scanner;

/**
 * Created by hackeru on 2/28/2017.
 */
public class Menu {
    Function function;

    void start() {
        printMenu(0);
        start();
    }

    private void printMenu(int i) {
        System.out.println("please enter your choose :");
        System.out.println("0. exit");
        System.out.println("1. decryption file");
        System.out.println("2. encryption file");
        switch (scanChoose(i)) {
            case 0:
                exit();
                break;
            case 1:
                function = new Encryption();
                function.start();
                break;
            case 2:
                function = new Decryption();
                function.start();
                break;
            default:
                System.out.println("your choose is not exist");
                printMenu(i++);
                break;
        }
    }

    private int scanChoose(int i) {
        Scanner scanner = new Scanner(System.in);
        char[] sScanner = scanner.next().toCharArray();
        if (sScanner.length == 0) {
            System.out.println("your choose is invalid, try again");
            printMenu(i++);
        }
        int numChoose = sScanner[0] - 48;
        return numChoose;
    }

    private void exit(){
        System.out.println("byby!");
    }
}

