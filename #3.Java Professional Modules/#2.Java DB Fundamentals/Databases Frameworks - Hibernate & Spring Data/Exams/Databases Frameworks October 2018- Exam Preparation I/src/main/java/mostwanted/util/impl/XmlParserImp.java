package mostwanted.util.impl;

import mostwanted.util.inter.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringReader;

public class XmlParserImp implements XmlParser {

    @Override
    public <O> O parseXml(Class<O> objectClass, String filePath) throws JAXBException {
        FileUtilImp fileUtilImp = new FileUtilImp();
        JAXBContext jaxb = JAXBContext.newInstance(objectClass);
        O result = null;
        try {
            result = (O) jaxb.createUnmarshaller().unmarshal(new StringReader(fileUtilImp.readFile(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
