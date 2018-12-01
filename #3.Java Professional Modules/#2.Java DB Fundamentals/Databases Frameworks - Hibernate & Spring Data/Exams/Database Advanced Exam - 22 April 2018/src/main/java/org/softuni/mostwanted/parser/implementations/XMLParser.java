package org.softuni.mostwanted.parser.implementations;

import org.softuni.mostwanted.parser.interfaces.Parser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class XMLParser implements Parser {
    @Override
    public <T> T read(Class<T> objectClass, String fileContent) throws IOException, JAXBException {
        JAXBContext jaxb = JAXBContext.newInstance(objectClass);
        T result = (T) jaxb.createUnmarshaller().unmarshal(new StringReader(fileContent));
        return result;
    }

    @Override
    public <T> String write(T object) throws IOException, JAXBException {
        JAXBContext jaxb = JAXBContext.newInstance(object.getClass());
        StringWriter stringWriter = new StringWriter();
        Marshaller marshaller = jaxb.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(object,stringWriter);
        return stringWriter.toString();
    }
}
