package hell.io;

import hell.interfaces.OutputWriter;

public class OutputWriterImp implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
         //TODO: sha vidq ko sha i
    }
}
