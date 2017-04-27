package com.company;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by hackeru on 3/14/2017.
 */
class MenuTest {


    @Test
    void printMenuTestExit() {
        Menu menu=new Menu();
        MyFile myFile = mock(MyFile.class);
        Algorithm option= mock(Algorithm.class);
        InputOutput inputOutput = mock(InputOutput.class);
        menu.inputOutput = inputOutput;
        menu.printMenu("0");
        verify(inputOutput).getMessage("byby!");
    }
    @Test
    void printMenuTestNumberNotExist() {
        Menu menu=new Menu();
        MyFile myFile = mock(MyFile.class);
        AlgorithmByKey option= mock(AlgorithmByKey.class);
        menu.option=option;
        InputOutput inputOutput = mock(InputOutput.class);
        menu.inputOutput = inputOutput;
        menu.printMenu("8");
        verify(inputOutput).getMessage("your choose is not exist");
    }
    @Test
    void printMenuTestCharacter() {
        Menu menu=new Menu();
        MyFile myFile = mock(MyFile.class);
        AlgorithmByKey option= mock(AlgorithmByKey.class);
        menu.option=option;
        InputOutput inputOutput = mock(InputOutput.class);
        menu.inputOutput = inputOutput;
        menu.printMenu("a");
        verify(inputOutput).getMessage("your choose is not exist");
    }



}