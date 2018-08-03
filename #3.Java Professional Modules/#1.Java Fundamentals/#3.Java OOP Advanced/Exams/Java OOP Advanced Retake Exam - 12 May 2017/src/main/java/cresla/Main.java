package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.InputReaderImpl;
import cresla.io.OutputWriterImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        InputReader inputReader = new InputReaderImpl();
        OutputWriter outputWriter = new OutputWriterImpl();
        Manager manager = new ManagerImpl();

        while (true) {
            String line = inputReader.readLine();
            String[] splitted = line.split("\\s+");
            if (line.equals("Exit")) {
               outputWriter.writeLine(manager.exitCommand(Arrays.asList(splitted)));
                break;
            }

            switch (splitted[0]) {
                case "Reactor":
                    outputWriter.writeLine(manager.reactorCommand(Arrays.asList(splitted)));
                    break;
                case "Module":
                    outputWriter.writeLine(manager.moduleCommand(Arrays.asList(splitted)));
                    break;
                case "Report":
                    outputWriter.writeLine(manager.reportCommand(Arrays.asList(splitted)));
                    break;
            }
        }
    }
}
