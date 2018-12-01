package org.softuni.mostwanted.io.impl;

import org.softuni.mostwanted.io.interfaces.ConsoleIO;

import java.util.Scanner;

public class ConsoleIOImpl implements ConsoleIO {


    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
