package itsgosho.io.impl;


import itsgosho.io.interfaces.ConsoleIO;

import java.util.Scanner;

public class ConsoleIOImpl implements ConsoleIO {


    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
