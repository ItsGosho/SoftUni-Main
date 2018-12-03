package itsgosho.io.interfaces;

import java.io.IOException;

public interface FileIO {
    //File path UNDER RESOURCES !
    String read(String file) throws IOException;
    //File path UNDER RESOURCES !
    void write(String fileContent, String file) throws IOException;
}
