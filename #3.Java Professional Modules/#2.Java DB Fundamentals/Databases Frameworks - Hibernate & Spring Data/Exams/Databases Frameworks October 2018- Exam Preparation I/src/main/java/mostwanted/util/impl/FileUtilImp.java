package mostwanted.util.impl;

import mostwanted.util.inter.FileUtil;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileUtilImp implements FileUtil {

    //FILEPATH IS UNDER RESORUCES!
    @Override
    public String readFile(String filePath) throws IOException {
        String content = new Scanner(new File(new File("").getAbsolutePath()+"\\src\\main\\resources\\"+filePath)).useDelimiter("\\Z").next();
        return content;
    }
}
