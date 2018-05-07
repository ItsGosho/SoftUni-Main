package T03T04_Barracks.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
