package app.retake.parser;

import app.retake.parser.interfaces.Parser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

@Component(value = "XMLParser")
public class XMLParser implements Parser {

    private JAXBContext jaxbContext;

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
