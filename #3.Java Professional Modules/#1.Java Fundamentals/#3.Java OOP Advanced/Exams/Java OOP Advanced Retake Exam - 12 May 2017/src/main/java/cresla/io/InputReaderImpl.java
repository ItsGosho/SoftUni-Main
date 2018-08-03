package cresla.io;

import cresla.interfaces.InputReader;

import java.util.Scanner;

public class InputReaderImpl implements InputReader {

    private Scanner skener;

    public InputReaderImpl(){
        this.skener=new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return this.skener.nextLine();
    }
}
