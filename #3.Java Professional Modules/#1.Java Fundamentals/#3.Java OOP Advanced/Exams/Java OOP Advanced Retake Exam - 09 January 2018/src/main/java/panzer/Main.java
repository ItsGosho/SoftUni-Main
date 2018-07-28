package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.io.InputReaderImpl;
import panzer.io.OutputWriterImpl;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader=new InputReaderImpl();
        OutputWriter outputWriter=new OutputWriterImpl();

        Manager manager=new ManagerImpl();
        while (true){
            String line=inputReader.readLine();
            String[] test=line.split("\\s+");
            List<String> arguments = Arrays.asList(line.split("\\s"));

            if(arguments.get(0).equals("Terminate")){
               outputWriter.println(manager.terminate(arguments));
                break;
            }

            switch (arguments.get(0)){
                case "Vehicle":
                    outputWriter.println(manager.addVehicle(arguments));
                    break;
                case "Part":
                    outputWriter.println(manager.addPart(arguments));
                    break;
                case "Inspect":
                    outputWriter.println(manager.inspect(arguments));
                    break;
                case "Battle":
                    outputWriter.println(manager.battle(arguments));
                    break;
            }
        }
    }
}
