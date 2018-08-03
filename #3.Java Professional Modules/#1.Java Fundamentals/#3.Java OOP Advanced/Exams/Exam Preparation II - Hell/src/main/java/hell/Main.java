package hell;

import hell.interfaces.InputReader;
import hell.interfaces.Manager;
import hell.interfaces.OutputWriter;
import hell.io.InputReaderImp;
import hell.io.OutputWriterImp;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputReader inputReader = new InputReaderImp();
        OutputWriter outputWriter = new OutputWriterImp();
        Manager manager = new ManagerImp();

        while (true) {
            String line = inputReader.readLine();
            if (line.equals("Quit")) {
                outputWriter.writeLine(manager.quit());
                break;
            }
            String[] splitted = line.split("\\s+");

            switch (splitted[0]) {

                case "Hero":
                    outputWriter.writeLine(manager.addHero(splitted[1],splitted[2]));
                    break;
                case "Item":
                    outputWriter.writeLine(manager.addItem(splitted[1],splitted[2],
                            Integer.parseInt(splitted[3]),
                            Integer.parseInt(splitted[4]),
                            Integer.parseInt(splitted[5]),
                            Integer.parseInt(splitted[6]),
                            Integer.parseInt(splitted[7])));
                    break;
                case "Recipe":
                    String things="";
                    for (int i = 8; i < splitted.length; i++) {
                           things+=splitted[i]+" ";
                    }
                    outputWriter.writeLine(manager.addRecipe(splitted[1],splitted[2],
                            Integer.parseInt(splitted[3]),
                            Integer.parseInt(splitted[4]),
                            Integer.parseInt(splitted[5]),
                            Integer.parseInt(splitted[6]),
                            Integer.parseInt(splitted[7]),
                            things.split("\\s+")));
                    break;
                case "Inspect":
                    outputWriter.writeLine(manager.inspect(splitted[1]));
                    break;
            }
        }
    }
}