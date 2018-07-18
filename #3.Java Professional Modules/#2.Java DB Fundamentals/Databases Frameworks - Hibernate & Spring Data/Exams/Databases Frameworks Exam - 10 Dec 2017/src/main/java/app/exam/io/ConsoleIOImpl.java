package app.exam.io;

import app.exam.io.interfaces.ConsoleIO;

public class ConsoleIOImpl implements ConsoleIO {
    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
