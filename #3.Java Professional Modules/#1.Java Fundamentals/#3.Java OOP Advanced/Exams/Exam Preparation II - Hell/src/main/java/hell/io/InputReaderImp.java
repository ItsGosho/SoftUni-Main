package hell.io;

import hell.interfaces.InputReader;

import java.util.Scanner;

public class InputReaderImp implements InputReader {

    private Scanner scanner;

    public InputReaderImp(){
        this.scanner=new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
