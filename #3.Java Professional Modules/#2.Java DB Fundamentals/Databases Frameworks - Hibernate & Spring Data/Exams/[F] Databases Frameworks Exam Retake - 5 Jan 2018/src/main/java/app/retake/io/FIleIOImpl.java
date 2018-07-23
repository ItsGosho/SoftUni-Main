package app.retake.io;

import app.retake.io.api.FileIO;

import java.io.*;

public class FIleIOImpl implements FileIO {

    @Override
    public String read(String file) throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader(file));
        final String[] toReturn = {""};
        bf.lines().forEach(x->{
            toReturn[0] +=x+"\n";
        });
        return toReturn[0].trim();
    }

    @Override
    public void write(String fileContent, String file) throws IOException {
        File fW=new File(file);
        FileWriter fileWriter=new FileWriter(fW);
        fileWriter.write(fileContent);
        fileWriter.flush();
    }
}
