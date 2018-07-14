package com.masdefect.parser;

import com.masdefect.parser.interfaces.FileParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component(value = "XMLParser")
public class XMLParser implements FileParser {

    @Override
    public <T> T read(Class<T> objectClass, String fileContent) throws IOException, JAXBException {
        JAXBContext jax = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller=jax.createUnmarshaller();
        T toReturn = (T) unmarshaller.unmarshal(new FileReader(fileContent));
        return toReturn;
    }

    @Override
    public <T> String write(T object) throws IOException, JAXBException {
        JAXBContext jax = JAXBContext.newInstance(object.getClass());
        StringWriter stringWriter=new StringWriter();
        Marshaller marshaller=jax.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(object,stringWriter);
        return stringWriter.toString().trim();
    }
}
