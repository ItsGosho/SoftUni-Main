package itsgosho.io.impl;


import itsgosho.io.interfaces.FileIO;

import java.io.*;
import java.util.Scanner;

public class FileIOImpl implements FileIO {
    @Override
    public String read(String file) throws IOException {
        String content = new Scanner(new File(new File("").getAbsolutePath()+"\\src\\main\\resources\\"+file)).useDelimiter("\\Z").next();
        return content;
    }

    @Override
    public void write(String fileContent, String file) throws IOException {
        File newFile = new File(new File("").getAbsolutePath()+"\\src\\main\\resources\\"+file);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        bufferedWriter.write(fileContent);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
