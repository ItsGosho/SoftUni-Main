package javache.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class Reader {

    public static String readAllLines(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder str=new StringBuilder();
        while (bufferedReader.ready()){
            str.append((char)bufferedReader.read());
        }
        return str.toString();
    }
}
