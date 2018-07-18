package app.exam.parser;

import org.springframework.stereotype.Component;
import app.exam.parser.interfaces.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component(value = "XMLParser")
public class XMLParser implements Parser {


    @Override
    public <T> T read(Class<T> objectClass, String fileContent) throws JAXBException, FileNotFoundException {
        JAXBContext jax = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller=jax.createUnmarshaller();
        T toReturn = (T) unmarshaller.unmarshal(new FileReader(fileContent));
        return toReturn;
    }

    @Override
    public <T> String write(T object) throws JAXBException {
        JAXBContext jax = JAXBContext.newInstance(object.getClass());
        StringWriter stringWriter=new StringWriter();
        Marshaller marshaller=jax.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(object,stringWriter);
        return stringWriter.toString().trim();
    }
}
