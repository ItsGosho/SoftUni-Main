package cresla.interfaces;

import java.util.List;

public interface Manager {
    String reactorCommand(List<String> arguments);

    String moduleCommand(List<String> arguments);

    String reportCommand(List<String> arguments) throws NoSuchFieldException, IllegalAccessException;

    String exitCommand(List<String> arguments);
}
