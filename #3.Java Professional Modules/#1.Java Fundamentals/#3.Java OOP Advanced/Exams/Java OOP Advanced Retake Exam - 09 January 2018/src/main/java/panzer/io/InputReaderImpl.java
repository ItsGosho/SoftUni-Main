package panzer.io;

import panzer.contracts.InputReader;

import java.util.Scanner;

public class InputReaderImpl implements InputReader {
    private Scanner skener = new Scanner(System.in);

    @Override
    public String readLine() {
        return skener.nextLine();
    }
}
