package itsgosho.parser.implementations;

import itsgosho.parser.interfaces.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;


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
