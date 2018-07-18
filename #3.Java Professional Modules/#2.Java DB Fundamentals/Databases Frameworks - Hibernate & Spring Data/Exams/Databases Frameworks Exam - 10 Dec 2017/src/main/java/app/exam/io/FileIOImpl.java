package app.exam.io;

import app.exam.io.interfaces.FileIO;

import java.io.*;

public class FileIOImpl implements FileIO {
    @Override
    public String read(String file) throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader(new File("C:\\Users\\Gosho\\Desktop\\DB Exams\\Databases Frameworks October 2017 - Exam Preparation 2\\src\\main\\resources\\files\\json\\input\\stars.json")));
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
